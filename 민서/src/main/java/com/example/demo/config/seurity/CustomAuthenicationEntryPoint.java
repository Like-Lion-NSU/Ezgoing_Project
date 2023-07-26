package com.example.demo.config.seurity;

import com.example.demo.Dto.EntryPointErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class CustomAuthenicationEntryPoint implements AuthenticationEntryPoint {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenicationEntryPoint.class);

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        LOGGER.info("[commence] 인증 실패로 response.sendError 발생");

        EntryPointErrorResponse entryPointErrorResponse = new EntryPointErrorResponse();
        entryPointErrorResponse.setMsg("인증이 실패하였습니다.");

        response.setStatus(401);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(objectMapper.writer().writeValueAsString(entryPointErrorResponse));
    }
}
