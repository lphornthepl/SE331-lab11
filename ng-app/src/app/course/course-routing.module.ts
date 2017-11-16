import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListCourseComponent} from './list-course/list-course.component';
import {AddCourseComponent} from './add-course/add-course.component';

const courseRoute: Routes =
  [
    {path: 'courses', component: ListCourseComponent},
    {path: 'add-course', component: AddCourseComponent}
  ];

@NgModule({
  imports: [
    RouterModule.forRoot(courseRoute)
  ],
  declarations: [],
  exports: [
    RouterModule
  ]
})
export class CourseRoutingModule {
}
