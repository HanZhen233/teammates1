package com.server.teammates1.repository;

import com.server.teammates1.entity.CompeContent;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompeRepository extends JpaRepository<CompeContent,Integer> {
    public CompeContent findByName(String name);
}
