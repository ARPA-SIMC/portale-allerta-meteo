import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { ContactInput } from '../../../types.d';
import { Modal } from '../../Modal/Modal';
import styles from './ContactDetailPanel.module.css';
import cStyles from "../../../common.module.css";

export class ModifyContactForm extends Component<any, any> {

  generateValidationSchema = () => yup.object().shape({
    channelId: yup.number().required(),
    value: yup.string().required(),
    warning: yup.boolean(),
    modificaMinore: yup.boolean()
  })

  onSubmitContact = async (values: ContactInput) => {
    const result = await client.contacts.update(this.props.contact.id, {
      ...values,
      nominativeId: this.props.nominative.id
    })
    if(result.code === 204) {
      await this.props.refetch()
      Modal.hide()
      toast("Update avvenuto con successo", {
        type: toast.TYPE.SUCCESS
      })
    } else {
      toast("Update fallito, riprova", {
        type: toast.TYPE.ERROR
      })
    }
  }

  onChange = (setFieldValue) => (event) => {
    setFieldValue('channelId', event.target.value)
  }

  renderOptions = (channels) => {
    const options = channels.map(channel => <option key={channel.id} value={channel.id}>{channel.name}</option>)
    return options
  }

  onCheckChange = (setFieldValue,setFieldTouched, value) => event => {
    setFieldValue('warning', event.target.checked?true:false,true)
    setFieldTouched('warning',true,true)
  }

onCheckChange2 = (setFieldValue,setFieldTouched, value) => event => {
    setFieldValue('modificaMinore', event.target.checked?true:false,true)
    setFieldTouched('modificaMinore',true,true)
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik
        initialValues={{
          warning: this.props.contact.warning,
          value: this.props.contact.value,
          channelId: this.props.contact.channelId,
	  modificaMinore: false
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitContact}
      >
        {({isValid, setFieldValue, setFieldTouched, dirty, values}) => (
          <Form>
            <div className={cStyles.field}>
              <label>
                <span>Canale</span>
                <select style={{width: '100%'}} name="channelId" onChange={this.onChange(setFieldValue)} defaultValue={this.props.contact.channelId}>
                <>
                  <option value={undefined}> -- SELEZIONA CANALE -- </option>
                  {this.renderOptions(this.props.channels)}
                </>
                </select>
              </label>
            </div>
            <div className={cStyles.field}>
              <label>
                <span>Valore</span>
                <Field type="text" name="value" />
              </label>
            </div>
            <div className={cStyles.field}>
              <label>
                <span>Allertamento</span>
                <input type="checkbox" defaultChecked={values.warning} onChange={this.onCheckChange(setFieldValue,setFieldTouched, values.warning)} />
              </label>
            </div>
            <div className={cStyles.field}>
              <label>
                <span>Modifica minore</span>
                <input type="checkbox" defaultChecked={false} onChange={this.onCheckChange2(setFieldValue,setFieldTouched, values.modificaMinore)} />
              </label>
            </div>

            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid || !dirty} type="submit"> Salva </button>

          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}
