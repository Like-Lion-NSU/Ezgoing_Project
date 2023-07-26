package com.example.demo.domain;

import com.example.demo.Dto.MemberDto;
import com.example.demo.MemberDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table

public class Member implements MemberDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String uid;

    @Column(nullable = false)
    private String emaill;

    @Column(nullable = false)
    private String phoneNum;

    @Column(nullable = false)
    private String birthDay;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;
//    private LocalDate m_date;
//    private String m_location;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    // 계정의 가지고 있는 권한 목록을 리턴
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    // 계정의 이름 리턴
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getUsername(){
        return this.uid;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }




    // 계정이 만료됐는지 리턴 true는 만료되지 않았다는 의미
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpried(){
        return true;
    }

    // 계정이 잠겨있는지 리턴  true는 잠기지 않았다는 의미
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    // 비밀번호가 만료되었는지 리턴 true는 만료되지 않았다는 의미
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    // 계정이 활성화돼 있는지 리턴 true는 활성화 상태
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled(){
        return true;
    }

    @Builder

    public Member(String name, String uid, String password, List<String> roles, String phoneNum, String emaill, String birthDay){
        this.name =name;
        this.uid=uid;
        this.password = password;
        this.roles = roles;
        this.emaill = emaill;
        this.phoneNum = phoneNum;
        this.birthDay = birthDay;
    }

//    public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
//        Member member = Member.builder()
//                .name(memberDto.getName())
//                .uid(memberDto.getUid())
//                .password(passwordEncoder.encode(memberDto.getPassword()))  //암호화처리
////                .roles(MemberRole.USER)
//                .build();
//        return member;
//    }
}
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Festival> festivals = new ArrayList<>();
//





