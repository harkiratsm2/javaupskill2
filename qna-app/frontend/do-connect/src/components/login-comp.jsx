import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import "react-toastify/dist/ReactToastify.css"
import { useEffect } from "react";
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import '../styles/login.css';

const LoginComponent = () => {

  const [username, usernameChange] = useState('');
  const [password, passwordChange] = useState('');

  const usenavigate = useNavigate();

  useEffect(() => {
    sessionStorage.clear();
  }, [])

  const handleLogin = (e) => {

    e.preventDefault();
    if (validate()) {

      fetch("http://localhost:8080/user/findUser/" + username + "/" + password)
        .then((res) => {
          return res.json();
        }).then((resp) => {
          console.log(resp)
          if (Object.keys(resp).length === 0) {
            toast('Username/Password is Invalid');
          }
          else {
            if (resp.role === 'student') {
              sessionStorage.setItem('username', resp.username.toLowerCase());
              sessionStorage.setItem('role', resp.role);
              usenavigate('/studentHome');
            }
            else {
              sessionStorage.setItem('username', resp.username.toLowerCase());
              sessionStorage.setItem('role', resp.role);
              usenavigate('/adminHome');
            }

          }
        }).catch((err) => {
          toast('Username/Password is Invalid');
        })

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
    return result;
  }

  return (
    <>
      <Card style={{ width: '20rem' }} className="card">
        <Card.Body>
          <Card.Title style={{ textAlign: 'center' }}><span className="cardHeading">Login</span></Card.Title>
          <br />
          <br />
          <Form onSubmit={handleLogin}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
              <Form.Label>Username</Form.Label>
              <Form.Control type="text" placeholder="Enter your Username" value={username} onChange={e => usernameChange(e.target.value)} />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" placeholder="Password" value={password} onChange={e => passwordChange(e.target.value)} />
            </Form.Group>
            <br />
            <div className="divButton">
              <Button variant="success" type="submit" className="button" size="lg">
                Submit
              </Button>
            </div>
          </Form>
          <br />
          <Link to="/register"><center>New User? Click here to Sign-Up</center></Link>
        </Card.Body>
      </Card>
      <ToastContainer />
    </>
  )
}

export default LoginComponent;