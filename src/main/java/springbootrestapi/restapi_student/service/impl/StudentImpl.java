package springbootrestapi.restapi_student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootrestapi.restapi_student.model.entity.Student;
import springbootrestapi.restapi_student.repository.StudentRepository;
import springbootrestapi.restapi_student.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Không tồn tại student với id: "+id));
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        studentRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Không tồn tại student với id: "+id));
        student.setStuId(id);
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Long id) {
        try{
            studentRepository.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public List<Student> getStudentsByName(String fullName) {
        return studentRepository.getStudentsByFullNameContaining(fullName);
    }
}
