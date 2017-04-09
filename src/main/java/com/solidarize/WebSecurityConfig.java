package com.solidarize;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.CacheControlHeadersWriter;
import org.springframework.security.web.header.writers.HstsHeaderWriter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.XContentTypeOptionsHeaderWriter;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
        http.authorizeRequests()
                .antMatchers("/css/**", "/jquery/**", "/bootstrap/**",
                        "/jquery/images/**", "/webjars/**")
                .permitAll();
        http.csrf().disable();
        http.headers()
                .contentTypeOptions()
                .and().xssProtection()
                .and().cacheControl()
                .and().httpStrictTransportSecurity()
                .and().frameOptions()
                .and().addHeaderWriter(new StaticHeadersWriter(
                "X-Content-Security-Policy", "script-src 'self'"))
                .addHeaderWriter(new XXssProtectionHeaderWriter())
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                .addHeaderWriter(new XContentTypeOptionsHeaderWriter())
                .addHeaderWriter(new CacheControlHeadersWriter())
                .addHeaderWriter(new HstsHeaderWriter());

    }
}
