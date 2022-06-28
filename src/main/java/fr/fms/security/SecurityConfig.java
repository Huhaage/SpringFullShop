package fr.fms.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder pe = passwordEncoder();
        auth.inMemoryAuthentication().withUser("Neo@free.fr").password(pe.encode("12345")).roles("ADMIN", "USER");
        auth.inMemoryAuthentication().withUser("SarahLune@yahoo.fr").password(pe.encode("6789")).roles("USER");
        auth.inMemoryAuthentication().withUser("Jcd@yahoo.fr").password(pe.encode("101112")).roles("USER");
        auth.inMemoryAuthentication().withUser("Christoof@yahoo.fr").password(pe.encode("131415")).roles("USER");
        auth.inMemoryAuthentication().withUser("Huhaage@yahoo.fr").password(pe.encode("161718")).roles("USER");

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
      
        http.formLogin()

          // lien personnalisé   à debug
                .loginPage("/login")
                .usernameParameter("mail")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureUrl("/login")
                .permitAll();
        http.logout()
                .logoutUrl("/logout")
                 .logoutSuccessUrl("/login");

        http.authorizeRequests().antMatchers("/order").hasRole("USER");
        http.authorizeRequests().antMatchers("/admin", "/addArticle", "/save", "/adminListArticles",
                "/delete", "/updateArticle", "/editArticle", "/adminListCategories", "/addCategory",
                "/saveCategory", "/editCategory", "/updateCategory").hasRole("ADMIN");

        http.exceptionHandling().accessDeniedPage("/403");
    }

}