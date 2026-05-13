package springbootrestapi.restapi_student.service;

import springbootrestapi.restapi_student.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student insertStudent(Student student);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long id);
    List<Student> getStudentsByName(String fullName);
}
