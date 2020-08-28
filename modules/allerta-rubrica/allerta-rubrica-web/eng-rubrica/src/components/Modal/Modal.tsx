import React from "react";
import styles from "./Modal.module.css";
import cStyles from "../../common.module.css"

interface ModalState {
  show: boolean,
  title: string,
  content: JSX.Element | null,
  onAccept: any,
  onDismiss: any,
  tall: boolean
}

export class Modal extends React.Component<any, ModalState> {
  state = {
    show: false,
    title: '',
    content: null,
    tall: false,
    onAccept: undefined,
    onDismiss: undefined
  }
  static instance: Modal;

  static show = (title: string, content: JSX.Element, onAccept:any = undefined, onDismiss:any = undefined) => {
    Modal.instance._show(title, content, onAccept, onDismiss)
  }

  static showTall = (title: string, content: JSX.Element, onAccept:any = undefined, onDismiss:any = undefined) => {
    Modal.instance._showTall(title, content, onAccept, onDismiss)
  }

  static hide = () => {
    Modal.instance._hide()
  }

  constructor(props: any) {
    super(props)
    Modal.instance = this
  }

  _hide = () => {
    Modal.instance.setState({
      show: false,
      title: '',
      content: null,
      onAccept: () => {},
      onDismiss: () => {}
    })
  }

  _show = (title: string, content: JSX.Element, onAccept: () => void, onDismiss: () => void) => {
    window.scrollTo(0,0)
    Modal.instance.setState({
      show: true,
      title,
      content,
      onAccept,
      onDismiss
    })
  }

  _showTall = (title: string, content: JSX.Element, onAccept: () => void, onDismiss: () => void) => {
    window.scrollTo(0,0)
    Modal.instance.setState({
      show: true,
      tall: true,
      title,
      content,
      onAccept,
      onDismiss
    })
  }

  dismiss = () => {
    if(this.state.onDismiss && typeof this.state.onDismiss === 'function') {
      this.state.onDismiss();
    }
    this._hide();
  }

  render() {
    return (
      this.state.show && (
        <>
          <div className={styles.backDrop} onClick={this._hide}></div>
          <div className={this.state.tall?styles.tallModal:styles.modal}>
            <h1 className={styles.modalTitle}>{this.state.title}</h1>
            <div className={styles.modalContent}>
              {this.state.content}
            </div>
            <div className={styles.modalActions}>
              <button className={cStyles.button} onClick={this.dismiss}>Annulla</button>
              {typeof this.state.onAccept === 'function' && (
                <button className={cStyles.button} onClick={this.state.onAccept}>Conferma</button>
              )}
            </div>
          </div>
        </>
      )
    )
  }
}
