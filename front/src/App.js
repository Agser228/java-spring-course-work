import { BrowserRouter as Routes, Route } from 'react-router-dom';
import './App.css';
import CreateChildComponent from './components/CreateChildComponent';
import HeaderComponent from './components/HeaderComponent';
import ListChildrenComponent from './components/ListChildrenComponent';
import Footer from './components/UI/footer/Footer';
import ViewChildComponent from './components/ViewChildComponent';
import Squads from './pages/Squads';
import Voucher from './pages/Voucher';
import Children from './pages/Children';
import { BrowserRouter } from "react-router-dom"
import AppRouter from './components/AppRouter';
import Navbar from "./components/UI/navbar/Navbar";


function App() {
  return (
    <div>
          <div className="container">
              <BrowserRouter>
              <Navbar/>
              <AppRouter/>
            </BrowserRouter>
          </div>
        <Footer/>
    </div>
  );
}

export default App;
