import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'; // Import the useParams hook
import { getCourseById } from '../services/apiServices'; // Corrected the import path

const CourseDetails = () => {
    const { id: courseId } = useParams();
    const [course, setCourse] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchCourse = async () => {
            try {
                const response = await getCourseById(courseId);
                setCourse(response.data);
            } catch (error) {
                console.error('Error fetching course:', error);
                setError('Failed to load course details.');
            } finally {
                setLoading(false);
            }
        };

        fetchCourse();
    }, [courseId]);

    if (loading) return <p>Loading course details...</p>;
    if (error) return <p style={{ color: 'red' }}>{error}</p>;

    return (
        <div>
            <h1>{course.title}</h1>
            <p>{course.description}</p>
        </div>
    );
};

export default CourseDetails;