package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class SignUpResultDto {
    private boolean success;
    private int code;
    private String msg;
}
