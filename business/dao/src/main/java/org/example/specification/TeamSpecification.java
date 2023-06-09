package org.example.specification;

import jakarta.persistence.criteria.Predicate;
import org.example.model.Team;
import org.springframework.data.jpa.domain.Specification;

public class TeamSpecification {

    public static Specification<Team> findByKeyword(String keyword) {
        return (root, query, builder) -> {
            Predicate keywordPredicate = builder.or(
                    builder.like(root.get("name"), "%" + keyword + "%")
            );
            return builder.and(keywordPredicate);
        };
    }

}
