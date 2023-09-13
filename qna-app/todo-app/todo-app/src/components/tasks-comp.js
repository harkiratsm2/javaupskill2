import Button from 'react-bootstrap/Button';
import Table from 'react-bootstrap/Table';
import { useNavigate } from 'react-router';
import { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import '../styles/navbar.css'
import { ToastContainer, toast } from 'react-toastify';

const TaskComponent = () => {

    const usenavigate = useNavigate();

    const [taskData, taskDataChange] = useState(null);

    useEffect(() => {

        fetch("http://localhost:8080/task/getAllTasks")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                taskDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })

    }, []);

    async function deleteUser(id) {
        
        await fetch("http://localhost:8080/task/delete/" + id, {
            method: "DELETE"
        })
            .then(() => {
                console.log('i am response from delete method')
                toast("Task Deleted SuccessFully");
            }).catch((err) => {
                console.log(err.message);
                toast('Task not Deleted');
            })

            fetch("http://localhost:8080/task/getAllTasks")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log('i am fetching data after deletion')
                console.log(resp);
                taskDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })
    }

    const updateUser = (id) => {
        usenavigate("/updateUser/" + id);
    }

    return (

        <>
            <div className='headingUser'>Tasks</div>
            <Link to="/addTask">
                <Button variant="info" size="lg" style={{ marginLeft: '80px', marginBottom: '20px' }}>
                    Add Task
                </Button></Link>
            <Table striped bordered hover style={{ maxWidth: '90%', marginLeft: '70px', border: '3px solid green' }}>
                <thead style={{ backgroundColor: 'orange', fontSize: '20px' }}>
                    <tr>
                        <th style={{ width: '8%' }}>Task Id</th>
                        <th>Description</th>
                        <th>Assigned Date</th>
                        <th>Status</th>
                        <th>Resolution</th>
                        <th style={{ width: '18%' }}>Actions</th>
                    </tr>
                </thead>
                <tbody>

                    {
                        taskData &&
                        taskData.map(item => (

                            <tr key={item.taskId}>
                                <td>
                                    {item.taskId}
                                </td>
                                <td>
                                    {item.description}
                                </td>
                                <td>
                                    {item.assignedDate}
                                </td>
                                <td>
                                    {item.status}
                                </td>
                                <td>
                                    {item.resolution}
                                </td>
                                <td>
                                    <Button variant="success" onClick={() => { updateUser(item.taskId) }}>
                                        Update
                                    </Button>&ensp;
                                    <Button variant="danger" onClick={() => { deleteUser(item.taskId) }}>Delete</Button>
                                </td>
                            </tr>

                        ))
                    }

                </tbody>
            </Table>
            <ToastContainer />
        </>

    )

}

export default TaskComponent;