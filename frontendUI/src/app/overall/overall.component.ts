import {Component, Input, OnInit} from '@angular/core';
import { Subscription } from "rxjs/Subscription";
import { ServerOverallService } from '../shared/server/server.overall.service';

@Component({
  selector: 'app-overall',
  templateUrl: './overall.component.html',
  styleUrls: ['./overall.component.css']
})
export class OverallComponent implements OnInit {

  @Input()
  linkToOverall: string;
  overall: any;
  subscription: Subscription;

  constructor(private overallService: ServerOverallService) { }

  ngOnInit() {
    console.log('http://' + this.linkToOverall);
    this.subscription = this.overallService.getFromUrl('http://' + this.linkToOverall).subscribe(data => {
      this.overall = data;
      console.log(this.overall);
      console.log(data);
    });
  }

}
