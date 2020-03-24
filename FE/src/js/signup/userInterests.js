import { getElements } from '../util/commonUtil.js';

const tags = [];

export function addInterests({ key }, tagUiWrap, signupInterests) {
    if (key === ',') {
        const interest = signupInterests.value.replace(/[,]/g, '');
        signupInterests.value = '';
        if (!interest) return checkInterests();
        tags.push(interest);
        return updateTag(tagUiWrap);
    }
    return '';
}

export function removeInterests({ key }, tagUiWrap, signupInterests) {
    if (tags.length > 0 && signupInterests.value === '' && (key === 'Backspace' || key === 'Delete')) {
        signupInterests.value = tags.pop() + ' ';
        return updateTag(tagUiWrap);
    }
    return '';
}

export function removeInterestsOnClick({ target }, tagUiWrap) {
    if (target.classList.contains('tag-ui-close')) {
        const data = target.getAttribute('data-item');
        const index = tags.indexOf(data);
        tags.splice(index, 1);
        return updateTag(tagUiWrap);
    }
    return '';
}

export function resetTag() {
    getElements('.tag-ui').forEach(tag => tag.parentElement.removeChild(tag));
}

function checkInterests() {
    if (tags.length < 3) return '3개 이상의 관심사를 입력하세요.';
    return '';
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