import React, { Component } from "react";
import { toast } from "react-toastify";
import { Formik, Form, Field } from "formik";
import * as yup from "yup";
import { client } from "../../../resources";
import { PanelContext } from "../../../context/panelContext";
import { GroupInput } from "../../../types.d";
import styles from "./GroupDetailPanel.module.css";
import cStyles from "../../../common.module.css";
import { Modal } from "../../Modal/Modal";

export class GroupForm extends Component<any, any> {
  static contextType = PanelContext;
  context!: React.ContextType<typeof PanelContext>;

  generateValidationSchema = () =>
    yup.object().shape({
      name: yup.string().required(),
      categoria: yup.number().required()
    });

  onSubmitGroup = async (values: GroupInput) => {
    const result = await client.groups.update(this.props.group.id, values);
    if (result.code === 204) {
      toast("Gruppo modificato", {
        type: toast.TYPE.SUCCESS
      });
      Modal.hide();
      this.props.refetch();
    } else {
      toast("Modifica fallita, riprova", {
        type: toast.TYPE.ERROR
      });
    }
  };

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
              name: this.props.group.name,
              categoria:this.props.group.categoria || -1
            }}
            validationSchema={this.generateValidationSchema()}
            onSubmit={this.onSubmitGroup}
          >
            {({ isValid, setFieldValue }) => (
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
                <select name="categoria" id="categoria" onChange={this.onChange(setFieldValue)} defaultValue={this.props.group.categoria||-1}>
                <>
                  <option value={-1}> NESSUNA </option>
                  {this.renderOptions(this.props.categories)}
                </>
                </select>
              </label>
              </div>
                <button
                  className={`${cStyles.button} ${cStyles.actionButton}`}
                  disabled={!isValid} type="submit">Modifica</button>
              </Form>
            )}
          </Formik>
        </div>
      </>
    );
  }
}
