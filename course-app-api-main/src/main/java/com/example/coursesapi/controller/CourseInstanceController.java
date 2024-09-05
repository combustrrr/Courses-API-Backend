package com.example.coursesapi.controller;

import com.example.coursesapi.model.CourseInstance;
import com.example.coursesapi.services.CourseInstanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    // TODO: Create the APIs exactly as per the requirement

    private final CourseInstanceService courseInstanceService;

    public CourseInstanceController(CourseInstanceService courseInstanceService) {
        this.courseInstanceService = courseInstanceService;
    }

    @PostMapping
    public ResponseEntity<CourseInstance> createInstance(@RequestBody CourseInstance instance) {
        return courseInstanceService.createInstance(instance);
    }

    @GetMapping
    public ResponseEntity<List<CourseInstance>> getAllInstances() {
        return courseInstanceService.getAllInstances();
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return courseInstanceService.getInstancesByYearAndSemester(year, semester);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseInstance> getInstanceById(@PathVariable Long id) {
        return courseInstanceService.getInstanceById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInstance(@PathVariable Long id) {
        return courseInstanceService.deleteInstance(id);
    }

}