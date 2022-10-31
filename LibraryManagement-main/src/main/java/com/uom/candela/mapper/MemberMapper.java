package com.uom.candela.mapper;

import com.uom.candela.dto.MemberDTO;
import com.uom.candela.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    public MemberDTO memberToMemberDto(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setName(member.getName());
        memberDTO.setFaculty(member.getFaculty());

        return memberDTO;
    }

    public Member memberDtoToMember(MemberDTO memberDTO) {
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setName(memberDTO.getName());
        member.setFaculty(memberDTO.getFaculty());

        return member;
    }

    public List<MemberDTO> membersToMemberDtos(List<Member> members) {
        return members.stream().map(this::memberToMemberDto).collect(Collectors.toList());
    }
}
