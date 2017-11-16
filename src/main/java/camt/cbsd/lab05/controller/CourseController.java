package camt.cbsd.lab05.controller;


import camt.cbsd.lab05.entity.Course;
import camt.cbsd.lab05.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * Created by Dto on 16-Apr-17.
 */
@RestController
public class CourseController {

    CourseService courseService;
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(courseService.list());
    }

    @PostMapping("/course")
    public ResponseEntity<?> add(@RequestBody Course course){
        courseService.add(course);
        return ResponseEntity.ok(course);
    }
}
