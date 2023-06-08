package org.example.specification;

import jakarta.persistence.criteria.Predicate;
import org.example.libs.EmpStatus;
import org.example.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> findByKeywordAndStatus(String keyword, EmpStatus empStatus) {
        return (root, query, builder) -> {
            Predicate keywordPredicate = builder.or(
                    builder.like(root.get("firstName"), "%" + keyword + "%"),
                    builder.like(root.get("lastName"), "%" + keyword + "%"),
                    builder.like(root.get("fatherName"), "%" + keyword + "%"),
                    builder.like(root.get("account"), "%" + keyword + "%"),
                    builder.like(root.get("email"), "%" + keyword + "%")
            );
            Predicate statusPredicate = builder.equal(root.get("empStatus"), empStatus);
            return builder.and(keywordPredicate, statusPredicate);
        };
    }

}
