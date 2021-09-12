package com.codehacks.complaintracker.controller;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Rhume
 */
@RequestScoped
@Named
public class LoginController {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @Inject
    FacesContext facesContext;

    @Inject
    SecurityContext securityContext;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void execute() throws IOException {
        switch (processAuthentication()) {
            case SEND_CONTINUE:
                facesContext.responseComplete();
                break;
            case SEND_FAILURE:
                facesContext.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
                break;
            case SUCCESS:
                getExternalContext().redirect(getExternalContext().getRequestContextPath()
                        + "/app/complaintpage.xhtml");
                break;
        }
    }

    private AuthenticationStatus processAuthentication() {
        ExternalContext ec = getExternalContext();
        return securityContext.authenticate((HttpServletRequest) ec.getRequest(),
                (HttpServletResponse) ec.getResponse(),
                AuthenticationParameters.withParams().
                        credential(new UsernamePasswordCredential(email, password)));
    }

    private ExternalContext getExternalContext() {
        return facesContext.getExternalContext();
    }
}
