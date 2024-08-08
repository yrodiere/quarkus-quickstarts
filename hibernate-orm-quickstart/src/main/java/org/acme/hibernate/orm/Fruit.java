package org.acme.hibernate.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

    @OneToOne(mappedBy = "fruit", fetch = FetchType.LAZY)
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

    public FruitDetail getFruitDetail() {
        return fruitDetail;
    }

    public void setFruitDetail(FruitDetail fruitDetail) {
        this.fruitDetail = fruitDetail;
    }

}
