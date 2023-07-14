package com.example.demo.Service;

import com.example.demo.Dto.MemberSaveDto;
import com.example.demo.domain.Festival;
import com.example.demo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repository.FestivalRepository;
import com.example.demo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final FestivalRepository festivalRepository;
    /**
     * 회원가입
     */
    @Transactional //변경
    public Long join(MemberSaveDto memberSaveDto) {
        Member member = memberSaveDto.toEntity();
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getMember_id();
    }
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers =
                memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Festival> searchFestival(MemberSaveDto memberSaveDto){
        return festivalRepository.findFestival(memberSaveDto.toEntity());
    }



    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    /**
     * 회원 수정
     */
    @Transactional
    public void update(Long id, String name) {
//        Member member = memberRepository.findOne(id); //memberRepository에서 id로 찾아온 다음 / 영속성콘텍스트가 id를 DB에서 가져오고 member로 반환
//        member.setName(name); //member가 꺼내지면 setName으로 이름을 바꿔준다(변경감지에 의해서). 영속성컨텍스트가 플러쉬하고 DB가 트랜젝션 커밋
    }
}


