package com.inferit.taskplanning.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Project must have a name.")
    private String projectName;
    @NotBlank(message="Project need a Identifier")
    @Size(min=4, max=10, message = "Create an Identifier of 4 to 10 charecters")
    @Column(unique= true,updatable = false)
    private String projectIdentifier;
    @NotBlank(message="Project should have a description")
    private String projectDescription;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updatedDate;

    public Project(){}

    @PrePersist
    protected void onCreate(){
        createdDate =new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedDate=new Date();
    }

}
