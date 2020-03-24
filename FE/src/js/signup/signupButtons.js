import { getElement, getElements } from '../util/commonUtil.js';
import { ALERT_LOG } from '../constants/constant.js';

export function signupResetBtnHandle(resetTag) {
    if (confirm(ALERT_LOG.RESET)) {
        const signupFormWrap = getElement('.signup-form-wrap');
        signupFormWrap.reset();
        resetTag();

        const stateText = getElements('.state-text');
        stateText.forEach(el => el.innerHTML = '');
    }
}


// 가입하기