import { getElement } from '../util/commonUtil.js';

export function checkYear(year) {
    if (year.length !== 4) return '태어난 년도 4자리를 정확하게 입력하세요.';
    return checkBirthDate();
}

export function checkDay(day) {
    if (day.length < 1 || day.length > 2) return '태어난 날짜를 정확하게 입력하세요.';
    return checkBirthDate();
}

export function checkBirthDate() {
    const inputYear = getElement('#birth-date-year').value;
    const inputMonth = getElement('#birth-date-month').value;
    const inputDay = getElement('#birth-date-day').value;
    const lastDay = new Date(inputYear, inputMonth, 0).getDate();

    if (!inputYear || !inputMonth || !inputDay) return '';
    if (lastDay < inputDay) return '태어난 날짜를 다시 확인해주세요.';
    if (!checkAge(inputYear, inputMonth, inputDay)) return '만 14세 이상 99세 이하만 가입 가능합니다.';
    return '';
}

function checkAge(year, month, day) {
    const age = calcAge(year, month, day < 10 ? '0' + day : day);
    if (age < 14 || age > 99) return false;
    return true;
}

function calcAge(year, month, day) {
    const date = new Date();
    const curYear = date.getFullYear();
    let curMonth = (date.getMonth() + 1);
    let curDay = date.getDate();
    if (curMonth < 10) curMonth = '0' + curMonth;
    if (curDay < 10) curDay = '0' + curDay;
    const curMMDD = curMonth + curDay;
    const YYYY = year;
    const MMDD = month + day;
    const age = curMMDD < MMDD ? curYear - YYYY - 1 : curYear - YYYY;
    return age;
}

export function checkEmail(email) {
    const checkEmail = email.search(/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);
    if (checkEmail) return '이메일 주소를 다시 확인해주세요.';
    return '';
}

export function checkPhoneNumber(number) {
    const checkNumber = number.search(/^010\d{3,4}\d{4}$/);
    if (checkNumber) return '형식에 맞지 않는 번호입니다.';
    return '';
}