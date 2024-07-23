import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field, FormikValues, FormikActions} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { PanelContext } from '../../../context/panelContext';
import { PanelType, GroupInput } from '../../../types.d';
import styles from './GroupDetailPanel.module.css';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css";

export class CreateGroupForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  generateValidationSchema = () => yup.object().shape({
    name: yup.string().required(),
    categoria: yup.number().required()
  })

  onSubmitGroup = async (values: GroupInput) => {
    const result = await client.groups.create(values)
    if(result.code === 201) {
      toast("Gruppo creato con successo", {
        type: toast.TYPE.SUCCESS
      })
      this.props.refetch()
      Modal.hide()
    } else {
      toast("Creazione gruppo fallita, riprova", {
        type: toast.TYPE.ERROR
      })
    }
  }

renderOptions = (channels) => {
    const options = channels.map(channel => <option key={channel.ID_CATEGORIA} value={channel.ID_CATEGORIA}>{channel.DESCRIZIONE}</option>)
    return options
  }

 onChange = (setFieldValue) => (event) => {
    console.log('nuova categoria '+event.target.value)
    setFieldValue('categoria', event.target.value)
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik
        initialValues={{
          name: '',
          categoria: -1
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitGroup}
      >
        {({isValid, setFieldValue}) => (
          <Form>
            <div className={cStyles.field}>
              <label>
                <span>Nome</span>
                <Field type="text" name="name" />
              </label>
            </div>
           <div className={cStyles.field}>
	     <label>
                <span>Categoria</span>
                <select name="categoria" id="categoria" onChange={this.onChange(setFieldValue)}>
                <>
                  <option value={-1}> NESSUNA </option>
                  {this.renderOptions(this.props.categories)}
                </>
                </select>
              </label>
              </div>
            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} type="submit"> Crea </button>

          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}
