import {Component, Input, OnInit} from '@angular/core';
import {Course} from '../Course';

@Component({
  selector: 'course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css'],
})
export class CourseListComponent implements OnInit {
  constructor() {
  }
  @Input() count:number;
  @Input('enrolledCourse') courses:Course;
  ngOnInit() {

  }
}
