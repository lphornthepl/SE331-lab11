package camt.cbsd.lab05.service;


import camt.cbsd.lab05.dao.CourseDao;
import camt.cbsd.lab05.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dto on 16-Apr-17.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    CourseDao courseDao;

    @Override
    public List<Course> list() {
        return courseDao.list();
    }

    @Override
    public Course add(Course course) {
        return courseDao.add(course);
    }
}
