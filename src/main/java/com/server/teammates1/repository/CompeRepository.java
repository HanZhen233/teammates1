package com.server.teammates1.repository;

import com.server.teammates1.entity.CompetitionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompeRepository extends JpaRepository<CompetitionInfo,Integer> {
  public CompetitionInfo findByName(String name);
  public   CompetitionInfo findByLevel(String level);
}
