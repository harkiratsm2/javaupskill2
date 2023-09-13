import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router';
import { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import '../styles/navbar.css'

const ApprovalComponent = () => {

    const usenavigate = useNavigate();

    let usernameLoggedIn = sessionStorage.getItem('username');

    const [userQuesData, userQuesDataChange] = useState(null);
    const [userAnsData, userAnsDataChange] = useState(null);

    useEffect(() => {

        let username = sessionStorage.getItem('username');
        let role = sessionStorage.getItem('role');
        // eslint-disable-next-line react-hooks/exhaustive-deps
        usernameLoggedIn = username;
        console.log(username);
        console.log(role);
        if (username === '' || username === null || role !== 'admin') {
            usenavigate('/');
        }

        fetch("http://localhost:8081/quesans/getQuesByStatus")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userQuesDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })

        fetch("http://localhost:8081/quesans/getAnsByStatus")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userAnsDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })

    }, [])

    async function approveQues(id)  {

        await fetch("http://localhost:8081/quesans/approveQues/" + id)
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                toast('Question Approved Successfully')
            }).catch((err) => {
                toast('Question Approved Successfully')
                console.log(err.message);
            })

            fetch("http://localhost:8081/quesans/getQuesByStatus")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userQuesDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })
    }

    async function approveAns(id) {

        await fetch("http://localhost:8081/quesans/approveAns/" + id)
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                toast('Answer Approved Successfully')
            }).catch((err) => {
                toast('Answer Approved Successfully')
                console.log(err.message);
            })

            fetch("http://localhost:8081/quesans/getAnsByStatus")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userAnsDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })
    }

    async function rejectQues(id) {
        
        await fetch("http://localhost:8081/quesans/rejectQues/" + id)
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                toast('Question Rejected Successfully')
            }).catch((err) => {
                toast('Question Rejected Successfully')
                console.log(err.message);
            })

            fetch("http://localhost:8081/quesans/getQuesByStatus")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userQuesDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })
    }

    async function rejectAns(id) {

        await fetch("http://localhost:8081/quesans/rejectAns/" + id)
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                toast('Answer Rejected Successfully')
            }).catch((err) => {
                toast('Answer Rejected Successfully')
                console.log(err.message);
            })

            fetch("http://localhost:8081/quesans/getAnsByStatus")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userAnsDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })
    }

    const handleLogout = () => {

        usenavigate('/');
    }

    return (

        <>
            <Navbar bg="light" expand="lg" className='container'>
                <Container>
                    <Navbar.Brand className='navbarHeading'>Admin-Dashboard</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Link to='/adminHome'><Button variant="secondary">Home</Button></Link>&ensp;
                            <Link to='/userCrud'><Button variant="secondary">User-CRUD</Button></Link>&ensp;
                            <Link to='/approval'><Button variant="info">Approval</Button></Link>&ensp;
                        </Nav>
                    </Navbar.Collapse>
                    <Button variant="danger" onClick={handleLogout}>Logout</Button>
                </Container>
            </Navbar>
            <div className='headingUser'>Questions Pending for Approval</div>
            <Table striped bordered hover style={{ maxWidth: '90%', marginLeft: '70px', border: '3px solid green' }}>
                <thead style={{ backgroundColor: 'orange', fontSize: '20px' }}>
                    <tr>
                        <th style={{ width: '4%' }}>Id</th>
                        <th>Question</th>
                        <th style={{ width: '10%' }}>Topic</th>
                        <th style={{ width: '10%' }}>Status</th>
                        <th style={{ width: '18%' }}>Actions</th>
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
                                <td>
                                    <Button variant="success" onClick={() => { approveQues(item.id) }}>
                                        Approve
                                    </Button>&ensp;
                                    <Button variant="danger" onClick={() => { rejectQues(item.id) }}>Reject</Button>
                                </td>
                            </tr>

                        ))
                    }

                </tbody>
            </Table>
            <div className='headingUser'>Answers Pending for Approval</div>
            <Table striped bordered hover style={{ maxWidth: '90%', marginLeft: '70px', border: '3px solid green' }}>
                <thead style={{ backgroundColor: 'orange', fontSize: '20px' }}>
                    <tr>
                        <th style={{ width: '4%' }}>Id</th>
                        <th>Answer</th>
                        <th style={{ width: '12%' }}>Question Id</th>
                        <th style={{ width: '10%' }}>Status</th>
                        <th style={{ width: '18%' }}>Actions</th>
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
                                <td>
                                    <Button variant="success" onClick={() => { approveAns(item.id) }}>
                                        Approve
                                    </Button>&ensp;
                                    <Button variant="danger" onClick={() => { rejectAns(item.id) }}>Reject</Button>
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

export default ApprovalComponent;