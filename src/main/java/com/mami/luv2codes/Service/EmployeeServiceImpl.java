package com.mami.luv2codes.Service;

import com.mami.luv2codes.Dao.EmployeeDAO;
import com.mami.luv2codes.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDAO employeeDAO;

  @Autowired //not required
  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee findById(int theId) {
    return employeeDAO.findById(theId);
  }

  @Override
  @Transactional
  public void save(Employee theEmployee) {
    employeeDAO.save(theEmployee);
  }

  @Override
  @Transactional
  public void deleteById(int theId) {
    employeeDAO.deleteById(theId);
  }
}