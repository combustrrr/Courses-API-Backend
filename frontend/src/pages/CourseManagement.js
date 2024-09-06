import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import CourseList from '../components/CourseList';
import CourseDetails from '../components/CourseDetails';
import CourseForm from '../components/CourseForm';

const CourseManagement = () => (
    <Routes>
        <Route path="/courses" element={<CourseList />} />
        <Route path="/courses/:id" element={<CourseDetails />} />
        <Route path="/add-course" element={<CourseForm />} />
        <Route path="*" element={<Navigate to="/courses" />} />
    </Routes>
);

export default CourseManagement;