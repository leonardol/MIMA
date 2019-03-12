package com.pCarpet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.EmployeeConverter;
import com.pCarpet.dao.EmployeeDAO;
import com.pCarpet.dto.EmployeeDTO;
import com.pCarpet.model.Employee;
import com.pCarpet.model.User;

@Service
public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public EmployeeDTO insertEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeConverter.convertToEntity(employeeDTO);
		employeeDAO.saveAndFlush(employee);
		return EmployeeConverter.convertToDto(employee);
	}
	
	public boolean deleteEmployeeById(EmployeeDTO employee) {
		employeeDAO.deleteById(employee.getId());
		return true;
	}
	
	public List<EmployeeDTO> getEmployeeByIdBusinessOwner(int id){
		User businessOwner = new User();
		businessOwner.setId(id);
		return (EmployeeConverter.toListDTO(employeeDAO.findAllByBusinessOwner(businessOwner)));
	}
	
	public EmployeeDTO getEmployeeById(int id) {
		return EmployeeConverter.convertToDto(employeeDAO.findEmployeeById(id));
	}
}
