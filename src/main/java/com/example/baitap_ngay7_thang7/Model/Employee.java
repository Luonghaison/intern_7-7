package com.example.baitap_ngay7_thang7.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    private int id;
    private String name;
    private String email;
    private String department;
    private List<String> roles;
}
