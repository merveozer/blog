package com.app.blog.config;

import com.app.blog.security.JwtAuthenticationEntryPoint;
import com.app.blog.security.JwtAuthenticationFilter;
import com.app.blog.security.implementation.UserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsManager userDetailsManager;

    private JwtAuthenticationEntryPoint handler;

    public SecurityConfig(UserDetailsManager userDetailsManager, JwtAuthenticationEntryPoint handler) {
        super();
        this.userDetailsManager = userDetailsManager;
        this.handler = handler;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {

        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsManager).passwordEncoder(passwordEncoder());
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests().antMatchers("/").permitAll();

        /*
         * .antMatchers(HttpMethod.POST, "/api/users/deleteuser")
         * .hasAuthority("SUPERADMIN") .antMatchers(HttpMethod.GET, "/api/roles/getall")
         * .hasAuthority("SUPERADMIN") .antMatchers(HttpMethod.GET,
         * "/api/users/getallusers") .hasAuthority("SUPERADMIN")
         * .antMatchers(HttpMethod.POST, "/auth/updateRole") .hasAuthority("SUPERADMIN")
         *
         *
         *
         * .antMatchers(HttpMethod.GET, "/pokemon") .permitAll()
         *
         * .antMatchers(HttpMethod.GET, "/pokemonsAndTrainers") .permitAll()
         *
         * .antMatchers(HttpMethod.GET, "/powerestFivePokemon") .permitAll()
         *
         * .antMatchers(HttpMethod.GET, "/game") .permitAll()
         *
         * .antMatchers(HttpMethod.GET, "/pokemonTrainer") .permitAll()
         *
         *
         *
         * .antMatchers(HttpMethod.PATCH, "/description") .hasAnyAuthority("SUPERADMIN",
         * "ADMIN")
         *
         * .antMatchers(HttpMethod.PATCH, "/trainer") .hasAnyAuthority("SUPERADMIN",
         * "ADMIN")
         *
         * .antMatchers(HttpMethod.PATCH, "/updateWinner")
         * .hasAnyAuthority("SUPERADMIN", "ADMIN")
         *
         *
         *
         * .antMatchers(HttpMethod.POST, "/pokemon") .hasAnyAuthority("SUPERADMIN",
         * "ADMIN")
         *
         * .antMatchers(HttpMethod.POST, "/game") .hasAnyAuthority("SUPERADMIN",
         * "ADMIN")
         *
         *
         * .antMatchers(HttpMethod.DELETE, "/pokemon") .hasAnyAuthority("SUPERADMIN",
         * "ADMIN")
         *
         *
         *
         *
         * .antMatchers("/auth/login") .permitAll() .antMatchers("/auth/register")
         * .permitAll() .anyRequest().authenticated();
         */

        httpSecurity
                .cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(handler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

        httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}