export const signupData = {
    userId: null,
    password: null,
    passwordRecheck: null,
    name: null,
    year: null,
    month: null,
    day: null,
    sex: null,
    email: null,
    phoneNumber: null,
    interest: null,
    clausesAgree: null
}

const signupJSON = {
    userId: null,
    password: null,
    name: null,
    birthday: null,
    sex: null,
    email: null,
    phoneNumber: null,
    interest: null
}

export function makeSignupJSON() {
    signupJSON.userId = signupData.userId;
    signupJSON.password = signupData.password;
    signupJSON.name = signupData.name;
    signupJSON.birthday = `${signupData.year}-${signupData.month}-${signupData.day}`;
    signupJSON.sex = signupData.sex;
    signupJSON.email = signupData.email;
    signupJSON.phoneNumber = signupData.phoneNumber;
    signupJSON.interest = signupData.interest.join(', ');
    return signupJSON;
}

export function resetSignupData() {
    for (let key in signupData) {
        signupData[key] = null;
    }
}