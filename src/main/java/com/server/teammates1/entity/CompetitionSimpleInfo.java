package com.server.teammates1.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "compeName")
public class CompetitionSimpleInfo {


    @Id
    @GeneratedValue
    private long id;
    private String name;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
