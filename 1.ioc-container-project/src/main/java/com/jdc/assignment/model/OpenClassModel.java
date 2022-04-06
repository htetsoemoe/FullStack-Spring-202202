package com.jdc.assignment.model;

import java.util.List;

import com.jdc.assignment.domain.OpenClass;

public interface OpenClassModel {
	
	List<OpenClass> findByCourse(int courseId);
	void createClass(OpenClass openClass);
	public OpenClass findById(int openClassId, int courseId);
}
