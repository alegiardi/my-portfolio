package com.portfolio.service;

import com.portfolio.model.Project;
import com.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;

    // Get all projects ordered by their display order
    public List<Project> getAllProjects() {
        return projectRepository.findAllByOrderByOrderAsc();
    }

    // Get a single project by ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Save a new project
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // Delete a project
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
} 