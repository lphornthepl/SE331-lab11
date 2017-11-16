package camt.cbsd.lab05.dao;

import camt.cbsd.lab05.entity.Student;
import camt.cbsd.lab05.repository.StudentRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Profile("DBDataSource")
public class StudentDaoDBImpl implements StudentDao {
    StudentRepository studentRepository;
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getStudents() {

        return Lists.newArrayList(studentRepository.findAll());

    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Integer size() {
        return (int)studentRepository.count();
    }

}
