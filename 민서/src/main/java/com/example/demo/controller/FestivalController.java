//package com.example.demo.controller;
//
//import com.example.demo.Service.FestivalService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//@RequiredArgsConstructor
//public class FestivalController {
//
//    private final FestivalService festivalService;
//    @GetMapping("/festivals") //축제 리스트 가져오기
//    public String getFestivalList(Model model) {
//        model.addAttribute("festivals", festivalService.getFestivals());
//        return "festivalList";
//    }
    //
//    @GetMapping("/festivals/{festivalId}")
//    public String getFestivalDetail(@PathVariable int festivalId, Model model) {
//        Festival festival = festivalService.getFestivalById(festivalId);
//        if (festival == null) {
//            // 축제가 존재하지 않을 경우 에러 처리 등을 수행하고 원하는 페이지로 이동
//            return "errorPage";
//        }
//        model.addAttribute("festival", festival);
//        return "festivalDetail";
//    }
//}
