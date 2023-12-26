package com.wit.S19D2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role", schema = "s19d2")
@NoArgsConstructor
@AllArgsConstructor
@Data //GrantedAuthority içerisindeki getAuthority metodunu eziyoruz
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="authority")
    private String authority;
}
