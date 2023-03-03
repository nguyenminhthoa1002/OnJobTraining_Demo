package ra.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int studentId);
    Student saveOrUpdate(Student student);
    void delete(int studentId);
    List<Student> findByStudentNameContaining(String search);
    List<Student> sortStudentByStudentName(String direction);
    List<Student> sortStudentByStudentId(String direction);
    List<Student> sortStudentByStudentAge(String direction);
    List<Student> sortStudentByStudentStatus(String direction);
    Page<Student> getPaging(Pageable pageable);
}
