package org.acme.hibernate.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Human {
    @Id
    @GeneratedValue
    public Long id;

    @OneToOne(fetch = FetchType.LAZY)
    public Animal pet;
}
