package camt.cbsd.lab05.service;



import camt.cbsd.lab05.entity.Course;

import java.util.List;

/**
 * Created by Dto on 16-Apr-17.
 */
public interface CourseService {
    List<Course> list();
    Course add(Course course);
}
