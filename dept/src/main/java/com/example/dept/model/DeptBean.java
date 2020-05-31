package com.example.dept.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="dept")
public class DeptBean {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "dept_id")
  private String deptId;
  @Column(name = "name")
  private String name;
  
  public DeptBean() {}
  public DeptBean(String deptId, String name) {
    super();
    this.deptId = deptId;
    this.name = name;
  }
  public String getDeptId() {
    return deptId;
  }
  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
