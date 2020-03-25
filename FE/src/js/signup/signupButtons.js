import { getElement, getElements } from '../util/commonUtil.js';
import { ALERT_MESSAGE } from '../constants/constant.js';

export function signupResetBtnHandle(resetTag) {
    if (!confirm(ALERT_MESSAGE.RESET)) return;
    const signupFormWrap = getElement('.signup-form-wrap');
    const stateText = getElements('.state-text');
    signupFormWrap.reset();
    stateText.forEach(el => el.innerHTML = '');
    resetTag();
}


// 가입하기