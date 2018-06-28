package com.server.teammates1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TeamInfo")
public class TeamInfo implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String competitionName;
    private String competitionLevel;
    private String time;
    private String university;
    private String introduction;
    private String initiator;
    private String requirement;
    private String connection;
//    @OneToMany(mappedBy = "teamInfo")
//    private List<TeamInfoComment> teamInfoComments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(String competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }


//    public List<TeamInfoComment> getTeamInfoComments() {
//        return teamInfoComments;
//    }
//
//    public void setTeamInfoComments(List<TeamInfoComment> teamInfoComments) {
//        this.teamInfoComments = teamInfoComments;
//    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

}