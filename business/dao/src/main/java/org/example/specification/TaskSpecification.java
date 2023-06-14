package org.example.specification;

import jakarta.persistence.criteria.*;
import org.example.dto.search.SearchTaskDTO;
import org.example.libs.TaskStatus;
import org.example.model.Employee;
import org.example.model.Task;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TaskSpecification {

    public static Specification<Task> findWithFilter(SearchTaskDTO searchTaskDTO) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            // Фильтр по текстовому полю
            if (searchTaskDTO.getSearch() != null) {
                predicates.add(builder.like(
                        builder.lower(root.get("name")),
                        "%" + searchTaskDTO.getSearch().toLowerCase() + "%"));
            }

            // Фильтр по статусу задачи
            if (searchTaskDTO.getStatusFilter() != null && !searchTaskDTO.getStatusFilter().isEmpty()) {
                predicates.add(root.<TaskStatus>get("status").in(searchTaskDTO.getStatusFilter()));
            }

            // Фильтр по исполнителю
            if (searchTaskDTO.getEmployeeId() != null) {
                Join<Task, Employee> employeeJoin = root.join("employee");
                predicates.add(builder.equal(employeeJoin.<Long>get("id"), searchTaskDTO.getEmployeeId()));
            }

            // Фильтр по автору
            if (searchTaskDTO.getAuthorId() != null) {
                predicates.add(builder.equal(root.<Long>get("authorId"), searchTaskDTO.getAuthorId()));
            }

            // Фильтр по крайнему сроку задачи
            if (searchTaskDTO.getDeadlineFrom() != null && searchTaskDTO.getDeadlineTo() != null) {
                predicates.add(builder.between(
                        root.get("deadline"),
                        searchTaskDTO.getDeadlineFrom(),
                        searchTaskDTO.getDeadlineTo()));
            } else if (searchTaskDTO.getDeadlineFrom() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get("deadline"), searchTaskDTO.getDeadlineFrom()));
            } else if (searchTaskDTO.getDeadlineTo() != null) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get("deadline"), searchTaskDTO.getDeadlineTo()));
            }

            // Фильтр по периоду создания задачи
            if (searchTaskDTO.getCreationFrom() != null && searchTaskDTO.getCreationTo() != null) {
                predicates.add(builder.between(
                        root.get("creationDate"),
                        searchTaskDTO.getCreationFrom(),
                        searchTaskDTO.getCreationTo()));
            } else if (searchTaskDTO.getCreationFrom() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get("creationDate"), searchTaskDTO.getCreationFrom()));
            } else if (searchTaskDTO.getCreationTo() != null) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get("creationDate"), searchTaskDTO.getCreationTo()));
            }

            // Сортировка по дате создания в обратном порядке
            query.orderBy(builder.desc(root.get("creationDate")));

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
