package com.example.studentapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final List<Student> students = new ArrayList<>();
    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {

        if (student.getName() == null || student.getName().isBlank() ||
            student.getCourse() == null || student.getCourse().isBlank()) {
            return ResponseEntity.badRequest().body("Name and course must not be empty");
        }

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Student with ID " + student.getId() + " already exists");
            }
        }

        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Student with ID " + id + " not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                return ResponseEntity.ok("Student deleted successfully");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Student with ID " + id + " not found");
    }
}
