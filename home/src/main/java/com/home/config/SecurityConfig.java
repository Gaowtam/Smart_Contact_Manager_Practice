package com.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.home.services.impl.SecurityCustomuserDetailService;

@Configuration
public class SecurityConfig {
    //user create and login using java code with in memory service
    
    // @Bean
    // public UserDetailsService userDetailsService()
    // {
    //     UserDetails user1=User
    //     .withDefaultPasswordEncoder()
    //     .username("admin123")
    //     .password("admin123")
    //     .roles("ADMIN","USER")
    //     .build();

    //     UserDetails user2=User
    //     .withDefaultPasswordEncoder()
    //     .username("user123")
    //     .password("password")
    //     // .roles("ADMIN","USER")
    //     .build();

    //     var inMemoryUserDetailsManager=new  InMemoryUserDetailsManager(user1,user2);
    //     return inMemoryUserDetailsManager;
    // }

    @Autowired
    private SecurityCustomuserDetailService userDetailService;


    //configuration of authentication provider for  spring securtity
    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userDetailService);

        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        //configration

        httpSecurity.authorizeHttpRequests(authorize->{
            // authorize.requestMatchers("/home","/register","services").permitAll(); kon kon url permission set kora hoice


            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });

        //Form defaulat login
        httpSecurity.formLogin(Customizer.withDefaults());

        return httpSecurity.build();//default security filter chain
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
