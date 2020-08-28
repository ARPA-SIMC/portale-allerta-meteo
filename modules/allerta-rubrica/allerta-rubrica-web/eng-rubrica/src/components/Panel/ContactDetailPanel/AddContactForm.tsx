import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { ContactInput } from '../../../types.d';
import styles from './ContactDetailPanel.module.css';
import { Modal } from '../../Modal/Modal';
import cStyles from "../../../common.module.css";

export class AddContactForm extends Component<any, any> {

  generateValidationSchema = () => yup.object().shape({
    channelId: yup.number().required(),
    value: yup.string().required(),
    warn: yup.boolean(),
  })

  onSubmitContact = async (values: ContactInput) => {
    const result = await client.contacts.create({
      ...values,
      nominativeId: this.props.nominative.id
    })
    if(result.code === 201) {
      await this.props.refetch()
      toast("Update avvenuto con successo", {
        type: toast.TYPE.SUCCESS
      })
      Modal.hide()
    } else {
      toast("Update fallito, riprova", {
        type: toast.TYPE.ERROR
      })
    }
  }

  onChange = (setFieldValue) => (event) => {
    setFieldValue('channelId', event.target.value)
  }

  onCheckChange = (setFieldValue, value) => event => {
    setFieldValue('warning', event.target.checked)
  }

  renderOptions = (channels) => {
    const options = channels.map(channel => <option key={channel.id} value={channel.id}>{channel.name}</option>)
    return options
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik
        initialValues={{
          warning: true,
          value: '',
          channelId: null
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitContact}
      >
        {({isValid, setFieldValue, values}) => (
          <Form>
            <div className={cStyles.field}>
              <label>
                <span>Canale</span>
                <select name="channelId" onChange={this.onChange(setFieldValue)}>
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
                <input type="checkbox" defaultChecked={values.warning} onChange={this.onCheckChange(setFieldValue, values.warning)} />
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
