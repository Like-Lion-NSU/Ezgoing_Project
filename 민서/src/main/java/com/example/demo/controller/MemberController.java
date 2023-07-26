//package com.example.demo.controller;
//
////import com.example.demo.Dto.MemberSaveDto;
////import com.example.demo.Service.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@Controller
//@RequiredArgsConstructor
//public class MemberController {
//
//    private final MemberService memberService;
//
//
//
//    @PostMapping("/login")
//    public String createForm(Model model){
//    model.addAttribute("memberSaveDto", new MemberSaveDto());
//    return "/member/loginForm";
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm(MemberSaveDto memberSaveDto) {
//        Long id = memberService.join(memberSaveDto);
//        return "/member/member/login";
//    }
//
//    @GetMapping("/gd")
//    public String list(Model model) {
//        List<Member> login = memberService.findMembers();
//        model.addAttribute("login", login);
//        return "login";
//    }
//
//}
