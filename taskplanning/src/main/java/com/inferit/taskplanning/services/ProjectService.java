package com.inferit.taskplanning.services;

import com.inferit.taskplanning.domain.Project;
import com.inferit.taskplanning.repositories.ProjectRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Data
@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){

        this.projectRepository=projectRepository;


    }
    public Project saveOrUpdate(Project project){
       return projectRepository.save(project);
    }
}
