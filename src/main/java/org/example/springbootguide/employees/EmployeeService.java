package org.example.springbootguide.employees;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
//        return List.of(
//                new Employee(
//                        1L,
//                        "Vasili",
//                        "vsil@gmail.com",
//                        LocalDate.of(1987, 11, 18),
//                        "Norilsk, Bogdana Hmelnickogo str. house 1, ",
//                        36,
//                        100000,
//                        "+7-902-552-03-57"
//
//                ),
//                new Employee(
//                        2L,
//                        "Alexandr",
//                        "alex@gmail.com",
//                        LocalDate.of(1987, 12, 25),
//                        "Norilsk, Bogdana Hmelnickogo str. house 3, ",
//                        36,
//                        200000,
//                        "+7-911-552-03-57"
//                )
//
//
//        );
        return employeeRepository.findAll();
    }

    public Object createEmployee(Employee employee) {

        if (employee.getId() != null) {
            throw new IllegalArgumentException("Id must be null");

        } if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (employee.getSalary() <= 50000) {
            throw new IllegalArgumentException("Salary must be greater than or equal to 50000");
        }

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Employee with id " + id + " already exists");
        }
        employeeRepository.deleteById(id);
    }
    @Transactional
    public void updateEmployee(
            Long id,
            String email,
            Integer salary
    ){
        var employee = employeeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Employee with id " + id + " does not exist")
        );
        if (email != null && !email.isEmpty()
        && !email.equals(employee.getEmail())) {
            Optional<Employee> employeeOpt = employeeRepository.findByEmail(email);
            if (employeeOpt.isPresent()) {
                throw new IllegalArgumentException("Employee with email " + email + " already exists");
            }
        employee.setEmail(email);
        }
        if (salary != null) {
            if (salary <= 50000) {
                throw new IllegalArgumentException("Salary must be greater than or equal to 50000");
            }
            employee.setSalary(salary);
        }
    }
}

