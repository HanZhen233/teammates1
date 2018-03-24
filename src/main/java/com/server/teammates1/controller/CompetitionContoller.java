package com.server.teammates1.controller;


import com.server.teammates1.entity.CompeContent;

import com.server.teammates1.entity.CompeSimpContent;
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

    @RequestMapping(value = "/simpleContent",method = RequestMethod.GET)
    public List<CompeSimpContent> getSimpleCompetition1(){
        return comSimRepository.findAll();
    }


    @RequestMapping(value = "/Content",method = RequestMethod.POST)

    public CompeContent getSimpleCompetition(@RequestParam("name")String name){
        return compeRepository.findByName(name);
    }



}