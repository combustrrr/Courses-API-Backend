package com.example.coursesapi.services;

import com.example.coursesapi.model.Course;
import com.example.coursesapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<Course> createCourse(Course course) {
        Course newCourse = courseRepository.save(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }


    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }


    public ResponseEntity<Course> getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public ResponseEntity<Course> updateCourse(Long id, Course course) {

        return courseRepository.findById(id)
                .map(existingCourse -> {
                    existingCourse.setTitle(course.getTitle());
                    existingCourse.setDescription(course.getDescription());
                    Course updatedCourse = courseRepository.save(existingCourse);
                    return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public ResponseEntity<Void> deleteCourse(Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
