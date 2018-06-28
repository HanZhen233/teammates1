package com.server.teammates1.securityConfiguration;

import com.server.teammates1.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     *
     */

    @Bean
        UserDetailsService customUserService() {
            return new UserService();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());;
        }
   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
        return   new BCryptPasswordEncoder();
    }


    @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests().
                    antMatchers("/competition/**","/addUser","/teamInfo/browseTeamInfo",
                            "/teamInfo/browseTeamInfo/**","/teamInfo/browseTeamComments").permitAll()
                    .antMatchers("/manage/**").hasRole("ADMIN")
                    .anyRequest().authenticated().
                    and().
                    formLogin().
                    loginProcessingUrl("/login").
                    usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/login1")
                    .and()
                    .logout().logoutUrl("/logout")
                    .and()
                    //开启cookie保存用户数据
                    .rememberMe()
                    //设置cookie有效期
                    .tokenValiditySeconds(60 * 60 * 24 * 7)
                    .and()
                    .logout().permitAll()
                    .and().csrf().disable();
        }


    }

