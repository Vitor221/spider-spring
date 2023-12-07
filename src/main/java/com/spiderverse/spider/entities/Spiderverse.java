package com.spiderverse.spider.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spiderverse.spider.entities.enums.SpiderSituationStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
public class Spiderverse implements Serializable {

    @Id
    private Long earthId;
    private String name;
    private String spiderName;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momentCreation;

    private Integer spiderSituationInt;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToMany
    @JoinTable(name = "tb_heroes_villains", joinColumns = @JoinColumn(name = "id_spider"), inverseJoinColumns = @JoinColumn(name = "id_villain"))
    private Set<Villain> villains = new HashSet<>();

    @OneToOne(mappedBy = "spiderverse", cascade = CascadeType.ALL)
    private SpiderLocal spiderLocal;

    public Spiderverse() {
    }

    public Spiderverse(Long earthId, String name, String spiderName, String description, Instant momentCreation, SpiderSituationStatus spiderSituationStatus, User user) {
        this.earthId = earthId;
        this.name = name;
        this.spiderName = spiderName;
        this.description = description;
        this.momentCreation = momentCreation;
        setSpiderSituationInt(spiderSituationStatus);
        this.user = user;
    }

    public Long getEarthId() {
        return earthId;
    }

    public void setEarthId(Long earthId) {
        this.earthId = earthId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpiderName() {
        return spiderName;
    }

    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getMomentCreation() {
        return momentCreation;
    }

    public SpiderLocal getSpiderLocal() {
        return spiderLocal;
    }

    public void setSpiderLocal(SpiderLocal spiderLocal) {
        this.spiderLocal = spiderLocal;
    }

    public Set<Villain> getVillains() {
        return villains;
    }

    public void setMomentCreation(Instant momentCreation) {
        this.momentCreation = momentCreation;
    }

    public SpiderSituationStatus getSpiderSituationInt() {
        return SpiderSituationStatus.valueSituation(spiderSituationInt);
    }

    public void setSpiderSituationInt(SpiderSituationStatus spiderSituationStatus) {
        this.spiderSituationInt = spiderSituationStatus.getCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spiderverse that = (Spiderverse) o;
        return Objects.equals(earthId, that.earthId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earthId);
    }
}
