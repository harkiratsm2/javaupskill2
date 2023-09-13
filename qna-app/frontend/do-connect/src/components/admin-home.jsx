import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { useNavigate } from 'react-router';
import { useEffect } from "react";
import { Link } from 'react-router-dom';
import '../styles/navbar.css'

const AdminHomeComponent = () => {

    const usenavigate = useNavigate();

    let usernameLoggedIn = sessionStorage.getItem('username');

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

    }, [])

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
                            <Link to='/adminHome'><Button variant="info">Home</Button></Link>&ensp;
                            <Link to='/userCrud'><Button variant="secondary">User-CRUD</Button></Link>&ensp;
                            <Link to='/approval'><Button variant="secondary">Approval</Button></Link>&ensp;
                        </Nav>
                    </Navbar.Collapse>
                    <Button variant="danger" onClick={handleLogout}>Logout</Button>
                </Container>
            </Navbar>
            <div className='headingUser'>Welcome, {usernameLoggedIn}</div>
        </>

    )

}

export default AdminHomeComponent;