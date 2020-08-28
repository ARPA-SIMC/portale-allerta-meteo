import React, { Component } from "react";
import { Loader } from "../../Loader";
import { client } from "../../../resources";
import { PanelContext } from "../../../context/panelContext";
import styles from "./PermissionPanel.module.css"
import { toast, ToastType } from "react-toastify";

type PermissionPanelState = {
  loading: boolean;
  data?: any;
  error?: string | null;
}

export class PermissionPanel extends Component<any, PermissionPanelState> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  state = {
    loading: false,
    data: new Array(),
    error: null
  }

  fetchData = async () => {
    try {
      this.setState({ loading: true })
      const {data} = await client.rolesPermission.all()
      console.log(data)
      this.setState({ loading: false, data, error: null})
    }
    catch(err) {
      console.error(err);
      this.setState({loading: false, data: [], error: 'API Error'})
    }
  }



  handleChange = (role) => async (event) => {
    event.persist()
    try {
      console.log(event.target.value, 'prev', role.read, 'next', !role.read)
      switch(event.target.value) {
        case "R":
          const r = await client.rolesPermission.update(role.roleId, role.permission, !role.read, role.write)
          break;
        case "W":
          const w = await client.rolesPermission.update(role.roleId, role.permission, role.read, !role.write)
          break;
        case "P":
          const p = await client.rolesPermission.update(role.roleId, !role.permission, role.read, role.write)
          break;
      }
      toast('Ruolo aggiornato con successo', {type: ToastType.SUCCESS})
      this.fetchData()
    } catch (error) {
      toast('Errore nell\' aggiornamento', {type: ToastType.ERROR})
    }
  }

  componentDidMount() {
    this.fetchData()
  }

  render() {
    const {loading, error, data} = this.state;
    return (
      <>
        {loading && data.length === 0 && <Loader />}
        {!loading && !error && data.length > 0 && (
          <div className={styles.permissionGrid}>
            <span style={{textAlign: 'center', fontWeight: 'bold'}}>RUOLO</span>
            <span style={{textAlign: 'center', fontWeight: 'bold'}}>LETTURA</span>
            <span style={{textAlign: 'center', fontWeight: 'bold'}}>SCRITTURA</span>
            <span style={{textAlign: 'center', fontWeight: 'bold'}}>PERMESSI</span>
            {this.state.data.map(el => {
              return (<React.Fragment key={el.roleId}>
                <span className={`${styles.perm} ${styles.left}`}>{el.roleName}</span>
                <span className={styles.perm}>
                  <input type="checkbox" value={'R'} onChange={this.handleChange(el)} defaultChecked={el.read}/>
                </span>
                <span className={styles.perm}>
                  <input type="checkbox" value={'W'} onChange={this.handleChange(el)} defaultChecked={el.write}/>
                </span>
                <span className={styles.perm}>
                  <input type="checkbox" value={'P'} onChange={this.handleChange(el)} defaultChecked={el.permission}/>
                </span>
              </React.Fragment>)
            })}
          </div>
        )}
        {!loading && error && ( <div>{error}</div> )}
      </>
    )
  }
}
