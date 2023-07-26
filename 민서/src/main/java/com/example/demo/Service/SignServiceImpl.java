package com.example.demo.Service;

import com.example.demo.Dto.SignInResultDto;
import com.example.demo.Dto.SignUpResultDto;
import com.example.demo.common.CommonResponse;
import com.example.demo.config.seurity.JwtTokenProvider;
import com.example.demo.domain.Member;
import com.example.demo.repository.JpaMemberRepositroy;
//import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignServiceImpl implements SignService{
    private final Logger LOGGER = LoggerFactory.getLogger(SignServiceImpl.class);


    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder;
    public JpaMemberRepositroy jpaMemberRepositroy;

    @Autowired
    public SignServiceImpl(JpaMemberRepositroy jpaMemberRepositroy, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder){
        this.jpaMemberRepositroy = jpaMemberRepositroy;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SignUpResultDto signUp(String id, String password, String name, String role, String phoneNum, String email, String birthDay ){
        LOGGER.info("[getSignUpResult] 회원 가입 정보 전달");
        Member member;
        if(role.equalsIgnoreCase("admin")){
            member = Member.builder()
                    .uid(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_ADMIN"))
                    .emaill(email)
                    .phoneNum(phoneNum)
                    .birthDay(birthDay)
                    .build();


        }else {
            member = Member.builder()
                    .uid(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_USER"))
                    .emaill(email)
                    .phoneNum(phoneNum)
                    .birthDay(birthDay)
                    .build();
        }

        Member saveMember = jpaMemberRepositroy.save(member);
        SignUpResultDto signUpResultDto = new SignUpResultDto();

        LOGGER.info("[getSignUpResul] memberEntity 값이 들어왔는지 확인 후 결과값 주입");
        if(!saveMember.getName().isEmpty()){
            LOGGER.info("[getSignUpResult] 정상 처리 완료");
            setSuccessResult(signUpResultDto);
        }
        else {
            LOGGER.info("[getSignUpResult] 실패 처리 완료");
            setFailResult(signUpResultDto);
        }
        return signUpResultDto;
    }

public SignInResultDto signIn(String id, String password) throws RuntimeException{
        LOGGER.info("[getSignInResult] signDataHandler 로 회원 정보 요청");
        Member member = jpaMemberRepositroy.getByUid(id);
        LOGGER.info("[getSignInResult] Id : {}",id);

        LOGGER.info("[getSignInResult] 패스워드 비교 수행");
        if(!passwordEncoder.matches(password, member.getPassword())){
            throw new RuntimeException();
        }
        LOGGER.info("[getSignInResult] 패스워드 일치");

        LOGGER.info("[getSignInResult] SignInResultDto 객체 생성");
        SignInResultDto signInResultDto = SignInResultDto.builder()
                .token(jwtTokenProvider.createToken(String.valueOf(member.getUid()), member.getRoles()))
                .build();

                LOGGER.info("[getSignInResult] SignInResultDto 객체에 값 주입");
                setSuccessResult(signInResultDto);

                return signInResultDto;
}

private void setSuccessResult(SignUpResultDto result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
}
private void setFailResult(SignUpResultDto result){
        result.setSuccess(false);
        result.setCode(CommonResponse.FAIL.getCode());
        result.setMsg(CommonResponse.FAIL.getMsg());
}


}
