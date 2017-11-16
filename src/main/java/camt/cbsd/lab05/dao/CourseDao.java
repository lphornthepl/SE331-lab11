package camt.cbsd.lab05.dao;


import camt.cbsd.lab05.entity.Course;

import java.util.List;

/**
 * Created by Dto on 07-Apr-17.
 */
public interface CourseDao {
    Course add(Course course);
    List<Course> list();
}
