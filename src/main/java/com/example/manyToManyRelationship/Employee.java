package com.example.manyToManyRelationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Employee {
    @Id
    private int employee_id;
    private String employee_name;
    @ManyToMany
    private List<Project> projectList;

    public Employee() {
    }

    public Employee(int employee_id, String employee_name, List<Project> projectList) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.projectList = projectList;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
