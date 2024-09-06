import React, { useEffect, useState } from 'react';
import { getAllCourses, deleteCourseById } from '../services/apiService';

const CourseList = () => {
    const [courses, setCourses] = useState([]);

    useEffect(() => {
        getAllCourses()
            .then(response => setCourses(response.data))
            .catch(error => console.error('Error fetching courses:', error));
    }, []);

    const handleDelete = (id) => {
        deleteCourseById(id)
            .then(() => setCourses(courses.filter(course => course.id !== id)))
            .catch(error => console.error('Error deleting course:', error));
    };

    return (
        <div>
            <h1>Course List</h1>
            <ul>
                {courses.map(course => (
                    <li key={course.id}>
                        <h2>{course.title}</h2>
                        <p>{course.description}</p>
                        <button onClick={() => handleDelete(course.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CourseList;
