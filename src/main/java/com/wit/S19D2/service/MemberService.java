package com.wit.S19D2.service;

import com.wit.S19D2.entity.Member;
import com.wit.S19D2.entity.Role;
import com.wit.S19D2.repository.MemberRepository;
import com.wit.S19D2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired

    public MemberService(MemberRepository memberRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member register(String email, String password){
        Optional<Member> found= memberRepository.findByEmail(email);//member daha önce register olmuş mu kontrolü
        if(found.isPresent()){
            throw new RuntimeException("User with given email already exist,please login: "+email);
        }
        String encodedPasword=passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        List<Role> roleList = new ArrayList<>();
        roleList.add(userRole);

        Member member=new Member();
        member.setEmail(email);
        member.setPassword(encodedPasword);
        member.setAuthorities(roleList);
        return memberRepository.save(member);
    }
}
