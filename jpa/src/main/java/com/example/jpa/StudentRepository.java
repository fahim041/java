package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("select s from Student s where s.firstName = :firstName and s.age >= :age")
    Optional<Student> findStudentByFirstNameAndAgeIsGreaterThanEqual(@Param("firstName") String firstName, @Param("age") Integer age);
}
