package org.academiadecodigo.onegitwonders.dto;

public class CrewDto {

    private Integer id;
    private String name;
    private String logo;
    private String tag;
    private Integer crewRep;

    public CrewDto() {
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
