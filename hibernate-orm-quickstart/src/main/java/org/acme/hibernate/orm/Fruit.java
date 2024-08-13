package org.acme.hibernate.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "known_fruits")
@NamedEntityGraph(name = Fruit.ENTITY_GRAPH_FIND_ALL, includeAllAttributes = false, attributeNodes = {
        @NamedAttributeNode("name")
})
public class Fruit {

    public static final String ENTITY_GRAPH_FIND_ALL = "Fruits.findAll";

    @Id
    @SequenceGenerator(name = "fruitsSequence", sequenceName = "known_fruits_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "fruitsSequence")
    private Integer id;

    @Column(length = 40, unique = true)
    private String name;

    @OneToOne(mappedBy = "fruit", fetch = FetchType.EAGER)
    private FruitDetail fruitDetail;

    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public FruitDetail getFruitDetail() {
        return fruitDetail;
    }

    public void setFruitDetail(FruitDetail fruitDetail) {
        this.fruitDetail = fruitDetail;
    }

}
