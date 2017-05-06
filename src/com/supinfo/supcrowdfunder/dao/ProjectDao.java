package com.supinfo.supcrowdfunder.dao;

import java.util.List;

import com.supinfo.supcrowdfunder.entity.Project;

public interface ProjectDao {
	
	Project addProject(Project project);
	
	Project getProjectById(Long projectId);
	
	List<Project> getAllProjects();
	
	void removeProject(Project project);
	
	void removeProject(Long projectId);
	
	List<Project> getProjectsByCategory(Long catId);
	
	public void updateProject(Project project);

}