package ra.model.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Student;
import ra.model.repository.StudentRepository;
import ra.model.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImple implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> findByStudentNameContaining(String search) {
        return studentRepository.findByStudentNameContaining(search);
    }

    @Override
    public List<Student> sortStudentByStudentName(String direction) {
        if (direction.equals("asc")){
            return studentRepository.findAll(Sort.by("studentName").ascending());
        } else if (direction.equals("des")){
            return studentRepository.findAll(Sort.by("studentName").descending());
        }
        return null;
    }

    @Override
    public List<Student> sortStudentByStudentId(String direction) {
        if (direction.equals("asc")){
            return studentRepository.findAll(Sort.by("studentId").ascending());
        } else if (direction.equals("des")){
            return studentRepository.findAll(Sort.by("studentId").descending());
        }
        return null;
    }

    @Override
    public List<Student> sortStudentByStudentAge(String direction) {
        if (direction.equals("asc")){
            return studentRepository.findAll(Sort.by("age").ascending());
        } else if (direction.equals("des")){
            return studentRepository.findAll(Sort.by("age").descending());
        }
        return null;
    }

    @Override
    public List<Student> sortStudentByStudentStatus(String direction) {
        if (direction.equals("asc")){
            return studentRepository.findAll(Sort.by("studentStatus").ascending());
        } else if (direction.equals("des")){
            return studentRepository.findAll(Sort.by("studentStatus").descending());
        }
        return null;
    }

    @Override
    public Page<Student> getPaging(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


}
