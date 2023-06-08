package org.example.specification;

import jakarta.persistence.criteria.Predicate;
import org.example.libs.ProjStatus;
import org.example.model.Project;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProjectSpecification {

    public static Specification<Project> findByKeywordAndStatus(String keyword, List<ProjStatus> statuses) {
        return (root, query, builder) -> {
            Predicate keywordPredicate = builder.or(
                    builder.like(root.get("name"), "%" + keyword + "%"),
                    builder.like(root.get("description"), "%" + keyword + "%")
            );
            Predicate statusPredicate = null;
            if (statuses!=null) {
                statusPredicate = root.get("empStatus").in(statuses);
            }
            return statusPredicate != null ? builder.and(keywordPredicate, statusPredicate) : keywordPredicate;
        };
    }

}
