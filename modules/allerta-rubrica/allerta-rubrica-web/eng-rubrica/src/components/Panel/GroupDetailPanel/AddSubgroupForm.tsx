import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field, FormikValues, FormikActions} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { PanelContext } from '../../../context/panelContext';
import styles from './GroupDetailPanel.module.css';
import cStyles from "../../../common.module.css";
import AutocompleteGroup from '../../Autocomplete/AutocompleteGroup';
import { Modal } from '../../Modal/Modal';

export class AddSubgroupForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  generateValidationSchema = () => yup.object().shape({
    id: yup.mixed().required(),
  })

  onSubgroupAdd = async (values: any, actions: any) => {
    try {
      const result = await client.groups.setSubgroup(this.props.group.id, values.id)
      if(result.code === 201) {
        toast("Sottogruppo aggiunto con successo", {
          type: toast.TYPE.SUCCESS
        })
        Modal.hide()
        this.props.refetch()
      }
    } catch (error) {
      console.error(error)
      toast(error, {
        type: toast.TYPE.ERROR
      })
    }
  }

  render() {
    return (
    <>
      <div className={styles.detailForm}>
      <Formik
        initialValues={{
          id: ''
        }}
        validationSchema={this.generateValidationSchema()}
        onSubmit={this.onSubgroupAdd}
      >
        {({isValid, setFieldValue, resetForm}) => (
          <Form>
            <div>
              <label>
                <span>Sottogruppo da aggiungere: </span>
                <AutocompleteGroup update={setFieldValue} />
              </label>
            </div>

            <button
              style={{marginTop: '1rem'}}
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} type="submit"> Aggiungi Sottogruppo </button>

          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}
