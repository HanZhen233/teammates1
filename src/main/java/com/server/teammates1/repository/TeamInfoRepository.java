package com.server.teammates1.repository;


import com.server.teammates1.entity.TeamInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamInfoRepository extends JpaRepository<TeamInfo,Long> {
public  TeamInfo findById(long id);
//    Page<TeamInfo>
}
