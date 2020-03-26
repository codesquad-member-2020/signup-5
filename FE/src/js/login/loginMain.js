import { getElement } from '../util/commonUtil.js';
import { loginRequest } from '../http/request.js';

const loginForm = getElement('.login-form-wrap');
const signupBtn = getElement('.signup-btn');

loginForm.addEventListener('submit', loginBtnSubmitHandle);
signupBtn.addEventListener('click', signupBtnClickHandle);

function loginBtnSubmitHandle(evt) {
    evt.preventDefault();
    loginRequest(makeLoginData());
}

function makeLoginData() {
    const loginFormData = new FormData(loginForm);
    const loginData = {};
    for (let [key, value] of loginFormData) {
        loginData[key] = value;
    }
    return loginData;
}

function signupBtnClickHandle() {
    window.location.href = './signup.html';
}