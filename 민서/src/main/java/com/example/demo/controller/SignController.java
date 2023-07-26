package com.example.demo.controller;

import com.example.demo.Dto.SignInResultDto;
import com.example.demo.Dto.SignUpResultDto;
import com.example.demo.Service.SignService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


//@RequestMapping("/sign-api")
@RequiredArgsConstructor
@Controller
public class SignController {

    private final Logger LOGGER = LoggerFactory.getLogger(SignController.class);
    private final SignService signService;

    @GetMapping("/sign-in")
    public String signIn1(Model model){
        model.addAttribute("SignInResultDto");
        return "member/loginForm";
    }

    @PostMapping(value = "/sign-in")
    public String signIn(
            @ApiParam(value = "id", required = true) @RequestParam String id,
            @ApiParam(value = "password", required = true) @RequestParam String password)
            throws RuntimeException{
        LOGGER.info("[SignIn] 로그인을 시도하고 있습니다. id : {} . pw : ****",id);
        SignInResultDto signInResultDto = signService.signIn(id, password);

        if(signInResultDto.getCode() == 0){
            LOGGER.info("[signIn] 정상적으로 로그인 되었습니다. id : {} token : {}", id);
            signInResultDto.getToken();
        }
        return "member/index1";
    }

    @GetMapping("/sign-up")
    public String signUp1(Model model){
        model.addAttribute("SignUpResultDto");
        return "member/join";
    }

    @PostMapping(value = "/sign-up")
    public String signUp(
            @ApiParam(value = "ID", required = true ) @RequestParam String id,
            @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "권한", required = true) @RequestParam String role,
            @ApiParam(value = "전화번호", required = true) @RequestParam String phoneNum,
            @ApiParam(value = "생년월일", required = true ) @RequestParam String birthDay,
            @ApiParam(value = "이메일", required = true ) @RequestParam String email){
        LOGGER.info("[signUp] 회원가입을 수행합니다. id : {} , password : ****, name : {} , role : {} ", id, name, role);
        SignUpResultDto signUpResultDto = signService.signUp(id, password, name, role,phoneNum,birthDay,email);

        LOGGER.info("[signUp] 회원가입을 완료했습니다. id : {}" ,id);
        return "member/loginForm";
    }

    @GetMapping(value = "/exception")
    public void exceptionTest() throws RuntimeException{
        throw new RuntimeException("접근이 금지되었습니다.");
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String ,String >> ExceptionHandler(RuntimeException e){
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.error("ExceptionHandler 호출, {}, {}", e.getCause(), e.getMessage());

        Map<String, String > map = new HashMap<>();

        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }

//    @GetMapping("/user/login")
//    public String login(@RequestParam String username, @RequestParam String password, Model model) {
//        // TODO: 로그인 처리를 수행하고 결과를 SignUpResultDto로 받아옴 (예시로 세팅)
//        SignUpResultDto resultDto = new SignUpResultDto(true, 200, "로그인 성공");
//
//        // 결과 메시지를 모델에 추가하여 HTML에 표시
//        model.addAttribute("result", resultDto.getMsg());
//
//        // 로그인 성공 시 메인 페이지 또는 다른 페이지로 리다이렉트
//        if (result   Dto.isSuccess()) {
//            return "redirect:/main"; // 로그인 성공 시 리다이렉트할 URL
//        } else {
//            return "redirect:/user/login"; // 로그인 실패 시 리다이렉트할 URL
//        }
//    }

//   @GetMapping("/join")
//    public String join(){
//        return "member/join";
//    }
//
//        @GetMapping("/join")
//    public String showLoginForm(SignUpResultDto signUpResultDto) {
//
//        return "/member/member/login";
//    }


}
