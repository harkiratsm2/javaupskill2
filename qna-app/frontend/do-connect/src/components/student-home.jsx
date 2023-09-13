import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Table from 'react-bootstrap/Table';
import { useNavigate } from 'react-router';
import { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import '../styles/navbar.css'

const StudentHomeComponent = () => {

    const usenavigate = useNavigate();

    let usernameLoggedIn = sessionStorage.getItem('username');

    const [userQuesData, userQuesDataChange] = useState(null);
    const [userAnsData, userAnsDataChange] = useState(null);

    useEffect(() => {

        let username = sessionStorage.getItem('username');
        let role = sessionStorage.getItem('role');
        
        console.log(username);
        console.log(role);
        if (username === '' || username === null || role !== 'student') {
            usenavigate('/');
        }

        fetch("http://localhost:8081/quesans/getQuesByUsername/"+username)
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userQuesDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })

            fetch("http://localhost:8081/quesans/getAnsByUsername/"+username)
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userAnsDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })

    },[])

    const handleLogout = () => {
        
        usenavigate('/');
    }

    return (

        <>
            <Navbar bg="light" expand="lg" className='container'>
            <Container>
                <Navbar.Brand className='navbarHeading'>Student-Dashboard</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                    <Link to='/studentHome'><Button variant="info">Home</Button></Link>&ensp;
                    <Link to='/askQues'><Button variant="secondary">Ask Question</Button></Link>&ensp;
                    <Link to='/qna'><Button variant="secondary">QnA</Button></Link>&ensp;
                    </Nav>
                </Navbar.Collapse>
                <Button variant="danger" onClick={handleLogout}>Logout</Button>
            </Container>
        </Navbar>
        <div className='headingUser'>Welcome, {usernameLoggedIn} (Your QnA Status)</div>
        <div className='headingUser'>Questions</div>
        <Table striped bordered hover style={{maxWidth: '90%', marginLeft: '70px', border: '3px solid green'}}>
        <thead style={{backgroundColor: 'orange', fontSize: '20px'}}>
                    <tr>
                        <th style={{width: '12%'}}>Question Id</th>
                        <th>Question</th>
                        <th style={{width: '10%'}}>Topic</th>
                        <th style={{width: '10%'}}>Status</th>
                    </tr>
                </thead>
                <tbody>

                    {
                        userQuesData &&
                        userQuesData.map(item => (

                            <tr key={item.id}>
                                <td>
                                    {item.id}
                                </td>
                                <td>
                                    {item.question}
                                </td>
                                <td>
                                    {item.topic}
                                </td>
                                <td>
                                    {item.status}
                                </td>
                            </tr>

                        ))
                    }

                </tbody>
            </Table>
            <div className='headingUser'>Answers</div>
        <Table striped bordered hover style={{maxWidth: '90%', marginLeft: '70px', border: '3px solid green'}}>
        <thead style={{backgroundColor: 'orange', fontSize: '20px'}}>
                    <tr>
                        <th style={{width: '10%'}}>Answer Id</th>
                        <th>Answer</th>
                        <th style={{width: '12%'}}>Question Id</th>
                        <th style={{width: '10%'}}>Status</th>
                    </tr>
                </thead>
                <tbody>

                    {
                        userAnsData &&
                        userAnsData.map(item => (

                            <tr key={item.id}>
                                <td>
                                    {item.id}
                                </td>
                                <td>
                                    {item.answer}
                                </td>
                                <td>
                                    {item.quesId}
                                </td>
                                <td>
                                    {item.status}
                                </td>
                            </tr>

                        ))
                    }

                </tbody>
            </Table>
        </>
        
    )

}

export default StudentHomeComponent;