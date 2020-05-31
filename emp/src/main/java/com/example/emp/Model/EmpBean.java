package com.example.emp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="emp")
public class EmpBean {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
  private long id;
  @Column(name = "emp_id")
  private String empId;
  @Column(name = "emp_name")
  private String empName;
  @Column(name = "age")
  private int age;
  @Column(name = "addr")
  private String addr;
  @Column(name = "salary")
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
