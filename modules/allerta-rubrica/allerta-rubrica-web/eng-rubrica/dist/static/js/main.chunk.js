(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/common.module.css":
/*!**********************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/common.module.css ***!
  \**********************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".common_button__3i05i {\n    position: relative;\n    display: inline-block;\n    box-sizing: border-box;\n    border: none;\n    border-radius: 4px;\n    padding: 0 16px;\n    min-width: 64px;\n    height: 36px;\n    vertical-align: middle;\n    text-align: center;\n    text-overflow: ellipsis;\n    text-transform: uppercase;\n    color: rgb(255, 255, 255);\n    background-color: rgb(33, 150, 243);\n    box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n    font-size: 14px;\n    font-weight: 500;\n    line-height: 36px;\n    overflow: hidden;\n    outline: none;\n    cursor: pointer;\n    -webkit-transition: box-shadow 0.2s;\n    transition: box-shadow 0.2s;\n}\n\n.common_button__3i05i::-moz-focus-inner {\n    border: none;\n}\n\n/* Overlay */\n.common_button__3i05i::before {\n    content: \"\";\n    position: absolute;\n    top: 0;\n    bottom: 0;\n    left: 0;\n    right: 0;\n    background-color: rgb(255, 255, 255);\n    opacity: 0;\n    -webkit-transition: opacity 0.2s;\n    transition: opacity 0.2s;\n}\n\n/* Ripple */\n.common_button__3i05i::after {\n    content: \"\";\n    position: absolute;\n    left: 50%;\n    top: 50%;\n    border-radius: 50%;\n    padding: 50%;\n    width: 32px; /* Safari */\n    height: 32px; /* Safari */\n    background-color: rgb(255, 255, 255);\n    opacity: 0;\n    -webkit-transform: translate(-50%, -50%) scale(1);\n            transform: translate(-50%, -50%) scale(1);\n    -webkit-transition: opacity 1s, -webkit-transform 0.5s;\n    transition: opacity 1s, -webkit-transform 0.5s;\n    transition: opacity 1s, transform 0.5s;\n    transition: opacity 1s, transform 0.5s, -webkit-transform 0.5s;\n}\n\n/* Hover, Focus */\n.common_button__3i05i:hover,\n.common_button__3i05i:focus {\n    box-shadow: 0 2px 4px -1px rgba(0, 0, 0, 0.2), 0 4px 5px 0 rgba(0, 0, 0, 0.14), 0 1px 10px 0 rgba(0, 0, 0, 0.12);\n}\n\n.common_button__3i05i:hover::before {\n    opacity: 0.08;\n}\n\n.common_button__3i05i:focus::before {\n    opacity: 0.24;\n}\n\n.common_button__3i05i:hover:focus::before {\n    opacity: 0.3;\n}\n\n/* Active */\n.common_button__3i05i:active {\n    box-shadow: 0 5px 5px -3px rgba(0, 0, 0, 0.2), 0 8px 10px 1px rgba(0, 0, 0, 0.14), 0 3px 14px 2px rgba(0, 0, 0, 0.12);\n}\n\n.common_button__3i05i:active::after {\n    opacity: 0.32;\n    -webkit-transform: translate(-50%, -50%) scale(0);\n            transform: translate(-50%, -50%) scale(0);\n    -webkit-transition: -webkit-transform 0s;\n    transition: -webkit-transform 0s;\n    transition: transform 0s;\n    transition: transform 0s, -webkit-transform 0s;\n}\n\n/* Disabled */\n.common_button__3i05i:disabled {\n    color: rgba(0, 0, 0, 0.38);\n    background-color: rgba( 0, 0, 0, 0.12);\n    box-shadow: none;\n    cursor: auto;\n    cursor: initial;\n}\n\n.common_button__3i05i:disabled::before {\n    opacity: 0;\n}\n\n.common_button__3i05i:disabled::after {\n    opacity: 0;\n}\n\n.common_actionButton__fHtRI {\n    position: absolute;\n    bottom: 1rem;\n    right: 1rem;\n}\n\n.common_field__3Dg5N {\n  margin: .5rem 0;\n}\n\n.common_field__3Dg5N label {\n  display: block;\n}\n\n.common_tabActions__2K4ln {\n  display: flex;\n  justify-content: space-around;\n}\n\n.common_buttonRow__TpAUS {\n  padding-left: 1rem;\n  padding-bottom: 1rem;\n  display: flex;\n  align-items: center;\n  justify-content: flex-start;\n}\n\n/* Modal */\n.common_listedContent__1zBX8 {\n  display: flex;\n  flex-direction: column;\n  height: 100%\n}\n\n.common_modalList__2C7CO {\n  margin-top: 1rem;\n  flex: 1 1;\n  overflow: overlay;\n}\n\n.common_modalItem__3twHv {\n  display: block;\n  padding: .25rem 0\n}\n\n/* Lists */\n\n.common_list__DGTGR {\n  height: 200px;\n  overflow: auto;\n  padding: 0;\n  margin: 0;\n  margin-top: .75rem;\n  border: 1px solid rgba(0,0,0,.25)\n}\n\n.common_list__DGTGR li {\n  display: flex;\n  align-items: center;\n  justify-content: flex-start;\n  padding: .5rem 0;\n}\n\n.common_list__DGTGR li span {\n  text-align: left;\n  padding-left: .5rem;\n  display: block;\n  flex: 1 1;\n}\n\n.common_list__DGTGR li input,\n.common_list__DGTGR li select {\n  width: auto !important;\n}\n", ""]);

// Exports
exports.locals = {
	"button": "common_button__3i05i",
	"actionButton": "common_actionButton__fHtRI",
	"field": "common_field__3Dg5N",
	"tabActions": "common_tabActions__2K4ln",
	"buttonRow": "common_buttonRow__TpAUS",
	"listedContent": "common_listedContent__1zBX8",
	"modalList": "common_modalList__2C7CO",
	"modalItem": "common_modalItem__3twHv",
	"list": "common_list__DGTGR"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Loader/Loader.module.css":
/*!****************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Loader/Loader.module.css ***!
  \****************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".Loader_loader__1nXm4 {\n  position: absolute;\n  top: 50%;\n  left: 50%;\n  -webkit-transform: translate(-50%, -50%);\n          transform: translate(-50%, -50%);\n}", ""]);

// Exports
exports.locals = {
	"loader": "Loader_loader__1nXm4"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Main/main.module.css":
/*!************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Main/main.module.css ***!
  \************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".main_mainWrapper__1Ly04 {\n  max-width: 100%;\n  width: 100%;\n  height: 100%;\n  padding: .5rem;\n  position: relative;\n}\n\n.main_panelsGrid__2hfGX {\n  height: 100%;\n}\n\n.main_grid1__2U-o- {\n  display: block;\n  width: 100%;\n  height: 100%;\n}\n\n.main_grid2__12MzE {\n  display: grid !important;\n  grid-template-columns: 1fr 1fr;\n  grid-template-rows: 1fr;\n  grid-column-gap: 1rem;\n}\n\n.main_mycheckbox__3nU6I {\n  width: 30px !important;\n  max-width: 30px !important;\n}\n", ""]);

// Exports
exports.locals = {
	"mainWrapper": "main_mainWrapper__1Ly04",
	"panelsGrid": "main_panelsGrid__2hfGX",
	"grid1": "main_grid1__2U-o-",
	"grid2": "main_grid2__12MzE",
	"mycheckbox": "main_mycheckbox__3nU6I"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Modal/Modal.module.css":
/*!**************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Modal/Modal.module.css ***!
  \**************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".Modal_backDrop__H96IY {\n  position: absolute;\n  top: 0;\n  left: 0;\n  bottom: 0;\n  right: 0;\n  width: 100%;\n  background: rgba(0,0,0,.75);\n  z-index: 1000;\n}\n\n.Modal_modal__3OJ38 {\n  position: fixed;\n  top: 50%;\n  left: 50%;\n  padding: 1rem;\n  -webkit-transform: translate(-50%, -50%);\n          transform: translate(-50%, -50%);\n  background: white;\n  width: 450px;\n\n  overflow: hidden;\n  z-index: 1500;\n  display: flex;\n  flex-direction: column;\n  border-radius: 4px;\n}\n\n.Modal_tallModal__1bZkN {\n  position: fixed;\n  top: 50%;\n  left: 50%;\n  padding: 1rem;\n  -webkit-transform: translate(-50%, -50%);\n          transform: translate(-50%, -50%);\n  background: white;\n  width: 450px;\n \n  overflow: hidden;\n  z-index: 1500;\n  display: flex;\n  flex-direction: column;\n  border-radius: 4px;\n}\n\n.Modal_modalTitle__XI-9y {\n  margin: 0;\n  text-align: center;\n  font-size: 1.4rem\n}\n\n.Modal_modalContent__3k-sj {\n  text-align: center;\n  margin: 0;\n  flex: 1 1;\n}\n\n.Modal_modalActions__3EYz7 {\n  display: flex;\n  justify-content: space-between;\n}\n", ""]);

// Exports
exports.locals = {
	"backDrop": "Modal_backDrop__H96IY",
	"modal": "Modal_modal__3OJ38",
	"tallModal": "Modal_tallModal__1bZkN",
	"modalTitle": "Modal_modalTitle__XI-9y",
	"modalContent": "Modal_modalContent__3k-sj",
	"modalActions": "Modal_modalActions__3EYz7"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css":
/*!**********************************************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css ***!
  \**********************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".ContactDetailPanel_detailWrapper__30sgI {\n  padding: 1rem;\n}\n\n.ContactDetailPanel_detailData__23CuF {\n  padding: 0 0 1rem;\n}\n\n.ContactDetailPanel_detailData__23CuF h1 {\n  margin-top: 0;\n}\n\n.ContactDetailPanel_detailForm__2Tjzf {\n  padding-top: 1rem;\n}\n\n.ContactDetailPanel_detailForm__2Tjzf span{\n  display: block;\n  margin-bottom: .25rem;\n}\n\n.ContactDetailPanel_dataList__qVuf2 {\n  margin: 0 0 1rem;\n}\n\n.ContactDetailPanel_dataList__qVuf2 li {\n  width: 100%;\n  padding: .5rem;\n}\n\n.ContactDetailPanel_contactsList__rCo2D,\n.ContactDetailPanel_groupsList__3sGkf {\n  border-radius: 4px;\n  box-shadow: inset 0px 0px 5px 0px rgba(0,0,0,0.2);\n  padding: 0;\n  margin: 0;\n  list-style: none;\n  border: 1px solid rgba(0,0,0,0.25);\n}\n", ""]);

// Exports
exports.locals = {
	"detailWrapper": "ContactDetailPanel_detailWrapper__30sgI",
	"detailData": "ContactDetailPanel_detailData__23CuF",
	"detailForm": "ContactDetailPanel_detailForm__2Tjzf",
	"dataList": "ContactDetailPanel_dataList__qVuf2",
	"contactsList": "ContactDetailPanel_contactsList__rCo2D",
	"groupsList": "ContactDetailPanel_groupsList__3sGkf"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css":
/*!******************************************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css ***!
  \******************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".GroupDetailPanel_groupsWrapper__1WZcv{\n  padding: 0 1rem;\n  height: 100%;\n}\n\n.GroupDetailPanel_subGroups__3XiYN,\n.GroupDetailPanel_nominatives__1as5d {\n  border-radius: 4px;\n  box-shadow: inset 0px 0px 5px 0px rgba(0,0,0,0.2);\n  padding: .5rem;\n  list-style: none;\n  border: 1px solid rgba(0,0,0,0.25);\n  margin: 0;\n}\n\n.GroupDetailPanel_subGroups__3XiYN{\n  margin-bottom: 1rem;\n}\n", ""]);

// Exports
exports.locals = {
	"groupsWrapper": "GroupDetailPanel_groupsWrapper__1WZcv",
	"subGroups": "GroupDetailPanel_subGroups__3XiYN",
	"nominatives": "GroupDetailPanel_nominatives__1as5d"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/Panel.module.css":
/*!**************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Panel/Panel.module.css ***!
  \**************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".Panel_panel__3fJzM {\n  height: 100%;\n  overflow: hidden;\n  border-radius: 4px;\n  box-shadow: 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 1px 5px 0 rgba(0, 0, 0, 0.12);\n  border: 1px solid rgba(33,33,33, 0.25);\n  display: grid;\n  grid-template-rows: auto 1fr;\n  grid-template-columns: 100%;\n}\n\n.Panel_panelHeader__9X-9f {\n  padding: 1rem;\n  display: flex;\n  width: 100%;\n  justify-content: space-between;\n  align-items: center;\n}\n\n.Panel_panelBody__mh3Ll {\n  padding: 1rem;\n}\n\n.Panel_inFocus__3qWYf {\n  border: 1px solid rgba(68, 124, 177, 0.75);\n}\n", ""]);

// Exports
exports.locals = {
	"panel": "Panel_panel__3fJzM",
	"panelHeader": "Panel_panelHeader__9X-9f",
	"panelBody": "Panel_panelBody__mh3Ll",
	"inFocus": "Panel_inFocus__3qWYf"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PanelSelector/PanelSelector.module.css":
/*!************************************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Panel/PanelSelector/PanelSelector.module.css ***!
  \************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".PanelSelector_panelSelector__hM1k0 {\n  width: 200px;\n  min-height: calc(34px + 1rem);\n  position: relative;\n  z-index: 5;\n}\n  \n.PanelSelector_selectorOptions__27e2R {\n  background: white;\n  border: 1px solid rgba(0,0,0,.075);\n  border-radius: 3px;\n  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.075);\n  list-style: none;\n  display: flex;\n  justify-content: center;\n  flex-direction: column;\n  margin: 0;\n  overflow: hidden;\n  padding: .5rem 0;\n  position: absolute;\n  -webkit-transition: height .3s ease;\n  transition: height .3s ease;\n  width: 100%;\n  z-index: 10;\n}\n\n.PanelSelector_selectorItem__1xb8P {\n  color: rgba(30,30,30,1);\n  cursor: pointer;\n  display: flex;\n  align-items: center;\n  padding: .5rem 1.0rem;\n  -webkit-transition: background .25s ease, color .25s ease;\n  transition: background .25s ease, color .25s ease;\n}\n\n.PanelSelector_closed__1ck4- {\n  height: calc(34px + 1rem);\n}\n  \n.PanelSelector_opened__3QlPU {\n  height: calc(calc(34px * 3) + 1rem);\n}\n\n.PanelSelector_opened__3QlPU.PanelSelector_admin__uct2Q {\n  height: calc(calc(34px * 4) + 2rem) !important;\n}\n\n.PanelSelector_opened__3QlPU .PanelSelector_selectorItem__1xb8P:hover {\n  background: linear-gradient(135deg, rgba(32,124,229,1) 0%, rgba(73,155,234,1) 100%);\n  color: rgba(230,230,230,1);\n}", ""]);

// Exports
exports.locals = {
	"panelSelector": "PanelSelector_panelSelector__hM1k0",
	"selectorOptions": "PanelSelector_selectorOptions__27e2R",
	"selectorItem": "PanelSelector_selectorItem__1xb8P",
	"closed": "PanelSelector_closed__1ck4-",
	"opened": "PanelSelector_opened__3QlPU",
	"admin": "PanelSelector_admin__uct2Q"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PermissionPanel/PermissionPanel.module.css":
/*!****************************************************************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!./node_modules/postcss-loader/src??postcss!./src/components/Panel/PermissionPanel/PermissionPanel.module.css ***!
  \****************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../../../../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, ".PermissionPanel_permissionGrid__2n4ve{\n    display: grid;\n    grid-template-columns: 1fr 1fr 1fr 1fr;\n    grid-auto-rows: 2.5rem;\n    grid-gap: .5rem;\n    margin-top: .5rem;\n    max-height: 100%;\n    overflow: auto;\n}\n\n.PermissionPanel_perm__3VoZv {\n  align-self: center;\n  justify-self: center;\n}\n\n.PermissionPanel_perm__3VoZv.PermissionPanel_left__2xt93 {\n  justify-self: self-start;\n  padding-left: 1rem;\n}\n", ""]);

// Exports
exports.locals = {
	"permissionGrid": "PermissionPanel_permissionGrid__2n4ve",
	"perm": "PermissionPanel_perm__3VoZv",
	"left": "PermissionPanel_left__2xt93"
};

/***/ }),

/***/ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/index.css":
/*!**************************************************************************************************************************!*\
  !*** ./node_modules/css-loader/dist/cjs.js??ref--6-oneOf-3-1!./node_modules/postcss-loader/src??postcss!./src/index.css ***!
  \**************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(/*! ../node_modules/css-loader/dist/runtime/api.js */ "./node_modules/css-loader/dist/runtime/api.js")(false);
// Module
exports.push([module.i, "[data-app=\"rbMeteoAlert\"] {\n  box-sizing: border-box;\n  height: 100%\n}\n\n[data-app=\"rbMeteoAlert\"] *,*::before,*::after {\n  box-sizing: inherit\n}\n\n.rbBody {\n  position: relative;\n  margin: 0;\n  padding: 0;\n  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',\n    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',\n    sans-serif;\n  height: 100%;\n  -webkit-font-smoothing: antialiased;\n  -moz-osx-font-smoothing: grayscale;\n}\n\n#app-root{\n  \n}\n\n.center-align {\n  text-align: center;\n}\n\n.ag-theme-material {\n  height: 100% !important\n}\n.leftAligned {\n  text-align: left\n}\n\nlabel span {\n  width: 100%;\n  text-align: left;\n  display: block;\n  text-transform: uppercase;\n  margin-bottom: .5rem;\n}\n\ninput[type=text],\ninput[type=url],\ninput[type=tel],\ninput[type=number],\ninput[type=color],\ninput[type=email] {\n  display: block;\n  width: 100%;\n  border-radius: 4px;\n  border: 1px solid rgba(27, 81, 143, 0.33);\n  box-shadow: 0 0 10px rgba(0,0,0,0.1);\n  padding: .5rem;\n  background: rgba(255,255,255,0.5);\n  margin: 0 auto;\n}\n\n.mycheckbox {\n  width: 30px !important;\n  max-width: 30px !important;\n}\n\n.mytext {\n  width: 200px !important;\n  max-width: 200px !important;\n}\n\n.ag-root-wrapper.ag-layout-normal {\n\theight: auto !important;\n\theight: initial !important;\n}\n\n.ag-root-wrapper-body.ag-layout-normal {\n\theight: auto !important;\n\theight: initial !important;\n}\n", ""]);



/***/ }),

/***/ "./src/common.module.css":
/*!*******************************!*\
  !*** ./src/common.module.css ***!
  \*******************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../node_modules/postcss-loader/src??postcss!./common.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/common.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../node_modules/postcss-loader/src??postcss!./common.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/common.module.css", function() {
		var newContent = __webpack_require__(/*! !../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../node_modules/postcss-loader/src??postcss!./common.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/common.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/DragDrop/DraggableComponent.tsx":
/*!********************************************************!*\
  !*** ./src/components/DragDrop/DraggableComponent.tsx ***!
  \********************************************************/
/*! exports provided: DraggableComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DraggableComponent", function() { return DraggableComponent; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_slicedToArray__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/slicedToArray */ "./node_modules/@babel/runtime/helpers/esm/slicedToArray.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var react_dnd__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! react-dnd */ "./node_modules/react-dnd/dist/esm/index.js");

var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\DragDrop\\DraggableComponent.tsx";


function DraggableComponent(props) {
  var _useDrag = Object(react_dnd__WEBPACK_IMPORTED_MODULE_2__["useDrag"])({
    item: {
      data: props.data,
      type: props.type
    }
  }),
      _useDrag2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_slicedToArray__WEBPACK_IMPORTED_MODULE_0__["default"])(_useDrag, 2),
      collectedProps = _useDrag2[0],
      drag = _useDrag2[1];

  return react__WEBPACK_IMPORTED_MODULE_1___default.a.createElement("div", {
    ref: drag,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 8
    },
    __self: this
  }, props.children);
}

/***/ }),

/***/ "./src/components/Loader/Loader.module.css":
/*!*************************************************!*\
  !*** ./src/components/Loader/Loader.module.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Loader.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Loader/Loader.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Loader.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Loader/Loader.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Loader.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Loader/Loader.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Loader/Loader.tsx":
/*!******************************************!*\
  !*** ./src/components/Loader/Loader.tsx ***!
  \******************************************/
/*! exports provided: Loader */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Loader", function() { return Loader; });
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var _Loader_module_css__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./Loader.module.css */ "./src/components/Loader/Loader.module.css");
/* harmony import */ var _Loader_module_css__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(_Loader_module_css__WEBPACK_IMPORTED_MODULE_1__);
var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Loader\\Loader.tsx";


var Loader = function Loader() {
  return react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement("div", {
    className: _Loader_module_css__WEBPACK_IMPORTED_MODULE_1___default.a.loader,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 3
    },
    __self: this
  }, "Loading....");
};

/***/ }),

/***/ "./src/components/Loader/index.ts":
/*!****************************************!*\
  !*** ./src/components/Loader/index.ts ***!
  \****************************************/
/*! exports provided: Loader */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Loader__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Loader */ "./src/components/Loader/Loader.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "Loader", function() { return _Loader__WEBPACK_IMPORTED_MODULE_0__["Loader"]; });




/***/ }),

/***/ "./src/components/Main/Main.tsx":
/*!**************************************!*\
  !*** ./src/components/Main/Main.tsx ***!
  \**************************************/
/*! exports provided: Main */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Main", function() { return Main; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/objectSpread */ "./node_modules/@babel/runtime/helpers/esm/objectSpread.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var _types_d__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../types.d */ "./src/types.d.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _Panel__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../Panel */ "./src/components/Panel/index.tsx");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../resources */ "./src/resources.ts");
/* harmony import */ var _main_module_css__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./main.module.css */ "./src/components/Main/main.module.css");
/* harmony import */ var _main_module_css__WEBPACK_IMPORTED_MODULE_14___default = /*#__PURE__*/__webpack_require__.n(_main_module_css__WEBPACK_IMPORTED_MODULE_14__);
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../utils */ "./src/utils.ts");
/* harmony import */ var react_toastify_dist_ReactToastify_css__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! react-toastify/dist/ReactToastify.css */ "./node_modules/react-toastify/dist/ReactToastify.css");
/* harmony import */ var react_toastify_dist_ReactToastify_css__WEBPACK_IMPORTED_MODULE_16___default = /*#__PURE__*/__webpack_require__.n(react_toastify_dist_ReactToastify_css__WEBPACK_IMPORTED_MODULE_16__);








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Main\\Main.tsx";









var Main =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(Main, _Component);

  function Main() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, Main);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(Main)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.state = {
      loggedUser: undefined,
      channels: [],
      roles: [],
      permissions: [],
      rolesPermission: [],
      focusedIndex: '',
      cache: {},
      panels: new Array({
        id: Object(_utils__WEBPACK_IMPORTED_MODULE_15__["genID"])(),
        type: _types_d__WEBPACK_IMPORTED_MODULE_10__["PanelType"].GROUPS,
        history: []
      })
    };

    _this.setCache = function (panel, key, value) {
      var cac = _this.state.cache ? Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_2__["default"])({}, _this.state.cache) : {};
      cac[panel + '_' + key] = value;

      _this.setState({
        cache: cac
      });
    };

    _this.getCache = function (panel, key) {
      return _this.state.cache[panel + '_' + key];
    };

    _this.onSplit = function () {
      var panels = _this.state.panels;

      if (panels.length === 2) {
        return;
      }

      ;
      panels.push({
        id: Object(_utils__WEBPACK_IMPORTED_MODULE_15__["genID"])(),
        type: _types_d__WEBPACK_IMPORTED_MODULE_10__["PanelType"].CONTACTS,
        history: [],
        resId: undefined
      });
      return _this.setState(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_2__["default"])({}, _this.state, {
        panels: panels
      }), function () {
        window.dispatchEvent(new UIEvent('resize'));
      });
    };

    _this.onMerge = function () {
      var _this$state = _this.state,
          panels = _this$state.panels,
          focusedIndex = _this$state.focusedIndex;

      if (panels.length === 1) {
        return;
      }

      ;
      var newPanels = panels.filter(function (panel) {
        return panel.id !== focusedIndex;
      });
      return _this.setState(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_2__["default"])({}, _this.state, {
        panels: newPanels
      }), function () {
        _this.focusId(newPanels[0].id);

        window.dispatchEvent(new UIEvent('resize'));
      });
    };

    _this.onFocus = function (event) {
      event.persist();
      var id = event.currentTarget.dataset.id;

      _this.setState(function (p) {
        return {
          focusedIndex: id
        };
      });
    };

    _this.focusId = function (id) {
      _this.setState(function (p) {
        return {
          focusedIndex: id
        };
      });
    };

    _this.onSelect = function (type, id, resId, currentState) {
      var panels = _this.state.panels; //se currentState vale null verifichiamo il riferimento al pannello attuale che abbiamo appeso in window

      if (id && !currentState) {
        if (window['rubrica_panel_' + id]) currentState = window['rubrica_panel_' + id].state;
      }

      var newPanels = panels.map(function (panel) {
        if (panel.id === id) {
          panel.history.push({
            type: panel.type,
            resId: panel.resId,
            currentState: currentState
          });
          panel.type = type;
          panel.resId = resId;
        }

        return panel;
      });
      return _this.setState({
        panels: newPanels,
        focusedIndex: id
      });
    };

    _this.onNominative = function (resId, currentState) {
      _this.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_10__["PanelType"].CONTACT_DETAILS, _this.state.focusedIndex, resId, currentState);
    };

    _this.onGroup = function (resId, currentState) {
      _this.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_10__["PanelType"].GROUP_DETAILS, _this.state.focusedIndex, resId, currentState);
    };

    _this.onGoBack = function (panelId) {
      return function (event) {
        var panel = _this.state.panels.find(function (el) {
          return el.id === panelId;
        });

        var panelHistory = panel.history;
        var poppedElement = panelHistory.pop();

        var newPanels = _this.state.panels.map(function (el) {
          if (el.id === panelId) {
            el.resId = poppedElement.resId;
            el.type = poppedElement.type;
            el.currentState = poppedElement.currentState;
            return el;
          } else {
            return el;
          }
        });

        _this.setState(function (p) {
          return {
            panels: newPanels
          };
        });
      };
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(Main, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee() {
        var _ref, channels, _ref2, roles, _ref3, permissions, _ref4, rolesPermission, _ref5, loggedUser;

        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_13__["client"].channels.all();

              case 2:
                _ref = _context.sent;
                channels = _ref.data;
                _context.next = 6;
                return _resources__WEBPACK_IMPORTED_MODULE_13__["client"].roles.all();

              case 6:
                _ref2 = _context.sent;
                roles = _ref2.data;
                _context.next = 10;
                return _resources__WEBPACK_IMPORTED_MODULE_13__["client"].permission.all();

              case 10:
                _ref3 = _context.sent;
                permissions = _ref3.data;
                _context.next = 14;
                return _resources__WEBPACK_IMPORTED_MODULE_13__["client"].rolesPermission.all();

              case 14:
                _ref4 = _context.sent;
                rolesPermission = _ref4.data;
                _context.next = 18;
                return _resources__WEBPACK_IMPORTED_MODULE_13__["client"].loggedUser();

              case 18:
                _ref5 = _context.sent;
                loggedUser = _ref5.data;
                this.setState(function (p) {
                  return Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_2__["default"])({}, p, {
                    channels: channels,
                    roles: roles,
                    loggedUser: loggedUser,
                    permissions: permissions,
                    rolesPermission: rolesPermission
                  });
                });

              case 21:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, this);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "render",
    value: function render() {
      var _this$state2 = this.state,
          panels = _this$state2.panels,
          channels = _this$state2.channels,
          roles = _this$state2.roles,
          loggedUser = _this$state2.loggedUser,
          focusedIndex = _this$state2.focusedIndex,
          permissions = _this$state2.permissions,
          rolesPermission = _this$state2.rolesPermission,
          cache = _this$state2.cache;
      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("main", {
        className: "".concat(_main_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.mainWrapper),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 147
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("section", {
        className: "".concat(_main_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.panelsGrid, " ").concat(_main_module_css__WEBPACK_IMPORTED_MODULE_14___default.a["grid".concat(panels.length)]),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 148
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_context_panelContext__WEBPACK_IMPORTED_MODULE_11__["PanelContext"].Provider, {
        value: {
          loggedUser: loggedUser,
          roles: roles,
          channels: channels,
          panels: panels,
          focusedIndex: focusedIndex,
          permissions: permissions,
          rolesPermission: rolesPermission,
          getCache: this.getCache,
          setCache: this.setCache,
          onGoBack: this.onGoBack,
          onMerge: this.onMerge,
          onSplit: this.onSplit,
          onSelect: this.onSelect,
          onFocus: this.onFocus,
          focusId: this.focusId
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 149
        },
        __self: this
      }, panels.map(function (_ref6) {
        var id = _ref6.id,
            type = _ref6.type,
            currentState = _ref6.currentState;
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_Panel__WEBPACK_IMPORTED_MODULE_12__["Panel"], {
          key: "panel_".concat(id),
          id: id,
          type: type,
          currentState: currentState,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 166
          },
          __self: this
        });
      }))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react_toastify__WEBPACK_IMPORTED_MODULE_9__["ToastContainer"], {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 170
        },
        __self: this
      }));
    }
  }]);

  return Main;
}(react__WEBPACK_IMPORTED_MODULE_8__["Component"]);

/***/ }),

/***/ "./src/components/Main/index.ts":
/*!**************************************!*\
  !*** ./src/components/Main/index.ts ***!
  \**************************************/
/*! exports provided: Main */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Main__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Main */ "./src/components/Main/Main.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "Main", function() { return _Main__WEBPACK_IMPORTED_MODULE_0__["Main"]; });




/***/ }),

/***/ "./src/components/Main/main.module.css":
/*!*********************************************!*\
  !*** ./src/components/Main/main.module.css ***!
  \*********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./main.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Main/main.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./main.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Main/main.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./main.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Main/main.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Modal/Modal.module.css":
/*!***********************************************!*\
  !*** ./src/components/Modal/Modal.module.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Modal.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Modal/Modal.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Modal.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Modal/Modal.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Modal.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Modal/Modal.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Modal/Modal.tsx":
/*!****************************************!*\
  !*** ./src/components/Modal/Modal.tsx ***!
  \****************************************/
/*! exports provided: Modal */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Modal", function() { return Modal; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_assertThisInitialized__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/assertThisInitialized */ "./node_modules/@babel/runtime/helpers/esm/assertThisInitialized.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_6___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_6__);
/* harmony import */ var _Modal_module_css__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./Modal.module.css */ "./src/components/Modal/Modal.module.css");
/* harmony import */ var _Modal_module_css__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(_Modal_module_css__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_8__);






var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Modal\\Modal.tsx";



var Modal =
/*#__PURE__*/
function (_React$Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__["default"])(Modal, _React$Component);

  function Modal(props) {
    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__["default"])(this, Modal);

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__["default"])(this, Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__["default"])(Modal).call(this, props));
    _this.state = {
      show: false,
      title: '',
      content: null,
      tall: false,
      onAccept: undefined,
      onDismiss: undefined
    };

    _this._hide = function () {
      Modal.instance.setState({
        show: false,
        title: '',
        content: null,
        onAccept: function onAccept() {},
        onDismiss: function onDismiss() {}
      });
    };

    _this._show = function (title, content, onAccept, onDismiss) {
      window.scrollTo(0, 0);
      Modal.instance.setState({
        show: true,
        title: title,
        content: content,
        onAccept: onAccept,
        onDismiss: onDismiss
      });
    };

    _this._showTall = function (title, content, onAccept, onDismiss) {
      window.scrollTo(0, 0);
      Modal.instance.setState({
        show: true,
        tall: true,
        title: title,
        content: content,
        onAccept: onAccept,
        onDismiss: onDismiss
      });
    };

    _this.dismiss = function () {
      if (_this.state.onDismiss && typeof _this.state.onDismiss === 'function') {
        _this.state.onDismiss();
      }

      _this._hide();
    };

    Modal.instance = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_assertThisInitialized__WEBPACK_IMPORTED_MODULE_5__["default"])(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_assertThisInitialized__WEBPACK_IMPORTED_MODULE_5__["default"])(_this));
    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__["default"])(Modal, [{
    key: "render",
    value: function render() {
      return this.state.show && react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_6___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement("div", {
        className: _Modal_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.backDrop,
        onClick: this._hide,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 86
        },
        __self: this
      }), react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement("div", {
        className: this.state.tall ? _Modal_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.tallModal : _Modal_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.modal,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 87
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement("h1", {
        className: _Modal_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.modalTitle,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 88
        },
        __self: this
      }, this.state.title), react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement("div", {
        className: _Modal_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.modalContent,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 89
        },
        __self: this
      }, this.state.content), react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement("div", {
        className: _Modal_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.modalActions,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 92
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement("button", {
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.button,
        onClick: this.dismiss,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 93
        },
        __self: this
      }, "Annulla"), typeof this.state.onAccept === 'function' && react__WEBPACK_IMPORTED_MODULE_6___default.a.createElement("button", {
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.button,
        onClick: this.state.onAccept,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 95
        },
        __self: this
      }, "Conferma"))));
    }
  }]);

  return Modal;
}(react__WEBPACK_IMPORTED_MODULE_6___default.a.Component);
Modal.instance = void 0;

Modal.show = function (title, content) {
  var onAccept = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : undefined;
  var onDismiss = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : undefined;

  Modal.instance._show(title, content, onAccept, onDismiss);
};

Modal.showTall = function (title, content) {
  var onAccept = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : undefined;
  var onDismiss = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : undefined;

  Modal.instance._showTall(title, content, onAccept, onDismiss);
};

Modal.hide = function () {
  Modal.instance._hide();
};

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/AddContactForm.tsx":
/*!********************************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/AddContactForm.tsx ***!
  \********************************************************************/
/*! exports provided: AddContactForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddContactForm", function() { return AddContactForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/objectSpread */ "./node_modules/@babel/runtime/helpers/esm/objectSpread.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_12__);
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./ContactDetailPanel.module.css */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_15__);








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactDetailPanel\\AddContactForm.tsx";








var AddContactForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(AddContactForm, _Component);

  function AddContactForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, AddContactForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(AddContactForm)).call.apply(_getPrototypeOf2, [this].concat(args)));

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_12__["object"]().shape({
        channelId: yup__WEBPACK_IMPORTED_MODULE_12__["number"]().required(),
        value: yup__WEBPACK_IMPORTED_MODULE_12__["string"]().required(),
        warn: yup__WEBPACK_IMPORTED_MODULE_12__["boolean"]()
      });
    };

    _this.onSubmitContact =
    /*#__PURE__*/
    function () {
      var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee(values) {
        var result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].contacts.create(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_1__["default"])({}, values, {
                  nominativeId: _this.props.nominative.id
                }));

              case 2:
                result = _context.sent;

                if (!(result.code === 201)) {
                  _context.next = 10;
                  break;
                }

                _context.next = 6;
                return _this.props.refetch();

              case 6:
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Update avvenuto con successo", {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.SUCCESS
                });
                _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__["Modal"].hide();
                _context.next = 11;
                break;

              case 10:
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Update fallito, riprova", {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.ERROR
                });

              case 11:
              case "end":
                return _context.stop();
            }
          }
        }, _callee);
      }));

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }();

    _this.onChange = function (setFieldValue) {
      return function (event) {
        setFieldValue('channelId', event.target.value);
      };
    };

    _this.onCheckChange = function (setFieldValue, value) {
      return function (event) {
        setFieldValue('warning', value);
      };
    };

    _this.renderOptions = function (channels) {
      var options = channels.map(function (channel) {
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
          key: channel.id,
          value: channel.id,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 46
          },
          __self: this
        }, channel.name);
      });
      return options;
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(AddContactForm, [{
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 53
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Formik"], {
        initialValues: {
          warning: true,
          value: '',
          channelId: null
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitContact,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 54
        },
        __self: this
      }, function (_ref2) {
        var isValid = _ref2.isValid,
            setFieldValue = _ref2.setFieldValue,
            values = _ref2.values;
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 64
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 65
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 66
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 67
          },
          __self: this
        }, "Canale"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("select", {
          name: "channelId",
          onChange: _this2.onChange(setFieldValue),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 68
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
          value: undefined,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 70
          },
          __self: this
        }, " -- SELEZIONA CANALE -- "), _this2.renderOptions(_this2.props.channels))))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 76
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 77
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 78
          },
          __self: this
        }, "Valore"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Field"], {
          type: "text",
          name: "value",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 79
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 82
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 83
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 84
          },
          __self: this
        }, "Allertamento"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
          type: "checkbox",
          defaultChecked: values.warning,
          onChange: _this2.onCheckChange(setFieldValue, values.warning),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 85
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 89
          },
          __self: this
        }, " Crea "));
      })));
    }
  }]);

  return AddContactForm;
}(react__WEBPACK_IMPORTED_MODULE_8__["Component"]);

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css":
/*!*******************************************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./ContactDetailPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./ContactDetailPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./ContactDetailPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.tsx":
/*!************************************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/ContactDetailPanel.tsx ***!
  \************************************************************************/
/*! exports provided: ContactDetailPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ContactDetailPanel", function() { return ContactDetailPanel; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/toConsumableArray */ "./node_modules/@babel/runtime/helpers/esm/toConsumableArray.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/objectSpread */ "./node_modules/@babel/runtime/helpers/esm/objectSpread.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var _Loader__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../Loader */ "./src/components/Loader/index.ts");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./ContactDetailPanel.module.css */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _DetailForm__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./DetailForm */ "./src/components/Panel/ContactDetailPanel/DetailForm.tsx");
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_16___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_16__);
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../utils */ "./src/utils.ts");
/* harmony import */ var _types_d__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../../../types.d */ "./src/types.d.ts");
/* harmony import */ var _AddContactForm__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./AddContactForm */ "./src/components/Panel/ContactDetailPanel/AddContactForm.tsx");
/* harmony import */ var _ModifyContactForm__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./ModifyContactForm */ "./src/components/Panel/ContactDetailPanel/ModifyContactForm.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_21___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_21__);
/* harmony import */ var _GroupList__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./GroupList */ "./src/components/Panel/ContactDetailPanel/GroupList.tsx");









var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactDetailPanel\\ContactDetailPanel.tsx";














var ContactDetailPanel =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_8__["default"])(ContactDetailPanel, _Component);

  function ContactDetailPanel() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_4__["default"])(this, ContactDetailPanel);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_6__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_7__["default"])(ContactDetailPanel)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      data: {},
      loading: true,
      error: null,
      resId: undefined,
      selected: [],
      selectedGroups: [],
      editedGroup: null
    };

    _this.toggleGroup = function (g) {
      console.log('toggle group ' + g);

      _this.setState({
        editedGroup: g == _this.state.editedGroup ? null : g
      });
    };

    _this.refetch =
    /*#__PURE__*/
    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
    /*#__PURE__*/
    C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee() {
      var panels, resId, _ref2, data;

      return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee$(_context) {
        while (1) {
          switch (_context.prev = _context.next) {
            case 0:
              panels = _this.context.panels;
              resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, _this.props.id);

              if (!resId) {
                _context.next = 14;
                break;
              }

              _context.prev = 3;
              _context.next = 6;
              return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].nominatives.getById(resId);

            case 6:
              _ref2 = _context.sent;
              data = _ref2.data;

              _this.setState({
                loading: false,
                data: data,
                error: null,
                resId: resId
              });

              _context.next = 14;
              break;

            case 11:
              _context.prev = 11;
              _context.t0 = _context["catch"](3);

              _this.setState({
                loading: false,
                data: null,
                error: 'API Error'
              });

            case 14:
            case "end":
              return _context.stop();
          }
        }
      }, _callee, null, [[3, 11]]);
    }));

    _this.removeContact = function (id) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee2() {
          var response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee2$(_context2) {
            while (1) {
              switch (_context2.prev = _context2.next) {
                case 0:
                  _context2.next = 2;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].contacts.delete(id);

                case 2:
                  response = _context2.sent;

                  if (response.code === 204) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Contatto eliminato con successo", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.SUCCESS
                    });
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                    _this.refetch();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Rimozione contatto fallita", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.ERROR
                    });
                  }

                case 4:
                case "end":
                  return _context2.stop();
              }
            }
          }, _callee2);
        }))
      );
    };

    _this.onRemoveContact = function (contact) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Elimina Contatto', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_9___default.a.Fragment, null, "Procedere con l'eliminazione del Contatto", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 104
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 105
          },
          __self: this
        }, contact.value), " ?"), _this.removeContact(contact.id));
      };
    };

    _this.addNominativeToGroup = function (nominative) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Associa a Gruppo', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_GroupList__WEBPACK_IMPORTED_MODULE_22__["GroupList"], {
          refetch: _this.refetch,
          nominative: nominative,
          roles: _this.context.roles,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 112
          },
          __self: this
        }));
      };
    };

    _this.removeNominativeFromGroup = function (id) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee3() {
          var panels, resId, response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee3$(_context3) {
            while (1) {
              switch (_context3.prev = _context3.next) {
                case 0:
                  panels = _this.context.panels;
                  resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, _this.props.id);
                  _context3.next = 4;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.unsetNominativeRole(id, resId);

                case 4:
                  response = _context3.sent;

                  if (response.code >= 200 && response.code < 300) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Nominativo dissociato con successo", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.SUCCESS
                    });
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                    _this.refetch();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Dissociazione da gruppo fallita", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.ERROR
                    });
                  }

                case 6:
                case "end":
                  return _context3.stop();
              }
            }
          }, _callee3);
        }))
      );
    };

    _this.onRemoveNominativeFromGroup = function (group, nominative) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Dissocia Nominativo', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_9___default.a.Fragment, null, "Procedere con la dissociazione del nominativo:", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 137
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 138
          },
          __self: this
        }, nominative.firstName, " ", nominative.lastName), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 139
          },
          __self: this
        }), "dal gruppo", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 141
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 142
          },
          __self: this
        }, group.name)), _this.removeNominativeFromGroup(group.id));
      };
    };

    _this.onGroupDetail = function (id) {
      return function () {
        _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_18__["PanelType"].GROUP_DETAILS, _this.props.id, id);
      };
    };

    _this.modifyNominative = function (nominative) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Modifica Nominativo', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_DetailForm__WEBPACK_IMPORTED_MODULE_14__["DetailForm"], {
          nominative: nominative,
          refetch: _this.refetch,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 153
          },
          __self: this
        }));
      };
    };

    _this.getRuoloIdFromName = function (nome, roles) {
      for (var k = 0; k < roles.length; k++) {
        if (roles[k].name == nome) return roles[k].id;
      }

      return "";
    };

    _this.getMenuRuolo = function (g) {
      var ruolo = _this.getRuoloSingolo(g);

      var specifica = _this.getSpecificaRuoloSingolo(g);

      for (var k = 0; k < _this.state.data.groups.length; k++) {
        if (_this.state.data.groups[k].id == g.id) {
          return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 168
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("select", {
            onChange: _this.handleRole(g),
            defaultValue: ruolo,
            style: {
              marginLeft: 'auto'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 169
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("option", {
            value: "",
            __source: {
              fileName: _jsxFileName,
              lineNumber: 170
            },
            __self: this
          }, "---"), _this.context.roles && _this.context.roles.map(function (role) {
            return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("option", {
              key: role.name,
              value: role.name,
              __source: {
                fileName: _jsxFileName,
                lineNumber: 171
              },
              __self: this
            }, role.name);
          })), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("input", {
            style: {
              display: 'inline'
            },
            className: "mytext",
            value: specifica,
            placeholder: "Specifica ruolo",
            type: "text",
            onChange: _this.handleSpecifica(g),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 173
            },
            __self: this
          }));
        }
      }
    };

    _this.handleRole = function (group) {
      return function (event) {
        var k;
        var out;

        for (k = 0; k < _this.state.data.groups.length; k++) {
          if (_this.state.data.groups[k].id == group.id) {
            _this.state.data.groups[k].role = event.target.value;

            var data2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_1__["default"])({}, _this.state.data);

            _this.setState({
              data: data2
            });

            _this.onSubmitChange(group.id, _this.state.data.groups[k].role, _this.state.data.groups[k].specificaRuolo);

            return;
          }
        }
      };
    };

    _this.handleSpecifica = function (group) {
      return function (event) {
        var k;
        var out;

        for (k = 0; k < _this.state.data.groups.length; k++) {
          if (_this.state.data.groups[k].id == group.id) {
            _this.state.data.groups[k].specificaRuolo = event.target.value;

            _this.setState({
              data: _this.state.data
            });

            var data2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_1__["default"])({}, _this.state.data);

            _this.setState({
              data: data2
            });

            _this.onSubmitChange(group.id, _this.state.data.groups[k].role, _this.state.data.groups[k].specificaRuolo);

            return;
          }
        }
      };
    };

    _this.onSubmitChange =
    /*#__PURE__*/
    function () {
      var _ref5 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee4(group, ruolo, spec) {
        var panels, resId, param, result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee4$(_context4) {
          while (1) {
            switch (_context4.prev = _context4.next) {
              case 0:
                _context4.prev = 0;
                panels = _this.context.panels;
                resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, _this.props.id);
                param = {
                  nominativeId: resId,
                  role: _this.getRuoloIdFromName(ruolo, _this.context.roles),
                  specificaRuolo: spec
                };
                _context4.next = 6;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.setNominativesRole(group, [param]);

              case 6:
                result = _context4.sent;
                _context4.next = 13;
                break;

              case 9:
                _context4.prev = 9;
                _context4.t0 = _context4["catch"](0);
                console.error(_context4.t0);
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])('Errore associzione', {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.ERROR
                });

              case 13:
              case "end":
                return _context4.stop();
            }
          }
        }, _callee4, null, [[0, 9]]);
      }));

      return function (_x, _x2, _x3) {
        return _ref5.apply(this, arguments);
      };
    }();

    _this.getRuolo = function (group) {
      var k;
      var out;

      for (k = 0; k < _this.state.data.groups.length; k++) {
        if (_this.state.data.groups[k].id == group.id) {
          out = ' ' + _this.state.data.groups[k].role;
          if (_this.state.data.groups[k].specificaRuolo) out += ' - ' + _this.state.data.groups[k].specificaRuolo;
          return out;
        }
      }

      return '';
    };

    _this.getRuoloSingolo = function (group) {
      var k;
      var out;

      for (k = 0; k < _this.state.data.groups.length; k++) {
        if (_this.state.data.groups[k].id == group.id) return _this.state.data.groups[k].role;
      }

      return '';
    };

    _this.getSpecificaRuoloSingolo = function (group) {
      var k;
      var out;

      for (k = 0; k < _this.state.data.groups.length; k++) {
        if (_this.state.data.groups[k].id == group.id) return _this.state.data.groups[k].specificaRuolo;
      }

      return '';
    };

    _this.addContact = function (channels) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Crea Contatto', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_AddContactForm__WEBPACK_IMPORTED_MODULE_19__["AddContactForm"], {
          channels: channels,
          refetch: _this.refetch,
          nominative: _this.state.data,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 263
          },
          __self: this
        }));
      };
    };

    _this.modifyContact = function (channels, contact) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Modifica Contatto', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_ModifyContactForm__WEBPACK_IMPORTED_MODULE_20__["ModifyContactForm"], {
          channels: channels,
          refetch: _this.refetch,
          contact: contact,
          nominative: _this.state.data,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 267
          },
          __self: this
        }));
      };
    };

    _this.deleteContacts = function (contacts) {
      return function (event) {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Elimina Contatti', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
          style: {
            textAlign: 'left'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 271
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
          style: {
            display: 'block',
            marginBottom: '1rem'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 272
          },
          __self: this
        }, " Eliminare i seguenti contatti: ", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 272
          },
          __self: this
        })), contacts.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
            key: el.id,
            style: {
              display: 'block',
              marginBottom: '.25rem'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 273
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 274
            },
            __self: this
          }, "- ", el.value));
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.actionButton),
          onClick: _this.removeContacts(_this.state.selected),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 276
          },
          __self: this
        }, " Elimina ")));
      };
    };

    _this.removeContacts = function (ids) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee5() {
          var obj, response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee5$(_context5) {
            while (1) {
              switch (_context5.prev = _context5.next) {
                case 0:
                  obj = ids.map(function (el) {
                    return {
                      id: el.id
                    };
                  });
                  _context5.next = 3;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].contacts.deleteMulti(obj);

                case 3:
                  response = _context5.sent;

                  if (response.code >= 200 && response.code < 300) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Contatti eliminati", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.SUCCESS
                    });
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                    _this.refetch();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Rimozione contatti fallita", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.ERROR
                    });
                  }

                case 5:
                case "end":
                  return _context5.stop();
              }
            }
          }, _callee5);
        }))
      );
    };

    _this.onRemoveGroups = function (groups) {
      return (
        /*#__PURE__*/
        function () {
          var _ref7 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
          /*#__PURE__*/
          C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee6(e) {
            return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee6$(_context6) {
              while (1) {
                switch (_context6.prev = _context6.next) {
                  case 0:
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Elimina Contatti', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
                      style: {
                        textAlign: 'left'
                      },
                      __source: {
                        fileName: _jsxFileName,
                        lineNumber: 297
                      },
                      __self: this
                    }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
                      style: {
                        display: 'block',
                        marginBottom: '1rem'
                      },
                      __source: {
                        fileName: _jsxFileName,
                        lineNumber: 298
                      },
                      __self: this
                    }, " Disassociare i seguenti gruppi: ", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
                      __source: {
                        fileName: _jsxFileName,
                        lineNumber: 298
                      },
                      __self: this
                    })), groups.map(function (el) {
                      return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
                        key: el.id,
                        style: {
                          display: 'block',
                          marginBottom: '.25rem'
                        },
                        __source: {
                          fileName: _jsxFileName,
                          lineNumber: 299
                        },
                        __self: this
                      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
                        __source: {
                          fileName: _jsxFileName,
                          lineNumber: 300
                        },
                        __self: this
                      }, "- ", el.name));
                    }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
                      className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.actionButton),
                      onClick: _this.removeGroups(_this.state.selectedGroups),
                      __source: {
                        fileName: _jsxFileName,
                        lineNumber: 302
                      },
                      __self: this
                    }, " Disassocia ")));

                  case 1:
                  case "end":
                    return _context6.stop();
                }
              }
            }, _callee6, this);
          }));

          return function (_x4) {
            return _ref7.apply(this, arguments);
          };
        }()
      );
    };

    _this.removeGroups = function (ids) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee7() {
          var obj, response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee7$(_context7) {
            while (1) {
              switch (_context7.prev = _context7.next) {
                case 0:
                  obj = ids.map(function (el) {
                    return {
                      id: el.id,
                      roleId: _this.context.roles.find(function (elm) {
                        return elm.name === el.role;
                      }).id
                    };
                  });
                  _context7.next = 3;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.unsetGroupsRole(_this.state.resId, obj);

                case 3:
                  response = _context7.sent;

                  if (response.code === 201) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Gruppi disassociati", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.SUCCESS
                    });
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                    _this.setState({
                      selectedGroups: []
                    }, _this.refetch);
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"])("Rimozione grouppo fallita", {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_16__["toast"].TYPE.SUCCESS
                    });
                  }

                case 5:
                case "end":
                  return _context7.stop();
              }
            }
          }, _callee7);
        }))
      );
    };

    _this.selectContact = function (contact) {
      return function (event) {
        var selected = [];

        if (_this.state.selected.find(function (el) {
          return el.id === contact.id;
        }) !== undefined) {
          selected = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(_this.state.selected.filter(function (el) {
            return el.id !== contact.id;
          }));
        } else {
          selected = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(_this.state.selected), [contact]);
        }

        _this.setState({
          selected: selected
        });
      };
    };

    _this.selectGroup = function (group) {
      return function (e) {
        var selectedGroups = [];

        if (_this.state.selectedGroups.find(function (el) {
          return el.id === group.id;
        }) !== undefined) {
          selectedGroups = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(_this.state.selected.filter(function (el) {
            return el.id !== group.id;
          }));
        } else {
          selectedGroups = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(_this.state.selectedGroups), [group]);
        }

        _this.setState({
          selectedGroups: selectedGroups
        });
      };
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_5__["default"])(ContactDetailPanel, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee8() {
        var panels, resId, _ref9, data;

        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee8$(_context8) {
          while (1) {
            switch (_context8.prev = _context8.next) {
              case 0:
                panels = this.context.panels;
                resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, this.props.id);

                if (!resId) {
                  _context8.next = 14;
                  break;
                }

                _context8.prev = 3;
                _context8.next = 6;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].nominatives.getById(resId);

              case 6:
                _ref9 = _context8.sent;
                data = _ref9.data;
                this.setState({
                  loading: false,
                  data: data,
                  error: null,
                  resId: resId
                });
                _context8.next = 14;
                break;

              case 11:
                _context8.prev = 11;
                _context8.t0 = _context8["catch"](3);
                this.setState({
                  loading: false,
                  data: null,
                  error: 'API Error'
                });

              case 14:
              case "end":
                return _context8.stop();
            }
          }
        }, _callee8, this, [[3, 11]]);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "componentDidUpdate",
    value: function componentDidUpdate(prevProps, prevState) {
      var panels = this.context.panels;
      var resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, this.props.id);

      if (resId !== this.state.resId) {
        this.refetch();
      }
    }
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      var _this$state = this.state,
          data = _this$state.data,
          error = _this$state.error,
          loading = _this$state.loading;
      var channels = this.context.channels;
      var dat = new Date();
      dat.setTime(data.lastEdit);
      return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_9___default.a.Fragment, null, loading && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_Loader__WEBPACK_IMPORTED_MODULE_10__["Loader"], {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 357
        },
        __self: this
      }), !loading && !error && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailWrapper,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 359
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailData,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 360
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("h1", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 361
        },
        __self: this
      }, data.firstName, " ", data.lastName), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 362
        },
        __self: this
      }, "(", data.contacts && data.contacts.length, ") Contatti - (", data.groups && data.groups.length, ") Gruppi"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 367
        },
        __self: this
      }, "Proprietario del nominativo: ", data.owner), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 370
        },
        __self: this
      }, "Ultima Modifica: ", data.modifyUser, " - ", " " + dat.toLocaleString('it-IT')), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginTop: '1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button,
        onClick: this.modifyNominative(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 373
        },
        __self: this
      }, "Modifica Nominativo"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginTop: '1rem',
          marginLeft: '1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button,
        onClick: this.refetch,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 377
        },
        __self: this
      }, "Refresh")), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 383
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("h4", {
        style: {
          marginTop: 0
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 384
        },
        __self: this
      }, "Contatti"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        style: {
          display: 'flex'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 385
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginBottom: '1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button,
        onClick: this.addContact(channels),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 386
        },
        __self: this
      }, "Aggiungi Contatto"), this.state.selected.length > 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginBottom: '1rem',
          marginLeft: '1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button,
        onClick: this.deleteContacts(this.state.selected),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 394
        },
        __self: this
      }, "Rimuovi Contatti")), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.dataList,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 405
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("ul", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.contactsList,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 406
        },
        __self: this
      }, data.contacts && data.contacts.map(function (el) {
        return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("li", {
          key: el.id,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 409
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          className: "mycheckbox",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 410
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("input", {
          style: {
            'marginRight': '1rem'
          },
          className: "mycheckbox",
          type: "checkbox",
          onChange: _this2.selectContact(el),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 410
          },
          __self: this
        })), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 411
          },
          __self: this
        }, Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getChannelName"])(channels, el.channelId), " - ", el.value), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.modifyContact(channels, el),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 412
          },
          __self: this
        }, " \uD83D\uDCDD"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onRemoveContact(el),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 413
          },
          __self: this
        }, "\u274C"));
      })))), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 421
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("h4", {
        style: {
          marginTop: 0
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 422
        },
        __self: this
      }, "Gruppi"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginBottom: '1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button,
        onClick: this.addNominativeToGroup(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 423
        },
        __self: this
      }, "Aggiungi Nominativo a Gruppo"), this.state.selectedGroups.length !== 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginBottom: '1rem',
          marginLeft: '1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_21___default.a.button,
        onClick: this.onRemoveGroups(this.state.selectedGroups),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 428
        },
        __self: this
      }, "Dissocia Gruppi"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.dataList,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 436
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("ul", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.groupsList,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 437
        },
        __self: this
      }, data.groups && data.groups.map(function (el, id) {
        return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("li", {
          key: el.id,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 440
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          className: "mycheckbox",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 441
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("input", {
          className: "mycheckbox",
          style: {
            width: '30px !important'
          },
          type: "checkbox",
          onChange: _this2.selectGroup(el),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 441
          },
          __self: this
        })), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 442
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 442
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: function onClick(e) {
            return _this2.toggleGroup(el.id);
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 442
          },
          __self: this
        }, el.name)), " -  ", _this2.state.editedGroup == el.id ? _this2.getMenuRuolo(el) : _this2.getRuolo(el)), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onGroupDetail(el.id),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 443
          },
          __self: this
        }, " \uD83D\uDD0D "), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onRemoveNominativeFromGroup(el, data),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 444
          },
          __self: this
        }, " \u274C "));
      }))))), !loading && error && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 456
        },
        __self: this
      }, error));
    }
  }]);

  return ContactDetailPanel;
}(react__WEBPACK_IMPORTED_MODULE_9__["Component"]);
ContactDetailPanel.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_12__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/CreateGreaterNominativeForm.tsx":
/*!*********************************************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/CreateGreaterNominativeForm.tsx ***!
  \*********************************************************************************/
/*! exports provided: CreateGreaterNominativeForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateGreaterNominativeForm", function() { return CreateGreaterNominativeForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_11___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_11__);
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./ContactDetailPanel.module.css */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_15__);







var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactDetailPanel\\CreateGreaterNominativeForm.tsx";









var CreateGreaterNominativeForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__["default"])(CreateGreaterNominativeForm, _Component);

  function CreateGreaterNominativeForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__["default"])(this, CreateGreaterNominativeForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__["default"])(CreateGreaterNominativeForm)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      loading: false,
      error: null,
      grouplist: null,
      groupFilter: ''
    };

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_11__["object"]().shape({
        firstName: yup__WEBPACK_IMPORTED_MODULE_11__["string"]().required(),
        lastName: yup__WEBPACK_IMPORTED_MODULE_11__["string"]().required(),
        //address: yup.string().required(),
        contacts: yup__WEBPACK_IMPORTED_MODULE_11__["array"](),
        groups: yup__WEBPACK_IMPORTED_MODULE_11__["array"]()
      });
    };

    _this.hasGroup = function () {
      return _this.props.group;
    };

    _this.prefilledGroup = function () {
      return _this.props.group && _this.props.group.name ? _this.props.group.name : null;
    };

    _this.onSubmitNominative =
    /*#__PURE__*/
    function () {
      var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee(values) {
        var result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_10__["client"].nominatives.create(values);

              case 2:
                result = _context.sent;

                if (result.code === 201) {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Nominativo creato con successo", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.SUCCESS
                  });
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__["Modal"].hide();

                  _this.props.refetch();
                } else {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Creazione nominativo fallita, riprova", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.ERROR
                  });
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__["Modal"].hide();
                }

              case 4:
              case "end":
                return _context.stop();
            }
          }
        }, _callee);
      }));

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }();

    _this.handleRole = function (values, setFieldValue) {
      return function (event) {
        setFieldValue('role', event.target.value);
      };
    };

    _this.filterGroups = function (setFieldValue) {
      return (
        /*#__PURE__*/
        function () {
          var _ref2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
          /*#__PURE__*/
          C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee2(e) {
            var data;
            return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee2$(_context2) {
              while (1) {
                switch (_context2.prev = _context2.next) {
                  case 0:
                    setFieldValue('group', null);

                    _this.setState({
                      groupFilter: e.target.value
                    });

                    if (!(!e.target.value || e.target.value.length < 2)) {
                      _context2.next = 5;
                      break;
                    }

                    _this.setState({
                      grouplist: null
                    });

                    return _context2.abrupt("return");

                  case 5:
                    _context2.next = 7;
                    return _resources__WEBPACK_IMPORTED_MODULE_10__["client"].groups.all(e.target.value, 3, 0);

                  case 7:
                    data = _context2.sent;

                    if (data.code === 200) {
                      _this.setState({
                        grouplist: data.data,
                        loading: false
                      });
                    } else {
                      _this.setState({
                        error: 'Errore API',
                        loading: false
                      });
                    }

                  case 9:
                  case "end":
                    return _context2.stop();
                }
              }
            }, _callee2);
          }));

          return function (_x2) {
            return _ref2.apply(this, arguments);
          };
        }()
      );
    };

    _this.handleGroupSelection = function (group, setFieldValue) {
      return function (event) {
        setFieldValue('group', group.id);

        _this.setState({
          groupFilter: group.name,
          grouplist: null
        });
      };
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__["default"])(CreateGreaterNominativeForm, [{
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 84
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Formik"], {
        initialValues: {
          firstName: '',
          lastName: '',
          role: null,
          group: this.hasGroup() ? this.props.group.id : null,
          specificaRuolo: '',
          contacts: [],
          address: '',
          email: '',
          telefono: '',
          groups: []
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitNominative,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 85
        },
        __self: this
      }, function (_ref3) {
        var values = _ref3.values,
            setFieldValue = _ref3.setFieldValue,
            isValid = _ref3.isValid;
        return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 102
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("table", {
          style: {
            width: '100%'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 103
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("tr", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 103
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 103
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 104
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 105
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 106
          },
          __self: this
        }, "Nome"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "firstName",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 107
          },
          __self: this
        })))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 109
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 110
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 111
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 112
          },
          __self: this
        }, "Cognome"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "lastName",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 113
          },
          __self: this
        }))))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("tr", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 115
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          colSpan: 2,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 115
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 116
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 117
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 118
          },
          __self: this
        }, "Indirizzo"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "address",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 119
          },
          __self: this
        }))))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("tr", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 121
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          colSpan: 2,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 121
          },
          __self: this
        }, _this2.hasGroup() && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 123
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 124
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 125
          },
          __self: this
        }, "Gruppo"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 126
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 126
          },
          __self: this
        }, _this2.prefilledGroup())))), !_this2.hasGroup() && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 131
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 132
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 133
          },
          __self: this
        }, "Gruppo"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("input", {
          value: _this2.state.groupFilter,
          type: "text",
          onChange: _this2.filterGroups(setFieldValue),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 134
          },
          __self: this
        }), _this2.state.grouplist && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("ul", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.list,
          style: {
            height: '120px'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 136
          },
          __self: this
        }, _this2.state.grouplist && _this2.state.grouplist.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_7___default.a.Fragment, {
            key: el.id,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 137
            },
            __self: this
          }, el.id >= 0 && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("li", {
            style: {
              display: 'flex',
              alignItems: 'center',
              padding: '.5rem 0'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 139
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
            style: {
              width: '90%',
              height: '16px',
              cursor: 'pointer'
            },
            onClick: _this2.handleGroupSelection(el, setFieldValue),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 140
            },
            __self: this
          }, el.name)));
        })))))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("tr", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 149
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 149
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 150
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 151
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 152
          },
          __self: this
        }, "Ruolo"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("select", {
          onChange: _this2.handleRole(values, setFieldValue),
          defaultValue: "",
          style: {
            marginLeft: 'auto'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 153
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("option", {
          value: "",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 154
          },
          __self: this
        }, "---"), _this2.props.roles && _this2.props.roles.map(function (role) {
          return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("option", {
            key: role.id,
            value: role.id,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 155
            },
            __self: this
          }, role.name);
        }))))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 158
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 159
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 160
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 161
          },
          __self: this
        }, "Specifica"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "specificaRuolo",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 162
          },
          __self: this
        }))))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("tr", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 164
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 164
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 165
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 166
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 167
          },
          __self: this
        }, "Email"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "email",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 168
          },
          __self: this
        })))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("td", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 170
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 171
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 172
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 173
          },
          __self: this
        }, "Telefoni"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "telefono",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 174
          },
          __self: this
        })))))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 177
          },
          __self: this
        }, " Crea "));
      }));
    }
  }]);

  return CreateGreaterNominativeForm;
}(react__WEBPACK_IMPORTED_MODULE_7__["Component"]);
CreateGreaterNominativeForm.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_12__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/DetailForm.tsx":
/*!****************************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/DetailForm.tsx ***!
  \****************************************************************/
/*! exports provided: DetailForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DetailForm", function() { return DetailForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_14___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_14__);
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./ContactDetailPanel.module.css */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_15__);







var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactDetailPanel\\DetailForm.tsx";









var DetailForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__["default"])(DetailForm, _Component);

  function DetailForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__["default"])(this, DetailForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__["default"])(DetailForm)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_13__["object"]().shape({
        firstName: yup__WEBPACK_IMPORTED_MODULE_13__["string"]().required(),
        lastName: yup__WEBPACK_IMPORTED_MODULE_13__["string"]().required(),
        address: yup__WEBPACK_IMPORTED_MODULE_13__["string"](),
        modificaMinore: yup__WEBPACK_IMPORTED_MODULE_13__["boolean"]()
      });
    };

    _this.onSubmitNominative =
    /*#__PURE__*/
    function () {
      var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee(values) {
        var result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_10__["client"].nominatives.update(_this.props.nominative.id, values);

              case 2:
                result = _context.sent;

                if (!(result.code === 204)) {
                  _context.next = 10;
                  break;
                }

                _context.next = 6;
                return _this.props.refetch();

              case 6:
                _Modal_Modal__WEBPACK_IMPORTED_MODULE_12__["Modal"].hide();
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Nominativo modificato", {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.SUCCESS
                });
                _context.next = 13;
                break;

              case 10:
                _context.next = 12;
                return _this.props.refetch();

              case 12:
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Modifica fallita, riprova", {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.ERROR
                });

              case 13:
              case "end":
                return _context.stop();
            }
          }
        }, _callee);
      }));

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }();

    _this.onCheckChange2 = function (setFieldValue, value) {
      return function (event) {
        setFieldValue('modificaMinore', event.target.value ? true : false);
      };
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__["default"])(DetailForm, [{
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_7___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 47
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Formik"], {
        initialValues: {
          firstName: this.props.nominative.firstName,
          lastName: this.props.nominative.lastName,
          contacts: this.props.nominative.contacts,
          address: this.props.nominative.address,
          groups: this.props.nominative.groups,
          group: null,
          role: null,
          specificaRuolo: '',
          modificaMinore: false
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitNominative,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 48
        },
        __self: this
      }, function (_ref2) {
        var isValid = _ref2.isValid,
            setFieldValue = _ref2.setFieldValue,
            values = _ref2.values;
        return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 64
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 65
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 66
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 67
          },
          __self: this
        }, "Nome"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "firstName",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 68
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 71
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 72
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 73
          },
          __self: this
        }, "Cognome"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "lastName",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 74
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 77
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 78
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 79
          },
          __self: this
        }, "Indirizzo"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "address",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 80
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 83
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 84
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 85
          },
          __self: this
        }, "Modifica minore"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("input", {
          type: "checkbox",
          defaultChecked: false,
          onChange: _this2.onCheckChange2(setFieldValue, values.modificaMinore),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 86
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 90
          },
          __self: this
        }, " Modifica "));
      })));
    }
  }]);

  return DetailForm;
}(react__WEBPACK_IMPORTED_MODULE_7__["Component"]);
DetailForm.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_11__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/GroupList.tsx":
/*!***************************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/GroupList.tsx ***!
  \***************************************************************/
/*! exports provided: GroupList */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GroupList", function() { return GroupList; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/toConsumableArray */ "./node_modules/@babel/runtime/helpers/esm/toConsumableArray.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_12__);
/* harmony import */ var _ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../ContactDetailPanel/ContactDetailPanel.module.css */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");
/* harmony import */ var _ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_15__);
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../../utils */ "./src/utils.ts");








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactDetailPanel\\GroupList.tsx";









var GroupList =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(GroupList, _Component);

  function GroupList() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, GroupList);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(GroupList)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.state = {
      data: [],
      loading: true,
      error: undefined
    };

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_12__["object"]().shape({
        groups: yup__WEBPACK_IMPORTED_MODULE_12__["array"]().of(yup__WEBPACK_IMPORTED_MODULE_12__["object"]({
          id: yup__WEBPACK_IMPORTED_MODULE_12__["mixed"]().required(),
          roleId: yup__WEBPACK_IMPORTED_MODULE_12__["mixed"]().required()
        }))
      });
    };

    _this.onSubmitChange =
    /*#__PURE__*/
    function () {
      var _ref2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee(_ref) {
        var groups, result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                groups = _ref.groups;
                _context.prev = 1;
                _context.next = 4;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.setGroupsNominativeRole(_this.props.nominative.id, groups);

              case 4:
                result = _context.sent;

                if (result.code >= 200 && result.code < 300) {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Nominativi associati", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.SUCCESS
                  });
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__["Modal"].hide();

                  _this.props.refetch();
                }

                _context.next = 12;
                break;

              case 8:
                _context.prev = 8;
                _context.t0 = _context["catch"](1);
                console.error(_context.t0);
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])('Errore associazione', {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.ERROR
                });

              case 12:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, null, [[1, 8]]);
      }));

      return function (_x) {
        return _ref2.apply(this, arguments);
      };
    }();

    _this.filterData =
    /*#__PURE__*/
    function () {
      var _ref3 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee2(e) {
        var data;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee2$(_context2) {
          while (1) {
            switch (_context2.prev = _context2.next) {
              case 0:
                _context2.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all(e.target.value, 100000, 0);

              case 2:
                data = _context2.sent;

                if (data.code === 200) {
                  _this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  _this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

                if (!(e.target.value === '')) {
                  _context2.next = 9;
                  break;
                }

                _context2.next = 7;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all('', 100000, 0);

              case 7:
                data = _context2.sent;

                if (data.code === 200) {
                  _this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  _this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

              case 9:
              case "end":
                return _context2.stop();
            }
          }
        }, _callee2);
      }));

      return function (_x2) {
        return _ref3.apply(this, arguments);
      };
    }();

    _this.handleSelection = function (group, setFieldValue, _ref4) {
      var groups = _ref4.groups;
      return function (event) {
        var selected = [];

        if (groups.find(function (el) {
          return el.id === group.id;
        }) !== undefined) {
          selected = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(groups.filter(function (el) {
            return el.id !== group.id;
          }));
        } else {
          selected = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(groups), [{
            id: group.id,
            role: undefined
          }]);
        }

        setFieldValue('groups', selected);
      };
    };

    _this.handleRole = function (group, _ref5, setFieldValue) {
      var groups = _ref5.groups;
      return function (event) {
        var pos = groups.findIndex(function (el) {
          return el.id === group.id;
        });

        var values = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(groups);

        values[pos].roleId = Number(event.target.value);
        setFieldValue('groups', values);
      };
    };

    _this.handleSpecifica = function (nominative, _ref6, setFieldValue) {
      var groups = _ref6.groups;
      return function (event) {
        var pos = groups.findIndex(function (el) {
          return el.id === nominative.id;
        });

        var values = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(groups);

        values[pos].specificaRuolo = event.target.value;
        setFieldValue('groups', values);
      };
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(GroupList, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee3() {
        var data;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee3$(_context3) {
          while (1) {
            switch (_context3.prev = _context3.next) {
              case 0:
                _context3.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all('', 100000, 0);

              case 2:
                data = _context3.sent;

                if (data.code === 200) {
                  this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

              case 4:
              case "end":
                return _context3.stop();
            }
          }
        }, _callee3, this);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: _ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 98
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Formik"], {
        initialValues: {
          groups: []
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitChange,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 99
        },
        __self: this
      }, function (_ref7) {
        var isValid = _ref7.isValid,
            setFieldValue = _ref7.setFieldValue,
            values = _ref7.values;
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 107
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
          type: "text",
          onChange: Object(_utils__WEBPACK_IMPORTED_MODULE_16__["debounced"])(_this2.filterData, 350),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 108
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("ul", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.list,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 109
          },
          __self: this
        }, _this2.state.data && _this2.state.data.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, {
            key: el.id,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 110
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("li", {
            style: {
              display: 'flex',
              alignItems: 'center',
              padding: '.5rem 0'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 112
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
            type: "checkbox",
            defaultChecked: false,
            onChange: _this2.handleSelection(el, setFieldValue, values),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 113
            },
            __self: this
          }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 114
            },
            __self: this
          }, el.name), values.groups.find(function (group) {
            return group.id === el.id;
          }) !== undefined && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 116
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("select", {
            onChange: _this2.handleRole(el, values, setFieldValue),
            defaultValue: "",
            style: {
              marginLeft: 'auto'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 117
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
            value: "",
            __source: {
              fileName: _jsxFileName,
              lineNumber: 118
            },
            __self: this
          }, "Seleziona ruolo"), _this2.props.roles && _this2.props.roles.map(function (role) {
            return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
              key: role.id,
              value: role.id,
              __source: {
                fileName: _jsxFileName,
                lineNumber: 119
              },
              __self: this
            }, role.name);
          })), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
            type: "text",
            placeholder: "Specifica ruolo",
            onChange: _this2.handleSpecifica(el, values, setFieldValue),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 121
            },
            __self: this
          }))));
        })), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 129
          },
          __self: this
        }, " Associa "));
      })));
    }
  }]);

  return GroupList;
}(react__WEBPACK_IMPORTED_MODULE_8__["Component"]);

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/ModifyContactForm.tsx":
/*!***********************************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/ModifyContactForm.tsx ***!
  \***********************************************************************/
/*! exports provided: ModifyContactForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModifyContactForm", function() { return ModifyContactForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/objectSpread */ "./node_modules/@babel/runtime/helpers/esm/objectSpread.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_12__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./ContactDetailPanel.module.css */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");
/* harmony import */ var _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14___default = /*#__PURE__*/__webpack_require__.n(_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14__);
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_15__);








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactDetailPanel\\ModifyContactForm.tsx";








var ModifyContactForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(ModifyContactForm, _Component);

  function ModifyContactForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, ModifyContactForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(ModifyContactForm)).call.apply(_getPrototypeOf2, [this].concat(args)));

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_12__["object"]().shape({
        channelId: yup__WEBPACK_IMPORTED_MODULE_12__["number"]().required(),
        value: yup__WEBPACK_IMPORTED_MODULE_12__["string"]().required(),
        warning: yup__WEBPACK_IMPORTED_MODULE_12__["boolean"](),
        modificaMinore: yup__WEBPACK_IMPORTED_MODULE_12__["boolean"]()
      });
    };

    _this.onSubmitContact =
    /*#__PURE__*/
    function () {
      var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee(values) {
        var result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].contacts.update(_this.props.contact.id, Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_1__["default"])({}, values, {
                  nominativeId: _this.props.nominative.id
                }));

              case 2:
                result = _context.sent;

                if (!(result.code === 204)) {
                  _context.next = 10;
                  break;
                }

                _context.next = 6;
                return _this.props.refetch();

              case 6:
                _Modal_Modal__WEBPACK_IMPORTED_MODULE_13__["Modal"].hide();
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Update avvenuto con successo", {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.SUCCESS
                });
                _context.next = 11;
                break;

              case 10:
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Update fallito, riprova", {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.ERROR
                });

              case 11:
              case "end":
                return _context.stop();
            }
          }
        }, _callee);
      }));

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }();

    _this.onChange = function (setFieldValue) {
      return function (event) {
        setFieldValue('channelId', event.target.value);
      };
    };

    _this.renderOptions = function (channels) {
      var options = channels.map(function (channel) {
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
          key: channel.id,
          value: channel.id,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 43
          },
          __self: this
        }, channel.name);
      });
      return options;
    };

    _this.onCheckChange = function (setFieldValue, value) {
      return function (event) {
        setFieldValue('warning', event.target.value ? true : false);
      };
    };

    _this.onCheckChange2 = function (setFieldValue, value) {
      return function (event) {
        setFieldValue('modificaMinore', event.target.value ? true : false);
      };
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(ModifyContactForm, [{
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: _ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 58
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Formik"], {
        initialValues: {
          warning: this.props.contact.warning,
          value: this.props.contact.value,
          channelId: this.props.contact.channelId,
          modificaMinore: false
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitContact,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 59
        },
        __self: this
      }, function (_ref2) {
        var isValid = _ref2.isValid,
            setFieldValue = _ref2.setFieldValue,
            dirty = _ref2.dirty,
            values = _ref2.values;
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 70
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 71
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 72
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 73
          },
          __self: this
        }, "Canale"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("select", {
          style: {
            width: '100%'
          },
          name: "channelId",
          onChange: _this2.onChange(setFieldValue),
          defaultValue: _this2.props.contact.channelId,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 74
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
          value: undefined,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 76
          },
          __self: this
        }, " -- SELEZIONA CANALE -- "), _this2.renderOptions(_this2.props.channels))))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 82
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 83
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 84
          },
          __self: this
        }, "Valore"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Field"], {
          type: "text",
          name: "value",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 85
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 88
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 89
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 90
          },
          __self: this
        }, "Allertamento"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
          type: "checkbox",
          defaultChecked: values.warning,
          onChange: _this2.onCheckChange(setFieldValue, values.warning),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 91
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 94
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 95
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 96
          },
          __self: this
        }, "Modifica minore"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
          type: "checkbox",
          defaultChecked: false,
          onChange: _this2.onCheckChange2(setFieldValue, values.modificaMinore),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 97
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 101
          },
          __self: this
        }, " Salva "));
      })));
    }
  }]);

  return ModifyContactForm;
}(react__WEBPACK_IMPORTED_MODULE_8__["Component"]);

/***/ }),

/***/ "./src/components/Panel/ContactDetailPanel/index.ts":
/*!**********************************************************!*\
  !*** ./src/components/Panel/ContactDetailPanel/index.ts ***!
  \**********************************************************/
/*! exports provided: ContactDetailPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _ContactDetailPanel__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./ContactDetailPanel */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ContactDetailPanel", function() { return _ContactDetailPanel__WEBPACK_IMPORTED_MODULE_0__["ContactDetailPanel"]; });




/***/ }),

/***/ "./src/components/Panel/ContactPanel/ContactPanel.tsx":
/*!************************************************************!*\
  !*** ./src/components/Panel/ContactPanel/ContactPanel.tsx ***!
  \************************************************************/
/*! exports provided: ContactPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ContactPanel", function() { return ContactPanel; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/objectSpread */ "./node_modules/@babel/runtime/helpers/esm/objectSpread.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var ag_grid_react__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ag-grid-react */ "./node_modules/ag-grid-react/main.js");
/* harmony import */ var ag_grid_react__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(ag_grid_react__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var _Loader__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../Loader */ "./src/components/Loader/index.ts");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _types_d__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../types.d */ "./src/types.d.ts");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_14___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_14__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _ContactDetailPanel_CreateGreaterNominativeForm__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../ContactDetailPanel/CreateGreaterNominativeForm */ "./src/components/Panel/ContactDetailPanel/CreateGreaterNominativeForm.tsx");
/* harmony import */ var _MoveNominativeForm__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./MoveNominativeForm */ "./src/components/Panel/ContactPanel/MoveNominativeForm.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_18___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_18__);
/* harmony import */ var _Loader_Loader_module_css__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../Loader/Loader.module.css */ "./src/components/Loader/Loader.module.css");
/* harmony import */ var _Loader_Loader_module_css__WEBPACK_IMPORTED_MODULE_19___default = /*#__PURE__*/__webpack_require__.n(_Loader_Loader_module_css__WEBPACK_IMPORTED_MODULE_19__);
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ../../../utils */ "./src/utils.ts");








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactPanel\\ContactPanel.tsx";













var ContactPanel =
/*#__PURE__*/
function (_PureComponent) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(ContactPanel, _PureComponent);

  function ContactPanel() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, ContactPanel);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(ContactPanel)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      loading: true,
      data: [],
      filter: '',
      error: null,
      selected: [],
      total: 0
    };
    _this.gridApi = null;

    _this.onGridReady = function (params) {
      _this.gridApi = params.api;

      _this.gridApi.sizeColumnsToFit();
    };

    _this.onResize = function () {
      if (_this.gridApi) {
        _this.gridApi.sizeColumnsToFit();
      }
    };

    _this.handleNewNominative = function () {
      /* Modal.show('Crea Nominativo', <CreateNominativeForm refetch={this.refetch} />, null, null)*/
      _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].showTall('Crea Nominativo', react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_ContactDetailPanel_CreateGreaterNominativeForm__WEBPACK_IMPORTED_MODULE_16__["CreateGreaterNominativeForm"], {
        refetch: _this.refetch,
        roles: _this.context.roles,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 47
        },
        __self: this
      }));
    };

    _this.handleNominativeClick = function (id) {
      return function () {
        return _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_13__["PanelType"].CONTACT_DETAILS, _this.props.id, id, _this.state);
      };
    };

    _this.handleNominativeRemoval = function (id) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee() {
          var response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee$(_context) {
            while (1) {
              switch (_context.prev = _context.next) {
                case 0:
                  _context.next = 2;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].nominatives.delete(id);

                case 2:
                  response = _context.sent;

                  if (response.code === 204) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"])('Nominativo cancellato con successo', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"].TYPE.SUCCESS
                    });

                    _this.refetch();

                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"])('Cancellazione fallita, riprova', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"].TYPE.ERROR
                    });
                  }

                case 4:
                case "end":
                  return _context.stop();
              }
            }
          }, _callee);
        }))
      );
    };

    _this.handleNominativesRemoval = function (nominatives) {
      return (
        /*#__PURE__*/
        function () {
          var _ref2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
          /*#__PURE__*/
          C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee2(event) {
            var ids, response;
            return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee2$(_context2) {
              while (1) {
                switch (_context2.prev = _context2.next) {
                  case 0:
                    ids = Array.isArray(nominatives) ? nominatives.map(function (_ref3) {
                      var id = _ref3.id;
                      return {
                        id: id
                      };
                    }) : [].concat({
                      "id": nominatives
                    });
                    _context2.next = 3;
                    return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].nominatives.deleteMulti(ids);

                  case 3:
                    response = _context2.sent;

                    if (response.code >= 200 && response.code < 300) {
                      Object(react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"])('Nominativi eliminati', {
                        type: react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"].TYPE.SUCCESS
                      });

                      _this.setState({
                        selected: []
                      }, function () {
                        return _this.refetch();
                      });
                    } else {
                      Object(react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"])('Eliminazione fallita, riprova', {
                        type: react_toastify__WEBPACK_IMPORTED_MODULE_14__["toast"].TYPE.ERROR
                      });
                    }

                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                  case 6:
                  case "end":
                    return _context2.stop();
                }
              }
            }, _callee2);
          }));

          return function (_x) {
            return _ref2.apply(this, arguments);
          };
        }()
      );
    };

    _this.handleRemoval = function (nominative) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Eliminazione nominativo', react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: "leftAligned",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 90
          },
          __self: this
        }, "Conferma la rimozione del nominativo:", react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 92
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.modalList,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 93
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 94
          },
          __self: this
        }, "- ", nominative.firstName, " ", nominative.lastName)), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.actionButton),
          onClick: _this.handleNominativesRemoval(nominative.id),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 96
          },
          __self: this
        }, "ELIMINA")));
      };
    };

    _this.handleMultiRemoval = function (nominatives) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Eliminazione nominativi', react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: "leftAligned ".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.listedContent),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 109
          },
          __self: this
        }, "Conferma la rimozione dei nominativi: ", react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 110
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.modalList,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 111
          },
          __self: this
        }, nominatives.map(function (nominative) {
          return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("b", {
            key: nominative.id,
            className: _common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.modalItem,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 113
            },
            __self: this
          }, " - ", nominative.firstName, " ", nominative.lastName, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("br", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 113
            },
            __self: this
          }));
        })), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.actionButton),
          onClick: _this.handleNominativesRemoval(nominatives),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 116
          },
          __self: this
        }, "ELIMINA")));
      };
    };

    _this.refetch =
    /*#__PURE__*/
    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
    /*#__PURE__*/
    C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee3() {
      var data;
      return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee3$(_context3) {
        while (1) {
          switch (_context3.prev = _context3.next) {
            case 0:
              _context3.prev = 0;
              _context3.next = 3;
              return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].nominatives.all(_this.state.filter, 100000, 0);

            case 3:
              data = _context3.sent;

              _this.setState({
                loading: false,
                data: data.data,
                error: null
              });

              _this.context.setCache(_this.props.id, 'contactData', data.data);

              _context3.next = 13;
              break;

            case 8:
              _context3.prev = 8;
              _context3.t0 = _context3["catch"](0);
              console.error(_context3.t0);

              _this.setState({
                loading: false,
                data: [],
                error: 'API Error'
              });

              _this.context.setCache(_this.props.id, 'contactData', null);

            case 13:
            case "end":
              return _context3.stop();
          }
        }
      }, _callee3, null, [[0, 8]]);
    }));

    _this.onSelectionChanged = function () {
      if (_this.gridApi) {
        _this.setState(function (p) {
          return Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__["default"])({}, p, {
            selected: _this.gridApi.getSelectedRows()
          });
        });
      }
    };

    _this.handleMove = function () {
      _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Sposta nominativo/i', react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_MoveNominativeForm__WEBPACK_IMPORTED_MODULE_17__["MoveNominativeForm"], {
        nominatives: _this.state.selected,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 148
        },
        __self: this
      }));
    };

    _this.filterData =
    /*#__PURE__*/
    function () {
      var _ref5 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee4(e) {
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee4$(_context4) {
          while (1) {
            switch (_context4.prev = _context4.next) {
              case 0:
                _this.context.setCache(_this.props.id, 'contactFilter', e.target.value);

                _this.setState({
                  filter: e.target.value
                });

                _this.refetch();

              case 3:
              case "end":
                return _context4.stop();
            }
          }
        }, _callee4);
      }));

      return function (_x2) {
        return _ref5.apply(this, arguments);
      };
    }();

    _this.colDefs = [{
      headerName: "",
      checkboxSelection: true,
      width: 20
    }, {
      headerName: "Nominativo",
      cellRendererFramework: function cellRendererFramework(_ref6) {
        var data = _ref6.data;
        var gruppi = '';
        var k;

        if (data && data.groups && data.groups.length > 0) {
          for (k = 0; k < data.groups.length; k++) {
            if (k > 0) gruppi += ', ';
            gruppi += data.groups[k].name;
          }
        }

        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          style: {
            'lineHeight': '23px'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 188
          },
          __self: this
        }, data && data.firstName, " ", data && data.lastName, " ", data && !data.firstName && !data.lastName && 'Senza nome', " ", react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 189
          },
          __self: this
        }), gruppi);
      }
    }, {
      headerName: "Contatti",
      width: 55,
      cellRenderer: function cellRenderer(_ref7) {
        var data = _ref7.data;
        return "".concat(data && data.contacts && data.contacts.length);
      }
    }, {
      headerName: "Ultima Modifica",
      width: 50,
      cellRenderer: function cellRenderer(_ref8) {
        var data = _ref8.data;
        var dat = new Date();

        if (data && data.lastEdit) {
          dat.setTime(data.lastEdit);
          return dat.toLocaleString('it-IT');
        }

        return '';
      }
    }, {
      headerName: "Azioni",
      width: 100,
      suppressSizeToFit: true,
      cellRendererFramework: function cellRendererFramework(_ref9) {
        var data = _ref9.data;
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.tabActions,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 206
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this.handleNominativeClick(data.id),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 207
          },
          __self: this
        }, " \uD83D\uDD0D "), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this.context.loggedUser && _this.context.loggedUser.write && _this.handleRemoval(data),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 208
          },
          __self: this
        }, " \u274C "));
      }
    }];
    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(ContactPanel, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee5() {
        var cacheData;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee5$(_context5) {
          while (1) {
            switch (_context5.prev = _context5.next) {
              case 0:
                window.addEventListener('resize', this.onResize, {
                  passive: true
                });
                cacheData = this.context.getCache(this.props.id, 'contactData');
                if (cacheData) this.setState({
                  data: cacheData,
                  loading: false
                });else {
                  try {
                    this.refetch();
                  } catch (err) {
                    console.error(err);
                    this.setState({
                      loading: false,
                      data: [],
                      error: 'API Error'
                    });
                  }
                }

              case 3:
              case "end":
                return _context5.stop();
            }
          }
        }, _callee5, this);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "componentWillUnmount",
    value: function componentWillUnmount() {
      window.removeEventListener('resize', this.onResize);
    }
  }, {
    key: "render",
    value: function render() {
      var _this$state = this.state,
          loading = _this$state.loading,
          error = _this$state.error,
          selected = _this$state.selected;
      var filt = this.context.getCache(this.props.id, 'contactFilter');
      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, loading && !this.context.loggedUser && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_Loader__WEBPACK_IMPORTED_MODULE_10__["Loader"], {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 221
        },
        __self: this
      }), !loading && !error && this.context.loggedUser && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.buttonRow,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 225
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.button,
        disabled: this.context.loggedUser && !this.context.loggedUser.write,
        onClick: this.handleNewNominative,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 226
        },
        __self: this
      }, "Crea Nominativo"), selected && selected.length >= 1 && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_18___default.a.button,
        style: {
          marginLeft: '1rem'
        },
        disabled: this.context.loggedUser && !this.context.loggedUser.write,
        onClick: this.handleMultiRemoval(selected),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 234
        },
        __self: this
      }, "Elimina Nominativi")), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
        htmlFor: "filtro",
        __source: {
          fileName: _jsxFileName,
          lineNumber: 244
        },
        __self: this
      }, "Filtra:"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
        id: "filtro",
        defaultValue: filt ? filt : "",
        type: "text",
        onChange: Object(_utils__WEBPACK_IMPORTED_MODULE_20__["debounced"])(this.filterData, 350),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 245
        },
        __self: this
      }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: "ag-theme-material",
        __source: {
          fileName: _jsxFileName,
          lineNumber: 246
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(ag_grid_react__WEBPACK_IMPORTED_MODULE_9__["AgGridReact"], {
        columnDefs: this.colDefs,
        rowSelection: "multiple",
        suppressRowClickSelection: true,
        rowData: this.state.data,
        onSelectionChanged: this.onSelectionChanged,
        pagination: true,
        paginationPageSize: 20,
        onFirstDataRendered: this.onGridReady,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 247
        },
        __self: this
      }))), !loading && error && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: _Loader_Loader_module_css__WEBPACK_IMPORTED_MODULE_19___default.a.loader,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 261
        },
        __self: this
      }, error));
    }
  }]);

  return ContactPanel;
}(react__WEBPACK_IMPORTED_MODULE_8__["PureComponent"]);
ContactPanel.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_12__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/ContactPanel/MoveNominativeForm.tsx":
/*!******************************************************************!*\
  !*** ./src/components/Panel/ContactPanel/MoveNominativeForm.tsx ***!
  \******************************************************************/
/*! exports provided: MoveNominativeForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MoveNominativeForm", function() { return MoveNominativeForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_5__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_9__);





var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\ContactPanel\\MoveNominativeForm.tsx";





var MoveNominativeForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__["default"])(MoveNominativeForm, _Component);

  function MoveNominativeForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__["default"])(this, MoveNominativeForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__["default"])(MoveNominativeForm)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      selectedGroupId: undefined
    };

    _this.submitChanges = function (values) {
      _resources__WEBPACK_IMPORTED_MODULE_7__["client"].groups.setNominativeRole(_this.state.selectedGroupId, values.nominativeId, values.roleId);
    };

    _this.handleChange = function (setFieldValue, id) {
      return function (event) {
        setFieldValue('nominatives', id);
      };
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__["default"])(MoveNominativeForm, [{
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_5___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        className: '',
        __source: {
          fileName: _jsxFileName,
          lineNumber: 28
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_6__["Formik"], {
        initialValues: {
          nominatives: []
        },
        onSubmit: this.submitChanges,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 29
        },
        __self: this
      }, function (_ref) {
        var values = _ref.values,
            isValid = _ref.isValid,
            setFieldValue = _ref.setFieldValue;
        return react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_6__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 36
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("ul", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 37
          },
          __self: this
        }, _this2.props.nominatives.map(function (el, idx) {
          react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("li", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 39
            },
            __self: this
          }, el.firstName, " ", el.lastName, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("input", {
            hidden: true,
            value: el.id,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 41
            },
            __self: this
          }), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("select", {
            name: "roleId",
            onChange: _this2.handleChange(setFieldValue, el.id),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 42
            },
            __self: this
          }, _this2.context.roles.map(function (role) {
            react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("option", {
              value: role.id,
              __source: {
                fileName: _jsxFileName,
                lineNumber: 44
              },
              __self: this
            }, role.name);
          })));
        })), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_9___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_9___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 51
          },
          __self: this
        }, " Salva Modifiche "));
      })));
    }
  }]);

  return MoveNominativeForm;
}(react__WEBPACK_IMPORTED_MODULE_5__["Component"]);
MoveNominativeForm.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_8__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/ContactPanel/index.ts":
/*!****************************************************!*\
  !*** ./src/components/Panel/ContactPanel/index.ts ***!
  \****************************************************/
/*! exports provided: ContactPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _ContactPanel__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./ContactPanel */ "./src/components/Panel/ContactPanel/ContactPanel.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ContactPanel", function() { return _ContactPanel__WEBPACK_IMPORTED_MODULE_0__["ContactPanel"]; });




/***/ }),

/***/ "./src/components/Panel/GroupDetailPanel/AddNominativesForm.tsx":
/*!**********************************************************************!*\
  !*** ./src/components/Panel/GroupDetailPanel/AddNominativesForm.tsx ***!
  \**********************************************************************/
/*! exports provided: AddNominativesForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddNominativesForm", function() { return AddNominativesForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/toConsumableArray */ "./node_modules/@babel/runtime/helpers/esm/toConsumableArray.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_12__);
/* harmony import */ var _ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../ContactDetailPanel/ContactDetailPanel.module.css */ "./src/components/Panel/ContactDetailPanel/ContactDetailPanel.module.css");
/* harmony import */ var _ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_15__);
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../../utils */ "./src/utils.ts");








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\GroupDetailPanel\\AddNominativesForm.tsx";









var AddNominativesForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(AddNominativesForm, _Component);

  function AddNominativesForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, AddNominativesForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(AddNominativesForm)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.state = {
      data: [],
      loading: true,
      error: undefined
    };

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_12__["object"]().shape({
        nominatives: yup__WEBPACK_IMPORTED_MODULE_12__["array"]().of(yup__WEBPACK_IMPORTED_MODULE_12__["object"]({
          nominativeId: yup__WEBPACK_IMPORTED_MODULE_12__["mixed"]().required(),
          role: yup__WEBPACK_IMPORTED_MODULE_12__["mixed"]().required()
        }))
      });
    };

    _this.onSubmitChange =
    /*#__PURE__*/
    function () {
      var _ref2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee(_ref) {
        var nominatives, result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                nominatives = _ref.nominatives;
                _context.prev = 1;
                _context.next = 4;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.setNominativesRole(_this.props.group.id, nominatives);

              case 4:
                result = _context.sent;

                if (result.code === 201) {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Nominativi associati", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.SUCCESS
                  });
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__["Modal"].hide();

                  _this.props.refetch();
                }

                _context.next = 12;
                break;

              case 8:
                _context.prev = 8;
                _context.t0 = _context["catch"](1);
                console.error(_context.t0);
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])('Errore associzione', {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.ERROR
                });

              case 12:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, null, [[1, 8]]);
      }));

      return function (_x) {
        return _ref2.apply(this, arguments);
      };
    }();

    _this.handleSelection = function (nominative, setFieldValue, _ref3) {
      var nominatives = _ref3.nominatives;
      return function (event) {
        var selected = [];

        if (nominatives.find(function (el) {
          return el.id === nominative.id;
        }) !== undefined) {
          selected = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(nominatives.filter(function (el) {
            return el.id !== nominative.id;
          }));
        } else {
          selected = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(nominatives), [{
            nominativeId: nominative.id,
            role: undefined
          }]);
        }

        setFieldValue('nominatives', selected);
      };
    };

    _this.handleRole = function (nominative, _ref4, setFieldValue) {
      var nominatives = _ref4.nominatives;
      return function (event) {
        var pos = nominatives.findIndex(function (el) {
          return el.nominativeId === nominative.id;
        });

        var values = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(nominatives);

        values[pos].role = event.target.value;
        setFieldValue('nominatives', values);
      };
    };

    _this.handleSpecifica = function (nominative, _ref5, setFieldValue) {
      var nominatives = _ref5.nominatives;
      return function (event) {
        var pos = nominatives.findIndex(function (el) {
          return el.nominativeId === nominative.id;
        });

        var values = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(nominatives);

        values[pos].specificaRuolo = event.target.value;
        setFieldValue('nominatives', values);
      };
    };

    _this.filterData =
    /*#__PURE__*/
    function () {
      var _ref6 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee2(e) {
        var data;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee2$(_context2) {
          while (1) {
            switch (_context2.prev = _context2.next) {
              case 0:
                _context2.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].nominatives.all(e.target.value, 100000, 0);

              case 2:
                data = _context2.sent;

                if (data.code === 200) {
                  _this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  _this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

                if (!(e.target.value === '')) {
                  _context2.next = 9;
                  break;
                }

                _context2.next = 7;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all('', 100000, 0);

              case 7:
                data = _context2.sent;

                if (data.code === 200) {
                  _this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  _this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

              case 9:
              case "end":
                return _context2.stop();
            }
          }
        }, _callee2);
      }));

      return function (_x2) {
        return _ref6.apply(this, arguments);
      };
    }();

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(AddNominativesForm, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee3() {
        var data;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee3$(_context3) {
          while (1) {
            switch (_context3.prev = _context3.next) {
              case 0:
                _context3.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].nominatives.all('', 100000, 0);

              case 2:
                data = _context3.sent;

                if (data.code === 200) {
                  this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

              case 4:
              case "end":
                return _context3.stop();
            }
          }
        }, _callee3, this);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: _ContactDetailPanel_ContactDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 98
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Formik"], {
        initialValues: {
          nominatives: []
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitChange,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 99
        },
        __self: this
      }, function (_ref7) {
        var isValid = _ref7.isValid,
            setFieldValue = _ref7.setFieldValue,
            values = _ref7.values;
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 107
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
          type: "text",
          onChange: Object(_utils__WEBPACK_IMPORTED_MODULE_16__["debounced"])(_this2.filterData, 350),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 108
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("ul", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.list,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 109
          },
          __self: this
        }, _this2.state.data && _this2.state.data.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, {
            key: el.id,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 110
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("li", {
            style: {
              display: 'flex',
              alignItems: 'center',
              padding: '.5rem 0'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 112
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
            type: "checkbox",
            defaultChecked: false,
            onChange: _this2.handleSelection(el, setFieldValue, values),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 113
            },
            __self: this
          }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 114
            },
            __self: this
          }, el.lastName, " ", el.firstName), values.nominatives.find(function (nomin) {
            return nomin.nominativeId === el.id;
          }) !== undefined && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 116
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("select", {
            onChange: _this2.handleRole(el, values, setFieldValue),
            defaultValue: "",
            style: {
              marginLeft: 'auto'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 117
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
            value: "",
            __source: {
              fileName: _jsxFileName,
              lineNumber: 118
            },
            __self: this
          }, "Seleziona ruolo e specifica"), _this2.props.roles && _this2.props.roles.map(function (role) {
            return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("option", {
              key: role.id,
              value: role.id,
              __source: {
                fileName: _jsxFileName,
                lineNumber: 119
              },
              __self: this
            }, role.name);
          })), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
            placeholder: "Specifica ruolo",
            type: "text",
            onChange: _this2.handleSpecifica(el, values, setFieldValue),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 121
            },
            __self: this
          }))));
        })), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 129
          },
          __self: this
        }, " Associa "));
      })));
    }
  }]);

  return AddNominativesForm;
}(react__WEBPACK_IMPORTED_MODULE_8__["Component"]);

/***/ }),

/***/ "./src/components/Panel/GroupDetailPanel/CreateGroupForm.tsx":
/*!*******************************************************************!*\
  !*** ./src/components/Panel/GroupDetailPanel/CreateGroupForm.tsx ***!
  \*******************************************************************/
/*! exports provided: CreateGroupForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateGroupForm", function() { return CreateGroupForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_11___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_11__);
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./GroupDetailPanel.module.css */ "./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_15__);







var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\GroupDetailPanel\\CreateGroupForm.tsx";









var CreateGroupForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__["default"])(CreateGroupForm, _Component);

  function CreateGroupForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__["default"])(this, CreateGroupForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__["default"])(CreateGroupForm)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_11__["object"]().shape({
        name: yup__WEBPACK_IMPORTED_MODULE_11__["string"]().required()
      });
    };

    _this.onSubmitGroup =
    /*#__PURE__*/
    function () {
      var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee(values) {
        var result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_10__["client"].groups.create(values);

              case 2:
                result = _context.sent;

                if (result.code === 201) {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Gruppo creato con successo", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.SUCCESS
                  });

                  _this.props.refetch();

                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_14__["Modal"].hide();
                } else {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Creazione gruppo fallita, riprova", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.ERROR
                  });
                }

              case 4:
              case "end":
                return _context.stop();
            }
          }
        }, _callee);
      }));

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }();

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__["default"])(CreateGroupForm, [{
    key: "render",
    value: function render() {
      return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_7___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 38
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Formik"], {
        initialValues: {
          name: ''
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitGroup,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 39
        },
        __self: this
      }, function (_ref2) {
        var isValid = _ref2.isValid;
        return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 47
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 48
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 49
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 50
          },
          __self: this
        }, "Nome"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "name",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 51
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 55
          },
          __self: this
        }, " Crea "));
      })));
    }
  }]);

  return CreateGroupForm;
}(react__WEBPACK_IMPORTED_MODULE_7__["Component"]);
CreateGroupForm.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_12__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css":
/*!***************************************************************************!*\
  !*** ./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./GroupDetailPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./GroupDetailPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./GroupDetailPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Panel/GroupDetailPanel/GroupDetailPanel.tsx":
/*!********************************************************************!*\
  !*** ./src/components/Panel/GroupDetailPanel/GroupDetailPanel.tsx ***!
  \********************************************************************/
/*! exports provided: GroupDetailPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GroupDetailPanel", function() { return GroupDetailPanel; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/objectSpread */ "./node_modules/@babel/runtime/helpers/esm/objectSpread.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/toConsumableArray */ "./node_modules/@babel/runtime/helpers/esm/toConsumableArray.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var _Loader__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../Loader */ "./src/components/Loader/index.ts");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./GroupDetailPanel.module.css */ "./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _GroupForm__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./GroupForm */ "./src/components/Panel/GroupDetailPanel/GroupForm.tsx");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_15__);
/* harmony import */ var _ContactDetailPanel_CreateGreaterNominativeForm__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../ContactDetailPanel/CreateGreaterNominativeForm */ "./src/components/Panel/ContactDetailPanel/CreateGreaterNominativeForm.tsx");
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../utils */ "./src/utils.ts");
/* harmony import */ var _types_d__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../../../types.d */ "./src/types.d.ts");
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_20___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_20__);
/* harmony import */ var _GroupList__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./GroupList */ "./src/components/Panel/GroupDetailPanel/GroupList.tsx");
/* harmony import */ var _AddNominativesForm__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./AddNominativesForm */ "./src/components/Panel/GroupDetailPanel/AddNominativesForm.tsx");









var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\GroupDetailPanel\\GroupDetailPanel.tsx";














var GroupDetailPanel =
/*#__PURE__*/
function (_PureComponent) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_8__["default"])(GroupDetailPanel, _PureComponent);

  function GroupDetailPanel() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_4__["default"])(this, GroupDetailPanel);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_6__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_7__["default"])(GroupDetailPanel)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      selectedGroups: [],
      selectedSupergroups: [],
      selectedNominatives: [],
      editedNominative: null,
      data: {},
      loading: true,
      error: null,
      resId: undefined
    };

    _this.toggleNominative = function (nominative) {
      console.log('toggle nominative ' + nominative);

      _this.setState({
        editedNominative: nominative == _this.state.editedNominative ? null : nominative
      });
    };

    _this.refetch =
    /*#__PURE__*/
    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
    /*#__PURE__*/
    C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee() {
      var panels, resId, _ref2, data;

      return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee$(_context) {
        while (1) {
          switch (_context.prev = _context.next) {
            case 0:
              panels = _this.context.panels;
              resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, _this.props.id);

              if (!resId) {
                _context.next = 14;
                break;
              }

              _context.prev = 3;
              _context.next = 6;
              return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.getById(resId);

            case 6:
              _ref2 = _context.sent;
              data = _ref2.data;

              _this.setState({
                loading: false,
                data: data,
                error: null,
                resId: resId
              });

              _context.next = 14;
              break;

            case 11:
              _context.prev = 11;
              _context.t0 = _context["catch"](3);

              _this.setState({
                loading: false,
                data: null,
                error: 'API Error'
              });

            case 14:
            case "end":
              return _context.stop();
          }
        }
      }, _callee, null, [[3, 11]]);
    }));

    _this.onGroupDetail = function (id) {
      return function () {
        _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_18__["PanelType"].GROUP_DETAILS, _this.props.id, id); // this.refetch() // Needed or data props won't update

      };
    };

    _this.onNominativeDetail = function (id) {
      return function () {
        _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_18__["PanelType"].CONTACT_DETAILS, _this.props.id, id); // this.refetch() // Needed or data props won't update

      };
    };

    _this.deleteSubgroup = function (id) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee2() {
          var data, response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee2$(_context2) {
            while (1) {
              switch (_context2.prev = _context2.next) {
                case 0:
                  data = _this.state.data;
                  _context2.next = 3;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.removeSubgroup(data.id, id);

                case 3:
                  response = _context2.sent;

                  if (response.code < 300) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Sottogruppo eliminato con successo', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.SUCCESS
                    });
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].hide();

                    _this.refetch();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Errore eliminazione sottogruppo', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.ERROR
                    });
                  }

                case 5:
                case "end":
                  return _context2.stop();
              }
            }
          }, _callee2);
        }))
      );
    };

    _this.onDeleteSubgroup = function (group, fatherGroup) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee3() {
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee3$(_context3) {
            while (1) {
              switch (_context3.prev = _context3.next) {
                case 0:
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Conferma disaddociazione gruppo', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
                    __source: {
                      fileName: _jsxFileName,
                      lineNumber: 109
                    },
                    __self: this
                  }, "Confermi la disassociazione del gruppo:", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
                    __source: {
                      fileName: _jsxFileName,
                      lineNumber: 111
                    },
                    __self: this
                  }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
                    __source: {
                      fileName: _jsxFileName,
                      lineNumber: 112
                    },
                    __self: this
                  }, group.name), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
                    __source: {
                      fileName: _jsxFileName,
                      lineNumber: 113
                    },
                    __self: this
                  }), "da", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
                    __source: {
                      fileName: _jsxFileName,
                      lineNumber: 115
                    },
                    __self: this
                  }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
                    __source: {
                      fileName: _jsxFileName,
                      lineNumber: 116
                    },
                    __self: this
                  }, fatherGroup.name)), _this.deleteSubgroup(group.id));

                case 1:
                case "end":
                  return _context3.stop();
              }
            }
          }, _callee3, this);
        }))
      );
    };

    _this.modifyGroup = function (group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Modifica Gruppo', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_GroupForm__WEBPACK_IMPORTED_MODULE_14__["GroupForm"], {
          refetch: _this.refetch,
          group: group,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 122
          },
          __self: this
        }));
      };
    };

    _this.exportGroup = function (group) {
      return function () {
        window.open("/o/rubrica/gruppo/?gruppo=" + group.id, "_blank");
      };
    };

    _this.unsetNominative = function (group, nominative) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee4() {
          var response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee4$(_context4) {
            while (1) {
              switch (_context4.prev = _context4.next) {
                case 0:
                  _context4.next = 2;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.unsetNominativeRole(group.id, nominative.id);

                case 2:
                  response = _context4.sent;

                  if (response.code < 300) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Nominativo disassociato con successo', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.SUCCESS
                    });

                    _this.refetch();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Errore disassociazione nominativo', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.ERROR
                    });
                  }

                case 4:
                case "end":
                  return _context4.stop();
              }
            }
          }, _callee4);
        }))
      );
    };

    _this.onUnsetNominative = function (nominative, group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Disassocia Nominativo', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 141
          },
          __self: this
        }, "Procedere con la dissociazione del nominativo ", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 142
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 143
          },
          __self: this
        }, nominative.firstName, " ", nominative.lastName), " ", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 143
          },
          __self: this
        }), "dal gruppo: ", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 144
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 145
          },
          __self: this
        }, group.name, " ?")), _this.unsetNominative(group, nominative));
      };
    };

    _this.onSetNominative = function (group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Associa Nominativi', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_AddNominativesForm__WEBPACK_IMPORTED_MODULE_22__["AddNominativesForm"], {
          refetch: _this.refetch,
          roles: _this.context.roles,
          group: group,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 153
          },
          __self: this
        }));
      };
    };

    _this.onCreateNominative = function (group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].showTall('Crea Nominativo in Gruppo', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_ContactDetailPanel_CreateGreaterNominativeForm__WEBPACK_IMPORTED_MODULE_16__["CreateGreaterNominativeForm"], {
          refetch: _this.refetch,
          roles: _this.context.roles,
          group: group,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 159
          },
          __self: this
        }));
      };
    };

    _this.onAddSubgroup = function (group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Associa Sottogruppi', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_GroupList__WEBPACK_IMPORTED_MODULE_21__["GroupList"], {
          refetch: _this.refetch,
          group: group,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 165
          },
          __self: this
        }));
      };
    };

    _this.onAddSupergroup = function (group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Aggiungi appartenenza', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_GroupList__WEBPACK_IMPORTED_MODULE_21__["GroupList"], {
          supergroup: true,
          refetch: _this.refetch,
          group: group,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 171
          },
          __self: this
        }));
      };
    };

    _this.onRemoveSubgroups = function (groups, parentId) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Disassocia Sottogruppi', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
          style: {
            textAlign: 'left'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 176
          },
          __self: this
        }, "Procedere con la disassociazione dei gruppi:", groups.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
            key: el.id,
            style: {
              margin: '.25rem 0',
              fontWeight: 'bold'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 179
            },
            __self: this
          }, "- ", el.name);
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
          onClick: _this.removeSubgroups(groups, parentId),
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.actionButton),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 181
          },
          __self: this
        }, "Disassocia")));
      };
    };

    _this.onRemoveSupergroups = function (groups, parentId) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Rimuovi appartenenza', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
          style: {
            textAlign: 'left'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 191
          },
          __self: this
        }, "Procedere con la rimozione delle appartenenze:", groups.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
            key: el.id,
            style: {
              margin: '.25rem 0',
              fontWeight: 'bold'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 194
            },
            __self: this
          }, "- ", el.name);
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
          onClick: _this.removeSupergroups(groups, parentId),
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.actionButton),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 196
          },
          __self: this
        }, "Rimuovi")));
      };
    };

    _this.onRemoveNominatives = function (nominatives, group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].show('Disassocia Nominativi', react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
          style: {
            textAlign: 'left'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 206
          },
          __self: this
        }, "Procedere con la disassociazione dei nominativi:", nominatives.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
            key: el.id,
            style: {
              margin: '.25rem 0',
              fontWeight: 'bold'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 209
            },
            __self: this
          }, "- ", el.firstName, " ", el.lastName);
        }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 211
          },
          __self: this
        }, "Dal gruppo: ", group.name, " ?"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
          onClick: _this.removeNominatives(group.id, nominatives),
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.actionButton),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 212
          },
          __self: this
        }, "Disassocia")));
      };
    };

    _this.removeNominatives = function (id, nominatives) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee5() {
          var data, response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee5$(_context5) {
            while (1) {
              switch (_context5.prev = _context5.next) {
                case 0:
                  data = nominatives.map(function (el) {
                    return {
                      nominativeId: el.id
                    };
                  });
                  _context5.prev = 1;
                  _context5.next = 4;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.unsetNominativesRole(id, data);

                case 4:
                  response = _context5.sent;

                  if (response.code < 300) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Nominativi disassociati', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.SUCCESS
                    });
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].hide();

                    _this.refetch();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Errore disassociazione nominativi', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.ERROR
                    });
                  }

                  _context5.next = 11;
                  break;

                case 8:
                  _context5.prev = 8;
                  _context5.t0 = _context5["catch"](1);
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Errore disassociazione nominativo', {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.ERROR
                  });

                case 11:
                case "end":
                  return _context5.stop();
              }
            }
          }, _callee5, null, [[1, 8]]);
        }))
      );
    };

    _this.removeSubgroups = function (groups, parentId) {
      return (
        /*#__PURE__*/
        function () {
          var _ref7 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
          /*#__PURE__*/
          C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee6(event) {
            var formattedRequest, response;
            return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee6$(_context6) {
              while (1) {
                switch (_context6.prev = _context6.next) {
                  case 0:
                    formattedRequest = groups.map(function (el) {
                      return {
                        subgroupId: el.id
                      };
                    });
                    _context6.next = 3;
                    return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.removeSubgroups(parentId, formattedRequest);

                  case 3:
                    response = _context6.sent;

                    if (response.code < 300) {
                      _this.setState({
                        selectedGroups: []
                      }, function () {
                        Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Gruppi disassociati', {
                          type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.SUCCESS
                        });
                        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].hide();

                        _this.refetch();
                      });
                    } else {
                      console.error(response);
                      Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Errore disassociazione', {
                        type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.ERROR
                      });
                    }

                  case 5:
                  case "end":
                    return _context6.stop();
                }
              }
            }, _callee6);
          }));

          return function (_x) {
            return _ref7.apply(this, arguments);
          };
        }()
      );
    };

    _this.removeSupergroups = function (groups, parentId) {
      return (
        /*#__PURE__*/
        function () {
          var _ref8 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
          /*#__PURE__*/
          C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee7(event) {
            var formattedRequest, response;
            return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee7$(_context7) {
              while (1) {
                switch (_context7.prev = _context7.next) {
                  case 0:
                    formattedRequest = groups.map(function (el) {
                      return {
                        subgroupId: el.id
                      };
                    });
                    _context7.next = 3;
                    return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.removeSupergroups(parentId, formattedRequest);

                  case 3:
                    response = _context7.sent;

                    if (response.code < 300) {
                      _this.setState({
                        selectedGroups: []
                      }, function () {
                        Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Appartenenze rimosse', {
                          type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.SUCCESS
                        });
                        _Modal_Modal__WEBPACK_IMPORTED_MODULE_19__["Modal"].hide();

                        _this.refetch();
                      });
                    } else {
                      console.error(response);
                      Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Errore disassociazione', {
                        type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.ERROR
                      });
                    }

                  case 5:
                  case "end":
                    return _context7.stop();
                }
              }
            }, _callee7);
          }));

          return function (_x2) {
            return _ref8.apply(this, arguments);
          };
        }()
      );
    };

    _this.handleGroupSelection = function (group) {
      return function (event) {
        var selectedGroups = [];

        if (_this.state.selectedGroups.find(function (el) {
          return el.id === group.id;
        }) !== undefined) {
          selectedGroups = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_1__["default"])(_this.state.selectedGroups.filter(function (el) {
            return el.id !== group.id;
          }));
        } else {
          selectedGroups = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_1__["default"])(_this.state.selectedGroups), [group]);
        }

        _this.setState({
          selectedGroups: selectedGroups
        });
      };
    };

    _this.handleSupergroupSelection = function (group) {
      return function (event) {
        var selectedSupergroups = [];

        if (_this.state.selectedSupergroups.find(function (el) {
          return el.id === group.id;
        }) !== undefined) {
          selectedSupergroups = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_1__["default"])(_this.state.selectedSupergroups.filter(function (el) {
            return el.id !== group.id;
          }));
        } else {
          selectedSupergroups = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_1__["default"])(_this.state.selectedSupergroups), [group]);
        }

        _this.setState({
          selectedSupergroups: selectedSupergroups
        });
      };
    };

    _this.handleNominativeSelection = function (nominative) {
      return function (event) {
        var selectedNominatives = [];

        if (_this.state.selectedNominatives.find(function (el) {
          return el.id === nominative.id;
        }) !== undefined) {
          selectedNominatives = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_1__["default"])(_this.state.selectedNominatives.filter(function (el) {
            return el.id !== nominative.id;
          }));
        } else {
          selectedNominatives = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_1__["default"])(_this.state.selectedNominatives), [nominative]);
        }

        _this.setState({
          selectedNominatives: selectedNominatives
        });
      };
    };

    _this.getRuoloIdFromName = function (nome, roles) {
      for (var k = 0; k < roles.length; k++) {
        if (roles[k].name == nome) return roles[k].id;
      }

      return "";
    };

    _this.getMenuRuolo = function (nominativo) {
      var ruolo = _this.getRuoloSingolo(nominativo);

      var specifica = _this.getSpecificaRuoloSingolo(nominativo);

      for (var k = 0; k < nominativo.groups.length; k++) {
        if (nominativo.groups[k].id == _this.state.data.id) {
          return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 312
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("select", {
            onChange: _this.handleRole(nominativo),
            defaultValue: ruolo,
            style: {
              marginLeft: 'auto'
            },
            __source: {
              fileName: _jsxFileName,
              lineNumber: 313
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("option", {
            value: "",
            __source: {
              fileName: _jsxFileName,
              lineNumber: 314
            },
            __self: this
          }, "---"), _this.context.roles && _this.context.roles.map(function (role) {
            return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("option", {
              key: role.name,
              value: role.name,
              __source: {
                fileName: _jsxFileName,
                lineNumber: 315
              },
              __self: this
            }, role.name);
          })), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("input", {
            style: {
              display: 'inline'
            },
            className: "mytext",
            value: specifica,
            placeholder: "Specifica ruolo",
            type: "text",
            onChange: _this.handleSpecifica(nominativo),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 317
            },
            __self: this
          }));
        }
      }
    };

    _this.handleRole = function (nominativo) {
      return function (event) {
        var k;
        var out;

        for (k = 0; k < nominativo.groups.length; k++) {
          if (nominativo.groups[k].id == _this.state.data.id) {
            nominativo.groups[k].role = event.target.value;

            var data2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__["default"])({}, _this.state.data);

            _this.setState({
              data: data2
            });

            _this.onSubmitChange(nominativo.id, nominativo.groups[k].role, nominativo.groups[k].specificaRuolo);

            return;
          }
        }
      };
    };

    _this.handleSpecifica = function (nominativo) {
      return function (event) {
        var k;
        var out;

        for (k = 0; k < nominativo.groups.length; k++) {
          if (nominativo.groups[k].id == _this.state.data.id) {
            nominativo.groups[k].specificaRuolo = event.target.value;

            _this.setState({
              data: _this.state.data
            });

            var data2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__["default"])({}, _this.state.data);

            _this.setState({
              data: data2
            });

            _this.onSubmitChange(nominativo.id, nominativo.groups[k].role, nominativo.groups[k].specificaRuolo);

            return;
          }
        }
      };
    };

    _this.onSubmitChange =
    /*#__PURE__*/
    function () {
      var _ref9 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee8(utente, ruolo, spec) {
        var param, result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee8$(_context8) {
          while (1) {
            switch (_context8.prev = _context8.next) {
              case 0:
                _context8.prev = 0;
                param = {
                  nominativeId: utente,
                  role: _this.getRuoloIdFromName(ruolo, _this.context.roles),
                  specificaRuolo: spec
                };
                _context8.next = 4;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.setNominativesRole(_this.state.data.id, [param]);

              case 4:
                result = _context8.sent;
                _context8.next = 11;
                break;

              case 7:
                _context8.prev = 7;
                _context8.t0 = _context8["catch"](0);
                console.error(_context8.t0);
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"])('Errore associzione', {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_15__["toast"].TYPE.ERROR
                });

              case 11:
              case "end":
                return _context8.stop();
            }
          }
        }, _callee8, null, [[0, 7]]);
      }));

      return function (_x3, _x4, _x5) {
        return _ref9.apply(this, arguments);
      };
    }();

    _this.getRuolo = function (nominativo) {
      var k;
      var out;

      for (k = 0; k < nominativo.groups.length; k++) {
        if (nominativo.groups[k].id == _this.state.data.id) out = '- ' + nominativo.groups[k].role;
        if (nominativo.groups[k].specificaRuolo) out += ' - ' + nominativo.groups[k].specificaRuolo;
        return out;
      }

      return '';
    };

    _this.getRuoloSingolo = function (nominativo) {
      var k;
      var out;

      for (k = 0; k < nominativo.groups.length; k++) {
        if (nominativo.groups[k].id == _this.state.data.id) return nominativo.groups[k].role;
      }

      return '';
    };

    _this.getSpecificaRuoloSingolo = function (nominativo) {
      var k;
      var out;

      for (k = 0; k < nominativo.groups.length; k++) {
        if (nominativo.groups[k].id == _this.state.data.id) return nominativo.groups[k].specificaRuolo;
      }

      return '';
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_5__["default"])(GroupDetailPanel, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.mark(function _callee9() {
        var panels, resId, _ref10, data;

        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_2___default.a.wrap(function _callee9$(_context9) {
          while (1) {
            switch (_context9.prev = _context9.next) {
              case 0:
                panels = this.context.panels;
                resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, this.props.id);

                if (!resId) {
                  _context9.next = 14;
                  break;
                }

                _context9.prev = 3;
                _context9.next = 6;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.getById(resId);

              case 6:
                _ref10 = _context9.sent;
                data = _ref10.data;
                this.setState({
                  loading: false,
                  data: data,
                  error: null,
                  resId: resId
                });
                _context9.next = 14;
                break;

              case 11:
                _context9.prev = 11;
                _context9.t0 = _context9["catch"](3);
                this.setState({
                  loading: false,
                  data: null,
                  error: 'API Error'
                });

              case 14:
              case "end":
                return _context9.stop();
            }
          }
        }, _callee9, this, [[3, 11]]);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "componentDidUpdate",
    value: function componentDidUpdate(prevProps, prevState) {
      var panels = this.context.panels;
      var resId = Object(_utils__WEBPACK_IMPORTED_MODULE_17__["getResId"])(panels, this.props.id);

      if (resId !== this.state.resId) {
        this.refetch();
      }
    }
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      var _this$state = this.state,
          data = _this$state.data,
          error = _this$state.error,
          loading = _this$state.loading;
      var d = new Date();
      d.setTime(data.lastEdit);
      console.log(d);
      var ultimaMod = d.toLocaleString('it-IT');
      return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_9___default.a.Fragment, null, loading && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(_Loader__WEBPACK_IMPORTED_MODULE_10__["Loader"], {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 410
        },
        __self: this
      }), !loading && !error && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.groupsWrapper,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 412
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.groupData,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 413
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("h1", {
        style: {
          marginTop: 0
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 414
        },
        __self: this
      }, data.name), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 415
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 416
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 417
        },
        __self: this
      }, data.nominativeCount), " Nominativi"), "\xA0 - \xA0", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 420
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 421
        },
        __self: this
      }, data.subgroupsCount), " Sottogruppi"), "\xA0 - \xA0 Appartiene a \xA0", react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 424
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 425
        },
        __self: this
      }, data.supergroupsCount), " gruppi"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 427
        },
        __self: this
      }, "Proprietario: ", data.owner && data.owner.name), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 428
        },
        __self: this
      }, "Ultima Modifica: ", ultimaMod, " - ", data.lastEditUser && "".concat(data.lastEditUser.firstName, " ").concat(data.lastEditUser.lastName)))), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginTop: '.5rem',
          marginRight: '.5rem',
          marginBottom: '.5rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.exportGroup(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 431
        },
        __self: this
      }, " Esporta "), data.id !== -1 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginTop: '.5rem',
          marginBottom: '.5rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.modifyGroup(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 436
        },
        __self: this
      }, " Modifica Gruppo "), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 441
        },
        __self: this
      }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("br", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 442
        },
        __self: this
      }), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.subgroupsList,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 443
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("h4", {
        style: {
          margin: 0
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 444
        },
        __self: this
      }, "Nominativi"), data.id !== -1 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_9___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginTop: '.5rem',
          marginRight: '.5rem',
          marginBottom: '.5rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.onCreateNominative(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 447
        },
        __self: this
      }, "Crea Nominativo"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          marginTop: '.5rem',
          marginBottom: '.5rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.onSetNominative(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 454
        },
        __self: this
      }, "Associa Nominativo"), this.state.selectedNominatives && this.state.selectedNominatives.length > 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          margin: '.5rem 0 .5rem 1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.onRemoveNominatives(this.state.selectedNominatives, data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 462
        },
        __self: this
      }, "Disassocia Nominativi")), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("ul", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.nominatives,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 469
        },
        __self: this
      }, data.nominatives && data.nominatives.length === 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 470
        },
        __self: this
      }, "Non ci sono nominativi"), data.nominatives && data.nominatives.map(function (nominative) {
        return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("li", {
          key: nominative.id,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 472
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          className: "mycheckbox",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 473
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("input", {
          type: "checkbox",
          className: "mycheckbox",
          defaultChecked: false,
          onChange: _this2.handleNominativeSelection(nominative),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 473
          },
          __self: this
        })), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 474
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 474
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: function onClick(e) {
            return _this2.toggleNominative(nominative.id);
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 474
          },
          __self: this
        }, nominative.firstName, " ", nominative.lastName)), " ", _this2.state.editedNominative == nominative.id ? _this2.getMenuRuolo(nominative) : _this2.getRuolo(nominative), " (", nominative.groups && nominative.groups.length, " Gruppi) (", nominative.contacts && nominative.contacts.length, " Contatti)"), data.id !== -1 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onNominativeDetail(nominative.id),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 475
          },
          __self: this
        }, " \uD83D\uDD0D "), data.id !== -1 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onUnsetNominative(nominative, data),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 476
          },
          __self: this
        }, " \u274C "));
      }))), data.id !== -1 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.subgroupsList,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 483
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 484
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("h4", {
        style: {
          margin: '1rem 0 0'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 485
        },
        __self: this
      }, "Appartiene ai gruppi"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          margin: '.5rem 0'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.onAddSupergroup(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 486
        },
        __self: this
      }, "Aggiungi appartenenza"), this.state.selectedSupergroups && this.state.selectedSupergroups.length > 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          margin: '.5rem 0 .5rem 1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.onRemoveSupergroups(this.state.selectedSupergroups, data.id),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 491
        },
        __self: this
      }, "Rimuovi appartenenza")), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("ul", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.subGroups,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 497
        },
        __self: this
      }, data.supergroups && data.supergroups.length === 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 498
        },
        __self: this
      }, "Non appartiene ad alcun gruppo"), data.supergroups && data.supergroups.map(function (group) {
        return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("li", {
          key: group.id,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 501
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          className: "mycheckbox",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 502
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("input", {
          type: "checkbox",
          className: "mycheckbox",
          defaultChecked: false,
          onChange: _this2.handleSupergroupSelection(group),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 502
          },
          __self: this
        })), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 503
          },
          __self: this
        }, group.name), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onGroupDetail(group.id),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 504
          },
          __self: this
        }, " \uD83D\uDD0D"));
      }))), data.id !== -1 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.subgroupsList,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 513
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 514
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("h4", {
        style: {
          margin: '1rem 0 0'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 515
        },
        __self: this
      }, "Sottogruppi"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          margin: '.5rem 0'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.onAddSubgroup(data),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 516
        },
        __self: this
      }, "Associa Sottogruppo"), this.state.selectedGroups && this.state.selectedGroups.length > 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("button", {
        style: {
          margin: '.5rem 0 .5rem 1rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_20___default.a.button,
        onClick: this.onRemoveSubgroups(this.state.selectedGroups, data.id),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 521
        },
        __self: this
      }, "Disassocia Sottogruppi")), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("ul", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.subGroups,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 527
        },
        __self: this
      }, data.subgroups && data.subgroups.length === 0 && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 528
        },
        __self: this
      }, "Non ci sono sottogruppi"), data.subgroups && data.subgroups.map(function (group) {
        return react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("li", {
          key: group.id,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 531
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          className: "mycheckbox",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 532
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("input", {
          type: "checkbox",
          className: "mycheckbox",
          defaultChecked: false,
          onChange: _this2.handleGroupSelection(group),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 532
          },
          __self: this
        })), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 533
          },
          __self: this
        }, group.name, " (", group.subgroupsCount, " Sottogruppi) (", group.nominativeCount, " Nominativi)"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onGroupDetail(group.id),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 534
          },
          __self: this
        }, " \uD83D\uDD0D"), react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("span", {
          style: {
            cursor: 'pointer'
          },
          onClick: _this2.onDeleteSubgroup(group, data),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 535
          },
          __self: this
        }, " \u274C"));
      })))), !loading && error && react__WEBPACK_IMPORTED_MODULE_9___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 546
        },
        __self: this
      }, error));
    }
  }]);

  return GroupDetailPanel;
}(react__WEBPACK_IMPORTED_MODULE_9__["PureComponent"]);
GroupDetailPanel.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_12__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/GroupDetailPanel/GroupForm.tsx":
/*!*************************************************************!*\
  !*** ./src/components/Panel/GroupDetailPanel/GroupForm.tsx ***!
  \*************************************************************/
/*! exports provided: GroupForm */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GroupForm", function() { return GroupForm; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_10___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_10__);
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./GroupDetailPanel.module.css */ "./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(_GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_14___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_14__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");







var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\GroupDetailPanel\\GroupForm.tsx";









var GroupForm =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__["default"])(GroupForm, _Component);

  function GroupForm() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__["default"])(this, GroupForm);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__["default"])(GroupForm)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_10__["object"]().shape({
        name: yup__WEBPACK_IMPORTED_MODULE_10__["string"]().required()
      });
    };

    _this.onSubmitGroup =
    /*#__PURE__*/
    function () {
      var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee(values) {
        var result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.update(_this.props.group.id, values);

              case 2:
                result = _context.sent;

                if (result.code === 204) {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Gruppo modificato", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.SUCCESS
                  });
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                  _this.props.refetch();
                } else {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"])("Modifica fallita, riprova", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_8__["toast"].TYPE.ERROR
                  });
                }

              case 4:
              case "end":
                return _context.stop();
            }
          }
        }, _callee);
      }));

      return function (_x) {
        return _ref.apply(this, arguments);
      };
    }();

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__["default"])(GroupForm, [{
    key: "render",
    value: function render() {
      return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_7___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_13___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 39
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Formik"], {
        initialValues: {
          name: this.props.group.name
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.onSubmitGroup,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 40
        },
        __self: this
      }, function (_ref2) {
        var isValid = _ref2.isValid;
        return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 48
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.field,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 49
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("label", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 50
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 51
          },
          __self: this
        }, "Nome"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_9__["Field"], {
          type: "text",
          name: "name",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 52
          },
          __self: this
        }))), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 55
          },
          __self: this
        }, "Modifica"));
      })));
    }
  }]);

  return GroupForm;
}(react__WEBPACK_IMPORTED_MODULE_7__["Component"]);
GroupForm.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_12__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/GroupDetailPanel/GroupList.tsx":
/*!*************************************************************!*\
  !*** ./src/components/Panel/GroupDetailPanel/GroupList.tsx ***!
  \*************************************************************/
/*! exports provided: GroupList */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GroupList", function() { return GroupList; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/toConsumableArray */ "./node_modules/@babel/runtime/helpers/esm/toConsumableArray.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var formik__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! formik */ "./node_modules/formik/dist/formik.esm.js");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! yup */ "./node_modules/yup/lib/index.js");
/* harmony import */ var yup__WEBPACK_IMPORTED_MODULE_12___default = /*#__PURE__*/__webpack_require__.n(yup__WEBPACK_IMPORTED_MODULE_12__);
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./GroupDetailPanel.module.css */ "./src/components/Panel/GroupDetailPanel/GroupDetailPanel.module.css");
/* harmony import */ var _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14___default = /*#__PURE__*/__webpack_require__.n(_GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14__);
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_15___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_15__);
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../utils */ "./src/utils.ts");








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\GroupDetailPanel\\GroupList.tsx";










var GroupList =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(GroupList, _Component);

  function GroupList() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, GroupList);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(GroupList)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.state = {
      data: [],
      selected: [],
      loading: true,
      error: undefined
    };
    _this.context = void 0;

    _this.generateValidationSchema = function () {
      return yup__WEBPACK_IMPORTED_MODULE_12__["object"]().shape({
        ids: yup__WEBPACK_IMPORTED_MODULE_12__["array"]().required()
      });
    };

    _this.onSubgroupAdd =
    /*#__PURE__*/
    function () {
      var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee(values, actions) {
        var result;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                _context.prev = 0;
                _context.next = 3;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.setSubgroup(_this.props.group.id, values.id);

              case 3:
                result = _context.sent;

                if (result.code === 201) {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Sottogruppo associato", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.SUCCESS
                  });
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_16__["Modal"].hide();

                  _this.props.refetch();
                }

                _context.next = 11;
                break;

              case 7:
                _context.prev = 7;
                _context.t0 = _context["catch"](0);
                console.error(_context.t0);
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])('Errore nell\' associazione', {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.ERROR
                });

              case 11:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, null, [[0, 7]]);
      }));

      return function (_x, _x2) {
        return _ref.apply(this, arguments);
      };
    }();

    _this.handleSelection = function (group, setFieldValue) {
      return function (event) {
        var selected = [];

        if (_this.state.selected.find(function (el) {
          return el.id === group.id;
        }) !== undefined) {
          selected = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(_this.state.selected.filter(function (el) {
            return el.id !== group.id;
          }));
        } else {
          selected = [].concat(Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_toConsumableArray__WEBPACK_IMPORTED_MODULE_0__["default"])(_this.state.selected), [{
            subgroupId: group.id
          }]);
        }

        setFieldValue('ids', selected);

        _this.setState({
          selected: selected
        });
      };
    };

    _this.handleSubmit =
    /*#__PURE__*/
    function () {
      var _ref2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee2(values, actions) {
        var response;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee2$(_context2) {
          while (1) {
            switch (_context2.prev = _context2.next) {
              case 0:
                _context2.prev = 0;

                if (!_this.props.supergroup) {
                  _context2.next = 7;
                  break;
                }

                _context2.next = 4;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.setSupergroupMulti(_this.props.group.id, values.ids);

              case 4:
                _context2.t0 = _context2.sent;
                _context2.next = 10;
                break;

              case 7:
                _context2.next = 9;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.setSubgroupMulti(_this.props.group.id, values.ids);

              case 9:
                _context2.t0 = _context2.sent;

              case 10:
                response = _context2.t0;

                if (response.code >= 200 && response.code < 300) {
                  Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])("Richiesta eseguita", {
                    type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.SUCCESS
                  });
                  _Modal_Modal__WEBPACK_IMPORTED_MODULE_16__["Modal"].hide();

                  _this.props.refetch();
                }

                _context2.next = 18;
                break;

              case 14:
                _context2.prev = 14;
                _context2.t1 = _context2["catch"](0);
                console.error(_context2.t1);
                Object(react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"])('Errore nell\' associazione', {
                  type: react_toastify__WEBPACK_IMPORTED_MODULE_9__["toast"].TYPE.ERROR
                });

              case 18:
              case "end":
                return _context2.stop();
            }
          }
        }, _callee2, null, [[0, 14]]);
      }));

      return function (_x3, _x4) {
        return _ref2.apply(this, arguments);
      };
    }();

    _this.filterData =
    /*#__PURE__*/
    function () {
      var _ref3 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee3(e) {
        var data;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee3$(_context3) {
          while (1) {
            switch (_context3.prev = _context3.next) {
              case 0:
                _context3.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all(e.target.value, 100000, 0);

              case 2:
                data = _context3.sent;

                if (data.code === 200) {
                  _this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  _this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

                if (!(e.target.value === '')) {
                  _context3.next = 9;
                  break;
                }

                _context3.next = 7;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all('', 100000, 0);

              case 7:
                data = _context3.sent;

                if (data.code === 200) {
                  _this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  _this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

              case 9:
              case "end":
                return _context3.stop();
            }
          }
        }, _callee3);
      }));

      return function (_x5) {
        return _ref3.apply(this, arguments);
      };
    }();

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(GroupList, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee4() {
        var data;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee4$(_context4) {
          while (1) {
            switch (_context4.prev = _context4.next) {
              case 0:
                _context4.next = 2;
                return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all('', 100000, 0);

              case 2:
                data = _context4.sent;

                if (data.code === 200) {
                  this.setState({
                    data: data.data,
                    loading: false
                  });
                } else {
                  this.setState({
                    error: 'Errore API',
                    loading: false
                  });
                }

              case 4:
              case "end":
                return _context4.stop();
            }
          }
        }, _callee4, this);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: _GroupDetailPanel_module_css__WEBPACK_IMPORTED_MODULE_14___default.a.detailForm,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 104
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Formik"], {
        initialValues: {
          ids: []
        },
        validationSchema: this.generateValidationSchema(),
        onSubmit: this.handleSubmit,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 105
        },
        __self: this
      }, function (_ref4) {
        var isValid = _ref4.isValid,
            setFieldValue = _ref4.setFieldValue,
            resetForm = _ref4.resetForm;
        return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(formik__WEBPACK_IMPORTED_MODULE_10__["Form"], {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 113
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
          type: "text",
          onChange: Object(_utils__WEBPACK_IMPORTED_MODULE_17__["debounced"])(_this2.filterData, 350),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 114
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("ul", {
          className: _common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.list,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 115
          },
          __self: this
        }, _this2.state.data && _this2.state.data.map(function (el) {
          return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, {
            key: el.id,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 116
            },
            __self: this
          }, el.id !== -1 && el.id !== _this2.props.group.id && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("li", {
            style: {},
            __source: {
              fileName: _jsxFileName,
              lineNumber: 118
            },
            __self: this
          }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
            type: "checkbox",
            defaultChecked: false,
            onChange: _this2.handleSelection(el, setFieldValue),
            __source: {
              fileName: _jsxFileName,
              lineNumber: 119
            },
            __self: this
          }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("span", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 120
            },
            __self: this
          }, el.name)));
        })), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          style: {
            marginTop: '1rem'
          },
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_15___default.a.actionButton),
          disabled: !isValid,
          type: "submit",
          __source: {
            fileName: _jsxFileName,
            lineNumber: 127
          },
          __self: this
        }, "Associa"));
      })));
    }
  }]);

  return GroupList;
}(react__WEBPACK_IMPORTED_MODULE_8__["Component"]);
GroupList.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_13__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/GroupDetailPanel/index.ts":
/*!********************************************************!*\
  !*** ./src/components/Panel/GroupDetailPanel/index.ts ***!
  \********************************************************/
/*! exports provided: GroupDetailPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _GroupDetailPanel__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./GroupDetailPanel */ "./src/components/Panel/GroupDetailPanel/GroupDetailPanel.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GroupDetailPanel", function() { return _GroupDetailPanel__WEBPACK_IMPORTED_MODULE_0__["GroupDetailPanel"]; });




/***/ }),

/***/ "./src/components/Panel/GroupPanel/GroupPanel.tsx":
/*!********************************************************!*\
  !*** ./src/components/Panel/GroupPanel/GroupPanel.tsx ***!
  \********************************************************/
/*! exports provided: GroupPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GroupPanel", function() { return GroupPanel; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/objectSpread */ "./node_modules/@babel/runtime/helpers/esm/objectSpread.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var ag_grid_react__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ag-grid-react */ "./node_modules/ag-grid-react/main.js");
/* harmony import */ var ag_grid_react__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(ag_grid_react__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var _Loader__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../Loader */ "./src/components/Loader/index.ts");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_13___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_13__);
/* harmony import */ var _types_d__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../types.d */ "./src/types.d.ts");
/* harmony import */ var _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var _GroupDetailPanel_CreateGroupForm__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../GroupDetailPanel/CreateGroupForm */ "./src/components/Panel/GroupDetailPanel/CreateGroupForm.tsx");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../common.module.css */ "./src/common.module.css");
/* harmony import */ var _common_module_css__WEBPACK_IMPORTED_MODULE_17___default = /*#__PURE__*/__webpack_require__.n(_common_module_css__WEBPACK_IMPORTED_MODULE_17__);
/* harmony import */ var _utils__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../../../utils */ "./src/utils.ts");
/* harmony import */ var _DragDrop_DraggableComponent__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../DragDrop/DraggableComponent */ "./src/components/DragDrop/DraggableComponent.tsx");








var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\GroupPanel\\GroupPanel.tsx";












var GroupPanel =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_7__["default"])(GroupPanel, _Component);

  function GroupPanel() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_3__["default"])(this, GroupPanel);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_5__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_6__["default"])(GroupPanel)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      selected: [],
      loading: false,
      filter: '',
      data: [],
      error: null,
      total: 0
      /*dataSource: IDatasource = {
      getRows: (params: IGetRowsParams) => {
         // Use startRow and endRow for sending pagination to Backend
        // params.startRow : Start Page
        // params.endRow : End Page
         const response = await client.groups.all(this.state.filter,params.endRow-params.startRow,params.startRow);
          params.successCallback(
            response.data, response.total
          );
      
      }
      }*/

    };
    _this.gridApi = null;

    _this.onGridReady = function (params) {
      _this.gridApi = params.api;

      _this.gridApi.sizeColumnsToFit();
    };

    _this.onResize = function () {
      if (_this.gridApi) {
        _this.gridApi.sizeColumnsToFit();
      }
    };

    _this.getNodeChildDetails = function (rowItem) {
      if (rowItem.subgroupsCount) {
        return {
          group: true,
          children: rowItem.subgroups,
          key: rowItem.id
        };
      } else {
        return {
          group: false
        };
      }
    };

    _this.refetch =
    /*#__PURE__*/
    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
    /*#__PURE__*/
    C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee() {
      var _ref2, data;

      return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee$(_context) {
        while (1) {
          switch (_context.prev = _context.next) {
            case 0:
              _context.prev = 0;
              _context.next = 3;
              return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.all(_this.state.filter);

            case 3:
              _ref2 = _context.sent;
              data = _ref2.data;

              _this.setState({
                loading: false,
                data: data,
                error: null
              });

              _this.context.setCache(_this.props.id, 'groupData', data);

              _context.next = 14;
              break;

            case 9:
              _context.prev = 9;
              _context.t0 = _context["catch"](0);
              console.error(_context.t0);

              _this.setState({
                loading: false,
                data: [],
                error: 'API Error'
              });

              _this.context.setCache(_this.props.id, 'groupData', null);

            case 14:
            case "end":
              return _context.stop();
          }
        }
      }, _callee, null, [[0, 9]]);
    }));

    _this.handleGroupDeletion = function (id) {
      return (
        /*#__PURE__*/
        Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
        /*#__PURE__*/
        C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee2() {
          var response;
          return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee2$(_context2) {
            while (1) {
              switch (_context2.prev = _context2.next) {
                case 0:
                  _context2.next = 2;
                  return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.delete(id);

                case 2:
                  response = _context2.sent;

                  if (response.code === 204) {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"])('Gruppo eliminato', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"].TYPE.SUCCESS
                    });
                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                    _this.refetch();
                  } else {
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"])('Eliminazione fallita, riprova', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"].TYPE.ERROR
                    });
                  }

                case 4:
                case "end":
                  return _context2.stop();
              }
            }
          }, _callee2);
        }))
      );
    };

    _this.onRemoval = function (group) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Elimina Gruppo', react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 124
          },
          __self: this
        }, "Procedere con l'eliminazione del Gruppo:", react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 126
          },
          __self: this
        }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("b", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 127
          },
          __self: this
        }, group.name), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_17___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_17___default.a.actionButton),
          onClick: _this.handleGroupDeletion(group.id),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 128
          },
          __self: this
        }, "ELIMINA")));
      };
    };

    _this.handleGroupDetail = function (id) {
      return function () {
        _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_14__["PanelType"].GROUP_DETAILS, _this.props.id, id, _this.state);
      };
    };

    _this.handleNewGroup = function () {
      _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Crea Gruppo', react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_GroupDetailPanel_CreateGroupForm__WEBPACK_IMPORTED_MODULE_16__["CreateGroupForm"], {
        refetch: _this.refetch,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 144
        },
        __self: this
      }));
    };

    _this.onSelectionChanged = function () {
      if (_this.gridApi) {
        var selected = _this.gridApi.getSelectedRows();

        _this.setState(function (p) {
          return Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__["default"])({}, p, {
            selected: selected
          });
        });
      }
    };

    _this.handleGroupsRemoval = function (groups) {
      return (
        /*#__PURE__*/
        function () {
          var _ref4 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
          /*#__PURE__*/
          C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee3(event) {
            var ids, response;
            return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee3$(_context3) {
              while (1) {
                switch (_context3.prev = _context3.next) {
                  case 0:
                    ids = groups.map(function (_ref5) {
                      var id = _ref5.id;
                      return {
                        id: id
                      };
                    });
                    _context3.next = 3;
                    return _resources__WEBPACK_IMPORTED_MODULE_11__["client"].groups.deleteMulti(ids);

                  case 3:
                    response = _context3.sent;

                    if (response.code === 204) {
                      Object(react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"])('Gruppi eliminati', {
                        type: react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"].TYPE.SUCCESS
                      });

                      _this.setState({
                        selected: []
                      }, function () {
                        return _this.refetch();
                      });
                    } else {
                      Object(react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"])('Eliminazione fallita, riprova', {
                        type: react_toastify__WEBPACK_IMPORTED_MODULE_13__["toast"].TYPE.ERROR
                      });
                    }

                    _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].hide();

                  case 6:
                  case "end":
                    return _context3.stop();
                }
              }
            }, _callee3);
          }));

          return function (_x) {
            return _ref4.apply(this, arguments);
          };
        }()
      );
    };

    _this.handleMultiRemoval = function (groups) {
      return function () {
        _Modal_Modal__WEBPACK_IMPORTED_MODULE_15__["Modal"].show('Elimina Gruppi', react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
          style: {
            textAlign: 'left'
          },
          __source: {
            fileName: _jsxFileName,
            lineNumber: 174
          },
          __self: this
        }, "Eliminare i gruppi: ", react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("br", {
          __source: {
            fileName: _jsxFileName,
            lineNumber: 175
          },
          __self: this
        }), groups.map(function (group) {
          return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("b", {
            key: group.id,
            __source: {
              fileName: _jsxFileName,
              lineNumber: 177
            },
            __self: this
          }, " - ", group.name, " ", react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("br", {
            __source: {
              fileName: _jsxFileName,
              lineNumber: 177
            },
            __self: this
          }));
        }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
          className: "".concat(_common_module_css__WEBPACK_IMPORTED_MODULE_17___default.a.button, " ").concat(_common_module_css__WEBPACK_IMPORTED_MODULE_17___default.a.actionButton),
          onClick: _this.handleGroupsRemoval(groups),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 179
          },
          __self: this
        }, "ELIMINA")));
      };
    };

    _this.filterData =
    /*#__PURE__*/
    function () {
      var _ref6 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee4(e) {
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee4$(_context4) {
          while (1) {
            switch (_context4.prev = _context4.next) {
              case 0:
                _this.context.setCache(_this.props.id, 'groupFilter', e.target.value);

                _this.setState({
                  filter: e.target.value
                });

                _this.refetch();

              case 3:
              case "end":
                return _context4.stop();
            }
          }
        }, _callee4);
      }));

      return function (_x2) {
        return _ref6.apply(this, arguments);
      };
    }();

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_4__["default"])(GroupPanel, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_2__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.mark(function _callee5() {
        var cacheData;
        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_1___default.a.wrap(function _callee5$(_context5) {
          while (1) {
            switch (_context5.prev = _context5.next) {
              case 0:
                window.addEventListener('resize', this.onResize, {
                  passive: true
                });
                cacheData = this.context.getCache(this.props.id, 'groupData');

                if (!cacheData) {
                  try {
                    this.setState({
                      loading: true
                    });
                    this.refetch();
                  } catch (err) {
                    console.error(err);
                    this.setState({
                      loading: false,
                      data: [],
                      error: 'API Error',
                      total: 0
                    });
                  }
                } else {
                  this.setState({
                    data: cacheData
                  });
                }

              case 3:
              case "end":
                return _context5.stop();
            }
          }
        }, _callee5, this);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "componentWillUnmount",
    value: function componentWillUnmount() {
      window.removeEventListener('resize', this.onResize);
    }
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      var _this$state = this.state,
          loading = _this$state.loading,
          error = _this$state.error,
          selected = _this$state.selected;
      console.log(this.context.loggedUser);
      var filt = this.context.getCache(this.props.id, 'groupFilter');
      return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, loading && !this.context.loggedUser && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_Loader__WEBPACK_IMPORTED_MODULE_10__["Loader"], {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 204
        },
        __self: this
      }), !loading && !error && this.context.loggedUser && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        style: {
          alignItems: 'center'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 207
        },
        __self: this
      }, this.context.loggedUser.write && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_8___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
        style: {
          marginLeft: '.5rem',
          marginBottom: '.5rem'
        },
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_17___default.a.button,
        onClick: this.handleNewGroup,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 210
        },
        __self: this
      }, "Crea Gruppo"), selected && selected.length > 1 && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("button", {
        className: _common_module_css__WEBPACK_IMPORTED_MODULE_17___default.a.button,
        style: {
          marginLeft: '1rem',
          marginBottom: '.5rem'
        },
        onClick: this.handleMultiRemoval(selected),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 215
        },
        __self: this
      }, "Elimina Gruppi"))), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("label", {
        htmlFor: "filtro",
        __source: {
          fileName: _jsxFileName,
          lineNumber: 220
        },
        __self: this
      }, "Filtra:"), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("input", {
        defaultValue: filt ? filt : "",
        name: "filtro-gruppo",
        id: "filtro",
        type: "text",
        onChange: Object(_utils__WEBPACK_IMPORTED_MODULE_18__["debounced"])(this.filterData, 350),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 221
        },
        __self: this
      }), react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        className: "ag-theme-material",
        style: {
          flex: 1
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 222
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(ag_grid_react__WEBPACK_IMPORTED_MODULE_9__["AgGridReact"], {
        columnDefs: [{
          checkboxSelection: this.context.loggedUser.write,
          headerName: "Nome Gruppo",
          field: "name",
          cellRenderer: "agGroupCellRenderer",
          cellRendererParams: {
            suppressCount: true
          },
          cellStyle: {
            'textOverflow': 'clip'
          },
          groupId: "id",
          valueFormatter: function valueFormatter(_ref7) {
            var data = _ref7.data,
                value = _ref7.value,
                node = _ref7.node;

            if (data.id !== -1) {
              return "\uD83D\uDCC2 ".concat(data.name, " - (").concat(data.subgroupsCount, " Sottogruppi) - (").concat(data.nominativeCount, " Nominativi)");
            } else {
              node.setRowSelectable(false);
              return "\uD83C\uDF1F ".concat(data.name, " - (").concat(data.nominativeCount, " Nominativi)");
            }
          }
        }, {
          headerName: 'Azioni',
          width: 110,
          suppressSizeToFit: true,
          suppressAutoSize: true,
          cellRendererFramework: function cellRendererFramework(_ref8) {
            var data = _ref8.data;
            return react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement(_DragDrop_DraggableComponent__WEBPACK_IMPORTED_MODULE_19__["DraggableComponent"], {
              type: "GROUP",
              data: data.id,
              __source: {
                fileName: _jsxFileName,
                lineNumber: 248
              },
              __self: this
            }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
              style: {
                display: 'flex',
                justifyContent: 'space-between'
              },
              __source: {
                fileName: _jsxFileName,
                lineNumber: 249
              },
              __self: this
            }, react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
              style: {
                cursor: 'pointer'
              },
              onClick: _this2.handleGroupDetail(data.id),
              __source: {
                fileName: _jsxFileName,
                lineNumber: 250
              },
              __self: this
            }, " \uD83D\uDD0D"), data.id !== -1 && _this2.context.loggedUser.write && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
              style: {
                cursor: 'pointer'
              },
              onClick: _this2.onRemoval(data),
              __source: {
                fileName: _jsxFileName,
                lineNumber: 254
              },
              __self: this
            }, "\u274C")));
          }
        }],
        rowSelection: "multiple",
        rowData: this.state.data,
        pagination: true,
        paginationPageSize: 10,
        onSelectionChanged: this.onSelectionChanged,
        onFirstDataRendered: this.onGridReady,
        getNodeChildDetails: this.getNodeChildDetails,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 223
        },
        __self: this
      }))), !loading && error && react__WEBPACK_IMPORTED_MODULE_8___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 275
        },
        __self: this
      }, error));
    }
  }]);

  return GroupPanel;
}(react__WEBPACK_IMPORTED_MODULE_8__["Component"]);
GroupPanel.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_12__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/GroupPanel/index.ts":
/*!**************************************************!*\
  !*** ./src/components/Panel/GroupPanel/index.ts ***!
  \**************************************************/
/*! exports provided: GroupPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _GroupPanel__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./GroupPanel */ "./src/components/Panel/GroupPanel/GroupPanel.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GroupPanel", function() { return _GroupPanel__WEBPACK_IMPORTED_MODULE_0__["GroupPanel"]; });




/***/ }),

/***/ "./src/components/Panel/LogPanel/LogPanel.tsx":
/*!****************************************************!*\
  !*** ./src/components/Panel/LogPanel/LogPanel.tsx ***!
  \****************************************************/
/*! exports provided: LogPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LogPanel", function() { return LogPanel; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var ag_grid_react__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ag-grid-react */ "./node_modules/ag-grid-react/main.js");
/* harmony import */ var ag_grid_react__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(ag_grid_react__WEBPACK_IMPORTED_MODULE_8__);
/* harmony import */ var _Loader__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../Loader */ "./src/components/Loader/index.ts");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _Tooltip__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../Tooltip */ "./src/components/Tooltip/index.ts");







var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\LogPanel\\LogPanel.tsx";





var LogPanel =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__["default"])(LogPanel, _Component);

  function LogPanel() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__["default"])(this, LogPanel);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__["default"])(LogPanel)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.state = {
      loading: false,
      data: [],
      error: null
    };
    _this.gridApi = null;

    _this.onGridReady = function (params) {
      _this.gridApi = params.api;

      _this.gridApi.sizeColumnsToFit();
    };

    _this.onResize = function () {
      if (_this.gridApi) {
        _this.gridApi.sizeColumnsToFit();
      }
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__["default"])(LogPanel, [{
    key: "componentDidMount",
    value: function () {
      var _componentDidMount = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
      /*#__PURE__*/
      C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee() {
        var _ref, data;

        return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
          while (1) {
            switch (_context.prev = _context.next) {
              case 0:
                window.addEventListener('resize', this.onResize, {
                  passive: true
                });
                _context.prev = 1;
                this.setState({
                  loading: true
                });
                _context.next = 5;
                return _resources__WEBPACK_IMPORTED_MODULE_10__["client"].logs.all('', 1000, 0);

              case 5:
                _ref = _context.sent;
                data = _ref.data;
                this.setState({
                  loading: false,
                  data: data,
                  error: null
                });
                _context.next = 14;
                break;

              case 10:
                _context.prev = 10;
                _context.t0 = _context["catch"](1);
                console.error(_context.t0);
                this.setState({
                  loading: false,
                  data: [],
                  error: 'API Error'
                });

              case 14:
              case "end":
                return _context.stop();
            }
          }
        }, _callee, this, [[1, 10]]);
      }));

      function componentDidMount() {
        return _componentDidMount.apply(this, arguments);
      }

      return componentDidMount;
    }()
  }, {
    key: "componentWillUnmount",
    value: function componentWillUnmount() {
      window.removeEventListener('resize', this.onResize);
    }
  }, {
    key: "render",
    value: function render() {
      var _this$state = this.state,
          loading = _this$state.loading,
          error = _this$state.error;
      return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_7___default.a.Fragment, null, loading && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(_Loader__WEBPACK_IMPORTED_MODULE_9__["Loader"], {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 55
        },
        __self: this
      }), !loading && !error && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        className: "ag-theme-material",
        style: {
          height: '100%'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 57
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(ag_grid_react__WEBPACK_IMPORTED_MODULE_8__["AgGridReact"], {
        columnDefs: [{
          headerName: "Chi",
          field: "editUser",
          tooltipField: "editUser",
          sortable: true,
          filter: true,
          cellRenderer: function cellRenderer(_ref2) {
            var value = _ref2.value;
            return "".concat(value && value.firstName, " ").concat(value && value.lastName);
          }
        }, {
          headerName: "Quando",
          field: "editDate",
          sortable: true,
          cellRenderer: function cellRenderer(_ref3) {
            var value = _ref3.value;
            return new Date(value).toLocaleString('it-IT');
          }
        }, {
          headerName: "Cosa",
          tooltipComponent: "tooltip",
          tooltipField: "description",
          filter: true,
          sortable: true,
          cellRenderer: function cellRenderer(_ref4) {
            var data = _ref4.data;
            return "[".concat(data && data.table, "]: ").concat(data && data.description);
          }
        }, {
          headerName: "Azione",
          sortable: true,
          field: "operation"
        }],
        rowData: this.state.data,
        pagination: true,
        paginationPageSize: 10,
        onFirstDataRendered: this.onGridReady,
        frameworkComponents: {
          tooltip: _Tooltip__WEBPACK_IMPORTED_MODULE_11__["TableTooltip"]
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 58
        },
        __self: this
      })), !loading && error && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 76
        },
        __self: this
      }, error));
    }
  }]);

  return LogPanel;
}(react__WEBPACK_IMPORTED_MODULE_7__["Component"]);

/***/ }),

/***/ "./src/components/Panel/LogPanel/index.ts":
/*!************************************************!*\
  !*** ./src/components/Panel/LogPanel/index.ts ***!
  \************************************************/
/*! exports provided: LogPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _LogPanel__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./LogPanel */ "./src/components/Panel/LogPanel/LogPanel.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "LogPanel", function() { return _LogPanel__WEBPACK_IMPORTED_MODULE_0__["LogPanel"]; });




/***/ }),

/***/ "./src/components/Panel/Panel.module.css":
/*!***********************************************!*\
  !*** ./src/components/Panel/Panel.module.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Panel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/Panel.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Panel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/Panel.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../node_modules/postcss-loader/src??postcss!./Panel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/Panel.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Panel/Panel.tsx":
/*!****************************************!*\
  !*** ./src/components/Panel/Panel.tsx ***!
  \****************************************/
/*! exports provided: Panel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Panel", function() { return Panel; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_5__);
/* harmony import */ var _types_d__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../types.d */ "./src/types.d.ts");
/* harmony import */ var _Panel_module_css__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./Panel.module.css */ "./src/components/Panel/Panel.module.css");
/* harmony import */ var _Panel_module_css__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(_Panel_module_css__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _PanelSelector__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./PanelSelector */ "./src/components/Panel/PanelSelector/index.tsx");
/* harmony import */ var _ContactPanel__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./ContactPanel */ "./src/components/Panel/ContactPanel/index.ts");
/* harmony import */ var _GroupPanel__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./GroupPanel */ "./src/components/Panel/GroupPanel/index.ts");
/* harmony import */ var _LogPanel__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./LogPanel */ "./src/components/Panel/LogPanel/index.ts");
/* harmony import */ var _ContactDetailPanel__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./ContactDetailPanel */ "./src/components/Panel/ContactDetailPanel/index.ts");
/* harmony import */ var _GroupDetailPanel__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./GroupDetailPanel */ "./src/components/Panel/GroupDetailPanel/index.ts");
/* harmony import */ var _PermissionPanel__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./PermissionPanel */ "./src/components/Panel/PermissionPanel/index.ts");





var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\Panel.tsx";











var Panel =
/*#__PURE__*/
function (_PureComponent) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__["default"])(Panel, _PureComponent);

  function Panel() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__["default"])(this, Panel);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__["default"])(Panel)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.panelRef = react__WEBPACK_IMPORTED_MODULE_5___default.a.createRef();
    _this.state = {
      inFocus: true
    };

    _this.focus = function (e) {
      if (_this.props.id === _this.context.focusedIndex) {
        _this.setState({
          inFocus: true
        });
      } else {
        _this.setState({
          inFocus: false
        });
      }

      _this.context.focusId(_this.props.id);
    };

    _this.refCallback = function (c) {
      if (c && c.props && c.props.id) {
        window['rubrica_panel_' + c.props.id] = c;
        console.log('rubrica_panel_' + c.props.id);
        console.log(window['rubrica_panel_' + c.props.id].state);
      }
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__["default"])(Panel, [{
    key: "componentDidUpdate",
    value: function componentDidUpdate() {
      if (this.props.id !== this.context.focusedIndex) {
        this.setState({
          inFocus: false
        });
      } else {
        this.setState({
          inFocus: true
        });
      }
    }
  }, {
    key: "componentDidMount",
    value: function componentDidMount() {
      this.context.focusId(this.props.id);
      this.panelRef.current.addEventListener('click', this.focus);
    }
  }, {
    key: "componentWillUnmount",
    value: function componentWillUnmount() {
      this.panelRef.current.addEventListener('click', this.focus);
    }
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      var type = this.props.type;
      return react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        className: "".concat(_Panel_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.panel, " ").concat(this.state.inFocus ? _Panel_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.inFocus : ''),
        ref: this.panelRef,
        "data-id": this.props.id,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 64
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        className: _Panel_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.panelHeader,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 65
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(_PanelSelector__WEBPACK_IMPORTED_MODULE_9__["PanelSelector"], {
        id: this.props.id,
        selected: this.props.type,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 66
        },
        __self: this
      }), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        style: {
          display: 'flex'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 67
        },
        __self: this
      }, this.context.panels.find(function (el) {
        return el.id === _this2.props.id;
      }).history.length > 0 && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        tabIndex: 0,
        onClick: this.context.onGoBack(this.props.id),
        style: {
          cursor: 'pointer',
          marginRight: '1rem'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 69
        },
        __self: this
      }, " \uD83D\uDD19 "), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        tabIndex: 0,
        onClick: this.context.onSplit,
        style: {
          cursor: 'pointer',
          marginRight: '1rem'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 71
        },
        __self: this
      }, " \u2795 "), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        tabIndex: 0,
        onClick: this.context.onMerge,
        style: {
          cursor: 'pointer'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 72
        },
        __self: this
      }, " \u2796 "))), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        className: _Panel_module_css__WEBPACK_IMPORTED_MODULE_7___default.a.panelBody,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 75
        },
        __self: this
      }, type === _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].CONTACTS && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(_ContactPanel__WEBPACK_IMPORTED_MODULE_10__["ContactPanel"], {
        id: this.props.id,
        currentState: this.props.currentState,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 76
        },
        __self: this
      }), type === _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].CONTACT_DETAILS && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(_ContactDetailPanel__WEBPACK_IMPORTED_MODULE_13__["ContactDetailPanel"], {
        id: this.props.id,
        currentState: this.props.currentState,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 77
        },
        __self: this
      }), type === _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].GROUPS && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(_GroupPanel__WEBPACK_IMPORTED_MODULE_11__["GroupPanel"], {
        id: this.props.id,
        currentState: this.props.currentState,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 78
        },
        __self: this
      }), type === _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].GROUP_DETAILS && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(_GroupDetailPanel__WEBPACK_IMPORTED_MODULE_14__["GroupDetailPanel"], {
        id: this.props.id,
        currentState: this.props.currentState,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 79
        },
        __self: this
      }), type === _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].LOGS && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(_LogPanel__WEBPACK_IMPORTED_MODULE_12__["LogPanel"], {
        id: this.props.id,
        currentState: this.props.currentState,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 80
        },
        __self: this
      }), type === _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].PERMISSION && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(_PermissionPanel__WEBPACK_IMPORTED_MODULE_15__["PermissionPanel"], {
        id: this.props.id,
        currentState: this.props.currentState,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 81
        },
        __self: this
      })));
    }
  }]);

  return Panel;
}(react__WEBPACK_IMPORTED_MODULE_5__["PureComponent"]);
Panel.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_8__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/PanelSelector/PanelSelector.module.css":
/*!*********************************************************************!*\
  !*** ./src/components/Panel/PanelSelector/PanelSelector.module.css ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./PanelSelector.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PanelSelector/PanelSelector.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./PanelSelector.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PanelSelector/PanelSelector.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./PanelSelector.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PanelSelector/PanelSelector.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Panel/PanelSelector/PanelSelector.tsx":
/*!**************************************************************!*\
  !*** ./src/components/Panel/PanelSelector/PanelSelector.tsx ***!
  \**************************************************************/
/*! exports provided: PanelSelector */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PanelSelector", function() { return PanelSelector; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_5__);
/* harmony import */ var _types_d__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../types.d */ "./src/types.d.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./PanelSelector.module.css */ "./src/components/Panel/PanelSelector/PanelSelector.module.css");
/* harmony import */ var _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default = /*#__PURE__*/__webpack_require__.n(_PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8__);





var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\PanelSelector\\PanelSelector.tsx";




var PanelSelector =
/*#__PURE__*/
function (_PureComponent) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__["default"])(PanelSelector, _PureComponent);

  function PanelSelector() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__["default"])(this, PanelSelector);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__["default"])(PanelSelector)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      open: false
    };

    _this.handleOpening = function () {
      return _this.setState(function (prevState) {
        return {
          open: !prevState.open
        };
      });
    };

    _this.selectContact = function () {
      return _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].CONTACTS, _this.props.id);
    };

    _this.selectGroups = function () {
      return _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].GROUPS, _this.props.id);
    };

    _this.selectLogs = function () {
      return _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].LOGS, _this.props.id);
    };

    _this.selectPermission = function () {
      return _this.context.onSelect(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].PERMISSION, _this.props.id);
    };

    _this.getNameFromPanelType = function (panelType) {
      switch (panelType) {
        case _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].LOGS:
          return '🗂 LOGS';

        case _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].CONTACTS:
          return '📑 NOMINATIVI';

        case _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].CONTACT_DETAILS:
          return '📑 DET NOMINATIVO';

        case _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].GROUPS:
          return '🗃 GRUPPI';

        case _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].GROUP_DETAILS:
          return '🗃 DET GRUPPO';

        case _types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].PERMISSION:
          return '⚙️ PERMESSI';
      }
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__["default"])(PanelSelector, [{
    key: "render",
    value: function render() {
      var selected = this.props.selected;
      var open = this.state.open;
      return react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        className: "".concat(_PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.panelSelector),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 50
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("ul", {
        onClick: this.handleOpening,
        className: "".concat(_PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.selectorOptions, " ").concat(open ? _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.opened : _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.closed, " ").concat(this.context.loggedUser && this.context.loggedUser.permission ? _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.admin : ''),
        __source: {
          fileName: _jsxFileName,
          lineNumber: 51
        },
        __self: this
      }, open && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_5___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("li", {
        className: _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.selectorItem,
        onClick: this.selectContact,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 54
        },
        __self: this
      }, this.getNameFromPanelType(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].CONTACTS)), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("li", {
        className: _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.selectorItem,
        onClick: this.selectGroups,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 55
        },
        __self: this
      }, this.getNameFromPanelType(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].GROUPS)), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("li", {
        className: _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.selectorItem,
        onClick: this.selectLogs,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 56
        },
        __self: this
      }, this.getNameFromPanelType(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].LOGS)), this.context.loggedUser.permission && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("li", {
        className: _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.selectorItem,
        onClick: this.selectPermission,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 58
        },
        __self: this
      }, this.getNameFromPanelType(_types_d__WEBPACK_IMPORTED_MODULE_6__["PanelType"].PERMISSION))), !open && react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("li", {
        className: _PanelSelector_module_css__WEBPACK_IMPORTED_MODULE_8___default.a.selectorItem,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 63
        },
        __self: this
      }, this.getNameFromPanelType(selected))));
    }
  }]);

  return PanelSelector;
}(react__WEBPACK_IMPORTED_MODULE_5__["PureComponent"]);
PanelSelector.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_7__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/PanelSelector/index.tsx":
/*!******************************************************!*\
  !*** ./src/components/Panel/PanelSelector/index.tsx ***!
  \******************************************************/
/*! exports provided: PanelSelector */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _PanelSelector__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./PanelSelector */ "./src/components/Panel/PanelSelector/PanelSelector.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "PanelSelector", function() { return _PanelSelector__WEBPACK_IMPORTED_MODULE_0__["PanelSelector"]; });




/***/ }),

/***/ "./src/components/Panel/PermissionPanel/PermissionPanel.module.css":
/*!*************************************************************************!*\
  !*** ./src/components/Panel/PermissionPanel/PermissionPanel.module.css ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./PermissionPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PermissionPanel/PermissionPanel.module.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../../../../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./PermissionPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PermissionPanel/PermissionPanel.module.css", function() {
		var newContent = __webpack_require__(/*! !../../../../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-4-1!../../../../node_modules/postcss-loader/src??postcss!./PermissionPanel.module.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/components/Panel/PermissionPanel/PermissionPanel.module.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/components/Panel/PermissionPanel/PermissionPanel.tsx":
/*!******************************************************************!*\
  !*** ./src/components/Panel/PermissionPanel/PermissionPanel.tsx ***!
  \******************************************************************/
/*! exports provided: PermissionPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PermissionPanel", function() { return PermissionPanel; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var _Loader__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../Loader */ "./src/components/Loader/index.ts");
/* harmony import */ var _resources__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../resources */ "./src/resources.ts");
/* harmony import */ var _context_panelContext__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../context/panelContext */ "./src/context/panelContext.ts");
/* harmony import */ var _PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./PermissionPanel.module.css */ "./src/components/Panel/PermissionPanel/PermissionPanel.module.css");
/* harmony import */ var _PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11___default = /*#__PURE__*/__webpack_require__.n(_PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11__);
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! react-toastify */ "./node_modules/react-toastify/lib/index.js");
/* harmony import */ var react_toastify__WEBPACK_IMPORTED_MODULE_12___default = /*#__PURE__*/__webpack_require__.n(react_toastify__WEBPACK_IMPORTED_MODULE_12__);







var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Panel\\PermissionPanel\\PermissionPanel.tsx";






var PermissionPanel =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_6__["default"])(PermissionPanel, _Component);

  function PermissionPanel() {
    var _getPrototypeOf2;

    var _this;

    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_2__["default"])(this, PermissionPanel);

    for (var _len = arguments.length, args = new Array(_len), _key = 0; _key < _len; _key++) {
      args[_key] = arguments[_key];
    }

    _this = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_4__["default"])(this, (_getPrototypeOf2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_5__["default"])(PermissionPanel)).call.apply(_getPrototypeOf2, [this].concat(args)));
    _this.context = void 0;
    _this.state = {
      loading: false,
      data: new Array(),
      error: null
    };
    _this.fetchData =
    /*#__PURE__*/
    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
    /*#__PURE__*/
    C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee() {
      var _ref2, data;

      return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
        while (1) {
          switch (_context.prev = _context.next) {
            case 0:
              _context.prev = 0;

              _this.setState({
                loading: true
              });

              _context.next = 4;
              return _resources__WEBPACK_IMPORTED_MODULE_9__["client"].rolesPermission.all();

            case 4:
              _ref2 = _context.sent;
              data = _ref2.data;
              console.log(data);

              _this.setState({
                loading: false,
                data: data,
                error: null
              });

              _context.next = 14;
              break;

            case 10:
              _context.prev = 10;
              _context.t0 = _context["catch"](0);
              console.error(_context.t0);

              _this.setState({
                loading: false,
                data: [],
                error: 'API Error'
              });

            case 14:
            case "end":
              return _context.stop();
          }
        }
      }, _callee, null, [[0, 10]]);
    }));

    _this.handleChange = function (role) {
      return (
        /*#__PURE__*/
        function () {
          var _ref3 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
          /*#__PURE__*/
          C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee2(event) {
            var r, w, p;
            return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee2$(_context2) {
              while (1) {
                switch (_context2.prev = _context2.next) {
                  case 0:
                    event.persist();
                    _context2.prev = 1;
                    console.log(event.target.value, 'prev', role.read, 'next', !role.read);
                    _context2.t0 = event.target.value;
                    _context2.next = _context2.t0 === "R" ? 6 : _context2.t0 === "W" ? 10 : _context2.t0 === "P" ? 14 : 18;
                    break;

                  case 6:
                    _context2.next = 8;
                    return _resources__WEBPACK_IMPORTED_MODULE_9__["client"].rolesPermission.update(role.roleId, role.permission, !role.read, role.write);

                  case 8:
                    r = _context2.sent;
                    return _context2.abrupt("break", 18);

                  case 10:
                    _context2.next = 12;
                    return _resources__WEBPACK_IMPORTED_MODULE_9__["client"].rolesPermission.update(role.roleId, role.permission, role.read, !role.write);

                  case 12:
                    w = _context2.sent;
                    return _context2.abrupt("break", 18);

                  case 14:
                    _context2.next = 16;
                    return _resources__WEBPACK_IMPORTED_MODULE_9__["client"].rolesPermission.update(role.roleId, !role.permission, role.read, role.write);

                  case 16:
                    p = _context2.sent;
                    return _context2.abrupt("break", 18);

                  case 18:
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_12__["toast"])('Ruolo aggiornato con successo', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_12__["ToastType"].SUCCESS
                    });

                    _this.fetchData();

                    _context2.next = 25;
                    break;

                  case 22:
                    _context2.prev = 22;
                    _context2.t1 = _context2["catch"](1);
                    Object(react_toastify__WEBPACK_IMPORTED_MODULE_12__["toast"])('Errore nell\' aggiornamento', {
                      type: react_toastify__WEBPACK_IMPORTED_MODULE_12__["ToastType"].ERROR
                    });

                  case 25:
                  case "end":
                    return _context2.stop();
                }
              }
            }, _callee2, null, [[1, 22]]);
          }));

          return function (_x) {
            return _ref3.apply(this, arguments);
          };
        }()
      );
    };

    return _this;
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_3__["default"])(PermissionPanel, [{
    key: "componentDidMount",
    value: function componentDidMount() {
      this.fetchData();
    }
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      var _this$state = this.state,
          loading = _this$state.loading,
          error = _this$state.error,
          data = _this$state.data;
      return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_7___default.a.Fragment, null, loading && data.length === 0 && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(_Loader__WEBPACK_IMPORTED_MODULE_8__["Loader"], {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 69
        },
        __self: this
      }), !loading && !error && data.length > 0 && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        className: _PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11___default.a.permissionGrid,
        __source: {
          fileName: _jsxFileName,
          lineNumber: 71
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
        style: {
          textAlign: 'center',
          fontWeight: 'bold'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 72
        },
        __self: this
      }, "RUOLO"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
        style: {
          textAlign: 'center',
          fontWeight: 'bold'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 73
        },
        __self: this
      }, "LETTURA"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
        style: {
          textAlign: 'center',
          fontWeight: 'bold'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 74
        },
        __self: this
      }, "SCRITTURA"), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
        style: {
          textAlign: 'center',
          fontWeight: 'bold'
        },
        __source: {
          fileName: _jsxFileName,
          lineNumber: 75
        },
        __self: this
      }, "PERMESSI"), this.state.data.map(function (el) {
        return react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_7___default.a.Fragment, {
          key: el.roleId,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 77
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          className: "".concat(_PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11___default.a.perm, " ").concat(_PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11___default.a.left),
          __source: {
            fileName: _jsxFileName,
            lineNumber: 78
          },
          __self: this
        }, el.roleName), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          className: _PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11___default.a.perm,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 79
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("input", {
          type: "checkbox",
          value: 'R',
          onChange: _this2.handleChange(el),
          defaultChecked: el.read,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 80
          },
          __self: this
        })), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          className: _PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11___default.a.perm,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 82
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("input", {
          type: "checkbox",
          value: 'W',
          onChange: _this2.handleChange(el),
          defaultChecked: el.write,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 83
          },
          __self: this
        })), react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("span", {
          className: _PermissionPanel_module_css__WEBPACK_IMPORTED_MODULE_11___default.a.perm,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 85
          },
          __self: this
        }, react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("input", {
          type: "checkbox",
          value: 'P',
          onChange: _this2.handleChange(el),
          defaultChecked: el.permission,
          __source: {
            fileName: _jsxFileName,
            lineNumber: 86
          },
          __self: this
        })));
      })), !loading && error && react__WEBPACK_IMPORTED_MODULE_7___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 92
        },
        __self: this
      }, error));
    }
  }]);

  return PermissionPanel;
}(react__WEBPACK_IMPORTED_MODULE_7__["Component"]);
PermissionPanel.contextType = _context_panelContext__WEBPACK_IMPORTED_MODULE_10__["PanelContext"];

/***/ }),

/***/ "./src/components/Panel/PermissionPanel/index.ts":
/*!*******************************************************!*\
  !*** ./src/components/Panel/PermissionPanel/index.ts ***!
  \*******************************************************/
/*! exports provided: PermissionPanel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _PermissionPanel__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./PermissionPanel */ "./src/components/Panel/PermissionPanel/PermissionPanel.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "PermissionPanel", function() { return _PermissionPanel__WEBPACK_IMPORTED_MODULE_0__["PermissionPanel"]; });




/***/ }),

/***/ "./src/components/Panel/index.tsx":
/*!****************************************!*\
  !*** ./src/components/Panel/index.tsx ***!
  \****************************************/
/*! exports provided: Panel */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Panel__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Panel */ "./src/components/Panel/Panel.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "Panel", function() { return _Panel__WEBPACK_IMPORTED_MODULE_0__["Panel"]; });




/***/ }),

/***/ "./src/components/Tooltip/Tooltip.tsx":
/*!********************************************!*\
  !*** ./src/components/Tooltip/Tooltip.tsx ***!
  \********************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "default", function() { return TableTooltip; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/classCallCheck */ "./node_modules/@babel/runtime/helpers/esm/classCallCheck.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/createClass */ "./node_modules/@babel/runtime/helpers/esm/createClass.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn */ "./node_modules/@babel/runtime/helpers/esm/possibleConstructorReturn.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/getPrototypeOf */ "./node_modules/@babel/runtime/helpers/esm/getPrototypeOf.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/inherits */ "./node_modules/@babel/runtime/helpers/esm/inherits.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_5__);





var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\components\\Tooltip\\Tooltip.tsx";


var TableTooltip =
/*#__PURE__*/
function (_Component) {
  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_inherits__WEBPACK_IMPORTED_MODULE_4__["default"])(TableTooltip, _Component);

  function TableTooltip() {
    Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_classCallCheck__WEBPACK_IMPORTED_MODULE_0__["default"])(this, TableTooltip);

    return Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_possibleConstructorReturn__WEBPACK_IMPORTED_MODULE_2__["default"])(this, Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_getPrototypeOf__WEBPACK_IMPORTED_MODULE_3__["default"])(TableTooltip).apply(this, arguments));
  }

  Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_createClass__WEBPACK_IMPORTED_MODULE_1__["default"])(TableTooltip, [{
    key: "componentDidMount",
    value: function componentDidMount() {
      this.props.reactContainer.className = 'ag-tooltip';
    }
  }, {
    key: "render",
    value: function render() {
      var data = this.props.api.getRowNode(this.props.rowIndex).data;
      return react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("div", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 11
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("p", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 12
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("span", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 12
        },
        __self: this
      }, "[".concat(data && data.table, "]:"))), react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("p", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 13
        },
        __self: this
      }, react__WEBPACK_IMPORTED_MODULE_5___default.a.createElement("span", {
        __source: {
          fileName: _jsxFileName,
          lineNumber: 13
        },
        __self: this
      }, "".concat(data && data.description))));
    }
  }]);

  return TableTooltip;
}(react__WEBPACK_IMPORTED_MODULE_5__["Component"]);



/***/ }),

/***/ "./src/components/Tooltip/index.ts":
/*!*****************************************!*\
  !*** ./src/components/Tooltip/index.ts ***!
  \*****************************************/
/*! exports provided: TableTooltip */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Tooltip__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Tooltip */ "./src/components/Tooltip/Tooltip.tsx");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "TableTooltip", function() { return _Tooltip__WEBPACK_IMPORTED_MODULE_0__["default"]; });




/***/ }),

/***/ "./src/context/panelContext.ts":
/*!*************************************!*\
  !*** ./src/context/panelContext.ts ***!
  \*************************************/
/*! exports provided: PanelContext */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PanelContext", function() { return PanelContext; });
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);

var PanelContext = Object(react__WEBPACK_IMPORTED_MODULE_0__["createContext"])({
  loggedUser: undefined,
  roles: new Array(),
  rolesPermission: new Array(),
  permissions: new Array(),
  channels: new Array(),
  panels: new Array(),
  focusedIndex: '',
  onGoBack: function onGoBack(panelId) {
    return function (event) {};
  },
  onMerge: function onMerge() {},
  onSplit: function onSplit() {},
  onSelect: function onSelect(type, id, resId, currentState) {},
  onFocus: function onFocus(event) {},
  focusId: function focusId(id) {},
  getCache: function getCache(panel, key) {
    return null;
  },
  setCache: function setCache(panel, key, value) {}
});


/***/ }),

/***/ "./src/index.css":
/*!***********************!*\
  !*** ./src/index.css ***!
  \***********************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {


var content = __webpack_require__(/*! !../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-3-1!../node_modules/postcss-loader/src??postcss!./index.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/index.css");

if(typeof content === 'string') content = [[module.i, content, '']];

var transform;
var insertInto;



var options = {"hmr":true}

options.transform = transform
options.insertInto = undefined;

var update = __webpack_require__(/*! ../node_modules/style-loader/lib/addStyles.js */ "./node_modules/style-loader/lib/addStyles.js")(content, options);

if(content.locals) module.exports = content.locals;

if(true) {
	module.hot.accept(/*! !../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-3-1!../node_modules/postcss-loader/src??postcss!./index.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/index.css", function() {
		var newContent = __webpack_require__(/*! !../node_modules/css-loader/dist/cjs.js??ref--6-oneOf-3-1!../node_modules/postcss-loader/src??postcss!./index.css */ "./node_modules/css-loader/dist/cjs.js?!./node_modules/postcss-loader/src/index.js?!./src/index.css");

		if(typeof newContent === 'string') newContent = [[module.i, newContent, '']];

		var locals = (function(a, b) {
			var key, idx = 0;

			for(key in a) {
				if(!b || a[key] !== b[key]) return false;
				idx++;
			}

			for(key in b) idx--;

			return idx === 0;
		}(content.locals, newContent.locals));

		if(!locals) throw new Error('Aborting CSS HMR due to changed css-modules locals.');

		update(newContent);
	});

	module.hot.dispose(function() { update(); });
}

/***/ }),

/***/ "./src/index.tsx":
/*!***********************!*\
  !*** ./src/index.tsx ***!
  \***********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var react_dom__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! react-dom */ "./node_modules/react-dom/index.js");
/* harmony import */ var react_dom__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react_dom__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _components_Main__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./components/Main */ "./src/components/Main/index.ts");
/* harmony import */ var _components_Modal_Modal__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/Modal/Modal */ "./src/components/Modal/Modal.tsx");
/* harmony import */ var url_search_params_polyfill__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! url-search-params-polyfill */ "./node_modules/url-search-params-polyfill/index.js");
/* harmony import */ var url_search_params_polyfill__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(url_search_params_polyfill__WEBPACK_IMPORTED_MODULE_4__);
/* harmony import */ var ag_grid_community_dist_styles_ag_grid_css__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ag-grid-community/dist/styles/ag-grid.css */ "./node_modules/ag-grid-community/dist/styles/ag-grid.css");
/* harmony import */ var ag_grid_community_dist_styles_ag_grid_css__WEBPACK_IMPORTED_MODULE_5___default = /*#__PURE__*/__webpack_require__.n(ag_grid_community_dist_styles_ag_grid_css__WEBPACK_IMPORTED_MODULE_5__);
/* harmony import */ var ag_grid_community_dist_styles_ag_theme_material_css__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ag-grid-community/dist/styles/ag-theme-material.css */ "./node_modules/ag-grid-community/dist/styles/ag-theme-material.css");
/* harmony import */ var ag_grid_community_dist_styles_ag_theme_material_css__WEBPACK_IMPORTED_MODULE_6___default = /*#__PURE__*/__webpack_require__.n(ag_grid_community_dist_styles_ag_theme_material_css__WEBPACK_IMPORTED_MODULE_6__);
/* harmony import */ var _index_css__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./index.css */ "./src/index.css");
/* harmony import */ var _index_css__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(_index_css__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var react_dnd__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! react-dnd */ "./node_modules/react-dnd/dist/esm/index.js");
/* harmony import */ var react_dnd_html5_backend__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! react-dnd-html5-backend */ "./node_modules/react-dnd-html5-backend/dist/esm/index.js");
var _jsxFileName = "C:\\Users\\GFavini\\git\\allertameteo\\modules\\allerta-rubrica\\allerta-rubrica-web\\eng-rubrica\\src\\index.tsx";






 // import 'ag-grid-enterprise';




Object(react_dom__WEBPACK_IMPORTED_MODULE_1__["render"])(react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(react__WEBPACK_IMPORTED_MODULE_0___default.a.Fragment, null, react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(react_dnd__WEBPACK_IMPORTED_MODULE_8__["DndProvider"], {
  backend: react_dnd_html5_backend__WEBPACK_IMPORTED_MODULE_9__["default"],
  __source: {
    fileName: _jsxFileName,
    lineNumber: 16
  },
  __self: undefined
}, react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(_components_Modal_Modal__WEBPACK_IMPORTED_MODULE_3__["Modal"], {
  __source: {
    fileName: _jsxFileName,
    lineNumber: 17
  },
  __self: undefined
}), react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement(_components_Main__WEBPACK_IMPORTED_MODULE_2__["Main"], {
  __source: {
    fileName: _jsxFileName,
    lineNumber: 18
  },
  __self: undefined
}))), document.getElementById('app-root'));

/***/ }),

/***/ "./src/resources.ts":
/*!**************************!*\
  !*** ./src/resources.ts ***!
  \**************************/
/*! exports provided: default, headers, client */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "headers", function() { return headers; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "client", function() { return client; });
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime/regenerator */ "./node_modules/@babel/runtime/regenerator/index.js");
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/asyncToGenerator */ "./node_modules/@babel/runtime/helpers/esm/asyncToGenerator.js");


//const host = "https://vm184lnx.ente.regione.emr.it:8443"
var host = ""; //const baseUrl = "/api/jsonws/Rubrica-portlet."

var baseUrl = "/api/jsonws/rubrica.";
var endpoints = {
  //groups:
  //`${host + baseUrl}rubricagruppo/groups`,
  groupsGet: "".concat(host + baseUrl, "rubricagruppo/get-groups"),
  groupsInsert: "".concat(host + baseUrl, "rubricagruppo/add-group"),
  groupsUpdate: "".concat(host + baseUrl, "rubricagruppo/update-groups"),
  groupsDelete: "".concat(host + baseUrl, "rubricagruppo/delete-groups"),
  groupsMultiDelete: "".concat(host + baseUrl, "rubricagruppo/delete-groups-multi"),
  groupsMulti: "".concat(host + baseUrl, "rubricagruppo/groups-multi"),
  groupNominatives: {
    insert: "".concat(host + baseUrl, "rubricagrupponominativi/add-group-nominatives"),
    delete: "".concat(host + baseUrl, "rubricagrupponominativi/delete-group-nominatives")
  },
  groupNominativesMulti: {
    insert: "".concat(host + baseUrl, "rubricagrupponominativi/add-group-nominatives-multi"),
    delete: "".concat(host + baseUrl, "rubricagrupponominativi/delete-group-nominatives-multi")
  },
  subgroups: {
    insert: "".concat(host + baseUrl, "rubricagruppogruppi/add-group-subgroups"),
    delete: "".concat(host + baseUrl, "rubricagruppogruppi/delete-group-subgroups"),
    update: "".concat(host + baseUrl, "rubricagruppogruppi/update-group-subgroups")
  },
  subgroupsMulti: {
    insert: "".concat(host + baseUrl, "rubricagruppogruppi/add-group-multi-subgroups"),
    delete: "".concat(host + baseUrl, "rubricagruppogruppi/delete-group-multi-subgroups")
  },
  supergroupsMulti: {
    insert: "".concat(host + baseUrl, "rubricagruppogruppi/add-group-multi-supergroups"),
    delete: "".concat(host + baseUrl, "rubricagruppogruppi/delete-group-multi-supergroups")
  },
  nominativesGet: "".concat(host + baseUrl, "rubricanominativo/get-nominatives"),
  nominativesUpdate: "".concat(host + baseUrl, "rubricanominativo/update-nominatives"),
  nominativesInsert: "".concat(host + baseUrl, "rubricanominativo/insert-nominatives"),
  nominativesDelete: "".concat(host + baseUrl, "rubricanominativo/delete-nominatives"),
  nominativesMulti: "".concat(host + baseUrl, "rubricanominativo/nominatives-multi"),
  nominativesGroupsMulti: {
    insert: "".concat(host + baseUrl, "rubricanominativo/add-nominatives-groups-multi"),
    delete: "".concat(host + baseUrl, "rubricanominativo/delete-nominatives-groups-multi")
  },
  contacts: {
    insert: "".concat(host + baseUrl, "rubricacontatto/add-contacts"),
    delete: "".concat(host + baseUrl, "rubricacontatto/delete-contacts"),
    update: "".concat(host + baseUrl, "rubricacontatto/update-contacts")
  },
  contactsMulti: "".concat(host + baseUrl, "rubricacontatto/delete-contacts-multi"),
  roles: "".concat(host + baseUrl, "rubricaruolorubrica/get-address-book-roles"),
  permission: "".concat(host + baseUrl, "rubricapermessi/get-permission"),
  rolePermission: "".concat(host + baseUrl, "rubricaruolopermessi/get-role-permission"),
  channels: "".concat(host + baseUrl, "rubricacanale/get-channels"),
  logs: "".concat(host + baseUrl, "rubricalog/get-logs"),
  loggedUser: "".concat(host + baseUrl, "rubricaruolopermessi/get-user-info")
};
var headers = new Headers();
headers.append('Cookie', 'JSESSIONID=1B406693174873A0DB2B429F9C4C4083.node01');
headers.append('Access-Control-Allow-Origin', 'https://vm184lnx.ente.regione.emr.it:8443');

var getFetch =
/*#__PURE__*/
function () {
  var _ref = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee(url, params) {
    var aut, res, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee$(_context) {
      while (1) {
        switch (_context.prev = _context.next) {
          case 0:
            // to include session cookies, if does not work try using 'include'
            aut = "p_auth=" + window["Liferay"].authToken;
            _context.next = 3;
            return fetch("".concat(url, "?").concat(aut, "&").concat(params), {
              headers: headers,
              method: "GET",
              credentials: "include"
            });

          case 3:
            res = _context.sent;
            _context.next = 6;
            return res.json();

          case 6:
            data = _context.sent;

            if (!(data.code !== 200)) {
              _context.next = 10;
              break;
            }

            console.error('api error:', data.error);
            throw new Error(data.error);

          case 10:
            return _context.abrupt("return", data);

          case 11:
          case "end":
            return _context.stop();
        }
      }
    }, _callee);
  }));

  return function getFetch(_x, _x2) {
    return _ref.apply(this, arguments);
  };
}();

var postFetch =
/*#__PURE__*/
function () {
  var _ref2 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee2(url, obj, params) {
    var form, aut, fetchUrl, res, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee2$(_context2) {
      while (1) {
        switch (_context2.prev = _context2.next) {
          case 0:
            form = new FormData();
            form.append('data', JSON.stringify(obj));
            aut = "p_auth=" + window["Liferay"].authToken;
            fetchUrl = params ? "".concat(url, "?").concat(aut, "&").concat(params) : "".concat(url, "?").concat(aut);
            _context2.next = 6;
            return fetch(fetchUrl, {
              headers: headers,
              method: 'POST',
              credentials: "include",
              body: form
            });

          case 6:
            res = _context2.sent;
            _context2.next = 9;
            return res.json();

          case 9:
            data = _context2.sent;

            if (!(data.code >= 300)) {
              _context2.next = 13;
              break;
            }

            console.error('api error:', data.error);
            throw new Error(data.error);

          case 13:
            console.log(data.success);
            return _context2.abrupt("return", data);

          case 15:
          case "end":
            return _context2.stop();
        }
      }
    }, _callee2);
  }));

  return function postFetch(_x3, _x4, _x5) {
    return _ref2.apply(this, arguments);
  };
}();

var putFetch =
/*#__PURE__*/
function () {
  var _ref3 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee3(url, params, obj) {
    var form, aut, fetchUrl, res, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee3$(_context3) {
      while (1) {
        switch (_context3.prev = _context3.next) {
          case 0:
            form = new FormData();
            form.append('data', JSON.stringify(obj));
            aut = "p_auth=" + window["Liferay"].authToken;
            fetchUrl = params ? "".concat(url, "?").concat(aut, "&").concat(params) : "".concat(url, "?").concat(aut);
            _context3.next = 6;
            return fetch(fetchUrl, {
              headers: headers,
              method: 'POST',
              credentials: "include",
              body: form
            });

          case 6:
            res = _context3.sent;
            _context3.next = 9;
            return res.json();

          case 9:
            data = _context3.sent;

            if (!(data.code >= 300)) {
              _context3.next = 13;
              break;
            }

            console.error('api error:', data.error);
            throw new Error(data.error);

          case 13:
            console.log(data.success);
            return _context3.abrupt("return", data);

          case 15:
          case "end":
            return _context3.stop();
        }
      }
    }, _callee3);
  }));

  return function putFetch(_x6, _x7, _x8) {
    return _ref3.apply(this, arguments);
  };
}();

var deleteFetch =
/*#__PURE__*/
function () {
  var _ref4 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee4(url, params, obj) {
    var form, aut, fetchUrl, res, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee4$(_context4) {
      while (1) {
        switch (_context4.prev = _context4.next) {
          case 0:
            form = new FormData();
            form.append('data', JSON.stringify(obj));
            aut = "p_auth=" + window["Liferay"].authToken;
            fetchUrl = params ? "".concat(url, "?").concat(aut, "&").concat(params) : "".concat(url, "?").concat(aut);
            _context4.next = 6;
            return fetch(fetchUrl, {
              headers: headers,
              method: 'POST',
              credentials: "include",
              body: form
            });

          case 6:
            res = _context4.sent;
            _context4.next = 9;
            return res.json();

          case 9:
            data = _context4.sent;

            if (!(data.code >= 300)) {
              _context4.next = 13;
              break;
            }

            console.error('api error:', data.error);
            throw new Error(data.error);

          case 13:
            console.log(data.success);
            return _context4.abrupt("return", data);

          case 15:
          case "end":
            return _context4.stop();
        }
      }
    }, _callee4);
  }));

  return function deleteFetch(_x9, _x10, _x11) {
    return _ref4.apply(this, arguments);
  };
}();

var getGroups =
/*#__PURE__*/
function () {
  var _ref5 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee5() {
    var name,
        limit,
        offset,
        params,
        data,
        _args5 = arguments;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee5$(_context5) {
      while (1) {
        switch (_context5.prev = _context5.next) {
          case 0:
            name = _args5.length > 0 && _args5[0] !== undefined ? _args5[0] : "";
            limit = _args5.length > 1 && _args5[1] !== undefined ? _args5[1] : 10000;
            offset = _args5.length > 2 && _args5[2] !== undefined ? _args5[2] : 0;
            params = new URLSearchParams();
            params.append("name", name);
            params.append("limit", limit.toString());
            params.append("offset", offset.toString());
            _context5.prev = 7;
            _context5.next = 10;
            return getFetch(endpoints.groupsGet, params.toString());

          case 10:
            data = _context5.sent;
            return _context5.abrupt("return", data);

          case 14:
            _context5.prev = 14;
            _context5.t0 = _context5["catch"](7);
            throw _context5.t0;

          case 17:
          case "end":
            return _context5.stop();
        }
      }
    }, _callee5, null, [[7, 14]]);
  }));

  return function getGroups() {
    return _ref5.apply(this, arguments);
  };
}();

var getNominatives =
/*#__PURE__*/
function () {
  var _ref6 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee6() {
    var name,
        limit,
        offset,
        params,
        data,
        _args6 = arguments;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee6$(_context6) {
      while (1) {
        switch (_context6.prev = _context6.next) {
          case 0:
            name = _args6.length > 0 && _args6[0] !== undefined ? _args6[0] : "";
            limit = _args6.length > 1 && _args6[1] !== undefined ? _args6[1] : 10;
            offset = _args6.length > 2 && _args6[2] !== undefined ? _args6[2] : 0;
            params = new URLSearchParams();
            params.append("name", name);
            params.append("limit", limit.toString());
            params.append("offset", offset.toString());
            _context6.prev = 7;
            _context6.next = 10;
            return getFetch(endpoints.nominativesGet, params.toString());

          case 10:
            data = _context6.sent;
            return _context6.abrupt("return", data);

          case 14:
            _context6.prev = 14;
            _context6.t0 = _context6["catch"](7);
            throw _context6.t0;

          case 17:
          case "end":
            return _context6.stop();
        }
      }
    }, _callee6, null, [[7, 14]]);
  }));

  return function getNominatives() {
    return _ref6.apply(this, arguments);
  };
}();

var getPermissions =
/*#__PURE__*/
function () {
  var _ref7 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee7() {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee7$(_context7) {
      while (1) {
        switch (_context7.prev = _context7.next) {
          case 0:
            _context7.prev = 0;
            _context7.next = 3;
            return getFetch(endpoints.permission);

          case 3:
            data = _context7.sent;
            return _context7.abrupt("return", data);

          case 7:
            _context7.prev = 7;
            _context7.t0 = _context7["catch"](0);
            throw _context7.t0;

          case 10:
          case "end":
            return _context7.stop();
        }
      }
    }, _callee7, null, [[0, 7]]);
  }));

  return function getPermissions() {
    return _ref7.apply(this, arguments);
  };
}();

var getRolesPermission =
/*#__PURE__*/
function () {
  var _ref8 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee8() {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee8$(_context8) {
      while (1) {
        switch (_context8.prev = _context8.next) {
          case 0:
            _context8.prev = 0;
            _context8.next = 3;
            return getFetch(endpoints.rolePermission, '');

          case 3:
            data = _context8.sent;
            return _context8.abrupt("return", data);

          case 7:
            _context8.prev = 7;
            _context8.t0 = _context8["catch"](0);
            throw _context8.t0;

          case 10:
          case "end":
            return _context8.stop();
        }
      }
    }, _callee8, null, [[0, 7]]);
  }));

  return function getRolesPermission() {
    return _ref8.apply(this, arguments);
  };
}();

var getRoles =
/*#__PURE__*/
function () {
  var _ref9 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee9() {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee9$(_context9) {
      while (1) {
        switch (_context9.prev = _context9.next) {
          case 0:
            _context9.prev = 0;
            _context9.next = 3;
            return getFetch(endpoints.roles);

          case 3:
            data = _context9.sent;
            return _context9.abrupt("return", data);

          case 7:
            _context9.prev = 7;
            _context9.t0 = _context9["catch"](0);
            throw _context9.t0;

          case 10:
          case "end":
            return _context9.stop();
        }
      }
    }, _callee9, null, [[0, 7]]);
  }));

  return function getRoles() {
    return _ref9.apply(this, arguments);
  };
}();

var getChannels =
/*#__PURE__*/
function () {
  var _ref10 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee10() {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee10$(_context10) {
      while (1) {
        switch (_context10.prev = _context10.next) {
          case 0:
            _context10.prev = 0;
            _context10.next = 3;
            return getFetch(endpoints.channels);

          case 3:
            data = _context10.sent;
            return _context10.abrupt("return", data);

          case 7:
            _context10.prev = 7;
            _context10.t0 = _context10["catch"](0);
            throw _context10.t0;

          case 10:
          case "end":
            return _context10.stop();
        }
      }
    }, _callee10, null, [[0, 7]]);
  }));

  return function getChannels() {
    return _ref10.apply(this, arguments);
  };
}();

var getLoggedUser =
/*#__PURE__*/
function () {
  var _ref11 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee11() {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee11$(_context11) {
      while (1) {
        switch (_context11.prev = _context11.next) {
          case 0:
            _context11.prev = 0;
            _context11.next = 3;
            return getFetch(endpoints.loggedUser);

          case 3:
            data = _context11.sent;
            return _context11.abrupt("return", data);

          case 7:
            _context11.prev = 7;
            _context11.t0 = _context11["catch"](0);
            throw _context11.t0;

          case 10:
          case "end":
            return _context11.stop();
        }
      }
    }, _callee11, null, [[0, 7]]);
  }));

  return function getLoggedUser() {
    return _ref11.apply(this, arguments);
  };
}();

var getLogs =
/*#__PURE__*/
function () {
  var _ref12 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee12(name) {
    var limit,
        offset,
        params,
        data,
        _args12 = arguments;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee12$(_context12) {
      while (1) {
        switch (_context12.prev = _context12.next) {
          case 0:
            limit = _args12.length > 1 && _args12[1] !== undefined ? _args12[1] : 10;
            offset = _args12.length > 2 && _args12[2] !== undefined ? _args12[2] : 0;
            params = new URLSearchParams();
            params.append("name", name);
            params.append("limit", limit.toString());
            params.append("offset", offset.toString());
            _context12.next = 8;
            return getFetch(endpoints.logs, params.toString());

          case 8:
            data = _context12.sent;
            return _context12.abrupt("return", data);

          case 10:
          case "end":
            return _context12.stop();
        }
      }
    }, _callee12);
  }));

  return function getLogs(_x12) {
    return _ref12.apply(this, arguments);
  };
}();

var getNominativeById =
/*#__PURE__*/
function () {
  var _ref13 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee13(id) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee13$(_context13) {
      while (1) {
        switch (_context13.prev = _context13.next) {
          case 0:
            params = new URLSearchParams();
            params.append("id", id.toString());
            _context13.next = 4;
            return getFetch(endpoints.nominativesGet, params.toString());

          case 4:
            data = _context13.sent;
            return _context13.abrupt("return", data);

          case 6:
          case "end":
            return _context13.stop();
        }
      }
    }, _callee13);
  }));

  return function getNominativeById(_x13) {
    return _ref13.apply(this, arguments);
  };
}();

var getGroupById =
/*#__PURE__*/
function () {
  var _ref14 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee14(id) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee14$(_context14) {
      while (1) {
        switch (_context14.prev = _context14.next) {
          case 0:
            params = new URLSearchParams();
            params.append("id", id.toString());
            _context14.next = 4;
            return getFetch(endpoints.groupsGet, params.toString());

          case 4:
            data = _context14.sent;
            return _context14.abrupt("return", data);

          case 6:
          case "end":
            return _context14.stop();
        }
      }
    }, _callee14);
  }));

  return function getGroupById(_x14) {
    return _ref14.apply(this, arguments);
  };
}();

var postNominative =
/*#__PURE__*/
function () {
  var _ref15 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee15(nominative) {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee15$(_context15) {
      while (1) {
        switch (_context15.prev = _context15.next) {
          case 0:
            _context15.next = 2;
            return postFetch(endpoints.nominativesInsert, nominative);

          case 2:
            data = _context15.sent;
            return _context15.abrupt("return", data);

          case 4:
          case "end":
            return _context15.stop();
        }
      }
    }, _callee15);
  }));

  return function postNominative(_x15) {
    return _ref15.apply(this, arguments);
  };
}();

var postContact =
/*#__PURE__*/
function () {
  var _ref16 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee16(contact) {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee16$(_context16) {
      while (1) {
        switch (_context16.prev = _context16.next) {
          case 0:
            _context16.next = 2;
            return postFetch(endpoints.contacts.insert, contact);

          case 2:
            data = _context16.sent;
            return _context16.abrupt("return", data);

          case 4:
          case "end":
            return _context16.stop();
        }
      }
    }, _callee16);
  }));

  return function postContact(_x16) {
    return _ref16.apply(this, arguments);
  };
}();

var postGroup =
/*#__PURE__*/
function () {
  var _ref17 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee17(group) {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee17$(_context17) {
      while (1) {
        switch (_context17.prev = _context17.next) {
          case 0:
            _context17.next = 2;
            return postFetch(endpoints.groupsInsert, group);

          case 2:
            data = _context17.sent;
            return _context17.abrupt("return", data);

          case 4:
          case "end":
            return _context17.stop();
        }
      }
    }, _callee17);
  }));

  return function postGroup(_x17) {
    return _ref17.apply(this, arguments);
  };
}();

var putContact =
/*#__PURE__*/
function () {
  var _ref18 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee18(id, contact) {
    var channelId, nominativeId, value, warning, modificaMinore, params, data, res;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee18$(_context18) {
      while (1) {
        switch (_context18.prev = _context18.next) {
          case 0:
            channelId = contact.channelId, nominativeId = contact.nominativeId, value = contact.value, warning = contact.warning, modificaMinore = contact.modificaMinore;
            params = new URLSearchParams();
            params.append('id', id.toString());
            data = {
              channelId: channelId,
              nominativeId: nominativeId,
              value: value,
              warning: warning,
              modificaMinore: modificaMinore
            };
            _context18.next = 6;
            return putFetch(endpoints.contacts.update, params.toString(), data);

          case 6:
            res = _context18.sent;
            return _context18.abrupt("return", res);

          case 8:
          case "end":
            return _context18.stop();
        }
      }
    }, _callee18);
  }));

  return function putContact(_x18, _x19) {
    return _ref18.apply(this, arguments);
  };
}();

var putNominative =
/*#__PURE__*/
function () {
  var _ref19 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee19(id, nominative) {
    var firstName, lastName, address, modificaMinore, params, data, res;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee19$(_context19) {
      while (1) {
        switch (_context19.prev = _context19.next) {
          case 0:
            firstName = nominative.firstName, lastName = nominative.lastName, address = nominative.address, modificaMinore = nominative.modificaMinore;
            params = new URLSearchParams();
            params.append('id', id.toString());
            data = {
              firstName: firstName,
              lastName: lastName,
              address: address,
              modificaMinore: modificaMinore
            };
            _context19.next = 6;
            return putFetch(endpoints.nominativesUpdate, params.toString(), data);

          case 6:
            res = _context19.sent;
            return _context19.abrupt("return", res);

          case 8:
          case "end":
            return _context19.stop();
        }
      }
    }, _callee19);
  }));

  return function putNominative(_x20, _x21) {
    return _ref19.apply(this, arguments);
  };
}();

var setNominativeRole =
/*#__PURE__*/
function () {
  var _ref20 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee20(groupId, nominativeId, roleId) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee20$(_context20) {
      while (1) {
        switch (_context20.prev = _context20.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', groupId.toString());
            _context20.next = 4;
            return postFetch(endpoints.groupNominatives.insert, {
              nominativeId: nominativeId,
              role: roleId
            }, params.toString());

          case 4:
            data = _context20.sent;
            return _context20.abrupt("return", data);

          case 6:
          case "end":
            return _context20.stop();
        }
      }
    }, _callee20);
  }));

  return function setNominativeRole(_x22, _x23, _x24) {
    return _ref20.apply(this, arguments);
  };
}();

var setNominativesRole =
/*#__PURE__*/
function () {
  var _ref21 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee21(groupId, nominatives) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee21$(_context21) {
      while (1) {
        switch (_context21.prev = _context21.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', groupId.toString());
            _context21.next = 4;
            return postFetch(endpoints.groupNominativesMulti.insert, nominatives, params.toString());

          case 4:
            data = _context21.sent;
            return _context21.abrupt("return", data);

          case 6:
          case "end":
            return _context21.stop();
        }
      }
    }, _callee21);
  }));

  return function setNominativesRole(_x25, _x26) {
    return _ref21.apply(this, arguments);
  };
}();

var setGroupsNominativeRole =
/*#__PURE__*/
function () {
  var _ref22 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee22(id, ids) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee22$(_context22) {
      while (1) {
        switch (_context22.prev = _context22.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context22.next = 4;
            return postFetch(endpoints.nominativesGroupsMulti.insert, ids, params.toString());

          case 4:
            data = _context22.sent;
            return _context22.abrupt("return", data);

          case 6:
          case "end":
            return _context22.stop();
        }
      }
    }, _callee22);
  }));

  return function setGroupsNominativeRole(_x27, _x28) {
    return _ref22.apply(this, arguments);
  };
}();

var updateRolePermission =
/*#__PURE__*/
function () {
  var _ref23 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee23(roleId, permission, read, write) {
    var obj, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee23$(_context23) {
      while (1) {
        switch (_context23.prev = _context23.next) {
          case 0:
            obj = [{
              permission: permission,
              read: read,
              write: write,
              roleId: roleId
            }];
            _context23.next = 3;
            return putFetch(endpoints.rolePermission, "", obj);

          case 3:
            data = _context23.sent;
            return _context23.abrupt("return", data);

          case 5:
          case "end":
            return _context23.stop();
        }
      }
    }, _callee23);
  }));

  return function updateRolePermission(_x29, _x30, _x31, _x32) {
    return _ref23.apply(this, arguments);
  };
}();

var unsetNominativeRole =
/*#__PURE__*/
function () {
  var _ref24 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee24(groupId, nominativeId) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee24$(_context24) {
      while (1) {
        switch (_context24.prev = _context24.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', groupId.toString());
            _context24.next = 4;
            return deleteFetch(endpoints.groupNominatives.delete, params.toString(), {
              nominativeId: nominativeId
            });

          case 4:
            data = _context24.sent;
            return _context24.abrupt("return", data);

          case 6:
          case "end":
            return _context24.stop();
        }
      }
    }, _callee24);
  }));

  return function unsetNominativeRole(_x33, _x34) {
    return _ref24.apply(this, arguments);
  };
}();

var unsetNominativesRole =
/*#__PURE__*/
function () {
  var _ref25 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee25(groupId, nominativeIds) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee25$(_context25) {
      while (1) {
        switch (_context25.prev = _context25.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', groupId.toString());
            _context25.next = 4;
            return deleteFetch(endpoints.groupNominativesMulti.delete, params.toString(), nominativeIds);

          case 4:
            data = _context25.sent;
            return _context25.abrupt("return", data);

          case 6:
          case "end":
            return _context25.stop();
        }
      }
    }, _callee25);
  }));

  return function unsetNominativesRole(_x35, _x36) {
    return _ref25.apply(this, arguments);
  };
}();

var unsetGroupsRole =
/*#__PURE__*/
function () {
  var _ref26 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee26(groupId, nominatives) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee26$(_context26) {
      while (1) {
        switch (_context26.prev = _context26.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', groupId.toString());
            _context26.next = 4;
            return deleteFetch(endpoints.nominativesGroupsMulti.delete, params.toString(), nominatives);

          case 4:
            data = _context26.sent;
            return _context26.abrupt("return", data);

          case 6:
          case "end":
            return _context26.stop();
        }
      }
    }, _callee26);
  }));

  return function unsetGroupsRole(_x37, _x38) {
    return _ref26.apply(this, arguments);
  };
}();

var putGroup =
/*#__PURE__*/
function () {
  var _ref27 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee27(id, group) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee27$(_context27) {
      while (1) {
        switch (_context27.prev = _context27.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context27.next = 4;
            return putFetch(endpoints.groupsUpdate, params.toString(), group);

          case 4:
            data = _context27.sent;
            return _context27.abrupt("return", data);

          case 6:
          case "end":
            return _context27.stop();
        }
      }
    }, _callee27);
  }));

  return function putGroup(_x39, _x40) {
    return _ref27.apply(this, arguments);
  };
}();

var deleteGroup =
/*#__PURE__*/
function () {
  var _ref28 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee28(id) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee28$(_context28) {
      while (1) {
        switch (_context28.prev = _context28.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context28.next = 4;
            return deleteFetch(endpoints.groupsDelete, params.toString());

          case 4:
            data = _context28.sent;
            return _context28.abrupt("return", data);

          case 6:
          case "end":
            return _context28.stop();
        }
      }
    }, _callee28);
  }));

  return function deleteGroup(_x41) {
    return _ref28.apply(this, arguments);
  };
}();

var deleteNominative =
/*#__PURE__*/
function () {
  var _ref29 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee29(id) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee29$(_context29) {
      while (1) {
        switch (_context29.prev = _context29.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context29.next = 4;
            return deleteFetch(endpoints.nominativesDelete, params.toString());

          case 4:
            data = _context29.sent;
            return _context29.abrupt("return", data);

          case 6:
          case "end":
            return _context29.stop();
        }
      }
    }, _callee29);
  }));

  return function deleteNominative(_x42) {
    return _ref29.apply(this, arguments);
  };
}();

var deleteNominatives =
/*#__PURE__*/
function () {
  var _ref30 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee30(ids) {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee30$(_context30) {
      while (1) {
        switch (_context30.prev = _context30.next) {
          case 0:
            _context30.next = 2;
            return deleteFetch(endpoints.nominativesMulti, "", ids);

          case 2:
            data = _context30.sent;
            return _context30.abrupt("return", data);

          case 4:
          case "end":
            return _context30.stop();
        }
      }
    }, _callee30);
  }));

  return function deleteNominatives(_x43) {
    return _ref30.apply(this, arguments);
  };
}();

var deleteGroups =
/*#__PURE__*/
function () {
  var _ref31 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee31(ids) {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee31$(_context31) {
      while (1) {
        switch (_context31.prev = _context31.next) {
          case 0:
            _context31.next = 2;
            return deleteFetch(endpoints.groupsMultiDelete, "", ids);

          case 2:
            data = _context31.sent;
            return _context31.abrupt("return", data);

          case 4:
          case "end":
            return _context31.stop();
        }
      }
    }, _callee31);
  }));

  return function deleteGroups(_x44) {
    return _ref31.apply(this, arguments);
  };
}();

var deleteContact =
/*#__PURE__*/
function () {
  var _ref32 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee32(id) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee32$(_context32) {
      while (1) {
        switch (_context32.prev = _context32.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context32.next = 4;
            return deleteFetch(endpoints.contacts.delete, params.toString());

          case 4:
            data = _context32.sent;
            return _context32.abrupt("return", data);

          case 6:
          case "end":
            return _context32.stop();
        }
      }
    }, _callee32);
  }));

  return function deleteContact(_x45) {
    return _ref32.apply(this, arguments);
  };
}();

var deleteContacts =
/*#__PURE__*/
function () {
  var _ref33 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee33(ids) {
    var data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee33$(_context33) {
      while (1) {
        switch (_context33.prev = _context33.next) {
          case 0:
            _context33.next = 2;
            return deleteFetch(endpoints.contactsMulti, "", ids);

          case 2:
            data = _context33.sent;
            return _context33.abrupt("return", data);

          case 4:
          case "end":
            return _context33.stop();
        }
      }
    }, _callee33);
  }));

  return function deleteContacts(_x46) {
    return _ref33.apply(this, arguments);
  };
}();

var setSubgroup =
/*#__PURE__*/
function () {
  var _ref34 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee34(id, subgroupId) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee34$(_context34) {
      while (1) {
        switch (_context34.prev = _context34.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context34.next = 4;
            return postFetch(endpoints.subgroups.insert, {
              subgroupId: subgroupId
            }, params.toString());

          case 4:
            data = _context34.sent;
            return _context34.abrupt("return", data);

          case 6:
          case "end":
            return _context34.stop();
        }
      }
    }, _callee34);
  }));

  return function setSubgroup(_x47, _x48) {
    return _ref34.apply(this, arguments);
  };
}();

var setSubgroupMulti =
/*#__PURE__*/
function () {
  var _ref35 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee35(id, subgroupIds) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee35$(_context35) {
      while (1) {
        switch (_context35.prev = _context35.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context35.next = 4;
            return postFetch(endpoints.subgroupsMulti.insert, subgroupIds, params.toString());

          case 4:
            data = _context35.sent;
            return _context35.abrupt("return", data);

          case 6:
          case "end":
            return _context35.stop();
        }
      }
    }, _callee35);
  }));

  return function setSubgroupMulti(_x49, _x50) {
    return _ref35.apply(this, arguments);
  };
}();

var setSupergroupMulti =
/*#__PURE__*/
function () {
  var _ref36 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee36(id, subgroupIds) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee36$(_context36) {
      while (1) {
        switch (_context36.prev = _context36.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context36.next = 4;
            return postFetch(endpoints.supergroupsMulti.insert, subgroupIds, params.toString());

          case 4:
            data = _context36.sent;
            return _context36.abrupt("return", data);

          case 6:
          case "end":
            return _context36.stop();
        }
      }
    }, _callee36);
  }));

  return function setSupergroupMulti(_x51, _x52) {
    return _ref36.apply(this, arguments);
  };
}();

var removeSubgroup =
/*#__PURE__*/
function () {
  var _ref37 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee37(id, subgroupId) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee37$(_context37) {
      while (1) {
        switch (_context37.prev = _context37.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context37.next = 4;
            return deleteFetch(endpoints.subgroups.delete, params.toString(), {
              subgroupId: subgroupId
            });

          case 4:
            data = _context37.sent;
            return _context37.abrupt("return", data);

          case 6:
          case "end":
            return _context37.stop();
        }
      }
    }, _callee37);
  }));

  return function removeSubgroup(_x53, _x54) {
    return _ref37.apply(this, arguments);
  };
}();

var removeSubgroups =
/*#__PURE__*/
function () {
  var _ref38 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee38(id, subgroupIds) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee38$(_context38) {
      while (1) {
        switch (_context38.prev = _context38.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context38.next = 4;
            return deleteFetch(endpoints.subgroupsMulti.delete, params.toString(), subgroupIds);

          case 4:
            data = _context38.sent;
            return _context38.abrupt("return", data);

          case 6:
          case "end":
            return _context38.stop();
        }
      }
    }, _callee38);
  }));

  return function removeSubgroups(_x55, _x56) {
    return _ref38.apply(this, arguments);
  };
}();

var removeSupergroups =
/*#__PURE__*/
function () {
  var _ref39 = Object(C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_1__["default"])(
  /*#__PURE__*/
  C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.mark(function _callee39(id, subgroupIds) {
    var params, data;
    return C_Users_GFavini_git_allertameteo_modules_allerta_rubrica_allerta_rubrica_web_eng_rubrica_node_modules_babel_runtime_regenerator__WEBPACK_IMPORTED_MODULE_0___default.a.wrap(function _callee39$(_context39) {
      while (1) {
        switch (_context39.prev = _context39.next) {
          case 0:
            params = new URLSearchParams();
            params.append('id', id.toString());
            _context39.next = 4;
            return deleteFetch(endpoints.supergroupsMulti.delete, params.toString(), subgroupIds);

          case 4:
            data = _context39.sent;
            return _context39.abrupt("return", data);

          case 6:
          case "end":
            return _context39.stop();
        }
      }
    }, _callee39);
  }));

  return function removeSupergroups(_x57, _x58) {
    return _ref39.apply(this, arguments);
  };
}();

var client = {
  groups: {
    setNominativeRole: setNominativeRole,
    setNominativesRole: setNominativesRole,
    setGroupsNominativeRole: setGroupsNominativeRole,
    unsetNominativeRole: unsetNominativeRole,
    unsetNominativesRole: unsetNominativesRole,
    unsetGroupsRole: unsetGroupsRole,
    setSubgroup: setSubgroup,
    setSubgroupMulti: setSubgroupMulti,
    setSupergroupMulti: setSupergroupMulti,
    removeSubgroup: removeSubgroup,
    removeSubgroups: removeSubgroups,
    removeSupergroups: removeSupergroups,
    all: getGroups,
    getById: getGroupById,
    create: postGroup,
    update: putGroup,
    delete: deleteGroup,
    deleteMulti: deleteGroups
  },
  nominatives: {
    all: getNominatives,
    getById: getNominativeById,
    create: postNominative,
    update: putNominative,
    delete: deleteNominative,
    deleteMulti: deleteNominatives
  },
  contacts: {
    create: postContact,
    delete: deleteContact,
    deleteMulti: deleteContacts,
    update: putContact
  },
  permission: {
    all: getPermissions
  },
  rolesPermission: {
    all: getRolesPermission,
    update: updateRolePermission
  },
  roles: {
    all: getRoles
  },
  channels: {
    all: getChannels
  },
  logs: {
    all: getLogs
  },
  loggedUser: getLoggedUser
};
/* harmony default export */ __webpack_exports__["default"] = (endpoints);


/***/ }),

/***/ "./src/types.d.ts":
/*!************************!*\
  !*** ./src/types.d.ts ***!
  \************************/
/*! exports provided: PanelType */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PanelType", function() { return PanelType; });
var PanelType;

(function (PanelType) {
  PanelType["GROUPS"] = "GROUPS";
  PanelType["GROUP_DETAILS"] = "GROUP_DETAILS";
  PanelType["LOGS"] = "LOGS";
  PanelType["CONTACTS"] = "CONTACTS";
  PanelType["CONTACT_DETAILS"] = "CONTACT_DETAIL";
  PanelType["PERMISSION"] = "PERMISSIONS";
})(PanelType || (PanelType = {}));

/***/ }),

/***/ "./src/utils.ts":
/*!**********************!*\
  !*** ./src/utils.ts ***!
  \**********************/
/*! exports provided: debounced, genID, getResId, getChannelName */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "debounced", function() { return debounced; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "genID", function() { return genID; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "getResId", function() { return getResId; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "getChannelName", function() { return getChannelName; });
var debounced = function debounced(func, wait) {
  var timeout;
  return function (args) {
    args.persist();

    if (timeout) {
      clearTimeout(timeout);
    }

    timeout = setTimeout(function () {
      func(args);
    }, wait);
  };
};
var genID = function genID() {
  var array = new Uint32Array(8);
  window.crypto.getRandomValues(array);
  var str = '';

  for (var i = 0; i < array.length; i++) {
    str += (i < 2 || i > 5 ? '' : '-') + array[i].toString(16).slice(-4);
  }

  return str;
};
var getResId = function getResId(panels, id) {
  var panel = panels.filter(function (panel) {
    return panel.id === id;
  });

  if (panel[0]) {
    return panel[0].resId;
  } else {
    return undefined;
  }
};
var getChannelName = function getChannelName(channels, channelId) {
  var channel = channels.filter(function (channel) {
    return channel.id === channelId;
  });

  if (channel[0]) {
    return channel[0].name;
  } else {
    return '';
  }
};

/***/ }),

/***/ 0:
/*!***********************************************************************************!*\
  !*** multi ./node_modules/react-dev-utils/webpackHotDevClient.js ./src/index.tsx ***!
  \***********************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

__webpack_require__(/*! C:\Users\GFavini\git\allertameteo\modules\allerta-rubrica\allerta-rubrica-web\eng-rubrica\node_modules\react-dev-utils\webpackHotDevClient.js */"./node_modules/react-dev-utils/webpackHotDevClient.js");
module.exports = __webpack_require__(/*! C:\Users\GFavini\git\allertameteo\modules\allerta-rubrica\allerta-rubrica-web\eng-rubrica\src\index.tsx */"./src/index.tsx");


/***/ })

},[[0,"runtime~main",0]]]);
//# sourceMappingURL=main.chunk.js.map