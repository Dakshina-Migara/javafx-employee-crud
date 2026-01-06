package com.example.practice.employeeDto;

public class EmployeeDto {
    private String name;
    private String nic;
    private int age;
    private double salary;

    public EmployeeDto(String name, String nic, int age, double salary) {
        this.setName(name);
        this.setNic(nic);
        this.setAge(age);
       this.setSalary(salary);
    }

    public EmployeeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
