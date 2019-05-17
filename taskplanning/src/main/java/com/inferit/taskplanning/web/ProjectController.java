package com.inferit.taskplanning.web;


import com.inferit.taskplanning.domain.Project;
import com.inferit.taskplanning.services.MapFieldErrorService;
import com.inferit.taskplanning.services.ProjectService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/project")
@Data
public class ProjectController {

    private ProjectService projectService;
    private MapFieldErrorService mapFieldErrorService;
    public ProjectController(ProjectService projectService,MapFieldErrorService mapFieldErrorService){
        this.projectService=projectService;
        this.mapFieldErrorService=mapFieldErrorService;
    }
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> errorMap=mapFieldErrorService.mapFieldError(result);
        if(errorMap!=null)return errorMap;

        Project project1=projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
}
