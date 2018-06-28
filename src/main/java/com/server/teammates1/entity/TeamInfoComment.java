package com.server.teammates1.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teamInfoComment")
public class TeamInfoComment implements Serializable {
    @Id
    @GeneratedValue
    private  long id;
    private  String commentInfo;
    private  String commentator;
    private  String time;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "team_info_id")
//    private TeamInfo teamInfo;
   private String teamId;
    public  TeamInfoComment(){
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

//    public TeamInfo getTeamInfo() {
//        return teamInfo;
//    }
//
//    public void setTeamInfo(TeamInfo teamInfo) {
//        this.teamInfo = teamInfo;
//    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
