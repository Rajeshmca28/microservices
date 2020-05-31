package com.example.dept.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.dept.model.DeptBean;

@Repository
public interface DeptRepository  extends JpaRepository<DeptBean, Long>{

}

