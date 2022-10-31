package com.uom.candela.controller;

import com.uom.candela.dto.BookDTO;
import com.uom.candela.dto.MemberDTO;
import com.uom.candela.mapper.MemberMapper;
import com.uom.candela.model.Book;
import com.uom.candela.model.Member;
import com.uom.candela.service.BookService;
import com.uom.candela.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getMembers() {
        List<MemberDTO> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable("id") String memberId) {
        MemberDTO memberDTO = memberService.getMemberById(memberId);
        return ResponseEntity.ok(memberDTO);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.createMember(memberDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable("id") String memberId, @RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.updateMember(memberId, memberDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") String memberId) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.ok().build();
    }
}
