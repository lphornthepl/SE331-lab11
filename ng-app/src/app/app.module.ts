import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {StudentsComponent} from './students/list/students.component';
import {StudentsAddComponent} from './students/add/students.add.component';
import {StudentsViewComponent} from './students/view/students.view.component';
import {FormsModule} from '@angular/forms';
import {StudentsDataService} from './service/students-data.service';
import {HttpModule} from '@angular/http';
import {MenuComponent} from './menu/menu.component';
import {FileNotFoundComponent} from './filenotfound/file-not-found.component';
import {AppRoutingModule} from './app-routing.module';
import {StudentRoutingModule} from './students/student-routing.module';
import {StudentsDataDBService} from './service/students-data-db.service';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import {StudentsDataServerService} from './service/students-data-server.service';
import {CourseListComponent} from './students/course-list/course-list.component';
import { ListCourseComponent } from './course/list-course/list-course.component';
import { CourseRoutingModule} from './course/course-routing.module';
import {AddCourseComponent} from './course/add-course/add-course.component';
import {CourseServerService} from './service/course-server.service';
import { LoginComponent } from './login/login.component';
import {AuthenticationService} from './service/authentication.service';

@NgModule({
  declarations: [AppComponent,
    StudentsComponent,
    StudentsAddComponent,
    StudentsViewComponent,
    MenuComponent, FileNotFoundComponent,
    CourseListComponent,
    ListCourseComponent,
    AddCourseComponent,
    LoginComponent],
  imports: [BrowserModule, FormsModule, HttpModule,
    StudentRoutingModule, CourseRoutingModule, AppRoutingModule],
  bootstrap: [AppComponent],
  providers: [{provide: StudentsDataService, useClass: StudentsDataServerService},
    CourseServerService,AuthenticationService],
})
export class AppModule {
}
