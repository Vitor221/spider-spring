package com.spiderverse.spider.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_spider_local")
public class SpiderLocal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String neighborhood;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Spiderverse spiderverse;

    public SpiderLocal(){
    }

    public SpiderLocal(Long id, String city, String neighborhood, Spiderverse spiderverse) {
        this.id = id;
        this.city = city;
        this.neighborhood = neighborhood;
        this.spiderverse = spiderverse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Spiderverse getSpiderverse() {
        return spiderverse;
    }

    public void setSpiderverse(Spiderverse spiderverse) {
        this.spiderverse = spiderverse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpiderLocal that = (SpiderLocal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
