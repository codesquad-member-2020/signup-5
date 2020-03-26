import { URL } from '../constants/url.js';
import { FORM_RULES, ALERT_MESSAGE, STATUS } from '../constants/constant.js';
import { getElement, classAdd } from '../util/commonUtil.js';

const fetchOption = {
    method: 'POST',
    mode: 'cors',
    headers: { 'Content-Type': 'application/json' },
};

export function joinRequest(userData) {
    const signupBlind = getElement('#signup-blind');
    classAdd(signupBlind, FORM_RULES.ACTIVE_KEY);
    fetchOption.body = JSON.stringify(userData);
    fetch(URL.DEV.JOIN_API, fetchOption)
        .then(res => checkJoin(res, makeLoginData(userData)));
}

function makeLoginData(userData) {
    const loginData = {};
    loginData.userId = userData.userId;
    loginData.password = userData.password;
    return loginData;
}

function checkJoin(res, loginData) {
    if (res.status === STATUS.SUCCESS) loginRequest(loginData);
    else alert(ALERT_MESSAGE.JOIN_FAIL);
}

export function loginRequest(loginData) {
    fetchOption.body = JSON.stringify(loginData);
    fetch(URL.DEV.LOGIN_API, fetchOption)
        .then(checkLogin);
}

function checkLogin(res) {
    if (res.status === STATUS.SUCCESS) window.location.href = './main.html'
    else alert(ALERT_MESSAGE.LOGIN_FAIL);
}

export function checkIdDuplicateRequest(id) {
    return fetch(URL.DEV.ID_CHECK_API + id)
        .then(checkDuplicate);
}

export function checkEmailDuplicateRequest(email) {
    return fetch(URL.DEV.EMAIL_CHECK_API + email)
        .then(checkDuplicate);
}

export function checkPhoneNumberDuplicateRequest(number) {
    return fetch(URL.DEV.PHONE_NUMBER_CHECK_API + number)
        .then(checkDuplicate);
}

function checkDuplicate(res) {
    if (res.status === STATUS.SUCCESS) return true;
    else if (res.status === STATUS.CONFLICT) return false;
}