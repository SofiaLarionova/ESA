
package com.example.jms.repository;

import com.example.jms.model.CvModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface CvModelRepository extends CrudRepository<CvModel, Long> {
    @Query("SELECT m FROM CvModel m ORDER BY m.releaseDate DESC")
    List<CvModel> getAllSortedByReleaseDateDesc();
}