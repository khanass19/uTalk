package com.example.project.specification;

import com.example.project.dto.UserSpecRequest;
import com.example.project.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<User> {

    private UserSpecRequest userSpecRequest;

    public UserSpecification(UserSpecRequest userSpecRequest) {
        this.userSpecRequest = userSpecRequest;
    }

    @Override
    public Predicate toPredicate(Root<User> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate predicateFirstName = criteriaBuilder.like(root.<String>get("firstName"),"%"+ userSpecRequest.getFirstName() + "%");
        Predicate predicateLastName = criteriaBuilder.like(root.<String>get("lastName"),"%"+ userSpecRequest.getLastName() + "%");
        return criteriaBuilder.and(predicateFirstName,predicateLastName);
    }

}
