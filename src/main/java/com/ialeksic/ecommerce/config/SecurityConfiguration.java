package com.ialeksic.ecommerce.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // protect endpoint /api/orders
        http.authorizeRequests()
                // protect endpoint - accessible to authenticated users only
                .antMatchers("/api/orders/**")

                .authenticated()
                .and()

                // configure OAuth2 resource server support
                .oauth2ResourceServer()

                // enable JWT-encoded bearer token support
                // jwt - java script web token
                .jwt();

        // CORS filters
        http.cors();

        // non-empty response body for 401 errors
        Okta.configureResourceServer401ResponseBody(http);

        // disable CSRF - since not using Cookies for session tracking
        http.csrf().disable();
    }
}
