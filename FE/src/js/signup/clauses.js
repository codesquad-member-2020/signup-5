import { getElement, classAdd, classRemove } from '../util/commonUtil.js';

export function openClauses(...elements) {
    elements.forEach(el => classAdd(el, 'active'));
}

export function closeClauses(...elements) {
    elements.forEach(el => classRemove(el, 'active'));
}

export function activeClausesAgreeBtn(clausesTextBox) {
    if (!(clausesTextBox.clientHeight + clausesTextBox.scrollTop >= clausesTextBox.scrollHeight)) return;
    const clausesAgreeBtn = getElement('.clauses-agree-btn');
    classAdd(clausesAgreeBtn, 'active');
    clausesAgreeBtn.disabled = false;
}

export function clausesAgree(...elements) {
    const clausesAgreeCheckbox = getElement('.clauses-agree-checkbox');
    clausesAgreeCheckbox.checked = true;
    closeClauses(...elements);
}