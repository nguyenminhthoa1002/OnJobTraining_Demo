package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Student;
import ra.model.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable("studentId") int studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("studentId") int studentId) {
        Student studentUpdate = studentService.findById(studentId);
        studentUpdate.setStudentName(student.getStudentName());
        studentUpdate.setAge(student.getAge());
        studentUpdate.setBirthDate(student.getBirthDate());
        studentUpdate.setStudentStatus(student.isStudentStatus());
        return studentService.saveOrUpdate(studentUpdate);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable("studentId") int studentId) {
        try {
            studentService.delete(studentId);
            return ResponseEntity.ok().body("Delete success!");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Delete failed!");
        }
    }

    @GetMapping("search")
    public List<Student> searchStudentByName(@RequestParam("searchName") String searchName) {
        return studentService.findByStudentNameContaining(searchName);
    }

    @GetMapping("sortByName")
    public List<Student> sortStudentByName(@RequestParam("direction") String direction) {
        return studentService.sortStudentByStudentName(direction);
    }

    @GetMapping("sortById")
    public List<Student> sortStudentById(@RequestParam("direction") String direction) {
        return studentService.sortStudentByStudentId(direction);
    }

    @GetMapping("sortByAge")
    public List<Student> sortStudentByAge(@RequestParam("direction") String direction) {
        return studentService.sortStudentByStudentAge(direction);
    }

    @GetMapping("sortByStatus")
    public List<Student> sortStudentByStatus(@RequestParam("direction") String direction) {
        return studentService.sortStudentByStudentStatus(direction);
    }

    @GetMapping("getPaging")
    public ResponseEntity<Map<String, Object>> getPaging(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> pageStudent = studentService.getPaging(pageable);
        Map<String, Object> data = new HashMap<>();
//        Dữ liệu trả về trên 1 trang
        data.put("students",pageStudent.getContent());
//        Tổng bản ghi trên 1 trang
        data.put("total", pageStudent.getSize());
//        Tổng dữ liệu
        data.put("totalStudents", pageStudent.getTotalElements());
//        Tổng số trang
        data.put("totalPage", pageStudent.getTotalPages());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("getPagingAndSortById")
    public ResponseEntity<Map<String, Object>> getPagingAndSortingById(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam("direction") String direction) {
        Sort.Order order = null;
        if (direction.equals("asc")){
            order = new Sort.Order(Sort.Direction.ASC,"studentId");
        } else if (direction.equals("des")){
            order = new Sort.Order(Sort.Direction.DESC,"studentId");
        }
        Pageable pageable = PageRequest.of(page, size,Sort.by(order));
        Page<Student> pageStudent = studentService.getPaging(pageable);
        Map<String, Object> data = new HashMap<>();
//        Dữ liệu trả về trên 1 trang
        data.put("students",pageStudent.getContent());
//        Tổng bản ghi trên 1 trang
        data.put("total", pageStudent.getSize());
//        Tổng dữ liệu
        data.put("totalStudents", pageStudent.getTotalElements());
//        Tổng số trang
        data.put("totalPage", pageStudent.getTotalPages());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("getPagingAndSortByName")
    public ResponseEntity<Map<String, Object>> getPagingAndSortingByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam("direction") String direction) {
        Sort.Order order = null;
        if (direction.equals("asc")){
            order = new Sort.Order(Sort.Direction.ASC,"studentName");
        } else if (direction.equals("des")){
            order = new Sort.Order(Sort.Direction.DESC,"studentName");
        }
        Pageable pageable = PageRequest.of(page, size,Sort.by(order));
        Page<Student> pageStudent = studentService.getPaging(pageable);
        Map<String, Object> data = new HashMap<>();
//        Dữ liệu trả về trên 1 trang
        data.put("students",pageStudent.getContent());
//        Tổng bản ghi trên 1 trang
        data.put("total", pageStudent.getSize());
//        Tổng dữ liệu
        data.put("totalStudents", pageStudent.getTotalElements());
//        Tổng số trang
        data.put("totalPage", pageStudent.getTotalPages());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("getPagingAndSortByAge")
    public ResponseEntity<Map<String, Object>> getPagingAndSortingByAge(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam("direction") String direction) {
        Sort.Order order = null;
        if (direction.equals("asc")){
            order = new Sort.Order(Sort.Direction.ASC,"age");
        } else if (direction.equals("des")){
            order = new Sort.Order(Sort.Direction.DESC,"age");
        }
        Pageable pageable = PageRequest.of(page, size,Sort.by(order));
        Page<Student> pageStudent = studentService.getPaging(pageable);
        Map<String, Object> data = new HashMap<>();
//        Dữ liệu trả về trên 1 trang
        data.put("students",pageStudent.getContent());
//        Tổng bản ghi trên 1 trang
        data.put("total", pageStudent.getSize());
//        Tổng dữ liệu
        data.put("totalStudents", pageStudent.getTotalElements());
//        Tổng số trang
        data.put("totalPage", pageStudent.getTotalPages());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("getPagingAndSortByStatus")
    public ResponseEntity<Map<String, Object>> getPagingAndSortingByStatus(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam("direction") String direction) {
        Sort.Order order = null;
        if (direction.equals("asc")){
            order = new Sort.Order(Sort.Direction.ASC,"studentStatus");
        } else if (direction.equals("des")){
            order = new Sort.Order(Sort.Direction.DESC,"studentStatus");
        }
        Pageable pageable = PageRequest.of(page, size,Sort.by(order));
        Page<Student> pageStudent = studentService.getPaging(pageable);
        Map<String, Object> data = new HashMap<>();
//        Dữ liệu trả về trên 1 trang
        data.put("students",pageStudent.getContent());
//        Tổng bản ghi trên 1 trang
        data.put("total", pageStudent.getSize());
//        Tổng dữ liệu
        data.put("totalStudents", pageStudent.getTotalElements());
//        Tổng số trang
        data.put("totalPage", pageStudent.getTotalPages());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
