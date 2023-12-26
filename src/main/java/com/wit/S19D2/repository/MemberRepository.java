package com.wit.S19D2.repository;

import com.wit.S19D2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("SELECT m FROM Member m WHERE m.email=:email")
    Optional<Member> findByEmail(String email);

}
