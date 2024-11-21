import logo from './logo.svg';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import { Dashboard } from './containers/Dashboard/Dashboard';

function App() {
  return (
    <div className="APP">
      <BrowserRouter>
        <Dashboard />
      </BrowserRouter>
    </div>
  );
}

export default App;
