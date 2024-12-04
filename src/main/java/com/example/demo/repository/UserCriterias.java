package com.example.demo.repository;

import com.example.demo.domain.UserType;

import java.util.Objects;
import java.util.StringJoiner;

public class UserCriterias {

    private String email;
    private UserType type;


    public String getEmail() {
        return email;
    }

    public UserType getType() {
        return type;
    }

    public UserCriterias setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserCriterias setType(UserType type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserCriterias.class.getSimpleName() + "[", "]")
                .add("name='" + email + "'")
                .add("type=" + type)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserCriterias that = (UserCriterias) o;
        return Objects.equals(email, that.email) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, type);
    }
}
