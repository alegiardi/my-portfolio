package com.portfolio.service;

import com.portfolio.model.Experience;
import com.portfolio.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    // This method shows how service uses repository
    public List<Experience> getAllExperiences() {
        // 1. Service calls repository method
        List<Experience> experiences = experienceRepository.findAllByOrderByStartDateDesc();

        // 2. Service can add additional logic before returning
        // For example, we could filter out future experiences
        experiences.removeIf(exp -> exp.getStartDate().isAfter(java.time.LocalDate.now()));

        // 3. Service returns processed data
        return experiences;
    }

    // Another example showing service-repository interaction
    public Experience saveExperience(Experience experience) {
        // 1. Service can validate/modify data before saving
        if (experience.getEndDate() != null &&
                experience.getEndDate().isBefore(experience.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }

        // 2. Service calls repository to save
        return experienceRepository.save(experience);
    }

    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}