export function updateState(checkCallBackFunc, target, ...additional) {
    target.closest('.signup-content').querySelector('.state-text').innerHTML = checkCallBackFunc(target.value, ...additional);
}

export function updateStateInterests(checkCallBackFunc, event, ...additional) {
    event.target.closest('.signup-content').querySelector('.state-text').innerHTML = checkCallBackFunc(event, ...additional);
}