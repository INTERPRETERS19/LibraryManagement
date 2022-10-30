package com.uom.candela.service;

import com.uom.candela.dto.BookDTO;
import com.uom.candela.dto.MemberDTO;
import com.uom.candela.mapper.MemberMapper;
import com.uom.candela.model.Book;
import com.uom.candela.model.Member;
import com.uom.candela.repository.BookRepository;
import com.uom.candela.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    public MemberDTO createMember(MemberDTO memberDTO) {
        memberDTO.setId(null);
        Member member = memberRepository.save(memberMapper.memberDtoToMember(memberDTO));
        return memberMapper.memberToMemberDto(member);
    }

    public MemberDTO getMemberById(String id) {
        return memberRepository.findById(id)
                .map(member -> memberMapper.memberToMemberDto(member))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public List<MemberDTO> getAllMembers() {
        return memberMapper.membersToMemberDtos(memberRepository.findAll());
    }

    public MemberDTO updateMember(String id, MemberDTO memberDTO) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (!memberOptional.isPresent()) throw new ResourceNotFoundException();

        Member member = memberMapper.memberDtoToMember(memberDTO);
        member.setId(memberOptional.get().getId());
        return memberMapper.memberToMemberDto(memberRepository.save(member));
    }

    public void deleteMemberById(String id) {
        memberRepository.deleteById(id);
    }
}
