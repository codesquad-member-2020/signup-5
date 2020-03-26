import { getElement } from '../util/commonUtil.js';
import { updateState, updateStateInterests } from '../util/signupUtil.js';
import { checkId, checkPassword, recheckPassword } from './userIdPassword.js';
import { checkYear, checkMonth, checkDay, checkEmail, checkPhoneNumber, checkName, checkGender } from './userPersonalData.js';
import { addInterests, removeInterests, removeInterestsOnClick } from './userInterests.js';
import { openClauses, closeClauses, activeClausesAgreeBtn, clausesAgree } from './clauses.js';
import { signupResetBtnHandle, signupJoinBtnHandle } from './signupButtons.js';

const signupFormWrap = getElement('.signup-form-wrap');
const clausesWrap = getElement('.clauses-wrap');
const signupBlind = getElement('#signup-blind');
const signupInterests = getElement('#signup-interests');
const clausesTextBox = getElement('#clauses-text-box');
const tagUiWrap = getElement('#tag-ui-wrap');

export function initSignupEvent() {
    signupFormWrap.addEventListener('input', formInputEventDelegation);
    signupFormWrap.addEventListener('change', formChageEventDelegation);
    signupFormWrap.addEventListener('click', formClickEventDelegation);

    signupInterests.addEventListener('keyup', (event) => updateStateInterests(addInterests, event, tagUiWrap, signupInterests));
    signupInterests.addEventListener('keydown', (event) => updateStateInterests(removeInterests, event, tagUiWrap, signupInterests));
    tagUiWrap.addEventListener('click', (event) => updateStateInterests(removeInterestsOnClick, event, tagUiWrap));
}

export function initClausesEvent() {
    clausesWrap.addEventListener('click', clausesClickEventDelegation);
    clausesTextBox.addEventListener('scroll', ({ target }) => activeClausesAgreeBtn(target));
}

function formInputEventDelegation({ target }) {
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

function formChageEventDelegation({ target }) {
    switch (target.id) {
        case 'signup-id': updateState(checkId, target);
            break;
        case 'birth-date-year': updateState(checkYear, target);
            break;
        case 'birth-date-month': updateState(checkMonth, target);
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

function formClickEventDelegation({ target }) {
    switch (target.id) {
        case 'clauses-agree-text': openClauses(signupBlind, clausesWrap);
            break;
        case 'signup-reset-btn': signupResetBtnHandle();
            break;
        case 'signup-join-btn': signupJoinBtnHandle();
            break;
        default: break;
    }
}

function clausesClickEventDelegation({ target }) {
    switch (target.id) {
        case 'clauses-close-btn': closeClauses(signupBlind, clausesWrap);
            break;
        case 'clauses-agree-btn': clausesAgree(signupBlind, clausesWrap);
            break;
        default: break;
    }
}