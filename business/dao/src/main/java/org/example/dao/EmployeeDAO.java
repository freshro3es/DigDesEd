package org.example.dao;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import jakarta.persistence.criteria.*;
//import org.example.model.Employee;
//import org.example.model.Team;
//import org.example.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class EmployeeDAO {
//
//    private final EntityManager entityManager;
//
//    @Autowired
//    public EmployeeDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
//    }
//
//    @Override
//    public List<Employee> findAllWithParam(Specification<Employee> spec) {
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
//        Root<Employee> employeeRoot = cq.from(Employee.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        if (firstName != null) {
//            predicates.add(cb.equal(employeeRoot.get("firstName"), firstName));
//        }
//        if (lastName != null) {
//            predicates.add(cb.equal(employeeRoot.get("lastName"), lastName));
//        }
//        if (fatherName != null) {
//            predicates.add(cb.equal(employeeRoot.get("fatherName"), fatherName));
//        }
//        if (position != null) {
//            predicates.add(cb.equal(employeeRoot.get("position"), position));
//        }
//        if (account != null) {
//            predicates.add(cb.equal(employeeRoot.get("account"), account));
//        }
//        if (email != null) {
//            predicates.add(cb.equal(employeeRoot.get("email"), email));
//        }
//        if (status != null) {
//            predicates.add(cb.equal(employeeRoot.get("status"), status));
//        }
//        if (role != null) {
//            Join<Employee, Team> employeeTeamJoin = employeeRoot.join("team");
//            predicates.add(cb.equal(employeeTeamJoin.get("role"), role));
//        }
//
//        cq.where(predicates.toArray(new Predicate[0]));
//
//        TypedQuery<Employee> query = entityManager.createQuery(cq);
//
//        return query.getResultList();
//    }
//
//    @Override
//    public Employee findById(Long id) {
//        return entityManager.find(Employee.class, id);
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        entityManager.persist(employee);
//        return employee;
//    }
//
//    @Override
//    public Employee update(Employee employee) {
//        entityManager.merge(employee);
//        return employee;
//    }
//
//    @Override
//    public void delete(Employee employee) {
//        entityManager.remove(employee);
////        return employee;
//    }
//}