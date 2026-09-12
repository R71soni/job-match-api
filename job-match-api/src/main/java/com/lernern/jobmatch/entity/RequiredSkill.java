package com.lernern.jobmatch.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class RequiredSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "skill is required")
    private String skill;

    @NotBlank(message = "type is required")
    @Pattern(
            regexp = "MUST_HAVE|NICE_TO_HAVE",
            message = "type must be MUST_HAVE or NICE_TO_HAVE"
    )
=======
import jakarta.persistence.Embeddable;

@Embeddable
public class RequiredSkill {

    private String skill;

>>>>>>> d5e521b (Add job creation API)
    private String type;

    public RequiredSkill() {
    }

<<<<<<< HEAD
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

=======
>>>>>>> d5e521b (Add job creation API)
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