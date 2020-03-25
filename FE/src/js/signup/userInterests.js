import { STATE_MESSAGE, FORM_RULES } from '../constants/constant.js';
import { getElements } from '../util/commonUtil.js';
import { signupData } from '../data/signupData.js';

const tags = [];

export function addInterests({ key }, tagUiWrap, signupInterests) {
    if (key !== ',') return;
    const interest = signupInterests.value.replace(/[,]/g, '');
    signupInterests.value = '';
    if (!interest) return;
    tags.push(interest);
    return updateTag(tagUiWrap);
}

export function removeInterests({ key }, tagUiWrap, signupInterests) {
    if (!checkRemoveCondition(key, signupInterests)) return;
    signupInterests.value = tags.pop() + ' ';
    return updateTag(tagUiWrap);
}

function checkRemoveCondition(key, signupInterests) {
    if (tags.length > 0 && signupInterests.value === '' && (key === 'Backspace' || key === 'Delete')) return true;
    return false;
}

export function removeInterestsOnClick({ target }, tagUiWrap) {
    if (!target.classList.contains('tag-ui-close')) return;
    const data = target.getAttribute('data-item');
    const index = tags.indexOf(data);
    tags.splice(index, 1);
    return updateTag(tagUiWrap);
}

export function resetTag() {
    getElements('.tag-ui').forEach(tag => tag.parentElement.removeChild(tag));
}

function checkInterests() {
    signupData.interest = null;
    if (tags.length < FORM_RULES.INTERESTS_MIN) return STATE_MESSAGE.INVALID.INTERESTS;
    signupData.interest = tags;
    return STATE_MESSAGE.VALID.DEFALUT;
}

function createTag(interest) {
    const tag = document.createElement('span');
    tag.setAttribute('class', 'tag-ui');
    tag.innerHTML = `${interest}<span class="tag-ui-close" data-item="${interest}">✖</span>`;
    return tag;
}

function updateTag(tagUiWrap) {
    resetTag();
    tags.slice().reverse().forEach(tag => tagUiWrap.prepend(createTag(tag)));
    return checkInterests();
}