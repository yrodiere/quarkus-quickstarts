package org.acme.hibernate.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "known_fruits_detail")
public class FruitDetail {

    @Id
    @SequenceGenerator(name = "fruitsDetailSequence", sequenceName = "known_fruits_detail_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "fruitsDetailSequence")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private Fruit fruit;

    @Column
    private String description;

    public FruitDetail() {
    }

    public FruitDetail(String name) {
        this.description = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

}
