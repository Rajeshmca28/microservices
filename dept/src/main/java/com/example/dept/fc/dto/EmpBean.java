package com.example.dept.fc.dto;

public class EmpBean {
  private long id;
  private String empId;
  private String empName;
  private int age;
  private String addr;
  private double salary;

  public EmpBean() {}

  public EmpBean(String empId, String empName, int age, String addr, double salary) {
    super();
    this.empId = empId;
    this.empName = empName;
    this.age = age;
    this.addr = addr;
    this.salary = salary;
  }

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
