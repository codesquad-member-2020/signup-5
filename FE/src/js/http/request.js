import { URL } from '../constants/url.js';
import { FORM_RULES, ALERT_MESSAGE, STATUS } from '../constants/constant.js';
import { getElement, classAdd } from '../util/commonUtil.js';

export function joinRequest(data) {
    const signupBlind = getElement('#signup-blind');
    classAdd(signupBlind, FORM_RULES.ACTIVE_KEY);

    const tempURL = URL.DEV.CORS_API + URL.DEV.JOIN_API;
    fetch(tempURL, {
        method: 'POST',
        mode: 'cors',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data),
    })
        .then(checkJoin);
}

function checkJoin(res) {
    if (res.status === STATUS.SUCCESS) window.location.href = './main.html'
    else {
        alert(ALERT_MESSAGE.JOIN_FAIL);
        window.location.reload();
    }
}