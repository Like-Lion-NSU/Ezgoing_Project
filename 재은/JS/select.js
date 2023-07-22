const selectBtn = document.querySelector('.btn')
const selectInner = document.querySelector('.selectContainer')

selectBtn.addEventListener('click',function(event){
    event.stopPropagation() 
    if(selectInner.classList.contains('show')){
        hideSelect()
    }else{
        showSelect()
    }
})
selectInner.addEventListener('click',function(event){
    event.stopPropagation() //막아주지 않으면 select 내부를 클릭한 것도 basketStarter를 클릭한 것이 됨  
})
window.addEventListener('click',function(){
    hideSelect()
})

function showSelect(){
    selectInner.classList.add('show')
}
function hideSelect(){
    selectInner.classList.remove('show')
}



// 현재 날짜를 구하는 함수
  function getCurrentDate() {
    var today = new Date();
    var year = today.getFullYear();
    var month = String(today.getMonth() + 1).padStart(2, '0');
    var day = String(today.getDate()).padStart(2, '0');
    return year + "-" + month + "-" + day;
  }

  // 최소값(min)을 현재 날짜로 설정
  document.getElementById("dateInput").setAttribute("min", getCurrentDate());

  //인원수 증감
  let counter=0;
  const minusBtn=document.getElementById("minus");
  const plusBtn=document.getElementById("plus");
  const person=document.getElementById("person");
  function minusClick(){
    counter-=1;
    if(counter<0) {
        counter=0;
    }
    person.innerText=`${counter}`
}
  function plusClick(){
    counter+=1;
    person.innerText=`${counter}`
  }
  minusBtn.addEventListener("click",minusClick);
  plusBtn.addEventListener("click",plusClick);
  // 끝나는 시간이 시작 시간보다 빠르지 않도록 검사하는 함수
  function validateEndTime() {
    var startTimeInput = document.getElementById("startTimeInput").value;
    var endTimeInput = document.getElementById("endTimeInput").value;

    if (endTimeInput < startTimeInput) {
      document.getElementById("endTimeInput").value = startTimeInput;
    }
  }
  function changeEndTime() {
    var startTimeInput = document.getElementById("startTimeInput").value;
    var endTimeInput = document.getElementById("endTimeInput").value;

    if (endTimeInput < startTimeInput) {
      document.getElementById("endTimeInput").value = startTimeInput;
      alert("마치는 시간은 시작시간보다 늦어야 합니다.")
    }
  }

  // 끝나는 시간이 시작 시간보다 빠르지 않도록 검사
  document.getElementById("startTimeInput").addEventListener("input", validateEndTime);
  document.getElementById("endTimeInput").addEventListener("change", changeEndTime);
