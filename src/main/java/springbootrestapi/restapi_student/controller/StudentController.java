package springbootrestapi.restapi_student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrestapi.restapi_student.model.dto.response.ApiData;
import springbootrestapi.restapi_student.model.entity.Student;
import springbootrestapi.restapi_student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiData<List<Student>>> getStudents() {
        return new ResponseEntity<>(new ApiData(
                true,
                "Get all students successfully!",
                studentService.getAllStudents(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiData<Student>> getStudentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ApiData(
                true,
                "Get student " + id + "successfully!",
                studentService.getStudentById(id),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiData<Student>> insertStudent(@RequestBody Student student) {
        return new ResponseEntity<>(new ApiData(
                true,
                "Insert student successfully!",
                studentService.insertStudent(student),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiData<Student>> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return new ResponseEntity<>(new ApiData<>(
                true,
                "Update student successfully!",
                studentService.updateStudent(id, student),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiData<Boolean>> deleteStudent(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new ApiData<>(
                true,
                "Delete student " + id + " successfully!",
                studentService.deleteStudent(id),
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search-by-name/{fullName}")
    public ResponseEntity<ApiData<List<Student>>> getStudentsByName(@PathVariable("fullName")String fullName) {
        return new ResponseEntity<>(new ApiData(
                true,
                "Get all students successfully!",
                studentService.getStudentsByName(fullName),
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
