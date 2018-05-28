package org.wildfly.swarm.examples.management.console;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("service")
public class Service {
    @GET
    public String get() {
        return "hello";
    }
}
