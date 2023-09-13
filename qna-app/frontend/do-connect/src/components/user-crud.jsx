import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Table from 'react-bootstrap/Table';
import { useNavigate } from 'react-router';
import { useEffect, useState } from "react";
import { Link } from 'react-router-dom';
import '../styles/navbar.css'
import { ToastContainer, toast } from 'react-toastify';

const UserCrudComponent = () => {

    const usenavigate = useNavigate();

    const [userData, userDataChange] = useState(null);

    useEffect(() => {

        let username = sessionStorage.getItem('username');
        let role = sessionStorage.getItem('role');

        console.log(username);
        if (username === '' || username === null || role !== 'admin') {
            usenavigate('/');
        }

        fetch("http://localhost:8080/user/getAllUsers")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                userDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })

    }, []);

    async function deleteUser(id) {
        
        await fetch("http://localhost:8080/user/delete/" + id, {
            method: "DELETE"
        })
            .then(() => {
                console.log('i am response from delete method')
                toast("Item Deleted SuccessFully");
            }).catch((err) => {
                console.log(err.message);
                toast('Item not Deleted');
            })

            fetch("http://localhost:8080/user/getAllUsers")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log('i am fetching data after deletion')
                console.log(resp);
                userDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })
    }

    const updateUser = (id) => {
        usenavigate("/updateUser/" + id);
    }

    const handleLogout = () => {

        sessionStorage.clear();
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
                            <Link to='/userCrud'><Button variant="info">User-CRUD</Button></Link>&ensp;
                            <Link to='/approval'><Button variant="secondary">Approval</Button></Link>&ensp;
                        </Nav>
                    </Navbar.Collapse>
                    <Button variant="danger" onClick={handleLogout}>Logout</Button>
                </Container>
            </Navbar>
            <div className='headingUser'>Users</div>
            <Link to="/addUser">
                <Button variant="info" size="lg" style={{ marginLeft: '80px', marginBottom: '20px' }}>
                    Add User
                </Button></Link>
            <Table striped bordered hover style={{ maxWidth: '90%', marginLeft: '70px', border: '3px solid green' }}>
                <thead style={{ backgroundColor: 'orange', fontSize: '20px' }}>
                    <tr>
                        <th style={{ width: '8%' }}>User Id</th>
                        <th>User Name</th>
                        <th>Password</th>
                        <th>Phone</th>
                        <th>E-Mail</th>
                        <th>Role</th>
                        <th style={{ width: '18%' }}>Actions</th>
                    </tr>
                </thead>
                <tbody>

                    {
                        userData &&
                        userData.map(item => (

                            <tr key={item.id}>
                                <td>
                                    {item.id}
                                </td>
                                <td>
                                    {item.username}
                                </td>
                                <td>
                                    {item.password}
                                </td>
                                <td>
                                    {item.phone}
                                </td>
                                <td>
                                    {item.email}
                                </td>
                                <td>
                                    {item.role}
                                </td>
                                <td>
                                    <Button variant="success" onClick={() => { updateUser(item.id) }}>
                                        Update
                                    </Button>&ensp;
                                    <Button variant="danger" onClick={() => { deleteUser(item.id) }}>Delete</Button>
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

export default UserCrudComponent;