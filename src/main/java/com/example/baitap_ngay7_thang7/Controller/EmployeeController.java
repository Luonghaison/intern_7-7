package com.example.baitap_ngay7_thang7.Controller;

import com.example.baitap_ngay7_thang7.Dto.Request.EmployeeDto;
import com.example.baitap_ngay7_thang7.Model.Employee;
import com.example.baitap_ngay7_thang7.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<?> create(@RequestBody Employee employee) {


        boolean checkEmail = employeeService.emailExist(employee.getEmail());
        if (checkEmail) {
            return new ResponseEntity<>("email đã tồn tại xin thử lại! ", HttpStatus.FAILED_DEPENDENCY);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<?> edit(@RequestBody Employee employee) {
        Employee employeeByEmail = employeeService.findByEmail(employee.getEmail());
        if (employeeByEmail != null && employeeByEmail.getId() != employee.getId()) {
            return new ResponseEntity<>("email đã tồn tại ", HttpStatus.NOT_FOUND);
        }
        employeeService.save(employee);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);

    }

    @GetMapping("/employee")
    public ResponseEntity<?> getall() {
        List<Employee> employeeList = employeeService.getAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/api/employee/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee==null){
            return new ResponseEntity<>("id not found, please try again!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }




}
