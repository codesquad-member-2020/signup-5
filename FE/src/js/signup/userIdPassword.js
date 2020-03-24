export function checkId(id) {
    const checkIdCondition = id.search(/^[a-z0-9-_]{5,20}$/);
    if (checkIdCondition) return '5~20자의 영문 소문자, 숫자와 특수기호(_)(-) 만 사용 가능합니다.';
    return '<span>사용 가능한 아이디입니다.</span>'
}

export function checkPassword(password) {
    const checkLength = password.search(/.{8,16}$/);
    if (checkLength) return '8자 이상 16자 이하로 입력해주세요.';

    const checkUpper = password.search(/^(?=.*[A-Z])/);
    if (checkUpper) return '영문 대문자를 최소 1자 이상 포함해주세요.';

    const checkNumber = password.search(/^(?=.*[0-9])/);
    if (checkNumber) return '숫자를 최소 1자 이상 포함해주세요.';

    const checkSpecial = password.replace(/[0-9]/g, '').search(/^((?=.*\d)|(?=.*\W))/);
    if (checkSpecial) return '특수문자를 최소 1자 이상 포함해주세요.';
    return '<span>안전한 비밀번호입니다.</span>';
}

export function recheckPassword(password, originPassword) {
    if (password !== originPassword) return '비밀번호가 일치하지 않습니다.';
    return '<span>비밀번호가 일치합니다.</span>';
}