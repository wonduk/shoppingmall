package org.shppoingmall.shopping.repository;

import org.shppoingmall.shopping.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/* entity/Member.java 클래스에 대해서 db에 저장해주는 Repository */ 
public interface MemberRepository extends JpaRepository<Member, Long>{
    
    Member findByEmail(String email);
}
