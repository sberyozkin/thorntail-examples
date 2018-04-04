package org.wildfly.swarm.examples.gradle;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * @author helio frota
 *
 */
public class Main {

    public static void main(String... args) throws Exception {

        Swarm swarm = new Swarm();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addClass(HelloRest.class);
        deployment.addClass(MyApplication.class);
        deployment.addAllDependencies();
        swarm.start().deploy(deployment);

    }
}
