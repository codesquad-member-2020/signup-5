import { getElement, classAdd, classRemove } from '../util/commonUtil.js';
import { FORM_RULES } from '../constants/constant.js';

const userInfoBtn = getElement('.user-info-btn');
const userInfo = getElement('.user-info');

userInfoBtn.addEventListener('click', () => {
    if (!userInfo.classList.contains(FORM_RULES.ACTIVE_KEY)) classAdd(userInfo, FORM_RULES.ACTIVE_KEY);
    else classRemove(userInfo, FORM_RULES.ACTIVE_KEY);
});