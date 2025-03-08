import { BrowserRouter, Route, Routes } from 'react-router'
import './App.css'
import EventPage from './Events/EventPage'
import EventDescription from './Events/EventDescription'

function App() {

  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<EventPage/>}/>
        <Route path='/event' element={<EventDescription/>}/>
      </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
