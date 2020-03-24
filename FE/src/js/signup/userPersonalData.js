import { getElement } from '../util/commonUtil.js';
import { STATE_LOG, FORM_RULES } from '../constants/constant.js';

export function checkYear(year) {
    if (year.length !== FORM_RULES.YEAR_MAX_LENGTH) return STATE_LOG.INVALID.BIRTH_DATE.YEAR;
    return checkBirthDate();
}

export function checkDay(day) {
    if (day.length < FORM_RULES.DAY_MIN_LENGTH || day.length > FORM_RULES.DAY_MAX_LENGTH) return STATE_LOG.INVALID.BIRTH_DATE.DAY;
    return checkBirthDate();
}

export function checkBirthDate() {
    const inputYear = getElement('#birth-date-year').value;
    const inputMonth = getElement('#birth-date-month').value;
    const inputDay = getElement('#birth-date-day').value;
    const lastDay = new Date(inputYear, inputMonth, 0).getDate();

    if (!inputYear || !inputMonth || !inputDay) return STATE_LOG.VALID.BASE;
    if (lastDay < inputDay) return STATE_LOG.INVALID.BIRTH_DATE.BASE;
    if (!checkAge(inputYear, inputMonth, inputDay)) return STATE_LOG.INVALID.BIRTH_DATE.AGE;
    return STATE_LOG.VALID.BASE;
}

function checkAge(year, month, day) {
    const age = calcAge(year, month, day < FORM_RULES.NOT_DIGIT ? '0' + day : day);
    if (age < FORM_RULES.AGE_MIN || age > FORM_RULES.AGE_MAX) return false;
    return true;
}

function calcAge(year, month, day) {
    const date = new Date();
    const curYear = date.getFullYear();
    let curMonth = (date.getMonth() + 1);
    let curDay = date.getDate();
    if (curMonth < FORM_RULES.NOT_DIGIT) curMonth = '0' + curMonth;
    if (curDay < FORM_RULES.NOT_DIGIT) curDay = '0' + curDay;
    const curMonthDay = curMonth + curDay;
    const inputYear = year;
    const inputMonthDay = month + day;
    const age = curMonthDay < inputMonthDay ? curYear - inputYear - 1 : curYear - inputYear;
    return age;
}

export function checkEmail(email) {
    const checkEmail = email.search(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
    if (checkEmail) return STATE_LOG.INVALID.EMAIL;
    return STATE_LOG.VALID.BASE;
}

export function checkPhoneNumber(number) {
    const checkNumber = number.search(/^010\d{3,4}\d{4}$/);
    if (checkNumber) return STATE_LOG.INVALID.PHONE_NUMBER;
    return STATE_LOG.VALID.BASE;
}