import { FORM_RULES } from '../constants/constant.js';
import { getElement, classAdd, classRemove } from '../util/commonUtil.js';
import { signupData } from '../data/signupData.js';

export function openClauses(...elements) {
    elements.forEach(el => classAdd(el, FORM_RULES.ACTIVE_KEY));
}

export function closeClauses(...elements) {
    elements.forEach(el => classRemove(el, FORM_RULES.ACTIVE_KEY));
}

export function activeClausesAgreeBtn(clausesTextBox) {
    if (!(clausesTextBox.clientHeight + clausesTextBox.scrollTop >= clausesTextBox.scrollHeight)) return;
    const clausesAgreeBtn = getElement('.clauses-agree-btn');
    classAdd(clausesAgreeBtn, FORM_RULES.ACTIVE_KEY);
    clausesAgreeBtn.disabled = false;
}

export function clausesAgree(...elements) {
    const clausesAgreeCheckbox = getElement('.clauses-agree-checkbox');
    clausesAgreeCheckbox.checked = true;
    signupData.clausesAgree = true;
    closeClauses(...elements);
}