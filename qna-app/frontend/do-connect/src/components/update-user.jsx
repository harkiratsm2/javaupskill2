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

const UpdateUserComponent = () => {

    const [username, usernameChange] = useState("");
    const [password, passwordChange] = useState("");
    const [fullname, fullnameChange] = useState("");
    const [phone, phoneChange] = useState("");
    const [email, emailChange] = useState("");
    const [role, roleChange] = useState("");

    const usenavigate = useNavigate();

    const { id } = useParams();

    useEffect(() => {

        let username = sessionStorage.getItem('username');
        let role = sessionStorage.getItem('role');

        console.log(username);
        if (username === '' || username === null || role !== 'admin') {
            usenavigate('/');
        }

        fetch('http://localhost:8080/user/findById/'+id)
            .then((res) => {
                return res.json();
            }).then((res) => {
                console.log(res);
                usernameChange(res.username);
                passwordChange(res.password);
                fullnameChange(res.fullname);
                emailChange(res.email);
                phoneChange(res.phone);
                roleChange(res.role);
            }).catch((err) => {
                console.log(err.message);
            })
    }, [])

    const handleBackButton = () => {

        usenavigate('/userCRUD');
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        if (validate()) {
            let registerData = { id, username, password, fullname, phone, email, role };
            console.log(registerData);

            fetch("http://localhost:8080/user/update", {
                method: "PUT",
                headers: { 'content-type': 'application/json' },
                body: JSON.stringify(registerData)
            }).then((res) => {
                console.log('Data saved Successfully');
                toast('User Updated Succesfully');
            }).catch((err) => {
                console.log('Failed' + err.message);
                toast('User not Updated');
            });
        }

    }

    const validate = () => {

        let result = true;
        if (username === '' || username === null) {
            result = false;
            toast('Please Enter Username')
        }
        if (password === '' || password === null) {
            result = false;
            toast('Please Enter Password')
        }
        if (fullname === '' || fullname === null) {
            result = false;
            toast('Please Enter FullName')
        }
        if (phone === '' || phone === null) {
            result = false;
            toast('Please Enter Phone')
        }
        if (email === '' || email === null) {
            result = false;
            toast('Please Enter Email')
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
                            <Form.Label>Id</Form.Label>
                            <Form.Control type="text"value={id} disabled="disabled"/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="text" placeholder="Enter your Username" value={username} onChange={e => usernameChange(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" value={password} onChange={e => passwordChange(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>FullName</Form.Label>
                            <Form.Control type="text" placeholder="Enter your FullName" value={fullname} onChange={e => fullnameChange(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label>Phone</Form.Label>
                            <Form.Control type="text" placeholder="Enter your Phone" value={phone} onChange={e => phoneChange(e.target.value)} />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" value={email} onChange={e => emailChange(e.target.value)} />
                        </Form.Group>
                        <label>Role</label>
                        <Form.Check
                            type="radio"
                            label="Student"
                            checked={role === 'student'} onChange={e => roleChange(e.target.value)} name='role' value="student"
                        />
                        <Form.Check
                            type="radio"
                            label="Admin"
                            checked={role === 'admin'} onChange={e => roleChange(e.target.value)} name='role' value="admin"
                        />
                        <center><Button variant="success" type="submit" size="lg">
                            Update User
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

export default UpdateUserComponent;