package ru.ssau.labs.repository;

import ru.ssau.labs.exception.NotExistStorageException;
import ru.ssau.labs.models.CvModel;
import ru.ssau.labs.sql.SQLHelper;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static ru.ssau.labs.util.DateUtil.convertJavaDateToSql;

public class CvModelStorage implements Storage<CvModel> {
    private static final Logger LOG = Logger.getLogger(CvModelStorage.class.getName());

    private final SQLHelper sqlHelper;

    public CvModelStorage(String dbUrl, String dbUser, String dbPassword) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        sqlHelper = new SQLHelper(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void clear() {
        LOG.info("Clear cvModel storage");
        sqlHelper.execute("TRUNCATE models CASCADE");
    }

    @Override
    public void save(CvModel cvModel) {
        LOG.info("Save cvModel " + cvModel.getId());
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO models (model_name, release_date, top5_score) VALUES (?,?,?)")) {
                preparedStatement.setString(1, cvModel.getName());
                preparedStatement.setDate(2, convertJavaDateToSql(cvModel.getRelease()));
                preparedStatement.setBigDecimal(3, cvModel.getScore());
                preparedStatement.execute();
            }
            return null;
        });
    }

    @Override
    public void update(CvModel cvModel) {
        LOG.info("Update cvModel " + cvModel.getId());
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE models m SET model_name=?, release_date=?, top5_score=? WHERE m.id=?")) {
                preparedStatement.setString(1, cvModel.getName());
                preparedStatement.setDate(2, convertJavaDateToSql(cvModel.getRelease()));
                preparedStatement.setBigDecimal(3, cvModel.getScore());
                preparedStatement.setInt(4, cvModel.getId());
                if (preparedStatement.executeUpdate() != 1) {
                    throw new NotExistStorageException(cvModel.getId(), CvModel.class.getSimpleName());
                }
                return null;
            }
        });
    }

    @Override
    public CvModel get(Integer id) {
        LOG.info("Get cvModel " + id);
        return sqlHelper.transactionalExecute(conn -> {
            CvModel cvModel;
            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM models m WHERE m.id =?")) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    throw new NotExistStorageException(id, CvModel.class.getSimpleName());
                }
                cvModel = new CvModel(
                        id,
                        resultSet.getString("model_name"),
                        resultSet.getDate("release_date"),
                        resultSet.getBigDecimal("top5_score")
                );
            }
            return cvModel;
        });
    }

    @Override
    public void delete(Integer id) {
        LOG.info("Delete cvModel" + id);
        sqlHelper.<Void>execute("DELETE FROM models m WHERE m.id =?", (preparedStatement) -> {
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 0) {
                throw new NotExistStorageException(id, CvModel.class.getSimpleName());
            }
            return null;
        });
    }

    @Override
    public List<CvModel> getAllSorted() {
        LOG.info("Get all sorted cvModels");
        Map<Integer, CvModel> cvModels = new LinkedHashMap<>();
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM models m ORDER BY model_name, id")) {
                ResultSet cvModelSet = preparedStatement.executeQuery();
                while (cvModelSet.next()) {
                    int id = cvModelSet.getInt("id");
                    String name = cvModelSet.getString("model_name");
                    Date release = cvModelSet.getDate("release_date");
                    BigDecimal rating = cvModelSet.getBigDecimal("top5_score");
                    cvModels.put(id, new CvModel(id, name, release, rating));
                }
            }
            return null;
        });
        return new ArrayList<>(cvModels.values());
    }

    @Override
    public int size() {
        LOG.info("Get cvModel-storage size");
        return sqlHelper.execute("SELECT COUNT(*) AS count FROM models m", (preparedStatement) -> {
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next() ? rs.getInt("count") : 0;
        });
    }
}