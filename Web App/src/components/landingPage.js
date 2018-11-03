import React, { Component } from 'react';
import './css/pages.css';

class LandingPage extends Component {
  constructor(props){
    super(props);
    this.state = {
      query:''
    }
  }

  _search(){

  }

  render() {
    return (
      <div className="landing-page-wrapper">
      <div id="landing_page_body">
          <div id="landing_heading">WindLabs Database Query</div>
          <div id="searchbar_wrapper">
              <div id="searchbar">
                  <input type="text" id="searchbar_input" placeholder="Search for a location" onChangeText={(text) => this.setState('query':text)}/>
                  <i className="fas fa-search" id="search_icon" onClick={this._search()}></i>
              </div>
          </div>
          <div id="bezier_curve"><img src="./images/bezier.svg" alt=""/></div>
      </div>
      </div>
    );

  }
}

export default LandingPage;
