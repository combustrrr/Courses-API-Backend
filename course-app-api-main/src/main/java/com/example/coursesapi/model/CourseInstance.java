package com.example.coursesapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "course_instance")
@Getter
@Setter
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private int semester;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}