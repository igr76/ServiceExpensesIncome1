package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract ,Integer> {

}
