import { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { ToastContainer, toast } from 'react-toastify';
import "react-toastify/dist/ReactToastify.css"
import { useNavigate } from "react-router";
import { useParams } from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import '../styles/register.css'

const UpdateTaskComponent = () => {

    const [description, descriptionChange] = useState("");
    const [assignedDate, assignedDateChange] = useState("");
    const [status, statusChange] = useState("");
    const [resolution, resolutionChange] = useState("");

    const usenavigate = useNavigate();

    const { id } = useParams();

    useEffect(() => {

        fetch('http://localhost:8080/task/findById/'+id)
            .then((res) => {
                return res.json();
            }).then((res) => {
                console.log(res);
                descriptionChange(res.description);
                assignedDateChange(res.assignedDate);
                statusChange(res.status);
                resolutionChange(res.resolution);
            }).catch((err) => {
                console.log(err.message);
            })
    }, [])

    const handleBackButton = () => {

        usenavigate('/');
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        let taskId = id;

        if (validate()) {
            let taskData = { taskId, description, assignedDate, status, resolution };
            console.log(taskData);

            fetch("http://localhost:8080/task/update", {
                method: "PUT",
                headers: { 'content-type': 'application/json' },
                body: JSON.stringify(taskData)
            }).then((res) => {
                console.log('Data saved Successfully');
                toast('Task Updated Succesfully');
            }).catch((err) => {
                console.log('Failed' + err.message);
                toast('Task not Updated');
            });
        }

    }

    const validate = () => {

        let result = true;
        if (description === '' || description === null) {
            result = false;
            toast('Please Enter Description')
        }
        if (assignedDate === '' || assignedDate === null) {
            result = false;
            toast('Please Select Assigned Date')
        }
        if (status === '' || status === null) {
            result = false;
            toast('Please Enter Status')
        }
        if (resolution === '' || resolution === null) {
            result = false;
            toast('Please Enter Resolution')
        }
        return result;
    }

    return (

        <>
            <Card style={{ width: '24rem' }} className="card">
                <Card.Body>
                    <Card.Title style={{ textAlign: 'center' }}><span className="cardHeading">Update User</span></Card.Title>
                    <br />
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Task Id</Form.Label>
                            <Form.Control type="text"value={id} disabled="disabled"/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Description</Form.Label>
                            <Form.Control type="text" placeholder="Enter your Description" value={description} onChange={e => descriptionChange(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Assigned Date</Form.Label>
                            <Form.Control type="date" value={assignedDate} onChange={e => assignedDateChange(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Status</Form.Label>
                            <Form.Control type="text" placeholder="Enter your Status" value={status} onChange={e => statusChange(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Resolution</Form.Label>
                            <Form.Control type="text" placeholder="Enter your Resolution" value={resolution} onChange={e => resolutionChange(e.target.value)} />
                        </Form.Group>
                        <center><Button variant="success" type="submit" size="lg">
                            Update Task
                        </Button>
                            &ensp;&ensp;
                            <Button variant="warning" onClick={handleBackButton} size="lg">
                                Back
                            </Button>
                        </center>

                    </Form>
                </Card.Body>
            </Card>
            <ToastContainer />
        </>


    )
}

export default UpdateTaskComponent;