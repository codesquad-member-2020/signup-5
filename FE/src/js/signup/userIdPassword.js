import { VALID_CHECK_REGEX, STATE_MESSAGE } from '../constants/constant.js';
import { signupData } from '../data/signupData.js';
import { checkIdDuplicateRequest } from '../http/request.js';

export async function checkId(id) {
    signupData.userId = null;
    const checkIdCondition = id.search(VALID_CHECK_REGEX.ID);
    if (checkIdCondition) return STATE_MESSAGE.INVALID.ID;
    if (!await checkIdDuplicateRequest(id).then(res => res)) return STATE_MESSAGE.DUPLICATE.ID;
    signupData.userId = id;
    return STATE_MESSAGE.VALID.ID;
}

export function checkPassword(password) {
    signupData.password = null;
    const checkLength = password.search(VALID_CHECK_REGEX.PASSWORD.LENGTH);
    if (checkLength) return STATE_MESSAGE.INVALID.PASSWORD.LENGTH;

    const checkUpper = password.search(VALID_CHECK_REGEX.PASSWORD.UPPER);
    if (checkUpper) return STATE_MESSAGE.INVALID.PASSWORD.UPPER;

    const checkNumber = password.search(VALID_CHECK_REGEX.PASSWORD.NUMBER);
    if (checkNumber) return STATE_MESSAGE.INVALID.PASSWORD.NUMBER;

    const checkSpecial = password.replace(/[0-9]/g, '').search(VALID_CHECK_REGEX.PASSWORD.SPECIAL);
    if (checkSpecial) return STATE_MESSAGE.INVALID.PASSWORD.SPECIAL;
    signupData.password = password;
    return STATE_MESSAGE.VALID.PASSWORD;
}

export function recheckPassword(password, originPassword) {
    signupData.passwordRecheck = null;
    if (password !== originPassword) return STATE_MESSAGE.INVALID.PASSWORD_RECHECK;
    signupData.passwordRecheck = password;
    return STATE_MESSAGE.VALID.PASSWORD_RECHECK;
}