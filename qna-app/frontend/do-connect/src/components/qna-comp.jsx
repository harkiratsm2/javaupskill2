import Card from 'react-bootstrap/Card';
import { useEffect, useState } from "react";
import { useNavigate } from 'react-router';
import { Link } from 'react-router-dom';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import { ToastContainer, toast } from 'react-toastify';
import InputGroup from 'react-bootstrap/InputGroup';
import "react-toastify/dist/ReactToastify.css"
import '../styles/navbar.css'

const QnAComponent = () => {

    const [answer, answerChange] = useState("");
    const [search, searchChange] = useState('');
    const [imageUrlFetch, imageUrlChange] = useState("")

    const [isShown, setIsShown] = useState(false);

    const [questionId, questionIdChange] = useState('');

    const usenavigate = useNavigate();

    const [quesansData, quesansDataChange] = useState([]);

    useEffect(() => {

        let username = sessionStorage.getItem('username');
        let role = sessionStorage.getItem('role');

        console.log(username);
        console.log(role);
        if (username === '' || username === null || role !== 'student') {
            usenavigate('/');
        }

        fetch("http://localhost:8081/quesans/getApprovedQuesAndAns")
            .then((res) => {
                return res.json();
            }).then((resp) => {
                console.log(resp);
                quesansDataChange(resp);
            }).catch((err) => {
                console.log(err.message);
            })
    }, [])

    const handleLogout = () => {

        usenavigate('/');
    }

    const handleAnswer = (id) => {



        if (validate()) {

            let username = sessionStorage.getItem('username');
            let quesId = id;

            let imagePath = imageUrlFetch.substring(12, imageUrlFetch.length);

            let imageUrl = "../assets/" + imagePath;

            let answerData = { answer, username, quesId, imageUrl };

            console.log(answerData);

            fetch("http://localhost:8081/quesans/addAnswer", {
                method: "POST",
                headers: { 'content-type': 'application/json' },
                body: JSON.stringify(answerData)
            }).then((res) => {
                console.log('Answer saved Successfully');
                toast('Answer Succesfully Sent for Approval');
            }).catch((err) => {
                console.log('Failed' + err.message);
                toast('Question not Saved');
            });
        }

    }

    const validate = () => {

        let result = true;
        if (answer === '' || answer === null) {
            result = false;
            toast('Please Enter Answer')
        }

        return result;
    }

    const handleClick = (e) => {

        console.log(e);

        answerChange('');

        imageUrlChange('');

        questionIdChange(e);

        setIsShown(true);
    }

    const handleClose = () => {

        setIsShown(false);
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
                            <Link to='/askQues'><Button variant="secondary">Ask Question</Button></Link>&ensp;
                            <Link to='/qna'><Button variant="info">QnA</Button></Link>&ensp;
                        </Nav>
                    </Navbar.Collapse>
                    <Button variant="danger" onClick={handleLogout}>Logout</Button>
                </Container>
            </Navbar>
            <br />
            <InputGroup className="mb-3" style={{ maxWidth: '30%', float: 'right', marginRight: '50px' }}>
                <InputGroup.Text id="basic-addon1">Search</InputGroup.Text>
                <Form.Control
                    placeholder="Search"
                    aria-label="Search"
                    aria-describedby="basic-addon1"
                    value={search} onChange={(e) => searchChange(e.target.value)} />
            </InputGroup>
            <br />

            {

                quesansData.filter(data => data.question.toLowerCase().includes(search.toLowerCase())).map(item => (
                    <div>
                        <Card key={item.id} style={{ marginLeft: '50px', marginRight: '50px' }}>
                            <Card.Body>
                                <div style={{ textAlign: 'right', fontSize: '20px', fontWeight: '700', marginRight: '30px' }}>Topic: {item.topic}</div>
                                <div style={{ marginLeft: '30px', marginRight: '30px' }}>
                                    <span style={{ fontSize: '25px', fontWeight: '700' }}>{item.question}</span>
                                    <span style={{ float: 'right', color: 'darkgreen', fontSize: '23px', fontWeight: '700', backgroundColor: 'yellow', borderRadius: '10px', border: '3px solid black' }}>{item.status}</span>
                                </div>
                                <div style={{ marginLeft: '30px', fontSize: '18px', fontWeight: '600', color: 'red' }}>(Asked By: {item.username})</div>
                                <div><center><img src={item.imageUrl} alt='' /></center></div>
                                <hr />
                                {
                                    item.answers.map(item1 => (
                                        <div key={item1.id}>
                                            <div><center><img src={item1.imageUrl} alt='' /></center></div>
                                            <div style={{ marginLeft: '100px', fontSize: '18px', fontWeight: '600' }}>{item1.answer}</div>
                                            <div style={{ marginright: '30px', fontSize: '18px', fontWeight: '600', color: 'red', textAlign: 'right' }}>--Answered By: {item1.username}</div>
                                        </div>

                                    ))
                                }
                                {
                                    !isShown || questionId !== item.id ?
                                        <center><Button variant="success" type="submit" onClick={() => { handleClick(item.id) }}>Give Answer</Button></center>
                                        :
                                        questionId === item.id && <>
                                            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                                                <Form.Control type="text" placeholder="Give Answer" value={answer} onChange={e => answerChange(e.target.value)} />
                                            </Form.Group>
                                            <Form.Group controlId="formFile" className="mb-3">
                                                <Form.Label>Upload Image</Form.Label>
                                                <Form.Control type="file" value={imageUrlFetch} onChange={e => imageUrlChange(e.target.value)} />
                                            </Form.Group>
                                            <center><Button variant="success" type="submit" onClick={() => { handleAnswer(item.id) }}>
                                                Submit
                                            </Button>
                                            &nbsp; &nbsp; &nbsp;
                                            <Button variant="warning" type="submit" onClick={() => { handleClose() }}>
                                                Close
                                            </Button>
                                            </center>
                                        </>
                                }

                            </Card.Body>
                        </Card>
                    </div>

                ))
            }
            <ToastContainer />
        </>
    );

}

export default QnAComponent;