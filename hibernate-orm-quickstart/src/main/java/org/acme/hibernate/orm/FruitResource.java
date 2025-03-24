package org.acme.hibernate.orm;

import java.util.List;

import org.hibernate.Session;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("fruits")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FruitResource {

    @Inject
    Session session;

    @GET
    @Transactional
    public List<Fruit> get() {
        var cb = session.getCriteriaBuilder();
        var query = cb.createQuery(Fruit.class);
        var root = query.from(Fruit.class);
        query.orderBy(cb.asc(root.get(Fruit_.seed).get(Seed_.id)));
        return session.createQuery(query).getResultList();
    }

}
