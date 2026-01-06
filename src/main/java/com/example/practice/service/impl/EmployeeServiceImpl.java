package com.example.practice.service.impl;

import com.example.practice.db.DBConnection;
import com.example.practice.employeeDto.EmployeeDto;
import com.example.practice.service.EmployeeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
            return null;
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<EmployeeDto> employees = new ArrayList<>();

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            var rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("employee_name");
                String nic = rs.getString("employee_nic");
                int age = rs.getInt("employee_age");
                double salary = rs.getDouble("employee_salary");

                EmployeeDto employee = new EmployeeDto(name, nic, age, salary);
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
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

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {
        String sql = "update employee set employee_name = ?, employee_age = ?, employee_salary = ? WHERE employee_nic = ?";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, employeeDto.getName());
            pst.setInt(2, employeeDto.getAge());
            pst.setDouble(3, employeeDto.getSalary());
            pst.setString(4, employeeDto.getNic());

            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public EmployeeDto getEmployeeByNic(String nic) {
        String sql = "SELECT * FROM employee WHERE employee_nic = ?";

        try {

            Connection conn = DBConnection.getInstance().getConnection();

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nic);

            var rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("employee_name");
                int age = rs.getInt("employee_age");
                double salary = rs.getDouble("employee_salary");

                return new EmployeeDto(name, nic, age, salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
