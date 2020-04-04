import { FORM_RULES } from '../constants/constant.js';
import { getElement, classAdd, classRemove } from '../util/commonUtil.js';
import { signupData } from '../data/signupData.js';

export function openClauses(...elements) {
    elements.forEach(el => classAdd(el, FORM_RULES.ACTIVE_KEY));
    const clausesTextBox = getElement('#clauses-text-box');
    clausesTextBox.scrollTop = 0;
}

export function closeClauses(...elements) {
    elements.forEach(el => classRemove(el, FORM_RULES.ACTIVE_KEY));
}

export function activeClausesAgreeBtn(clausesTextBox) {
    if (!(clausesTextBox.clientHeight + clausesTextBox.scrollTop >= clausesTextBox.scrollHeight)) return;
    clausesAgreeBtnToggle(true);
}

export function clausesAgree(...elements) {
    const clausesAgreeCheckbox = getElement('.clauses-agree-checkbox');
    clausesAgreeCheckbox.checked = true;
    signupData.clausesAgree = true;
    closeClauses(...elements);
}

export function clausesAgreeBtnToggle(isActive) {
    const clausesAgreeBtn = getElement('.clauses-agree-btn');
    if (isActive) classAdd(clausesAgreeBtn, FORM_RULES.ACTIVE_KEY);
    else classRemove(clausesAgreeBtn, FORM_RULES.ACTIVE_KEY);
    clausesAgreeBtn.disabled = !isActive;
}