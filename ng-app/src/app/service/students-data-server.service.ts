import {Injectable} from '@angular/core';
import {Student} from '../students/student';
import {Http, RequestOptions, Headers, Response} from '@angular/http';
import {StudentsDataService} from './students-data.service';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/mergeMap';
import {AuthenticationService} from './authentication.service';

@Injectable()
export class StudentsDataServerService {
  constructor(private http: Http, private authenticationService: AuthenticationService) {

  }


  getStudentsData() {
    let studentArray: Student[];
    let headers = new Headers({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.authenticationService.getToken()
    });
    return this.http.get('http://localhost:8080/student', {headers: headers})
      .map(res => res.json());
  }

  getStudent(id: number) {
    let student: Student;
    let headers = new Headers({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.authenticationService.getToken()
    });
    return this.http.get('http://localhost:8080/student/' + id, {headers: headers})
      .map((res: Response) => {
        if (res) {
          if (res.status === 200) {
            return res.json();
          }
          if (res.status === 204) {
            return null;
          }
        }
      });
  }

  addStudent(student: Student, file: any): Observable<Student> {
    const formData = new FormData();
    let fileName: string;
    formData.append('file', file);
    let header = new Headers({'Authorization': 'Bearer ' + this.authenticationService.getToken()});
    let options = new RequestOptions({headers: header});

    return this.http.post('http://localhost:8080/upload', formData,options)
      .flatMap(filename => {
        student.image = filename.text();
        let body = JSON.stringify(student);
        header.append('Content-Type','application/json');
        options = new RequestOptions({headers: header});
        return this.http.post('http://localhost:8080/student', body, options)
          .map(res => {
            return res.json()
          })
      });
  }

}
