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

        Set<String> candidateSkills = new HashSet<>();

        if (candidate.getSkills() != null) {
            for (String skill : candidate.getSkills()) {
                if (skill != null) {
                    candidateSkills.add(skill.trim().toLowerCase());
                }
            }
        }

        if (job.getRequiredSkills() == null) {
            return true;
        }

        for (RequiredSkill requiredSkill : job.getRequiredSkills()) {

            if ("MUST_HAVE".equalsIgnoreCase(requiredSkill.getType())) {

                String skill = requiredSkill.getSkill();

                if (skill == null
                        || !candidateSkills.contains(
                        skill.trim().toLowerCase())) {

                    return false;
                }
            }
        }

        return true;
    }

    public double calculateScore(
            Candidate candidate,
            Job job) {

        Set<String> candidateSkills = new HashSet<>();

        if (candidate.getSkills() != null) {
            for (String skill : candidate.getSkills()) {
                if (skill != null) {
                    candidateSkills.add(skill.trim().toLowerCase());
                }
            }
        }

        int mustHaveTotal = 0;
        int mustHaveMatched = 0;

        int niceToHaveTotal = 0;
        int niceToHaveMatched = 0;

        if (job.getRequiredSkills() == null) {
            return 0.0;
        }

        for (RequiredSkill requiredSkill : job.getRequiredSkills()) {

            if (requiredSkill == null) {
                continue;
            }

            String skill = requiredSkill.getSkill();

            if (skill == null) {
                continue;
            }

            skill = skill.trim().toLowerCase();

            if ("MUST_HAVE".equalsIgnoreCase(
                    requiredSkill.getType())) {

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

        double mustHaveScore = 0.0;

        if (mustHaveTotal > 0) {
            mustHaveScore =
                    ((double) mustHaveMatched / mustHaveTotal)
                            * MUST_HAVE_WEIGHT;
        }

        double niceToHaveScore = 0.0;

        if (niceToHaveTotal > 0) {
            niceToHaveScore =
                    ((double) niceToHaveMatched / niceToHaveTotal)
                            * NICE_TO_HAVE_WEIGHT;
        }

        return mustHaveScore + niceToHaveScore;
    }
}