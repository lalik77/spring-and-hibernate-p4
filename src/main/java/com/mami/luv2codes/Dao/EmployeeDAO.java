package com.mami.luv2codes.Dao;

import com.mami.luv2codes.model.Employee;
import java.util.List;

public interface EmployeeDAO {

  List<Employee> findAll();
  Employee findById(int theId);
  void save(Employee theEmployee);
  void deleteById(int theId);

}
