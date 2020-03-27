/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./src/js/login/loginMain.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./src/js/constants/constant.js":
/*!**************************************!*\
  !*** ./src/js/constants/constant.js ***!
  \**************************************/
/*! exports provided: VALID_CHECK_REGEX, STATE_MESSAGE, ALERT_MESSAGE, FORM_RULES, STATUS */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"VALID_CHECK_REGEX\", function() { return VALID_CHECK_REGEX; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"STATE_MESSAGE\", function() { return STATE_MESSAGE; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"ALERT_MESSAGE\", function() { return ALERT_MESSAGE; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"FORM_RULES\", function() { return FORM_RULES; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"STATUS\", function() { return STATUS; });\nconst VALID_CHECK_REGEX = {\n  ID: /^[a-z0-9-_]{5,20}$/,\n  PASSWORD: {\n    LENGTH: /.{8,16}$/,\n    UPPER: /^(?=.*[A-Z])/,\n    NUMBER: /^(?=.*[0-9])/,\n    SPECIAL: /^((?=.*\\d)|(?=.*\\W))/\n  },\n  EMAIL: /^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$/i,\n  PHONE_NUMBER: /^010\\d{3,4}\\d{4}$/\n};\nconst STATE_MESSAGE = {\n  VALID: {\n    DEFALUT: ' ',\n    ID: '<span>사용 가능한 아이디입니다.</span>',\n    PASSWORD: '<span>안전한 비밀번호입니다.</span>',\n    PASSWORD_RECHECK: '<span>비밀번호가 일치합니다.</span>'\n  },\n  INVALID: {\n    ID: '5~20자의 영문 소문자, 숫자와 특수기호(_)(-) 만 사용 가능합니다.',\n    PASSWORD: {\n      LENGTH: '8자 이상 16자 이하로 입력해주세요.',\n      UPPER: '영문 대문자를 최소 1자 이상 포함해주세요.',\n      NUMBER: '숫자를 최소 1자 이상 포함해주세요.',\n      SPECIAL: '특수문자를 최소 1자 이상 포함해주세요.'\n    },\n    PASSWORD_RECHECK: '비밀번호가 일치하지 않습니다.',\n    BIRTH_DATE: {\n      BASE: '생년월일을 모두 입력해주세요.',\n      YEAR: '태어난 년도 4자리를 정확하게 입력하세요.',\n      DAY: '태어난 날짜를 정확하게 입력하세요.',\n      AGE: '만 14세 이상 99세 이하만 가입 가능합니다.'\n    },\n    EMAIL: '이메일 주소를 다시 확인해주세요.',\n    PHONE_NUMBER: '형식에 맞지 않는 번호입니다.',\n    INTERESTS: '3개 이상의 관심사를 입력하세요.'\n  },\n  DUPLICATE: {\n    ID: '이미 사용 중인 아이디입니다.',\n    EMAIL: '이미 사용 중인 이메일입니다.',\n    PHONE_NUMBER: '이미 사용 중인 휴대전화입니다.'\n  }\n};\nconst ALERT_MESSAGE = {\n  RESET: '모든 내용을 새로 작성하시겠습니까?',\n  JOIN_INVALID: {\n    ID: '아이디를 확인해주세요.',\n    PASSWORD: '비밀번호를 확인해주세요.',\n    NAME: '이름을 확인해주세요.',\n    BIRTH_DATE: '생년월일을 확인해주세요.',\n    GENDER: '성별을 확인해주세요.',\n    EMAIL: '이메일을 확인해주세요.',\n    PHONE_NUMBER: '휴대전화를 확인해주세요.',\n    INTERESTS: '관심사를 확인해주세요.',\n    CLAUSES: '약관에 동의하지 않으셨습니다.'\n  },\n  JOIN_FAIL: '회원가입에 살패했습니다! 다시 시도해주세요.',\n  LOGIN_FAIL: '아이디 또는 비밀번호를 다시 확인해주세요.'\n};\nconst FORM_RULES = {\n  YEAR_MAX_LENGTH: 4,\n  DAY_MIN_LENGTH: 1,\n  DAY_MAX_LENGTH: 2,\n  AGE_MIN: 14,\n  AGE_MAX: 99,\n  NOT_DIGIT: 10,\n  INTERESTS_MIN: 3,\n  ACTIVE_KEY: 'active'\n};\nconst STATUS = {\n  SUCCESS: 200,\n  CONFLICT: 409\n};\n\n//# sourceURL=webpack:///./src/js/constants/constant.js?");

/***/ }),

/***/ "./src/js/constants/url.js":
/*!*********************************!*\
  !*** ./src/js/constants/url.js ***!
  \*********************************/
/*! exports provided: URL */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"URL\", function() { return URL; });\n// export const URL = {\n//     DEV: {\n//         ID_CHECK_API: 'https://signup-5-dev.herokuapp.com/duplicate?userId=',\n//         EMAIL_CHECK_API: 'https://signup-5-dev.herokuapp.com/duplicate?email=',\n//         PHONE_NUMBER_CHECK_API: 'https://signup-5-dev.herokuapp.com/duplicate?phone=',\n//         JOIN_API: 'https://signup-5-dev.herokuapp.com/join',\n//         LOGIN_API: 'https://signup-5-dev.herokuapp.com/login'\n//     },\n//     PROD: {}\n// }\nconst URL = {\n  DEV: {\n    ID_CHECK_API: '/duplicate?userId=',\n    EMAIL_CHECK_API: '/duplicate?email=',\n    PHONE_NUMBER_CHECK_API: '/duplicate?phone=',\n    JOIN_API: '/join',\n    LOGIN_API: '/login'\n  },\n  PROD: {}\n};\n\n//# sourceURL=webpack:///./src/js/constants/url.js?");

/***/ }),

/***/ "./src/js/http/request.js":
/*!********************************!*\
  !*** ./src/js/http/request.js ***!
  \********************************/
/*! exports provided: joinRequest, loginRequest, checkIdDuplicateRequest, checkEmailDuplicateRequest, checkPhoneNumberDuplicateRequest */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"joinRequest\", function() { return joinRequest; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"loginRequest\", function() { return loginRequest; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"checkIdDuplicateRequest\", function() { return checkIdDuplicateRequest; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"checkEmailDuplicateRequest\", function() { return checkEmailDuplicateRequest; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"checkPhoneNumberDuplicateRequest\", function() { return checkPhoneNumberDuplicateRequest; });\n/* harmony import */ var _constants_url_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../constants/url.js */ \"./src/js/constants/url.js\");\n/* harmony import */ var _constants_constant_js__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../constants/constant.js */ \"./src/js/constants/constant.js\");\n/* harmony import */ var _util_commonUtil_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../util/commonUtil.js */ \"./src/js/util/commonUtil.js\");\n\n\n\nconst fetchOption = {\n  method: 'POST',\n  mode: 'cors',\n  headers: {\n    'Content-Type': 'application/json'\n  }\n};\nconst HOST = 'http://' + window.location.host;\nfunction joinRequest(userData) {\n  const signupBlind = Object(_util_commonUtil_js__WEBPACK_IMPORTED_MODULE_2__[\"getElement\"])('#signup-blind');\n  Object(_util_commonUtil_js__WEBPACK_IMPORTED_MODULE_2__[\"classAdd\"])(signupBlind, _constants_constant_js__WEBPACK_IMPORTED_MODULE_1__[\"FORM_RULES\"].ACTIVE_KEY);\n  fetchOption.body = JSON.stringify(userData);\n  fetch(HOST + _constants_url_js__WEBPACK_IMPORTED_MODULE_0__[\"URL\"].DEV.JOIN_API, fetchOption).then(res => checkJoin(res, makeLoginData(userData)));\n}\n\nfunction makeLoginData(userData) {\n  const loginData = {};\n  loginData.userId = userData.userId;\n  loginData.password = userData.password;\n  return loginData;\n}\n\nfunction checkJoin(res, loginData) {\n  if (res.status === _constants_constant_js__WEBPACK_IMPORTED_MODULE_1__[\"STATUS\"].SUCCESS) loginRequest(loginData);else alert(_constants_constant_js__WEBPACK_IMPORTED_MODULE_1__[\"ALERT_MESSAGE\"].JOIN_FAIL);\n}\n\nfunction loginRequest(loginData) {\n  fetchOption.body = JSON.stringify(loginData);\n  fetch(HOST + _constants_url_js__WEBPACK_IMPORTED_MODULE_0__[\"URL\"].DEV.LOGIN_API, fetchOption).then(checkLogin);\n}\n\nfunction checkLogin(res) {\n  // if (res.status === STATUS.SUCCESS) window.location.href = './main.html'\n  if (res.status === _constants_constant_js__WEBPACK_IMPORTED_MODULE_1__[\"STATUS\"].SUCCESS) return;else alert(_constants_constant_js__WEBPACK_IMPORTED_MODULE_1__[\"ALERT_MESSAGE\"].LOGIN_FAIL);\n}\n\nfunction checkIdDuplicateRequest(id) {\n  return fetch(HOST + _constants_url_js__WEBPACK_IMPORTED_MODULE_0__[\"URL\"].DEV.ID_CHECK_API + id).then(checkDuplicate);\n}\nfunction checkEmailDuplicateRequest(email) {\n  return fetch(HOST + _constants_url_js__WEBPACK_IMPORTED_MODULE_0__[\"URL\"].DEV.EMAIL_CHECK_API + email).then(checkDuplicate);\n}\nfunction checkPhoneNumberDuplicateRequest(number) {\n  return fetch(HOST + _constants_url_js__WEBPACK_IMPORTED_MODULE_0__[\"URL\"].DEV.PHONE_NUMBER_CHECK_API + number).then(checkDuplicate);\n}\n\nfunction checkDuplicate(res) {\n  if (res.status === _constants_constant_js__WEBPACK_IMPORTED_MODULE_1__[\"STATUS\"].SUCCESS) return true;else if (res.status === _constants_constant_js__WEBPACK_IMPORTED_MODULE_1__[\"STATUS\"].CONFLICT) return false;\n}\n\n//# sourceURL=webpack:///./src/js/http/request.js?");

/***/ }),

/***/ "./src/js/login/loginMain.js":
/*!***********************************!*\
  !*** ./src/js/login/loginMain.js ***!
  \***********************************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _util_commonUtil_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../util/commonUtil.js */ \"./src/js/util/commonUtil.js\");\n/* harmony import */ var _http_request_js__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../http/request.js */ \"./src/js/http/request.js\");\n\n\nconst loginForm = Object(_util_commonUtil_js__WEBPACK_IMPORTED_MODULE_0__[\"getElement\"])('.login-form-wrap');\nconst signupBtn = Object(_util_commonUtil_js__WEBPACK_IMPORTED_MODULE_0__[\"getElement\"])('.signup-btn');\nloginForm.addEventListener('submit', loginBtnSubmitHandle);\nsignupBtn.addEventListener('click', signupBtnClickHandle);\n\nfunction loginBtnSubmitHandle(evt) {\n  evt.preventDefault();\n  Object(_http_request_js__WEBPACK_IMPORTED_MODULE_1__[\"loginRequest\"])(makeLoginData());\n}\n\nfunction makeLoginData() {\n  const loginFormData = new FormData(loginForm);\n  const loginData = {};\n\n  for (let [key, value] of loginFormData) {\n    loginData[key] = value;\n  }\n\n  return loginData;\n}\n\nfunction signupBtnClickHandle() {\n  window.location.href = './joinForm';\n}\n\n//# sourceURL=webpack:///./src/js/login/loginMain.js?");

/***/ }),

/***/ "./src/js/util/commonUtil.js":
/*!***********************************!*\
  !*** ./src/js/util/commonUtil.js ***!
  \***********************************/
/*! exports provided: getElement, getElements, classAdd, classRemove */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"getElement\", function() { return getElement; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"getElements\", function() { return getElements; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"classAdd\", function() { return classAdd; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"classRemove\", function() { return classRemove; });\nfunction getElement(target) {\n  return document.querySelector(target);\n}\nfunction getElements(target) {\n  return document.querySelectorAll(target);\n}\nfunction classAdd(target, className) {\n  target.classList.add(className);\n}\nfunction classRemove(target, className) {\n  target.classList.remove(className);\n}\n\n//# sourceURL=webpack:///./src/js/util/commonUtil.js?");

/***/ })

/******/ });