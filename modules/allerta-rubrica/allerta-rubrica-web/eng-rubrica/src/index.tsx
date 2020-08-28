import React from 'react';
import { render } from 'react-dom';
import { Main } from './components/Main';
import { Modal } from './components/Modal/Modal';
import 'url-search-params-polyfill';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-material.css';
// import 'ag-grid-enterprise';
import './index.css';



render(
  <>
    
    <Modal />
    <Main />
    
  </>,
  document.getElementById('app-root')
);
