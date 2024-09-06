import axios from 'axios';

// Base URL for API requests
const API_URL = 'http://localhost:8082/api';

// Add Course
export const addCourse = (courseData) => {
    return axios.post(`${API_URL}/courses`, courseData);
};

// Get All Courses
export const getAllCourses = () => {
    return axios.get(`${API_URL}/courses`);
};

// Get Course By ID
export const getCourseById = (id) => {
    return axios.get(`${API_URL}/courses/${id}`);
};

// Update Course
export const updateCourse = (id, courseData) => {
    return axios.put(`${API_URL}/courses/${id}`, courseData);
};

// Delete Course By ID
export const deleteCourseById = (id) => {
    return axios.delete(`${API_URL}/courses/${id}`);
};

// Get All Instances
export const getAllInstances = () => {
    return axios.get(`${API_URL}/instances`);
};

// Add Instance
export const addInstance = (instanceData) => {
    return axios.post(`${API_URL}/instances`, instanceData);
};

// Delete Instance
export const deleteInstanceById = (id) => {
    return axios.delete(`${API_URL}/instances/${id}`);
};

// Get Instance By ID
export const getInstanceById = (id) => {
    return axios.get(`${API_URL}/instances/${id}`);
};
