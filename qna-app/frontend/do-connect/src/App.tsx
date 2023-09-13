import React from 'react';
import { Route, Routes } from 'react-router-dom';
import AddUserComponent from './components/add-user';
import AdminHomeComponent from './components/admin-home';
import ApprovalComponent from './components/approval-comp';
import AskQuestionComponent from './components/ask-question';
import HeadingComponent from './components/header-comp';
import LoginComponent from './components/login-comp';
import QnAComponent from './components/qna-comp';
import RegisterComponent from './components/register-comp';
import StudentHomeComponent from './components/student-home';
import UpdateUserComponent from './components/update-user';
import UserCrudComponent from './components/user-crud';

function App() {
  return (
    <>
      <HeadingComponent/>
      <Routes>
        <Route path='/' element = {<LoginComponent />} />
        <Route path='/register' element = {<RegisterComponent />} />
        <Route path='/studentHome' element = {<StudentHomeComponent />} />
        <Route path='/askQues' element = {<AskQuestionComponent />} />
        <Route path='/qna' element = {<QnAComponent />} />
        <Route path='/adminHome' element = {<AdminHomeComponent />} />
        <Route path='/addUser' element = {<AddUserComponent />} />
        <Route path='/updateUser/:id' element = {<UpdateUserComponent />} />
        <Route path='/userCRUD' element = {<UserCrudComponent />} />
        <Route path='/approval' element = {<ApprovalComponent />} />
      </Routes>
    </>
    
  );
}

export default App;
