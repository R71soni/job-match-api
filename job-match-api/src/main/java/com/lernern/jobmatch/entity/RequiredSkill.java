package com.lernern.jobmatch.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class RequiredSkill {

    private String skill;

    private String type;

    public RequiredSkill() {
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}