package com.example.baitap_ngay7_thang7.Service;

import com.example.baitap_ngay7_thang7.Model.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeService {
    public static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee findById(int id) {
        for (Employee employee : employeeList
        ) {
            if (employee.getId() == id) {
                return employee;
            }
        }
       return null;
    }

    public void save(Employee employee) {
        if (employee.getId() == 0) {
            int id = employeeList.get(employeeList.size() - 1).getId() + 1;
            employee.setId(id);
            employeeList.add(employee);
        } else {
            employeeList.set(employeeList.indexOf(findById(employee.getId())), employee);
        }
    }

    public void deleteById(int id) {
        Employee employee = findById(id);
        if (employee == null) {
            throw new EntityNotFoundException("Không thể tìm thấy employee cùng id: " + id);
        }
        employeeList.remove(id);
    }

    public boolean emailExist(String email) {
        for (Employee employee : employeeList) {
            if (employee.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Employee findByEmail(String email) {
        for (Employee e : employeeList) {
            if (e.getEmail().equals(email)) {
                return e;
            }
        }
        return null;
    }
}

