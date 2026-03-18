package ru.ssau.labs.controller;


import ru.ssau.labs.config.AppConfig;
import ru.ssau.labs.models.CvModel;
import ru.ssau.labs.service.CvModelService;
import ru.ssau.labs.util.DateUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CvModelServlet extends HttpServlet {

    private CvModelService service;
    private DateFormat dateFormat;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = AppConfig.get().getCvModelService();
        dateFormat = new SimpleDateFormat(AppConfig.get().getDateFormat());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            CvModel model = service.get(id);
            request.setAttribute("model", model);
            request.getRequestDispatcher("/WEB-INF/view/updateModel.jsp").forward(request, response);
        } else {
            List<CvModel> models = service.getAllSorted();
            request.setAttribute("models", models);
            request.getRequestDispatcher("/WEB-INF/view/models.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        Date release;
        String name;
        BigDecimal score;

        String action = request.getParameter("action");
        switch (action) {
            case "clear":
                service.clear();
                break;
            case "save":
                name = request.getParameter("name");
                release = DateUtil.convertStringToJavaDate(request.getParameter("release"), dateFormat);
                score = new BigDecimal(request.getParameter("score"));
                service.save(name, release, score);
                break;
            case "update":
                id = Integer.parseInt(request.getParameter("id"));
                name = request.getParameter("name");
                release = DateUtil.convertStringToJavaDate(request.getParameter("release"), dateFormat);
                score = new BigDecimal(request.getParameter("score"));
                service.update(id, name, release, score);
                break;
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                service.delete(id);
                break;
        }

        response.sendRedirect(request.getContextPath() + "/models");
    }
}
