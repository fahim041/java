package com.example.jpa.course;

import com.example.jpa.book.Book;
import com.example.jpa.semester.Semester;
import com.example.jpa.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(
            name = "semester_id",
            referencedColumnName = "id"
    )
    @JsonIgnoreProperties(value = {"courses", "id"})
    private Semester semesters;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnoreProperties("courses")
    private List<Student> students;

    @OneToOne(optional = true)
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "id"
    )
    @JsonIgnoreProperties("course")
    private Book book;


    public void assignSemester(Semester semester){
        this.semesters = semester;
    }

    public void assignStudent(Student student){
        this.students.add(student);
    }

    public void assignBook(Book book){
        this.book = book;
    }

    @JsonIgnore
    public boolean isExist(){
        return id < 0 ? false: true;
    }

}
