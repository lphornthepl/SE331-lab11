import { Component, OnInit } from '@angular/core';
import {Course} from '../../students/course';
import {CourseServerService} from '../../service/course-server.service';
import {ActivatedRoute, Params} from '@angular/router';

@Component({
  selector: 'app-list-course',
  templateUrl: './list-course.component.html',
  styleUrls: ['./list-course.component.css']
})
export class ListCourseComponent implements OnInit {

  courses:Course[];
  constructor(private courseService:CourseServerService,private route:ActivatedRoute) { }

  result:string;
  ngOnInit() {
    this.route.queryParams
      .subscribe((params : Params) => {
      this.result = params['result'];
    });

    this.courseService.getCourse()
      .subscribe(courses=>this.courses = courses);
  }

}
