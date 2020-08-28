import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field, FormikValues, FormikActions} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { PanelContext } from '../../../context/panelContext';
import styles from './GroupDetailPanel.module.css';
import cStyles from "../../../common.module.css";
import { Modal } from '../../Modal/Modal';
import { debounced } from '../../../utils';


export class GroupList extends Component<any, any> {
  state = {
    data: [],
    selected: [],
    loading: true,
    error: undefined,
    timestamp: 0
  }

  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  generateValidationSchema = () => yup.object().shape({
    ids: yup.array().required(),
  })

  onSubgroupAdd = async (values: any, actions: any) => {
    try {
      const result = await client.groups.setSubgroup(this.props.group.id, values.id)
      if(result.code === 201) {
        toast("Sottogruppo associato", {
          type: toast.TYPE.SUCCESS
        })
        Modal.hide()
        this.props.refetch()
      }
    } catch (error) {
      console.error(error)
      toast('Errore nell\' associazione', {
        type: toast.TYPE.ERROR
      })
    }
  }

  handleSelection = (group, setFieldValue) => (event) => {
    let selected = []
    if (this.state.selected.find(el => el.id === group.id) !== undefined) {
      selected = [...this.state.selected.filter(el => el .id !== group.id)]
    } else {
      selected = [...this.state.selected, {subgroupId: group.id}]
    }
    setFieldValue('ids', selected)
    this.setState({selected})
  }

  handleSubmit = async (values, actions) => {
    try {
      const response = this.props.supergroup? await client.groups.setSupergroupMulti(this.props.group.id, values.ids) : await client.groups.setSubgroupMulti(this.props.group.id, values.ids)
      if(response.code >= 200 && response.code < 300) {
        toast("Richiesta eseguita", {
          type: toast.TYPE.SUCCESS
        })
        Modal.hide()
        this.props.refetch()
      }
    } catch (err) {
      console.error(err)
      toast('Errore nell\' associazione', {
        type: toast.TYPE.ERROR
      })
    }
  }

  async componentDidMount() {
    const data = await client.groups.all('', 100000, 0)
    if(data.code === 200) {
      if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
  }

filterData = async (e) => {
    let data = await client.groups.all(e.target.value, 100000, 0)
    if(data.code === 200) {
      if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
    } else {
      this.setState({error: 'Errore API', loading: false})
    }
    if(e.target.value === '') {
      data = await client.groups.all('', 100000, 0)
      if(data.code === 200) {
        if (data.timestamp>this.state.timestamp) this.setState({data: data.data, loading: false, timestamp: data.timestamp})
      } else {
        this.setState({error: 'Errore API', loading: false})
      }
    }
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
        <Formik
          initialValues={{
            ids: []
          }}
          validationSchema={this.generateValidationSchema()}
          onSubmit={this.handleSubmit}
        >
          {({isValid, setFieldValue, resetForm}) => (
            <Form>
            <input type="text" onChange={debounced(this.filterData, 350)} />
              <ul className={cStyles.list}>
                {this.state.data && this.state.data.map(el => <React.Fragment key={el.id}>
                  {el.id !== -1 && el.id !== this.props.group.id && (
                    <li style={{}}>
                      <input type="checkbox" defaultChecked={false} onChange={this.handleSelection(el, setFieldValue)} />
                      <span>{el.name}</span>
                    </li>
                  )}
                  </React.Fragment>
                )}
              </ul>

              <button
                style={{marginTop: '1rem'}}
                className={`${cStyles.button} ${cStyles.actionButton}`}
                disabled={!isValid} type="submit"
              >
                Associa
              </button>

            </Form>
          )}
        </Formik>
      </div>
    </>
  )}
}
