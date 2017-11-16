package camt.cbsd.lab05.repository;

import camt.cbsd.lab05.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findById(Long id);
}
