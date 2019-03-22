package org.wildfly.swarm.examples.keycloak;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/employee-sig")
public class SecuredApplication extends Application {
}
