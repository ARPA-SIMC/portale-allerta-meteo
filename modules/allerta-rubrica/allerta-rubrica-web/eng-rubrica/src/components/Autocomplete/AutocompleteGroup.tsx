import React, { Component, ChangeEvent, SyntheticEvent } from "react";
import { client } from '../../resources';
import styles from './Autocomplete.module.css';
import debounce from "lodash/debounce";

class AutocompleteGroup extends Component<any, any> {
  state = {
    activeSuggestion: 0,
    filteredSuggestions: new Array(),
    showSuggestions: false,
    userInput: "",
    selected: null
  };
  
  onChange = async (e: ChangeEvent) => {
    const userInput = (e.target as HTMLInputElement).value;
    this.setState({
      userInput
    }, () => this.fetchGroups(userInput));
  };

  fetchGroups = debounce(async (input: string) => {
    const response = await client.groups.all(input, 10000);
    const groups = response && response.data;
    const filteredSuggestions = groups.filter((group: any) => group.name.toLowerCase().includes(input.toLowerCase()));
    this.setState({
      activeSuggestion: 0,
      filteredSuggestions,
      showSuggestions: true,
    });
  }, 500)

  clearInput = () => {
    this.setState((prevstate: any) => ({
      userInput: "",
      selected: null  
    }))
  }

  onClick = (e: any) => {
    e.persist();
    this.setState((prev: any) => ({
      activeSuggestion: 0,
      filteredSuggestions: [],
      showSuggestions: false,
      userInput: (e.target as HTMLElement).innerText,
      selected: this.state.filteredSuggestions[this.state.activeSuggestion]
    }), () => {
      const { selected } = this.state;
      this.props.update('id', (selected as any).id)
    });
  };

  onKeyDown = (e: any) => {
    const { activeSuggestion, filteredSuggestions } = this.state;
    if (e.keyCode === 13) {
      this.setState({
        activeSuggestion: 0,
        showSuggestions: false,
        userInput: filteredSuggestions[activeSuggestion].name,
        selected: filteredSuggestions[activeSuggestion]
      });
    }
    else if (e.keyCode === 38) {
      if (activeSuggestion === 0) {
        return;
      }
      this.setState({ activeSuggestion: activeSuggestion - 1 });
    }
    else if (e.keyCode === 40) {
      if (activeSuggestion - 1 === filteredSuggestions.length) {
        return;
      }
      this.setState({ activeSuggestion: activeSuggestion + 1 });
    }
  };

  componentWillUnmount() {
    this.fetchGroups.cancel()
  }

  render() {
    const {
      onChange,
      onClick,
      onKeyDown,
      state: {
        activeSuggestion,
        filteredSuggestions,
        showSuggestions,
        userInput
      }
    } = this;

    let suggestionsListComponent;

    if (showSuggestions && userInput) {
      if (filteredSuggestions.length) {
        suggestionsListComponent = (
          <ul className={styles.suggestions}>
            {filteredSuggestions.map((suggestion: any, index) => {
              let className;

              if (index === activeSuggestion) {
                className = styles['suggestion-active'];
              }

              return (
                <li
                  key={suggestion.id}
                  className={className}
                  onClick={onClick}
                >
                  {suggestion.name}
                </li>
              );
            })}
          </ul>
        );
      } else {
        suggestionsListComponent = (
          <div className={styles['no-suggestions']}>
            <em>Non è stato trovato nessun gruppo</em>
          </div>
        );
      }
    }

    return (
      <>
        <input
          type="text"
          onChange={onChange}
          onKeyDown={onKeyDown}
          value={userInput}
        />
        {suggestionsListComponent}
      </>
    );
  }
}

export default AutocompleteGroup;