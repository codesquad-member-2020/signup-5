import { STATE_LOG } from '../constants/constant.js';

export function checkId(id) {
    const checkIdCondition = id.search(/^[a-z0-9-_]{5,20}$/);
    if (checkIdCondition) return STATE_LOG.INVALID.ID;
    return STATE_LOG.VALID.ID;
}

export function checkPassword(password) {
    const checkLength = password.search(/.{8,16}$/);
    if (checkLength) return STATE_LOG.INVALID.PASSWORD.LENGTH;

    const checkUpper = password.search(/^(?=.*[A-Z])/);
    if (checkUpper) return STATE_LOG.INVALID.PASSWORD.UPPER;

    const checkNumber = password.search(/^(?=.*[0-9])/);
    if (checkNumber) return STATE_LOG.INVALID.PASSWORD.NUMBER;

    const checkSpecial = password.replace(/[0-9]/g, '').search(/^((?=.*\d)|(?=.*\W))/);
    if (checkSpecial) return STATE_LOG.INVALID.PASSWORD.SPECIAL;
    return STATE_LOG.VALID.PASSWORD;
}

export function recheckPassword(password, originPassword) {
    if (password !== originPassword) return STATE_LOG.INVALID.PASSWORD_RECHECK;
    return STATE_LOG.VALID.PASSWORD_RECHECK;
}