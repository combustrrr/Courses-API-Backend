package com.example.coursesapi.repository;

import com.example.coursesapi.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByYearAndSemester(@Param("year") int year, @Param("semester") int semester);
}