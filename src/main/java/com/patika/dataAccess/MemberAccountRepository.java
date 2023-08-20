package com.patika.dataAccess;

import com.patika.entity.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Integer> {
}
