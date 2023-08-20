package com.patika.dataAccess;

import com.patika.business.requests.BillRequest;
import com.patika.entity.Bill;
import com.patika.entity.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query("SELECT b FROM Bill b WHERE b.code = :code")
    Bill getByCode(@Param("code") String code);

}
