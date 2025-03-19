package org.acme.hibernate.reactive;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Plant {

    @EmbeddedId
    protected Seed seed;

    @Column(length = 40, unique = true)
    protected String name;

    protected Plant(Seed seed, String name) {
        this.seed = seed;
        this.name = name;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
