package com.server.teammates1.controller;


import com.server.teammates1.entity.CompetitionInfo;

import com.server.teammates1.entity.CompetitionSimpleInfo;
import com.server.teammates1.repository.ComSimRepository;
import com.server.teammates1.repository.CompeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/competition")
public class CompetitionContoller {
    @Autowired
private CompeRepository compeRepository;
    @Autowired
private ComSimRepository comSimRepository;

    @RequestMapping(value = "/simpleContentAll",method = RequestMethod.GET)
    public List<CompetitionSimpleInfo> getSimpleCompetition1(){
        return comSimRepository.findAll();
    }
    @RequestMapping(value = "/ContentByname",method = RequestMethod.POST)
    public CompetitionInfo getCompetitionByName(@RequestParam("name")String name){
        return compeRepository.findByName(name);
    }
    @RequestMapping(value = "/ContentByLevel",method = RequestMethod.POST)
    public CompetitionInfo getSimpleCompetitionByLevel(@RequestParam("level")String level){
        return compeRepository.findByLevel(level);
    }



}