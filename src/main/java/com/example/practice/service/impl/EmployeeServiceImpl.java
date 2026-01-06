package com.example.practice.service.impl;

import com.example.practice.db.DBConnection;
import com.example.practice.employeeDto.EmployeeDto;
import com.example.practice.service.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        String sql = "insert into employee(employee_name,employee_nic,employee_age,employee_salary) values (?,?,?,?)";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, employeeDto.getName());
            pst.setString(2, employeeDto.getNic());
            pst.setInt(3, employeeDto.getAge());
            pst.setDouble(4, employeeDto.getSalary());

            pst.executeUpdate();
            return employeeDto;

        } catch (SQLException e) {
            e.printStackTrace();
            return null; // save failed
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return List.of();
    }

    @Override
    public boolean deleteEmployee(String nic) {
        String sql = "delete from employee where employee_nic = ?";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nic);

            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
