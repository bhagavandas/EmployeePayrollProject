package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.EmailDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.model.EmployeeModel;

public interface IEmployeeService {

	 RegisterDTO register(RegisterDTO registerDTO);

	

	String login(LoginDTO loginDTO);

	String logout(String token);

	RegisterDTO update(RegisterDTO registerDTO, String token);

	public List<EmployeeModel> getAllEmployees();

	//public RegisterDTO updateByEmployeeId(RegisterDTO employee, int employeeId);

	RegisterDTO updateByEmail(RegisterDTO employee, String email);
	RegisterDTO getEmployee(int employeeId);


	Optional<EmployeeModel> deleteEmail();



	//RegisterDTO searchByEmail(String email);



	String sendMail(EmailDTO mail);



	//Optional<EmployeeModel> deleteEmployeeName(String employeeName);



	Optional<EmployeeModel> deleteEmployeeId(int employeeId);



	RegisterDTO searchByEmployeeName(String employeeName);

}
