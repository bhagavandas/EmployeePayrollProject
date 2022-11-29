package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.model.EmployeeModel;
import com.example.demo.service.IEmployeeService;
import com.example.demo.utilities.JwtTokenUtil;

@RestController
@CrossOrigin("http://localhost:3000/")
public class Controller {

	@Autowired
	IEmployeeService employeeService;
	@Autowired
	JwtTokenUtil tokenUtil;

	@PostMapping("/registerEmployee")
	public ResponseEntity registerUser(@RequestBody RegisterDTO registerDTO) {
		RegisterDTO register = employeeService.register(registerDTO);
		return new ResponseEntity(register, "Registered successfully");
	}

//	@GetMapping("/searchEmployee")
//	public ResponseEntity searchEmployee(@RequestParam String email) {
//		RegisterDTO model = employeeService.searchByEmail(email);
//		return new ResponseEntity(model, "Fetched successfully");
//	}
	
	@GetMapping("/searchEmployee")
	public ResponseEntity searchEmployee(@RequestParam String employeeName) {
		RegisterDTO model = employeeService.searchByEmployeeName(employeeName);
		return new ResponseEntity(model, "Fetched successfully");
	}
	
	@GetMapping("/getsingleemployee/{employeeId}")
	public ResponseEntity getEmployee(@PathVariable int employeeId) {
		RegisterDTO empDto = employeeService.getEmployee(employeeId);
		return new ResponseEntity(empDto,"Details of single Employee");
	}
	

//	@Transactional
//	@DeleteMapping("/deleteEmployee")
//	public ResponseEntity deleteEmployee(@RequestParam String employeeName) {
//		Optional<EmployeeModel> model = employeeService.deleteEmail();
//		return new ResponseEntity(model, "Deleted successfully");
//	}
	
//	@DeleteMapping("/deleteEmployee")
//	@Transactional
//	public ResponseEntity deleteEmployee(@RequestParam String employeeName) {
//		Optional<EmployeeModel> model = employeeService.deleteEmployeeName(employeeName);
//		return new ResponseEntity(model, "Deleted successfully");
//	}
	
	@DeleteMapping("/deleteEmployee")
	@Transactional
	public ResponseEntity deleteEmployee(@RequestParam int employeeId) {
		Optional<EmployeeModel> model = employeeService.deleteEmployeeId(employeeId);
		return new ResponseEntity(model, "Deleted successfully");
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity updateEmployee(@RequestBody RegisterDTO employee, @RequestParam String email) {
		RegisterDTO register = employeeService.updateByEmail(employee, email);
		return new ResponseEntity(register, "Successfully updated by ID");
	}

	@GetMapping("/login")
	public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
		String login = employeeService.login(loginDTO);
		System.out.println("Login SuccessFully!!!");
		return new ResponseEntity(login, "Login successfully");
	}

	@GetMapping("/logout")
	public ResponseEntity logout(@RequestHeader String token) {
		String logout = employeeService.logout(token);
		System.out.println("Logout SuccessFully!!!");
		return new ResponseEntity(logout, "Logout successfully");
	}
	
	@PutMapping("/updateEmployeeByToken")
	public ResponseEntity updateUserByToken(@RequestBody RegisterDTO registerDTO, @RequestHeader String token) {
		RegisterDTO register = employeeService.update(registerDTO, token);
		return new ResponseEntity(register, "User updated successfully");
	}
	
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity getAllUser() {
		List<EmployeeModel> userModel1 = employeeService.getAllEmployees();
		return new ResponseEntity(userModel1, "Fetched Employees successfully");
	}

}
