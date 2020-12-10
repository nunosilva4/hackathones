package org.academiadecodigo.onegitwonders.model;

import javax.persistence.*;

@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Integer repCost;
    private Double successRate;
    private Integer repReward;
    @Version
    private Integer version;

    public Mission() {
    }

    public Integer getRepReward() {
        return repReward;
    }

    public void setRepReward(Integer repReward) {
        this.repReward = repReward;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRepCost() {
        return repCost;
    }

    public void setRepCost(Integer repCost) {
        this.repCost = repCost;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }
}
