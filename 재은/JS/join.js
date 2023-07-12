const $inputId= document.querySelector("#id")


const text0 = document.createElement('p');

const block_0 = document.querySelector(".id1")

function ID_CHECK(event){
    var regID = /^[a-z0-9_-]{5,20}$/;
    if(regID.test(event.target.value) === false) {
        text0.textContent = '5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.'
        text0.style.color = 'red'
        block_0.appendChild(text0)
    } else {
        text0.remove()
    }
}

$inputId.addEventListener("change", ID_CHECK)