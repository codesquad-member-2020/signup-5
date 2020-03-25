import { getElement } from '../util/commonUtil.js';
import { updateState, updateStateInterests } from '../util/signupUtil.js';
import { checkId, checkPassword, recheckPassword } from './userIdPassword.js';
import { checkYear, checkDay, checkBirthDate, checkEmail, checkPhoneNumber, checkName, checkGender } from './userPersonalData.js';
import { addInterests, removeInterests, removeInterestsOnClick, resetTag } from './userInterests.js';
import { openClauses, closeClauses, activeClausesAgreeBtn, clausesAgree } from './clauses.js';
import { signupResetBtnHandle } from './signupButtons.js';

const signupFormWrap = getElement('.signup-form-wrap');
const clausesWrap = getElement('.clauses-wrap');
const clausesWrapBlind = getElement('#clauses-wrap-blind');
const signupInterests = getElement('#signup-interests');
const clausesTextBox = getElement('#clauses-text-box');
const tagUiWrap = getElement('#tag-ui-wrap');

export function signupEventInit() {
    signupFormWrap.addEventListener('input', formInputEventDelegate);
    signupFormWrap.addEventListener('change', formChageEventDelegate);
    signupFormWrap.addEventListener('click', formClickEventDelegate);

    signupInterests.addEventListener('keyup', (event) => updateStateInterests(addInterests, event, tagUiWrap, signupInterests));
    signupInterests.addEventListener('keydown', (event) => updateStateInterests(removeInterests, event, tagUiWrap, signupInterests));
    tagUiWrap.addEventListener('click', (event) => updateStateInterests(removeInterestsOnClick, event, tagUiWrap));
}

export function clausesEventInit() {
    clausesWrap.addEventListener('click', clausesClickEventDelegate);
    clausesTextBox.addEventListener('scroll', ({ target }) => activeClausesAgreeBtn(target));
}

function formInputEventDelegate({ target }) {
    switch (target.id) {
        case 'signup-password': updateState(checkPassword, target);
            break;
        case 'signup-password-recheck': updateState(recheckPassword, target, getElement('#signup-password').value);
            break;
        case 'signup-name': checkName(target.value);
            break;
        case 'signup-gender': checkGender(target.value);
            break;
        default: break;
    }
}

function formChageEventDelegate({ target }) {
    switch (target.id) {
        case 'signup-id': updateState(checkId, target);
            break;
        case 'birth-date-year': updateState(checkYear, target);
            break;
        case 'birth-date-month': updateState(checkBirthDate, target);
            break;
        case 'birth-date-day': updateState(checkDay, target);
            break;
        case 'signup-email': updateState(checkEmail, target);
            break;
        case 'signup-phone-number': updateState(checkPhoneNumber, target);
            break;
        default: break;
    }
}

function formClickEventDelegate({ target }) {
    switch (target.id) {
        case 'clauses-agree-text': openClauses(clausesWrapBlind, clausesWrap);
            break;
        case 'signup-reset-btn': signupResetBtnHandle(resetTag);
            break;
        default: break;
    }
}

function clausesClickEventDelegate({ target }) {
    switch (target.id) {
        case 'clauses-close-btn': closeClauses(clausesWrapBlind, clausesWrap);
            break;
        case 'clauses-agree-btn': clausesAgree(clausesWrapBlind, clausesWrap);
            break;
        default: break;
    }
}