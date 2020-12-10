package org.academiadecodigo.onegitwonders.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "crew")
public class Crew extends Model{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String logo; //filepath
    private String tag; //filepath
    private Integer crewRep;
    @OneToMany(
            mappedBy = "crew",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    private List<Gangster> members = new ArrayList<>();

    public Crew() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCrewRep() {
        return crewRep;
    }

    public void setCrewRep(Integer crewRep) {
        this.crewRep = crewRep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gangster> getMembers() {
        return members;
    }

    public void setMembers(List<Gangster> members) {
        this.members = members;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
