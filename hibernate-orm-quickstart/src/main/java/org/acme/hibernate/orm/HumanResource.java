package org.acme.hibernate.orm;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import org.hibernate.proxy.HibernateProxy;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Path("humans")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class HumanResource {

    private static final Logger LOGGER = Logger.getLogger(HumanResource.class.getName());

    @Inject
    EntityManager entityManager;

    @GET
    public List<Human> get() {
        return entityManager.createNamedQuery("Humans.findAll", Human.class)
                .getResultList();
    }

    @GET
    @Path("{id}")
    public Human getSingle(Integer id) {
        Human entity = entityManager.find(Human.class, id);
        if (entity == null) {
            throw new WebApplicationException("Human with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @GET
    @Path("test/{id}")
    public Human test(Integer id) {
        Human entity = entityManager.find(Human.class, id);
        if (entity == null) {
            throw new WebApplicationException("Human with id of " + id + " does not exist.", 404);
        }
        if (entity.pet instanceof HibernateProxy) {
            throw new IllegalStateException("Found a proxy");
        }
        return entity;
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Inject
        ObjectMapper objectMapper;

        @Override
        public Response toResponse(Exception exception) {
            LOGGER.error("Failed to handle request", exception);

            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }

            ObjectNode exceptionJson = objectMapper.createObjectNode();
            exceptionJson.put("exceptionType", exception.getClass().getName());
            exceptionJson.put("code", code);

            if (exception.getMessage() != null) {
                exceptionJson.put("error", exception.getMessage());
            }

            return Response.status(code)
                    .entity(exceptionJson)
                    .build();
        }

    }
}
