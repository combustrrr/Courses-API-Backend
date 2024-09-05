package com.example.coursesapi.services;

import com.example.coursesapi.model.Course;
import com.example.coursesapi.model.CourseInstance;
import com.example.coursesapi.repository.CourseInstanceRepository;
import com.example.coursesapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInstanceService {
    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<CourseInstance> createInstance(CourseInstance instance) {
        Course course = courseRepository.findById(instance.getCourse().getId()).orElseThrow();
        instance.setCourse(course);
        CourseInstance newInstance = courseInstanceRepository.save(instance);
        return ResponseEntity.ok(newInstance);
    }


    public ResponseEntity<List<CourseInstance>> getAllInstances() {
        List<CourseInstance> instances = courseInstanceRepository.findAll();
        return ResponseEntity.ok(instances);
    }


    public ResponseEntity<List<CourseInstance>> getInstancesByYearAndSemester(int year, int semester) {
        List<CourseInstance> instances = courseInstanceRepository.findByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }


    public ResponseEntity<CourseInstance> getInstanceById(Long id) {
        return courseInstanceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Object> deleteInstance(Long id) {
        return courseInstanceRepository.findById(id)
                .map(instance -> {
                    try {
                        courseInstanceRepository.delete(instance);
                        return ResponseEntity.noContent().build();
                    } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
