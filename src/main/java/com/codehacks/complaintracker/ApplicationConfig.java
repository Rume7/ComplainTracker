package com.codehacks.complaintracker;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 * @author Rhume
 * @date Sept 10, 2021
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/complaintracker",
        callerQuery = "select * from users",
        groupsQuery = "select email from users where username = ?"
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
    
}
