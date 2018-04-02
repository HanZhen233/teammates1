package com.server.teammates1.repository;

import com.server.teammates1.entity.CompetitionSimpleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComSimRepository extends JpaRepository<CompetitionSimpleInfo,Integer> {
    @Override
    List<CompetitionSimpleInfo> findAll();
}
