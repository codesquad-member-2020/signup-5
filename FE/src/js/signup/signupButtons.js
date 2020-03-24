import { getElement, getElements } from '../util/commonUtil.js';

export function signupResetBtnHandle(resetTag) {
    if (confirm('모든 내용을 새로 작성하시겠습니까?')) {
        const signupFormWrap = getElement('.signup-form-wrap');
        signupFormWrap.reset();
        resetTag();

        const stateText = getElements('.state-text');
        stateText.forEach(el => el.innerHTML = '');
    }
}