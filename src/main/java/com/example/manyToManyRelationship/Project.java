package com.example.manyToManyRelationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int project_id;
    private String project_name;
    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList;

    public Project() {
    }

    public int getProject_id() {
        return project_id;
    }

    public Project(int project_id, String project_name, List<Employee> employeeList) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.employeeList = employeeList;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public List<Employee> getEmployeList() {
        return employeeList;
    }

    public void setEmployeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
