package com.example.demo.Dto;

import com.example.demo.MemberDetails;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberDto {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요")
    private String uid;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    private String password;

    @Builder
    public MemberDto(String name, String uid, String password){
        this.name=name;
        this.uid=uid;
        this.password=password;
    }
}
