package com.example.demo.Dto;

import com.example.demo.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSaveDto {

private String location;
private LocalDate date;

@Builder
public Member toEntity(){
return Member.builder()
        .location(location)
        .date(date)
        .build();
}

}
