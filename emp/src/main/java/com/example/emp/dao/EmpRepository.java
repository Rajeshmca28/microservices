package com.example.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.emp.Model.EmpBean;

@Repository
public interface EmpRepository  extends JpaRepository<EmpBean, Long>{

}
