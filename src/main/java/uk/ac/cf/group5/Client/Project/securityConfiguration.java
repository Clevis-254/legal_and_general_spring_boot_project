package uk.ac.cf.group5.Client.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class securityConfiguration {

    public  static final String [] ENDPOINTS_WHITELIST = {
            "/",
            "/403",
            "/css/**",
            "/images/**",
            "/LoginSuccess",
            "/dashboard",
            "/dashboard/**"
    };

    @Autowired
    private DataSource dataSource;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
            Exception {
        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .requestMatchers("/**").hasRole("ADMIN")
                        .requestMatchers("/Admin/**").hasRole("ADMIN")
                        .requestMatchers("LoginSuccess").hasRole( "USER")
                        .requestMatchers("/LoginSuccess").hasRole( "ADMIN")
                        .requestMatchers("/dashboard/**").hasRole( "USER")
                        .requestMatchers("/reviews/**").hasRole( "USER")
                        .requestMatchers("/request360").hasRole( "USER"))




                .formLogin(form -> form
                        //.loginPage("/login")
                        .permitAll()

                        //.defaultSuccessUrl("/dashboard",true)
                        .defaultSuccessUrl("/LoginSuccess", true)

                        .failureUrl("/login?error=true"))

                       // .formLogin(form -> form
                        //.loginPage("/login")
                       // .permitAll())
                .logout((l) -> l.permitAll().logoutSuccessUrl("/login"))
                .exceptionHandling(exceptions -> exceptions
                .accessDeniedPage("/403"));


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    UserDetailsService userDetailsService() {

        //we can replace this with another implementation of UserDetailsService.
        //that could use JPA to access the DB, or use LDAP instead.
        //quite often, Spring will provide default implementations. Read before writing!
        //The user details service interface provides a method to get a user by username.
        //That user will contain the authorities. With that object graph, Spring Security can do the rest.

        JdbcDaoImpl jdbcUserDetails = new JdbcDaoImpl();
        jdbcUserDetails.setDataSource(dataSource);
        jdbcUserDetails.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
        jdbcUserDetails.setAuthoritiesByUsernameQuery("select username, role from users where username=?");
        return jdbcUserDetails;
    }


}
