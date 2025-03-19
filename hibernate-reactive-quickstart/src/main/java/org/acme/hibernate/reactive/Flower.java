package org.acme.hibernate.reactive;

import jakarta.persistence.*;

@Entity
@Table(name = "known_flowers")
public class Flower extends Plant {

    public Flower() {
        super(new Seed(), null);
    }

    public Flower(Seed seed, String name) {
        super(seed, name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((seed == null) ? 0 : seed.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flower other = (Flower) obj;
        if (seed == null) {
            if (other.seed != null)
                return false;
        } else if (!seed.equals(other.seed))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Flower [seed=" + seed + ", name=" + name + "]";
    }

}
