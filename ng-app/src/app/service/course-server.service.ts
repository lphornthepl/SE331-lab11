import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Rx';
import {Course} from '../students/course';
import {Http,Headers, RequestOptions} from '@angular/http';

@Injectable()
export class CourseServerService {

  constructor(private http:Http) { }

  getCourse():Observable<Course[]>{
    return this.http.get('http://localhost:8080/course')
      .map(res => res.json());
  }

  addCourse(course:Course){
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers, method: 'post'});
    let body = JSON.stringify(course);
    return this.http.post('http://localhost:8080/course', body, options)
      .map(res => {
        return res.json()
      })
      .catch((error: any) => {
        return Observable.throw(new Error(error.status))
      })

  }
}
