export async function updateState(checkCallBackFunc, target, ...additional) {
    let stateMessage = checkCallBackFunc(target.value, ...additional);
    if (typeof stateMessage === 'object') stateMessage = await stateMessage.then(res => res);
    if (!stateMessage) stateMessage = '';
    target.closest('.signup-content').querySelector('.state-text').innerHTML = stateMessage;
}

export function updateStateInterests(checkCallBackFunc, event, ...additional) {
    let stateMessage = checkCallBackFunc(event, ...additional);
    if (!stateMessage) return;
    event.target.closest('.signup-content').querySelector('.state-text').innerHTML = stateMessage;
}