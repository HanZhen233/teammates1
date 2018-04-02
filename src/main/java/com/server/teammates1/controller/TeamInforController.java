package com.server.teammates1.controller;

import com.alibaba.fastjson.JSON;
import com.server.teammates1.entity.TeamInfo;
import com.server.teammates1.entity.TeamInfoComment;
import com.server.teammates1.repository.TeamInfoCommentRepository;
import com.server.teammates1.repository.TeamInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teamInfo")
public class TeamInforController {
  @Autowired
  private TeamInfoRepository teamInfoRepository;
  @Autowired
  private TeamInfoCommentRepository teamInfoCommentRepository;

  @RequestMapping(value = "addTeamInfo",method = RequestMethod.POST)
    public  String addInfo(@RequestParam("competitionName")String competitionName,
                           @RequestParam("competitionLevel")String competitionLevel,
                           @RequestParam("introduction")String introduction,
                           @RequestParam("initiator")String initiator){
    TeamInfo teamInfo=new TeamInfo();
    teamInfo.setCompetitionName(competitionName);
    teamInfo.setCompetitionLevel(competitionLevel);
    teamInfo.setIntroduction(introduction);
    teamInfo.setInitiator(initiator);
    teamInfoRepository.save(teamInfo);
      return "添加成功";
  }

  @RequestMapping(value = "/addTeamComment",method = RequestMethod.POST)
  public String addTeamComment(@RequestParam("teamInfoId")String teamInfoId,
                               @RequestParam("commentInfo")String commentInfo,
                               @RequestParam("")String commentator){
    TeamInfoComment teamInfoComment=new TeamInfoComment();
    teamInfoComment.setCommentator(commentator);
    teamInfoComment.setCommentInfo(commentInfo);

    teamInfoComment.setTeamInfo(teamInfoRepository.findById(Long.parseLong(teamInfoId)));
    teamInfoCommentRepository.save(teamInfoComment);
    return "添加成功";
  }




  @RequestMapping(value = "browseTeamInfo",method = RequestMethod.GET)
  public  String browseTeamIfo(@PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
    Page<TeamInfo> teamInfo = teamInfoRepository.findAll(pageable);
      return  JSON.toJSONString(teamInfo, true);
  }

}
