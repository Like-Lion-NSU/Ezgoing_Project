const idIcon = document.querySelector('.fa-user')
const passIcon = document.querySelector('.fa-lock')

const inputId=document.querySelector('.login_input_id')
const inputPass=document.querySelector('.login_input_pass')

inputId.addEventListener('click',function(event){
    idIcon.classList.add('iconColor')
    passIcon.classList.remove('iconColor')
    event.stopPropagation()
})
window.addEventListener('click',function(){
    idIcon.classList.remove('iconColor')
    passIcon.classList.remove('iconColor')
})

inputPass.addEventListener('click',function(event){
    idIcon.classList.remove('iconColor')
    passIcon.classList.add('iconColor')
    event.stopPropagation()
})