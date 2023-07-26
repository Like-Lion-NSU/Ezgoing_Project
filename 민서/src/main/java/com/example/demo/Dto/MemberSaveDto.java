package com.example.demo.Dto;

import com.example.demo.domain.Member;
//import com.example.demo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveDto {

    private String password;

private String location;
private LocalDate date;

@Builder
public Member toEntity(){
return Member.builder()
//        .location(location)
//        .date(date)
        .password(password)
        .build();
}

}
