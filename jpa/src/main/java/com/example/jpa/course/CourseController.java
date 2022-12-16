package com.example.jpa.course;

import com.example.jpa.book.Book;
import com.example.jpa.book.BookRepository;
import com.example.jpa.exception.NotFoundException;
import com.example.jpa.semester.Semester;
import com.example.jpa.semester.SemesterRepository;
import com.example.jpa.student.Student;
import com.example.jpa.student.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses/")
public class CourseController {
    private final CourseRepository courseRepository;
    private final SemesterRepository semesterRepository;

    private final StudentRepository studentRepository;

    private final BookRepository bookRepository;

    public CourseController(CourseRepository courseRepository, SemesterRepository semesterRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.courseRepository = courseRepository;
        this.semesterRepository = semesterRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }


    @GetMapping
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @GetMapping("/{courseId}/")
    public Course getCourse(@PathVariable Long courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Course not found"));
        return course;
    }

    @PatchMapping("/{courseId}/")
    public Course updateCourse(@PathVariable Long courseId,@RequestBody Course course){
        Course course1 = courseRepository.findById(courseId).orElseThrow(() -> new NotFoundException("Course not found"));
        course1.setName(course.getName());
        return courseRepository.save(course1);
    }

    @PutMapping("/{courseId}/semester/{semesterId}/")
    public Course assignSemester(@PathVariable Long courseId, @PathVariable Long semesterId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()  -> new NotFoundException("Course not found!"));
        Semester semester = semesterRepository.findById(semesterId).get();
        course.assignSemester(semester);
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/student/{studentId}/")
    public Course assignStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()  -> new NotFoundException("Course not found!"));
//        Semester semester = semesterRepository.findById(studentId).get();
        Student student = studentRepository.findById(studentId).get();
        course.assignStudent(student);
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/book/{bookId}/")
    public Course assignBook(@PathVariable Long courseId, @PathVariable Long bookId) {
        Course course = courseRepository.findById(courseId).orElseThrow(()  -> new NotFoundException("Course not found!"));
        Book book = bookRepository.findById(bookId).get();
        course.assignBook(book);
        return courseRepository.save(course);
    }
}
