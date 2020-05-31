package com.example.emp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.lambda.model.ResourceNotFoundException;
import com.example.emp.Model.EmpBean;
import com.example.emp.dao.EmpRepository;

@Service
public class EmpService {

  
  @Autowired
  EmpRepository empRepository;
  
  public List<EmpBean> getAll(){
    return empRepository.findAll();
  }

public boolean saveEmployee(EmpBean request) {
  saveEmp(request);
return true;
}

public EmpBean saveEmp(EmpBean bean) {
  return empRepository.save(bean);
}

public EmpBean getById(long id) {
  return empRepository.findById(id).get();//.orElseThrow(() -> new ResourceNotFoundException("Department not found"));
}
public void deleteById(long id) {
  empRepository.deleteById(id);

}

}
