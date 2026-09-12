package com.lernern.jobmatch.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class RequiredSkill {

    @NotBlank(message = "Skill name is required")
    private String skill;

    @NotBlank(message = "Skill type is required")
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