import { TestBed, inject } from '@angular/core/testing';
import {CourseServerService} from './course-server.service';



describe('CourseServiceServerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CourseServerService]
    });
  });

  it('should ...', inject([CourseServerService], (service: CourseServerService) => {
    expect(service).toBeTruthy();
  }));
});
