//package org.example.repository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import org.example.libs.EmpStatus;
//import org.example.model.Employee;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EmployeeRepositoryImpl implements EmployeeRepository {
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Override
//    public List<Employee> search(String keyword) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
//        Root<Employee> root = cq.from(Employee.class);
//
//        Predicate predicate = cb.and(
//                cb.or(
//                        cb.like(root.get("firstName"), "%" + keyword + "%"),
//                        cb.like(root.get("lastName"), "%" + keyword + "%"),
//                        cb.like(root.get("fatherName"), "%" + keyword + "%"),
//                        cb.like(root.get("account"), "%" + keyword + "%"),
//                        cb.like(root.get("email"), "%" + keyword + "%")
//                ),
//                cb.equal(root.get("empStatus"), EmpStatus.ACTIVE)
//        );
//
//        cq.select(root).where(predicate);
//        return entityManager.createQuery(cq).getResultList();
//    }
//}
