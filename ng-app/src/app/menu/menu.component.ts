import {Component} from '@angular/core';
import {Student} from "../students/student";
import {StudentsDataService} from "../service/students-data.service";
import {Router} from "@angular/router";
import {isUndefined} from 'util';
@Component({
 selector: 'menu',
 templateUrl: './menu.component.html',
 styleUrls:['./menu.component.css']
})
export class MenuComponent {
  constructor(private studentDataService: StudentsDataService, private router: Router ) {
  }
  students:Student[];
  ngOnInit() {
    this.studentDataService.getStudentsData()
      .subscribe(students => this.students = students);
  }
  showDetail(student: Student){
    this.router.navigate(['/detail',student.id]);
  }

  onViewClick(){
    if ( isUndefined(this.students)){
      this.studentDataService.getStudentsData()
        .subscribe(students => this.students = students);
    }
  }
}
