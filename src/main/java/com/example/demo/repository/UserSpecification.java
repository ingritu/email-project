package com.example.demo.repository;

import com.example.demo.domain.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    public static Specification<User> findBy(UserCriterias criterias) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criterias.getEmail() != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), criterias.getEmail()));
            }
            if (criterias.getType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("type"), criterias.getType()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
