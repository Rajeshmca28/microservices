package com.example.emp.controller;

import java.util.List;
import javax.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.emp.Model.EmpBean;
import com.example.emp.service.EmpService;
import in.clarolabs.base.response.BooleanResponse;
import in.clarolabs.exceptions.ClaroError;
import in.clarolabs.exceptions.ClaroException;
import in.clarolabs.response.ResponseBean;
import in.clarolabs.response.ResponseBuilder;

@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class EmpController {

  @Autowired
  EmpService empService;

  @GetMapping(path = "/emp/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EmpBean> getCropByDate() {
    return empService.getAll();
  }

  @PostMapping(path = "/save/emp", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE, headers = {"Accept=application/json"})
  public ResponseBean updateMandiPrice(@RequestBody EmpBean request) {
    ResponseBuilder builder = new ResponseBuilder();
    BooleanResponse data = new BooleanResponse();
    ClaroError claroError = null;
    try {
      data.setResult(empService.saveEmployee(request));
    } catch (ClaroException e) {
      claroError = e.getClaroError();
    }
    builder.setData(data);
    builder.setError(claroError);
    return builder.build();
  }

  @PostMapping("/update/dept/{id}")
  public EmpBean updateNote(@PathVariable(value = "id") long id, @RequestBody EmpBean bean) {

    EmpBean emp = empService.getById(id);
    emp.setEmpId(bean.getEmpId());
    emp.setEmpName(bean.getEmpName());
    emp.setAddr(bean.getAddr());
    emp.setAge(bean.getAge());
    emp.setSalary(bean.getSalary());

    EmpBean empDepartment = empService.saveEmp(emp);
    return empDepartment;
  }

  @PostMapping("/delete/dept/{id}")
  public boolean deleteDept(@PathVariable(value = "id") long id) {

    EmpBean dept = empService.getById(id);
    empService.deleteById(id);
    return true;
  }


}

