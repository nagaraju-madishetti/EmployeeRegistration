package com.infy;

import com.infy.entity.Employee;
import com.infy.repository.EmployeeRepo;
import com.infy.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class InfyRegistrationApplicationTests {
	@Autowired
    private EmployeeServiceImpl employeeServiceImpl;

	@MockBean
	private EmployeeRepo employeeRepo;
	@Test
	@DisplayName("saveEmployee")
	public void saveEmployee(){
	Employee employee=new Employee();
		employee.setId(6L);
		employee.setName("Shivaji");
		employee.setEmail("shivaji123@gmail.com");
		employee.setLocation("Hyderabad");
		employee.setMobile(7991253748L);
		Mockito.when(employeeRepo.save(employee)).thenReturn(employee);
		Assertions.assertEquals(employeeRepo.save(employee),employeeServiceImpl.saveEmployee(employee));

	}
	@Test
	@DisplayName("getAllEmployees")
	public void getAllEmployees(){
		List<Employee> employeeList=employeeRepo.findAll();
		Mockito.when(employeeList).thenReturn(employeeList);
		Assertions.assertEquals(employeeList,employeeServiceImpl.gellAllEmployees());
	}
	@Test
	@DisplayName("DeleteEmployee")
	public void  deleteEmployee(){
		Long id=1L;
		Mockito.doNothing().when(employeeRepo).deleteById(id);
		employeeServiceImpl.deleteEmployeeById(id);
		Mockito.verify(employeeRepo,Mockito.times(1)).deleteById(id);


	}


}
