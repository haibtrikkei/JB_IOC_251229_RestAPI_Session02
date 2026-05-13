package springbootrestapi.restapi_student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootrestapi.restapi_student.model.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> getStudentsByFullNameContaining(String fullName);
}
