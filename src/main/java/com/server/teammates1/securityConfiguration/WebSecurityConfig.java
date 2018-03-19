package com.server.teammates1.securityConfiguration;

import com.server.teammates1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

import javax.sql.DataSource;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     *
     */
private SecuritySettings settings;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Bean
        UserDetailsService customUserService() {
            return new UserService();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(customUserService());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin().
                    usernameParameter("username")
                    .passwordParameter("password").permitAll()
                    .and().authorizeRequests()
                    .antMatchers("/competition/Content","/logined").permitAll()
                    .and()
                    //开启cookie保存用户数据
                    .rememberMe()
                    //设置cookie有效期
                    .tokenValiditySeconds(60 * 60 * 24 * 7)
                    .tokenRepository(tokenRepository())
                    .and()
                    .logout().permitAll()
                    .and().csrf().disable();
        }
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jtr = new JdbcTokenRepositoryImpl();
        jtr.setDataSource(dataSource);
        return jtr;
    }

    }

