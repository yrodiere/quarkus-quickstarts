package org.acme.hibernate.reactive;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "known_fruits")
@NamedQuery(name = "Fruits.findAll", query = "SELECT f FROM Fruit f ORDER BY f.seed.id")
public class Fruit extends Plant {

    @Column
    @JsonIgnore
    private Integer friendId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumns({
        @JoinColumn(name = "friendId", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    })
    private Flower friend;

    public Fruit() {
        super(new Seed(), null);
    }

    public Fruit(Seed seed, String name, Integer friendId) {
        super(seed, name);
    }

    public Flower getFriend() {
        return friend;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fruit other = (Fruit) obj;
        if (seed == null) {
            if (other.seed != null)
                return false;
        } else if (!seed.equals(other.seed))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Fruit [seed=" + seed + ", name=" + name + "]";
    }

}
