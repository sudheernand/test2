package com.indus.training.persist.service;

import com.indus.training.persist.entity.EmployeeDetails;
import com.indus.training.persist.exception.EmployeeDAOException;

public interface IEmployeeDAO {
	public boolean select(int id) throws EmployeeDAOException;

	public void create(EmployeeDetails empDetailsObj) throws EmployeeDAOException;

	public void update(EmployeeDetails empDetailsObj);

}
