package com.wit.S19D2.service;

import com.wit.S19D2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//Login için
public class UserService implements UserDetailsService {
    private MemberRepository memberRepository;


    @Autowired
    public UserService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByEmail(username) //user varsa authenticationManager vasıtasıyla password kontrolü yapıyor
                .orElseThrow(()->new UsernameNotFoundException("Member is not valid"));
    }
}
