package com.example.dept.fc;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.dept.fc.dto.EmpBean;

@FeignClient(name = "emp-service", url = "http://localhost:8081")
public interface EmpClient {
  
  @GetMapping(path = "/emp/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EmpBean> getAll() ;

}
