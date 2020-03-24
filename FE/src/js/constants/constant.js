export const STATE_LOG = {
    VALID: {
        BASE: '',
        ID: '<span>사용 가능한 아이디입니다.</span>',
        PASSWORD: '<span>안전한 비밀번호입니다.</span>',
        PASSWORD_RECHECK: '<span>비밀번호가 일치합니다.</span>',
    },
    INVALID: {
        ID: '5~20자의 영문 소문자, 숫자와 특수기호(_)(-) 만 사용 가능합니다.',
        PASSWORD: {
            LENGTH: '8자 이상 16자 이하로 입력해주세요.',
            UPPER: '영문 대문자를 최소 1자 이상 포함해주세요.',
            NUMBER: '숫자를 최소 1자 이상 포함해주세요.',
            SPECIAL: '특수문자를 최소 1자 이상 포함해주세요.',
        },
        PASSWORD_RECHECK: '비밀번호가 일치하지 않습니다.',
        BIRTH_DATE: {
            BASE: '태어난 날짜를 다시 확인해주세요.',
            YEAR: '태어난 년도 4자리를 정확하게 입력하세요.',
            DAY: '태어난 날짜를 정확하게 입력하세요.',
            AGE: '만 14세 이상 99세 이하만 가입 가능합니다.'
        },
        EMAIL: '이메일 주소를 다시 확인해주세요.',
        PHONE_NUMBER: '형식에 맞지 않는 번호입니다.',
        INTERESTS: '3개 이상의 관심사를 입력하세요.'
    }
}

export const ALERT_LOG = {
    RESET: '모든 내용을 새로 작성하시겠습니까?'
}

export const FORM_RULES = {
    YEAR_MAX_LENGTH: 4,
    DAY_MIN_LENGTH: 1,
    DAY_MAX_LENGTH: 2,
    AGE_MIN: 14,
    AGE_MAX: 99,
    NOT_DIGIT: 10,
    INTERESTS_MIN: 3,
    ACTIVE_KEY: 'active'
}