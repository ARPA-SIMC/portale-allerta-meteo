import React, {Component} from 'react';
import { toast } from 'react-toastify';
import {Formik, Form, Field, FormikValues, FormikActions} from 'formik';
import { client } from '../../../resources';
import * as yup from 'yup';
import { PanelContext } from '../../../context/panelContext';
import cStyles from "../../../common.module.css";

export class MoveNominativeForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>

  state = {
    selectedGroupId: undefined
  }

  submitChanges = (values: any) => {
    client.groups.setNominativeRole(this.state.selectedGroupId, values.nominativeId, values.roleId)
  }

  handleChange = (setFieldValue, id) => (event) => {
    setFieldValue('nominatives', id)
  }

  render() {
    return (
    <>
      <div className={''}>
      <Formik 
        initialValues={{
          nominatives: [],
        }} 
        onSubmit={this.submitChanges}
      >
        {({values, isValid, setFieldValue}) => (
          <Form>
            <ul>
              {this.props.nominatives.map((el,idx) => {
                <li>
                  {el.firstName} {el.lastName}
                  <input hidden value={el.id} />
                  <select name="roleId" onChange={this.handleChange(setFieldValue, el.id)}>
                    {this.context.roles.map((role) => {
                      <option value={role.id}>{role.name}</option>
                    })}
                  </select>
                </li>
              })
              }
            </ul>
            <button
              className={`${cStyles.button} ${cStyles.actionButton}`}
              disabled={!isValid} 
              type="submit"> Salva Modifiche </button>
          </Form>
        )}
      </Formik>
      </div>
    </>
  )}
}