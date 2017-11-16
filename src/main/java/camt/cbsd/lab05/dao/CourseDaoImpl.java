package camt.cbsd.lab05.dao;


import camt.cbsd.lab05.entity.Course;
import camt.cbsd.lab05.repository.CourseRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dto on 07-Apr-17.
 */
@Repository
public class CourseDaoImpl implements CourseDao {
    CourseRepository courseRepository;
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> list() {
        return Lists.newArrayList(courseRepository.findAll());
    }


}
