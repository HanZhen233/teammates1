package com.server.teammates1.repository;

import com.server.teammates1.entity.TeamInfoComment;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamInfoCommentRepository extends JpaRepository<TeamInfoComment,Long> {
    List<TeamInfoComment> findByTeamId(String teamId);
}
