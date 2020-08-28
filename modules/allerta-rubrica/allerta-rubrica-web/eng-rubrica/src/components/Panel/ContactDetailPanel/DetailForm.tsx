import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field, FormikValues, FormikActions} from 'formik';
import { client } from '../../../resources';
import { PanelContext } from '../../../context/panelContext';
import { NominativeInput, PanelType } from '../../../types.d';
import { Modal } from '../../Modal/Modal';
import * as yup from 'yup';
import cStyles from "../../../common.module.css";
import styles from './ContactDetailPanel.module.css';


export class DetailForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  generateValidationSchema = () => yup.object().shape({
    firstName: yup.string().required(),
    lastName: yup.string().required(),
    address: yup.string(),
    modificaMinore: yup.boolean()
  })

  onSubmitNominative = async (values: NominativeInput) => {
    const result = await client.nominatives.update(this.props.nominative.id, values)
    if(result.code === 204) {
      await this.props.refetch()
      Modal.hide()
      toast("Nominativo modificato", {
        type: toast.TYPE.SUCCESS
      })
    } else {
      await this.props.refetch()
      toast("Modifica fallita, riprova", {
        type: toast.TYPE.ERROR
      })
    }
  }

onCheckChange2 = (setFieldValue, value) => event => {
    setFieldValue('modificaMinore', event.target.value?true:false)
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik
        initialValues={{
          firstName: this.props.nominative.firstName,
          lastName: this.props.nominative.lastName,
          contacts: this.props.nominative.contacts,
          address: this.props.nominative.address,
          groups: this.props.nominative.groups,
          group: null,
          role: null,
          specificaRuolo:'',
          modificaMinore:false
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubmitNominative}
      >
        {({isValid, setFieldValue, values}) => (
          <Form>
            <div className={cStyles.field}>
              <label>
                <span>Nome</span>
                <Field type="text" name="firstName" />
              </label>
            </div>
            <div className={cStyles.field}>
              <label>
                <span>Cognome</span>
                <Field type="text" name="lastName" />
              </label>
            </div>
            <div className={cStyles.field}>
              <label>
                <span>Indirizzo</span>
                <Field type="text" name="address" />
              </label>
            </div>
	 <div className={cStyles.field}>
              <label>
                <span>Modifica minore</span>
                <input type="checkbox" defaultChecked={false} onChange={this.onCheckChange2(setFieldValue, values.modificaMinore)} />
              </label>
            </div>

            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} type="submit"> Modifica </button>

          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}
