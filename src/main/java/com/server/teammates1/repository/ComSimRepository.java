package com.server.teammates1.repository;

import com.server.teammates1.entity.CompeSimpContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComSimRepository extends JpaRepository<CompeSimpContent,Integer> {
    @Override
    List<CompeSimpContent> findAll();
}
