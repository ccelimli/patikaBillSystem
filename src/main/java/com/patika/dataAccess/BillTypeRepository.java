package com.patika.dataAccess;

import com.patika.entity.BillType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillTypeRepository extends JpaRepository<BillType,Integer> {
}
