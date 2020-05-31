package com.example.dept.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.lambda.model.ResourceNotFoundException;
import com.example.dept.dao.DeptRepository;
import com.example.dept.model.DeptBean;

@Service
public class DeptService {
  
@Autowired
DeptRepository deptRepository;


public List<DeptBean> getAll(){
  return deptRepository.findAll();
}


public boolean saveDepartment(DeptBean request) {
  saveDept(request);
return true;
}

public DeptBean saveDept(DeptBean bean) {
  return deptRepository.save(bean);
}

public DeptBean getById(long id) {
  return deptRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found"));
}
public void deleteById(long id) {
 deptRepository.deleteById(id);

}
}
