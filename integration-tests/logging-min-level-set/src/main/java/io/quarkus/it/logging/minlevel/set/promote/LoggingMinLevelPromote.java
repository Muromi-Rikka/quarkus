package io.quarkus.it.logging.minlevel.set.promote;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import io.quarkus.it.logging.minlevel.set.LoggingWitness;

@Path("/log/promote")
public class LoggingMinLevelPromote {

    static final Logger LOG = Logger.getLogger(LoggingMinLevelPromote.class);

    @GET
    @Path("/not-info")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean isNotInfo() {
        return !LOG.isInfoEnabled() && !LoggingWitness.loggedInfo("should not print", LOG);
    }

    @GET
    @Path("/error")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean isError() {
        return LoggingWitness.loggedError("error message", LOG);
    }

}
