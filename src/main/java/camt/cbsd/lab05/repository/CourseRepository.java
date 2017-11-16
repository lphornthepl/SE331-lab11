package camt.cbsd.lab05.repository;


import camt.cbsd.lab05.entity.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dto on 07-Apr-17.
 */
public interface CourseRepository extends CrudRepository<Course,Long> {
}
