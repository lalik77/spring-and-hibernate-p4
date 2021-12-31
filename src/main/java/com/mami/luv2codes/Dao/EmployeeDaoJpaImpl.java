package com.mami.luv2codes.Dao;

import com.mami.luv2codes.model.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired // not a requirement
  public EmployeeDaoJpaImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {

    // create a query
    Query theQuery = entityManager.createQuery("from Employee");
    // execute query and get result list
    List employees = theQuery.getResultList();
    //return the results

    return employees;
  }

  @Override
  public Employee findById(int theId) {

    Employee theEmpl = entityManager.find(Employee.class,theId);

    return theEmpl;
  }

  @Override
  public void save(Employee theEmployee) {

    Employee dbEmployee = entityManager.merge(theEmployee);
    theEmployee.setId(dbEmployee.getId());

  }

  @Override
  public void deleteById(int theId) {

    Query thQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
    thQuery.setParameter("employeeId",theId);
    thQuery.executeUpdate();

  }
}
