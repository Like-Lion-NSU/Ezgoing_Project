const $inputId= document.querySelector("#id")
const $classId= document.querySelector(".id")
const userIcon = document.querySelector(".fa-user")

const $inputPass= document.querySelector("#pass")
const $classPass= document.querySelector(".pass")
const userLockIcon = document.querySelector(".fa-user-lock")

const $inputPass2= document.querySelector("#pass2")
const $classPass2= document.querySelector(".pass2")
const lockIcon = document.querySelector(".fa-lock")

const $inputName= document.querySelector("#name")
const $className= document.querySelector(".name")

const $inputBirth = document.querySelector("#birth")
const $classBirth= document.querySelector(".birth")

const $inputEmail = document.querySelector("#email")
const $classEmail= document.querySelector(".email")

const $inputPhone = document.querySelector("#phone")
const $classPhone= document.querySelector(".num")


const text0 = document.createElement('p');
const text1 = document.createElement('p');
const text2 = document.createElement('p');
const text3 = document.createElement('p');
const text4 = document.createElement('p');
const text5 = document.createElement('p');
const text6 = document.createElement('p');

const block_0 = document.querySelector(".flexId")
const block_1 = document.querySelector(".flexPass")
const block_2 = document.querySelector(".flexPass2")
const block_3 = document.querySelector(".flexName")
const block_4 = document.querySelector(".flexBirth")
const block_5=document.querySelector(".flexEmail")
const block_6=document.querySelector(".flexPhone")

function ID_CHECK(event){
    var regID = /^[a-z0-9_-]{5,20}$/;
    if(regID.test(event.target.value) === false) {
        text0.textContent = '5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.'
        text0.style.color = 'red'
        block_0.appendChild(text0)
        userIcon.classList.add('fail')
        $classId.classList.add('inputFail')
    } else {
        text0.remove()
        userIcon.classList.remove('fail')
        userIcon.classList.add('success')
        $classId.classList.remove('inputFail')
        $classId.classList.add('inputSuccess')
    }
}
function PWD_CHECK(event) {
    var regPass = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (regPass.test(event.target.value) === false) {
        text1.textContent = '8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요';
        text1.style.color = 'red';
        block_1.appendChild(text1);
        userLockIcon.classList.add('fail');
        $classPass.classList.add('inputFail');
    } else {
        text1.remove();
        userLockIcon.classList.remove('fail');
        userLockIcon.classList.add('success');
        $classPass.classList.remove('inputFail');
        $classPass.classList.add('inputSuccess');
    }

    if ($inputPass2.value.trim() !== '') {
        PWD_RECHECK(); // PWD_RECHECK 함수 호출
    }
}

function PWD_RECHECK() {
    const recheck = $inputPass2.value;
    const pwd_check = $inputPass.value; // pwd_check 값을 저장

    if (recheck !== pwd_check) {
        text2.textContent = '비밀번호가 일치하지 않습니다.';
        text2.style.color = 'red';
        block_2.appendChild(text2);
        lockIcon.classList.add('fail');
        $classPass2.classList.add('inputFail');
    } else {
        text2.remove();
        lockIcon.classList.remove('fail');
        lockIcon.classList.add('success');
        $classPass2.classList.remove('inputFail');
        $classPass2.classList.add('inputSuccess');
    }
}
function NAME_CHECK(event){
    var regName = /^[a-zA-Z가-힣]+$/;
    if(regName.test(event.target.value)===false){
        text3.textContent = '한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)'
        text3.style.color = 'red'
        block_3.appendChild(text3)
        $className.classList.add('inputFail')
    }
    else{
        text3.remove()
        $className.classList.remove('inputFail');
        $className.classList.add('inputSuccess');
    }
}
function BIRTH_CHECK(event){
    var regBirth = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\d|3[0-1])$/;
    if(regBirth.test(event.target.value)===false){
        text4.textContent = 'YYMMDD/생년월일 6글자를 바르게 입력해주세요.'
        text4.style.color = 'red'
        block_4.appendChild(text4)
        $classBirth.classList.add('inputFail')
    }
    else{
        text4.remove()
        $classBirth.classList.remove('inputFail');
        $classBirth.classList.add('inputSuccess');
    }
}

function EMAIL_CHECK(event){
    var regEmail=/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$/;
    if(regEmail.test(event.target.value)===false){
        text5.textContent = '이메일 주소를 다시 확인해주세요.'
        text5.style.color = 'red'
        block_5.appendChild(text5)
        $classEmail.classList.add('inputFail');
    } else {
        text5.remove()
        $classEmail.classList.remove('inputFail');
        $classEmail.classList.add('inputSuccess');
    }
}
function PHONE_CHECK(event){
    var regPhone=/^01(0|1|6|7|8|9)-\d{3,4}-\d{4}$/;
    if(regPhone.test(event.target.value)===false){
        text6.textContent = '휴대 전화 번호( - 하이픈 포함)를 다시 확인해주세요.'
        text6.style.color = 'red'
        block_6.appendChild(text6)
        $classPhone.classList.add('inputFail');
    } else {
        text6.remove()
        $classPhone.classList.remove('inputFail');
        $classPhone.classList.add('inputSuccess');
    }
}

$inputId.addEventListener("change", ID_CHECK)
$inputPass.addEventListener("change", PWD_CHECK)
$inputPass2.addEventListener("change", PWD_RECHECK)
$inputName.addEventListener("change", NAME_CHECK)
$inputBirth.addEventListener("change", BIRTH_CHECK)
$inputEmail.addEventListener("change",EMAIL_CHECK);
$inputPhone.addEventListener("change", PHONE_CHECK);


//값 보내기
// $submitBtn=document.querySelector('.submit');

// $submitBtn.addEventListener("click",register);
// function register() {
//     const req = {
//         id: $inputId.value,
//         pass: $inputPass.value,
//         pass2: $inputPass2.value,
//         name: $inputName.value,
//         year: $inputYear.value,
//         month: $inputMonth.value,
//         date: $inputDay.value,
//         email: $inputEmail.value,
//         num1: $inputNum1.value,
//         num2: $inputNum2.value,
//         num3: $inputNum3.value,
//     };

//     fetch("백엔드_URL", {
//         method: "POST", // 요청 메서드
//         body: JSON.stringify(req) // 전송할 데이터
//     })
//     .then(response => response.json()) // 백엔드로부터 받은 응답을 JSON 형식으로 파싱
//     .then(data => {
//         // 백엔드로부터 받은 응답에 대한 처리
//         console.log(data); // 예시로 받은 데이터를 콘솔에 출력
//     })
//     .catch(error => {
//         // 에러 처리
//         console.error("Error:", error);
//     });
// }

// document.getElementById("joinForm").addEventListener("submit", function(event) {
//     event.preventDefault(); // 이벤트 기본 동작 방지 (페이지 새로고침)
//     register(); // register 함수 호출
// });