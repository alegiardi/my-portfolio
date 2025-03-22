package com.portfolio.service;

import com.portfolio.model.Skill;
import com.portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService {
    
    @Autowired
    private SkillRepository skillRepository;

    // Get all skills grouped by category
    public Map<String, List<Skill>> getSkillsByCategory() {
        List<Skill> allSkills = skillRepository.findAllByOrderByCategoryAsc();
        return allSkills.stream()
                .collect(Collectors.groupingBy(Skill::getCategory));
    }

    // Get skills by category
    public List<Skill> getSkillsInCategory(String category) {
        return skillRepository.findByCategory(category);
    }

    // Get a single skill by ID
    public Optional<Skill> getSkillById(Long id) {
        return skillRepository.findById(id);
    }

    // Save a new skill
    public Skill saveSkill(Skill skill) {
        // Business logic: Ensure proficiency level is between 1 and 5
        if (skill.getProficiencyLevel() < 1) {
            skill.setProficiencyLevel(1);
        } else if (skill.getProficiencyLevel() > 5) {
            skill.setProficiencyLevel(5);
        }
        return skillRepository.save(skill);
    }

    // Delete a skill
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
} 