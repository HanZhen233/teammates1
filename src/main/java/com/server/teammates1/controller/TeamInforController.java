package com.server.teammates1.controller;

import com.alibaba.fastjson.JSON;
import com.server.teammates1.entity.TeamInfo;
import com.server.teammates1.entity.TeamInfoComment;
import com.server.teammates1.repository.SysUserRepository;
import com.server.teammates1.repository.TeamInfoCommentRepository;
import com.server.teammates1.repository.TeamInfoRepository;
import com.server.teammates1.service.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
  @Autowired
  private SysUserRepository sysUserRepository;


  @RequestMapping(value = "addTeamInfo",method = RequestMethod.POST)
    public  String addInfo(@RequestParam("competitionName")String competitionName,
                           @RequestParam("competitionLevel")String competitionLevel,
                           @RequestParam("introduction")String introduction,
                           @RequestParam("requirement")String requirement,
                           @RequestParam("connection")String connection,
                           @RequestParam("time")String time
                         ){


    String  initiator=null;
    String  university=null;
    SecurityUser securityUser=null;
    Object principal =  SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();
    if(principal instanceof UserDetails){
      securityUser   =((SecurityUser)principal);
    }
    initiator=securityUser.getUsername();
    university=securityUser.getUniversity();
    TeamInfo teamInfo=new TeamInfo();


    teamInfo.setCompetitionName(competitionName);
    teamInfo.setCompetitionLevel(competitionLevel);
    teamInfo.setIntroduction(introduction);
    teamInfo.setInitiator(initiator);
    teamInfo.setUniversity(university);
    teamInfo.setRequirement(requirement);
    teamInfo.setConnection(connection);
    teamInfo.setTime(time);


    teamInfoRepository.save(teamInfo);
      return "添加成功";
  }

  @RequestMapping(value = "/addTeamComment",method = RequestMethod.POST)
  public String addTeamComment(@RequestParam("teamInfoId")String teamInfoId,
                               @RequestParam("commentInfo")String commentInfo,
                               @RequestParam("time")String time ){
    SecurityUser securityUser=null;
    String commentator=null;
    Object principal =  SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();
    if(principal instanceof UserDetails){
      securityUser   =((SecurityUser)principal);
    }
    commentator=securityUser.getUsername();
    TeamInfoComment teamInfoComment=new TeamInfoComment();
    teamInfoComment.setCommentator(commentator);
    teamInfoComment.setCommentInfo(commentInfo);
    teamInfoComment.setTeamId(teamInfoId);
    teamInfoComment.setTime(time);

//    teamInfoComment.setTeamInfo(teamInfoRepository.findById(Long.parseLong(teamInfoId)));
    teamInfoCommentRepository.save(teamInfoComment);
    return "添加成功";
  }



 /**
  @RequestMapping(value = "/browseTeamInfo",method = RequestMethod.GET)
  public  String browseTeamIfo(@PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
    Page<TeamInfo> teamInfo = teamInfoRepository.findAll(pageable);
      return  JSON.toJSONString(teamInfo, true);
  }


  @RequestMapping(value = "/browseTeamInfo/byCompetitionLevel",method = RequestMethod.POST)

  public  String browseTeamIfoByCompetitionLevel(@RequestParam("competitionLevel")String competitionLevel,
          @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
    Page<TeamInfo> teamInfo = teamInfoRepository.findByCompetitionLevel(competitionLevel,pageable);
    return  JSON.toJSONString(teamInfo, true);
  }

  @RequestMapping(value = "/browseTeamInfo/byCompetitionName",method = RequestMethod.POST)
  public  String browseTeamIfoByCompetitionName(@RequestParam("competitionName")String competitionName,
                                       @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
    Page<TeamInfo> teamInfo = teamInfoRepository.findByCompetitionName(competitionName,pageable);
    return  JSON.toJSONString(teamInfo, true);
  }
  @RequestMapping(value = "/browseTeamInfo/byUniversity",method = RequestMethod.POST)
  public  String browseTeamIfoByUniversity(@RequestParam("university")String university,
                                                @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
    Page<TeamInfo> teamInfo = teamInfoRepository.findByUniversity(university,pageable);
    return  JSON.toJSONString(teamInfo, true);
  }
 **/

 @RequestMapping(value = "/browseTeamInfo",method = RequestMethod.GET)
 public   List<TeamInfo>browseTeamIfo(){

   return  teamInfoRepository.findAll();
 }


  @RequestMapping(value = "/browseTeamInfo/byCompetitionLevel",method = RequestMethod.POST)
  public  List<TeamInfo>  browseTeamIfoByCompetitionLevel(@RequestParam("competitionLevel")String competitionLevel){

    return  teamInfoRepository.findByCompetitionLevel(competitionLevel);
  }

  @RequestMapping(value = "/browseTeamInfo/byCompetitionName",method = RequestMethod.POST)
  public  List<TeamInfo> browseTeamIfoByCompetitionName(@RequestParam("competitionName")String competitionName
                                            ){

    return   teamInfoRepository.findByCompetitionName(competitionName);
  }
  @RequestMapping(value = "/browseTeamInfo/byUniversity",method = RequestMethod.POST)
  public   List<TeamInfo>  browseTeamIfoByUniversity(@RequestParam("university")String university
                                         ){

    return teamInfoRepository.findByUniversity(university);
  }

  @RequestMapping(value = "/browseTeamComments",method = RequestMethod.POST)
    public List<TeamInfoComment> browseTeamComments(@RequestParam("teamId")String teamId){
    return teamInfoCommentRepository.findByTeamId(teamId);
    }


}
