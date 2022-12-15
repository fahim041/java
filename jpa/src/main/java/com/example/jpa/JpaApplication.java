package com.example.jpa;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository){
        return args -> {
            System.out.println("running.......");
//            Faker faker = new Faker();
//            String firstName = faker.name().firstName();
//            String lastName = faker.name().lastName();
//            String email = String.format("%s.%s@gmail.com", firstName, lastName);
//            Student student = new Student(
//              firstName,
//              lastName,
//              email,
//              faker.number().numberBetween(17, 55)
//            );
//
//            student.AddBook(new Book("Book1", LocalDateTime.now().minusDays(4)));
//            student.AddBook(new Book("Book2", LocalDateTime.now()));
//            student.AddBook(new Book("Book3", LocalDateTime.now().minusDays(10)));
//
//
//            StudentIdCard studentIdCard = new StudentIdCard("123456889", student);
//            studentIdCardRepository.save(studentIdCard);

//            studentRepository.findById(24L).ifPresent(student -> System.out.println(student.getStudentIdCard()));

//            studentIdCardRepository.findById(1L).ifPresent(id -> System.out.println(id));

            studentRepository.findById(26L).ifPresent(student -> {
                List<Book> books = student.getBooks();
                System.out.println(books);
            });
        };
    }

    private static void extracted(StudentRepository studentRepository) {
        PageRequest pageRequest = PageRequest.of(1, 5, Sort.by("firstName").ascending());
        Page<Student> page = studentRepository.findAll(pageRequest);
        System.out.println(page.hasNext());
    }

}
