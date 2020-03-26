import { URL } from '../constants/url.js';
import { FORM_RULES, ALERT_MESSAGE, STATUS } from '../constants/constant.js';
import { getElement, classAdd } from '../util/commonUtil.js';

export function joinRequest(data) {
    const signupBlind = getElement('#signup-blind');
    classAdd(signupBlind, FORM_RULES.ACTIVE_KEY);

    fetch(URL.DEV.JOIN_API, {
        method: 'POST',
        mode: 'cors',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data),
    })
        .then(checkJoin);
}

function checkJoin(res) {
    if (res.status === STATUS.SUCCESS) window.location.href = './main.html'
    else {
        alert(ALERT_MESSAGE.JOIN_FAIL);
        window.location.reload();
    }
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