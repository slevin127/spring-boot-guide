package org.example.springbootguide.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private final EmployeeService employeeService;


@GetMapping
public List<Employee> helloWorld() {
    return employeeService.getEmployees();
}
@PostMapping
    public Employee createEmployee(
            @RequestBody Employee employee
) {
    return (Employee) employeeService.createEmployee(employee);
}
@DeleteMapping("/{empleyeeId}")
    public void deleteEmployee(
    @PathVariable("empleyeeId") Long id
){
    employeeService.deleteEmployee(id);
}

}

