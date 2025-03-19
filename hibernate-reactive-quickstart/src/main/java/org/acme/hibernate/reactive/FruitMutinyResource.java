package org.acme.hibernate.reactive;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny.SessionFactory;

@Path("fruits")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class FruitMutinyResource {

    @Inject
    SessionFactory sf;

    @GET
    public Uni<List<Fruit>> get() {
        return sf.withTransaction(s -> {
            var cb = sf.getCriteriaBuilder();
            var query = cb.createQuery(Fruit.class);
            var root = query.from(Fruit.class);
            query.orderBy(cb.asc(root.get(Fruit_.seed).get(Seed_.id)));
            return s.createQuery(query).getResultList();
        });
    }

}
