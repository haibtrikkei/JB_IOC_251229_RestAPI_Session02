package springbootrestapi.restapi_student.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long stuId;
    @Column(name = "full_name",length = 50,nullable = false)
    private String fullName;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "birthday")
    private LocalDate birthday;
    private String address;
    @Column(name = "class_name")
    private String className;
}
