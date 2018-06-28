package com.server.teammates1.repository;


import com.server.teammates1.entity.TeamInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamInfoRepository extends JpaRepository<TeamInfo,Long> {
public  TeamInfo findById(long id);
//    Page<TeamInfo>
    List<TeamInfo> findByCompetitionName(String name);
    List<TeamInfo> findByCompetitionLevel(String level );
    List<TeamInfo> findByUniversity(String university);

    Page<TeamInfo> findByCompetitionLevel(String competitionLevel,Pageable pageable);
    Page<TeamInfo> findByCompetitionName(String CompetitionName,Pageable pageable);
    Page<TeamInfo> findByUniversity(String university,Pageable pageable);
}
