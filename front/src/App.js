import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListChildrenComponent from './components/ListChildrenComponent';
import ViewChildComponent from './components/ViewChildComponent';
import CreateChildComponent from './components/CreateChildComponent';
import CreateVoucherComponent from './components/CreateVoucherComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent/>
          <div className="container">
            <Switch>
                <Route path = "/" exact component = {ListChildrenComponent}></Route>
                <Route path = "/add/:id" component = {CreateChildComponent}></Route>
                <Route path = "/view/:id" component = {ViewChildComponent}></Route>
                <Route path = "/voucher" component = {CreateVoucherComponent}></Route>

            </Switch>
          </div>
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
