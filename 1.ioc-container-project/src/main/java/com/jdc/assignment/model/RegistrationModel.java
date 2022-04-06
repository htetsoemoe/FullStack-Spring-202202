package com.jdc.assignment.model;

import java.util.List;


import com.jdc.assignment.domain.Registration;

public interface RegistrationModel {
	public List<Registration> findByCourseId(int openClassId);
	public void createRegistration(Registration registration);

}
