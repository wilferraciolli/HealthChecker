import {Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {Subscription} from 'rxjs';
import {HealthCheckService} from '../shared/server/health-check.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-health-check',
  templateUrl: './health-check.component.html',
  styleUrls: ['./health-check.component.css']
})
export class HealthCheckComponent implements OnInit {

  // @Input()
  // linkToHealthChecks: string;
  healthChecks: Array<any>;
  subscription: Subscription;

  constructor(private healthCheckService: HealthCheckService, private router: Router, private activatedRoute: ActivatedRoute) { }

  public navigateToHealthChecks(pageUrl, endPointUrl) {
    // navigate
    this.router.navigate([pageUrl, endPointUrl]).then( (e) => {
      if (e) {
        console.log("Navigation is successful!");
      } else {
        console.log("Navigation has failed!");
      }
    });
  }

  ngOnInit() {
    // get the value passed on the routing
    const url = this.activatedRoute.snapshot.params['linkToHealthChecks'];
    console.log(url);

    // call service
    this.subscription = this.healthCheckService.getHealthChecks('http://' + url).subscribe(data => {
      this.healthChecks = data;
    });
  }

}
