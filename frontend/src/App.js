import React from 'react';
import CourseForm from './components/CourseForm'; // Adjust the path if necessary

const App = () => {
    return (
        <div className="App">
            <h1>Course Management</h1>
            {/* Pass courseId as a prop if editing an existing course */}
            <CourseForm />
        </div>
    );
};

export default App;