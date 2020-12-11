package org.academiadecodigo.onegitwonders.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "crew")
public class Crew extends Model{

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
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "crew"
    )
    private List<Avatar> avatars = new ArrayList<>();

    public Crew() {
    }

    public List<Avatar> getAvatars() {
        return avatars;
    }

    public void setAvatars(List<Avatar> avatars) {
        this.avatars = avatars;
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
