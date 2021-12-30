package com.mami.luv2codes.Dao;

import com.mami.luv2codes.model.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmplyeeDaoHibernateImpl implements EmployeeDAO {

  //Define field for entitymanager
  private EntityManager entityManager;


  //setup constructor injection
  @Autowired //not required
  public EmplyeeDaoHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }


  @Override
  public List<Employee> findAll() {

    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // create a query
    Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

    // execute query and get result list
    List<Employee> employees = theQuery.getResultList();

    // return the results
    return employees;

  }

  @Override
  public Employee findById(int theId) {

    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // execute query
    Employee theEmployee = currentSession.get(Employee.class, theId);

    // return the results

    return theEmployee;
  }

  @Override
  public void save(Employee theEmployee) {
    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);
    // save employee
   currentSession.saveOrUpdate(theEmployee);
  }

  @Override
  public void deleteById(int theId) {
    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);
    // delete object with primary key
    Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
    query.setParameter("employeeId",theId);
    query.executeUpdate();
  }
}
