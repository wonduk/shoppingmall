package org.shppoingmall.shopping.entity;

import org.shppoingmall.shopping.constant.Role;
import org.shppoingmall.shopping.dto.MemberFormDto;
import org.springframework.security.crypto.password.PasswordEncoder;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {

     @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    //Member Entity를 생성하는 함수, 회원생성 메소드를 만들면 코드가 변경되더라고 한군데만 수정하면 되기 떄문에 
    //유지보수에 용이하다는 장점이 있음.
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        String password = passwordEncoder.encode(memberFormDto.getPassword()); //pw는 암호화시켜서 관리
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;
    }
    
}
