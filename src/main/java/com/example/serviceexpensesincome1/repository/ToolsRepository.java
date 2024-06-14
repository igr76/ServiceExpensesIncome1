package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Integer> {
}
