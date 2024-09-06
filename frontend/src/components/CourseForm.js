import React, { useState } from 'react';
import { addCourse, updateCourse } from '../services/apiServices'; // Corrected the import path

const CourseForm = ({ courseId }) => {
    const [courseData, setCourseData] = useState({ title: '', description: '' });
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setCourseData({ ...courseData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        setError(null);

        try {
            let response;
            if (courseId) {
                response = await updateCourse(courseId, courseData);
                console.log('Course updated:', response);
            } else {
                response = await addCourse(courseData);
                console.log('Course added:', response);
            }
        } catch (error) {
            console.error('Error submitting form:', error);
            setError('An error occurred while submitting the form. Please try again.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="title"
                value={courseData.title}
                onChange={handleInputChange}
                placeholder="Course Title"
                required
            />
            <textarea
                name="description"
                value={courseData.description}
                onChange={handleInputChange}
                placeholder="Course Description"
                required
            />
            <button type="submit" disabled={loading}>{loading ? 'Submitting...' : 'Submit'}</button>
            {error && <p style={{ color: 'red' }}>{error}</p>}
        </form>
    );
};

export default CourseForm;