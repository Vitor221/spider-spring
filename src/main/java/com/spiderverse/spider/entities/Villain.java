package com.spiderverse.spider.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spiderverse.spider.entities.enums.VillainSituationStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_villain")
public class Villain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String villainName;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momentCreate;

    private Integer villainStatusInt;

    @JsonIgnore
    @ManyToMany(mappedBy = "villains")
    private Set<Spiderverse> spiders = new HashSet<>();

    public Villain() {
    }

    public Villain(Long id, String name, String villainName, String description, Instant momentCreate, VillainSituationStatus villainSituationStatus) {
        this.id = id;
        this.name = name;
        this.villainName = villainName;
        this.description = description;
        this.momentCreate = momentCreate;
        setVillainStatusInt(villainSituationStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVillainName() {
        return villainName;
    }

    public void setVillainName(String villainName) {
        this.villainName = villainName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getMomentCreate() {
        return momentCreate;
    }

    public void setMomentCreate(Instant momentCreate) {
        this.momentCreate = momentCreate;
    }

    public VillainSituationStatus getVillainStatusInt() {
        return VillainSituationStatus.valueSituationVillain(villainStatusInt);
    }

    public void setVillainStatusInt(VillainSituationStatus villainSituationStatus) {
        this.villainStatusInt = villainSituationStatus.getCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Villain villains = (Villain) o;
        return Objects.equals(id, villains.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
