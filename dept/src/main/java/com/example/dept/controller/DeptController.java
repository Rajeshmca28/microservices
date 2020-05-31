package com.example.dept.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dept.dao.DeptRepository;
import com.example.dept.fc.EmpClient;
import com.example.dept.fc.dto.EmpBean;
import com.example.dept.model.DeptBean;
import com.example.dept.service.DeptService;
import in.clarolabs.base.response.BooleanResponse;
import in.clarolabs.exceptions.ClaroError;
import in.clarolabs.exceptions.ClaroException;
import in.clarolabs.response.ResponseBean;
import in.clarolabs.response.ResponseBuilder;

@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class DeptController {

  @Autowired
  DeptService deptService;
  
  @Autowired
  EmpClient empclient;

  @Autowired
  DeptRepository deptRepository;

  @GetMapping(path = "/dept/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<DeptBean> getCropByDate() {
    return deptService.getAll();
  }

  @GetMapping(path = "fetchAllEmp", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EmpBean> getAllEmp() {
    return empclient.getAll();
  }
  
  @PostMapping(path = "/save/department", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE, headers = {"Accept=application/json"})
  public ResponseBean updateMandiPrice(@RequestBody DeptBean request) {
    ResponseBuilder builder = new ResponseBuilder();
    BooleanResponse data = new BooleanResponse();
    ClaroError claroError = null;
    try {
      data.setResult(deptService.saveDepartment(request));
    } catch (ClaroException e) {
      claroError = e.getClaroError();
    }
    builder.setData(data);
    builder.setError(claroError);
    return builder.build();
  }

  @PostMapping("/update/dept/{id}")
  public DeptBean updateNote(@PathVariable(value = "id") long id, @RequestBody DeptBean bean) {

    DeptBean dept = deptService.getById(id);
    dept.setDeptId(bean.getDeptId());
    dept.setName(bean.getName());;

    DeptBean updateDepartment = deptService.saveDept(dept);
    return updateDepartment;
  }

  @PostMapping("/delete/dept/{id}")
  public boolean deleteDept(@PathVariable(value = "id") long id) {

    DeptBean dept = deptService.getById(id);
    deptService.deleteById(id);
    return true;
  }

}
