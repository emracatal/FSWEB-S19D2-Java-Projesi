package com.wit.S19D2.controller;

import com.wit.S19D2.dto.RegistrationMember;
import com.wit.S19D2.entity.Member;
import com.wit.S19D2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private MemberService memberService;

    @Autowired

    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember) {
        return memberService.register(registrationMember.email(), registrationMember.password());
    }
}
