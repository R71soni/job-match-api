package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.entity.RequiredSkill;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SkillScorer {

    private static final double MUST_HAVE_WEIGHT = 40.0;
    private static final double NICE_TO_HAVE_WEIGHT = 10.0;

    public boolean hasAllMustHaveSkills(
            Candidate candidate,
            Job job) {

        Set<String> candidateSkills = getCandidateSkills(candidate);

        for (RequiredSkill requiredSkill : job.getRequiredSkills()) {

            if ("MUST_HAVE".equalsIgnoreCase(requiredSkill.getType())) {

                String requiredSkillName =
                        normalize(requiredSkill.getSkill());

                if (!candidateSkills.contains(requiredSkillName)) {
                    return false;
                }
            }
        }

        return true;
    }

    public double calculateScore(
            Candidate candidate,
            Job job) {

        Set<String> candidateSkills = getCandidateSkills(candidate);

        int mustHaveTotal = 0;
        int mustHaveMatched = 0;

        int niceToHaveTotal = 0;
        int niceToHaveMatched = 0;

        for (RequiredSkill requiredSkill : job.getRequiredSkills()) {

            String skill =
                    normalize(requiredSkill.getSkill());

            if ("MUST_HAVE".equalsIgnoreCase(requiredSkill.getType())) {

                mustHaveTotal++;

                if (candidateSkills.contains(skill)) {
                    mustHaveMatched++;
                }

            } else if ("NICE_TO_HAVE".equalsIgnoreCase(
                    requiredSkill.getType())) {

                niceToHaveTotal++;

                if (candidateSkills.contains(skill)) {
                    niceToHaveMatched++;
                }
            }
        }

        double mustHaveScore = 0;

        if (mustHaveTotal > 0) {
            mustHaveScore =
                    ((double) mustHaveMatched / mustHaveTotal)
                            * MUST_HAVE_WEIGHT;
        }

        double niceToHaveScore = 0;

        if (niceToHaveTotal > 0) {
            niceToHaveScore =
                    ((double) niceToHaveMatched / niceToHaveTotal)
                            * NICE_TO_HAVE_WEIGHT;
        }

        return mustHaveScore + niceToHaveScore;
    }

    private Set<String> getCandidateSkills(
            Candidate candidate) {

        Set<String> skills = new HashSet<>();

        for (String skill : candidate.getSkills()) {

            if (skill != null && !skill.isBlank()) {
                skills.add(normalize(skill));
            }
        }

        return skills;
    }

    private String normalize(String skill) {
        return skill.trim().toLowerCase();
    }
}