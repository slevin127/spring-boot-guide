package org.example.springbootguide.employees;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;

    private String name;

    private String email;

    private LocalDate dateOfBirth;

    private String  address;
@Transient
    private Integer age;

    private Integer salary;

    private String phone;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAge() {
        if (age == null) {
            this.age = Period.between(
                    dateOfBirth, LocalDate.now()).getYears();
        }
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getPhone() {
        return phone;
    }

    public Employee(Long id, String name, String email, LocalDate dateOfBirth, String address, Integer salary, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        this.salary = salary;
        this.phone = phone;
    }
}
