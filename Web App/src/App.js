import React, { Component } from 'react';
import './components/css/pages.css';


class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      i : 0
    }
  }

  _search(){

  }

  render() {
    return (
      <div className="App">
      <img src='./components/images/good_logo.png' width="100" height="100" alt=''/>
      <div id="landing_page_body">
          <div id="landing_heading">WindLabs Database Query</div>
          <div id="searchbar_wrapper">
              <div id="searchbar">
                  <input type="text" id="searchbar_input" placeholder="Search for a location" onChangeText={(text) => this.setState('query':text)}/>
                  <img src="https://imageog.flaticon.com/icons/png/512/49/49116.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF" id="search_icon" alt="ee"/>
              </div>
          </div>
          <div id="bezier_curve"><img src="./images/bezier_good.png" alt=""/></div>
      </div>
      </div>
    );
  }
}

export default App;
