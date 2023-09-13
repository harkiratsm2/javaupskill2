import { Route, Routes } from "react-router";
import HeadingComponent from "./components/header-comp";
import TaskComponent from "./components/tasks-comp";
import AddTaskComponent from "./components/add-task";
import UpdateTaskComponent from "./components/update-task";

function App()
{
  return(
    <>
    <HeadingComponent/>
    <Routes>
      <Route path='/' element = {<TaskComponent />} />
      <Route path='/addTask' element = {<AddTaskComponent />} />
      <Route path='/updateUser/:id' element = {<UpdateTaskComponent />} />
    </Routes>
    </>
  )
}

export default App;