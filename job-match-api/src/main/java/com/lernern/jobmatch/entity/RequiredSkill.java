package com.lernern.jobmatch.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class RequiredSkill {

    @NotBlank(message = "skill is required")
    private String skill;

    @NotBlank(message = "type is required")
    @Pattern(
            regexp = "MUST_HAVE|NICE_TO_HAVE",
            message = "type must be MUST_HAVE or NICE_TO_HAVE"
    )
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