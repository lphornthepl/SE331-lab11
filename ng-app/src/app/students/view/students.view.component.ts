import {Component, Input} from '@angular/core';
import {Student} from '../student';
import {ActivatedRoute, Params} from "@angular/router";
import {StudentsDataService} from "../../service/students-data.service";
import 'rxjs/add/operator/switchMap';
@Component({
 selector: 'students-view',
 templateUrl: './students.view.component.html',
 styleUrls:['./students.view.component.css']
})
export class StudentsViewComponent {
  constructor(private route: ActivatedRoute, private studentDataService:StudentsDataService) {}
   student:Student;
   isNoData:boolean;

   inputCount:number;
   ngOnInit() {
      this.inputCount = 15;
      this.route.params
        .switchMap((params:Params) => this.studentDataService.getStudent(+params['id']))
        .subscribe((student:Student) => {
            if (student != null)
              this.student = student;
            else
              this.isNoData = true;
          }
        );
  }
}
