import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Form from 'react-bootstrap/Form';
import { ToastContainer, toast } from 'react-toastify';
import "react-toastify/dist/ReactToastify.css"
import Card from 'react-bootstrap/Card';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router';
import { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import '../styles/navbar.css';
import '../styles/askquestion.css';

const AskQuestionComponent = () => {

    const [question, questionChange] = useState("")
    const [imageUrlFetch, imageUrlChange] = useState("")
    const [topic, topicChange] = useState("");

    const usenavigate = useNavigate();

    useEffect(() => {

        let username = sessionStorage.getItem('username');
        let role = sessionStorage.getItem('role');

        console.log(username);
        console.log(role);
        if (username === '' || username === null || role !== 'student') {
            usenavigate('/');
        }

    }, [])

    const handleLogout = () => {

        usenavigate('/');
    }

    const handleSubmit = (e) => {

        e.preventDefault();

        if (validate()) {
            let username = sessionStorage.getItem('username');

            let imagePath = imageUrlFetch.substring(12, imageUrlFetch.length);

            let imageUrl = "../assets/" + imagePath;

            let questionData = { question, imageUrl, username, topic };

            console.log(questionData);

            fetch("http://localhost:8081/quesans/addQuestion", {
                method: "POST",
                headers: { 'content-type': 'application/json' },
                body: JSON.stringify(questionData)
            }).then((res) => {
                console.log('Question saved Successfully');
                toast('Question Succesfully Sent for Approval');
            }).catch((err) => {
                console.log('Failed' + err.message);
                toast('Question not Saved');
            });
        }

    }

    const validate = () => {

        let result = true;
        if (question === '' || question === null) {
            result = false;
            toast('Please Enter Question')
        }
        if (topic === '' || topic === null) {
            result = false;
            toast('Please Select Topic')
        }

        return result;
    }

    return (

        <>
            <Navbar bg="light" expand="lg" className='container'>
                <Container>
                    <Navbar.Brand className='navbarHeading'>Student-Dashboard</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Link to='/studentHome'><Button variant="secondary">Home</Button></Link>&ensp;
                            <Link to='/askQues'><Button variant="info">Ask Question</Button></Link>&ensp;
                            <Link to='/qna'><Button variant="secondary">QnA</Button></Link>&ensp;
                        </Nav>
                    </Navbar.Collapse>
                    <Button variant="danger" onClick={handleLogout}>Logout</Button>
                </Container>
            </Navbar>
            <Card style={{ width: '40rem' }} className="card">

                <Card.Body>
                    <Card.Title style={{ textAlign: 'center' }}><span className="cardHeading">Ask Question</span></Card.Title>
                    <br />
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                            <Form.Label>Question</Form.Label>
                            <Form.Control as="textarea" rows={3} value={question} onChange={e => questionChange(e.target.value)} />
                        </Form.Group>
                        <br />
                        <Form.Select aria-label="Default select example" onChange={(e) => {
                            const selectedTopic = e.target.value;
                            topicChange(selectedTopic);
                        }}>
                            <option value="">Select Topic</option>
                            <option value="react">React</option>
                            <option value="spring">Spring Boot</option>
                            <option value="java">Java</option>
                            <option value="tech">Tech</option>
                        </Form.Select>
                        <br />
                        <Form.Group controlId="formFile" className="mb-3">
                            <Form.Label>Upload Image</Form.Label>
                            <Form.Control type="file" value={imageUrlFetch} onChange={e => imageUrlChange(e.target.value)} />
                        </Form.Group>
                        <center><Button variant="primary" type='submit'>Ask Question</Button></center>
                    </Form>
                </Card.Body>
            </Card>
            
            <ToastContainer />
        </>

    )

}

export default AskQuestionComponent;