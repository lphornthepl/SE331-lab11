import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../service/authentication.service';
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-login',
  moduleId: module.id,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  model: any = {};
  loading = false;
  error = '';

  constructor(private router: Router,
              private authenticationService: AuthenticationService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    //reset login status
    this.authenticationService.logout();
    let source: String;
    this.route.queryParams.subscribe(
      params => {
        if (params['source'])
          source = params['source'];
        else
          source = null;
      }
    )

    if (source) {
      this.error = 'Please login before use' + source + 'page';
    }
  }

  login() {
    this.loading = true;
    this.authenticationService.login(this.model.username, this.model.password)
      .subscribe(result => {
        if (result === true) {
          //login success
          this.router.navigate(['courses']);
        } else {
          //login failed
          this.error = 'Username or password is incorrect';
          this.loading = false;
        }
      }, error => {
        this.loading = false;
        this.error = error;
      });
  }
}

