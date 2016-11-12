package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Employee;
import model.connection.ConnectionFactory;
import javax.persistence.NoResultException;

public class EmployeeDAO implements InterfaceDAO<Employee>{
    
    private static final String QUERY_FIND = "SELECT e FROM Employee e WHERE e.login = :login AND e.password = :password";
    
    @Override
    public Employee findById(Integer id){
        EntityManager manager = new ConnectionFactory().getConnection();
        Employee emp = manager.find(Employee.class, id);
        manager.close();
        return emp;
    }
    
    @Override
    public void save(Employee employee){
               
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        manager.merge(employee);
        manager.getTransaction().commit();
        manager.close();
    }
    
    @Override
    public void remove(Employee employee){
        EntityManager manager = new ConnectionFactory().getConnection();
        manager.getTransaction().begin();
        employee = manager.find(Employee.class, employee.getIdEmployee());
        manager.remove(employee);
        manager.getTransaction().commit();
        manager.close();
    }
    
    @Override
    public Employee findForObject(Employee employee) {
        EntityManager manager = new ConnectionFactory().getConnection();
        Query query = manager.createQuery(QUERY_FIND, Employee.class);
        query.setParameter("login", employee.getLogin());
        query.setParameter("password", employee.getPassword());
        
        Employee employeeBD = null;
        try{
            employeeBD = (Employee) query.getSingleResult();
        } catch (NoResultException e){
            System.out.println("Objeto Employee não encontrado no BD!");
            return null;
        } finally {
            manager.close();
        }
        
        return employeeBD;
    }
}
