import { ALERT_MESSAGE } from '../constants/constant.js';
import { getElement, getElements } from '../util/commonUtil.js';
import { resetSignupData, signupData, makeSignupJSON } from '../data/signupData.js';
import { resetTag } from './userInterests.js';
import { clausesAgreeBtnToggle } from './clauses.js';
import { joinRequest } from '../http/request.js';

export function signupResetBtnHandle() {
    if (!confirm(ALERT_MESSAGE.RESET)) return;
    const signupFormWrap = getElement('.signup-form-wrap');
    const stateText = getElements('.state-text');
    signupFormWrap.reset();
    stateText.forEach(el => el.innerHTML = '');
    clausesAgreeBtnToggle(false);
    resetSignupData();
    resetTag();
}

export function signupJoinBtnHandle() {
    for (let [key, value] of Object.entries(signupData)) {
        if (value) continue;
        notifyJoinError(key);
        return;
    }
    joinRequest(makeSignupJSON());
}

function notifyJoinError(key) {
    switch (key) {
        case "userId": alert(ALERT_MESSAGE.JOIN_INVALID.ID);
            break;
        case "password": alert(ALERT_MESSAGE.JOIN_INVALID.PASSWORD);
            break;
        case "passwordRecheck": alert(ALERT_MESSAGE.JOIN_INVALID.PASSWORD);
            break;
        case "name": alert(ALERT_MESSAGE.JOIN_INVALID.NAME);
            break;
        case "year": alert(ALERT_MESSAGE.JOIN_INVALID.BIRTH_DATE);
            break;
        case "month": alert(ALERT_MESSAGE.JOIN_INVALID.BIRTH_DATE);
            break;
        case "day": alert(ALERT_MESSAGE.JOIN_INVALID.BIRTH_DATE);
            break;
        case "sex": alert(ALERT_MESSAGE.JOIN_INVALID.GENDER);
            break;
        case "email": alert(ALERT_MESSAGE.JOIN_INVALID.EMAIL);
            break;
        case "phoneNumber": alert(ALERT_MESSAGE.JOIN_INVALID.PHONE_NUMBER);
            break;
        case "interest": alert(ALERT_MESSAGE.JOIN_INVALID.INTERESTS);
            break;
        case "clausesAgree": alert(ALERT_MESSAGE.JOIN_INVALID.CLAUSES);
    }
}