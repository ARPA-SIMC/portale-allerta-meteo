import React, { Component } from "react";
import { client } from '../../resources';

type TimerState = {
  time: any
  start: any
  timer : any
  isOn: boolean
}

export class Timer extends React.Component<{}, TimerState> {
  constructor(props){
    super(props)
    this.state = {
      time: 0,
      start: 0,
      timer: null,
      isOn: false
    }    
    this.startTimer = this.startTimer.bind(this)
    this.stopTimer = this.stopTimer.bind(this)
    this.resetTimer = this.resetTimer.bind(this)
  }  

  startTimer() {
    this.setState({
      time: this.state.time,
      start: Date.now() - this.state.time,
      isOn: true
    })
    this.setState({timer : setInterval(() => client.channels.all(), 60000) });
  }  

  stopTimer() {
    this.setState({isOn: false})
    clearInterval(this.state.timer)
  }  

  resetTimer() {
    this.setState({time: 0})
  }  

  render() {    
	if (!this.state.isOn) this.startTimer()
	return <div></div>
    
  }
}