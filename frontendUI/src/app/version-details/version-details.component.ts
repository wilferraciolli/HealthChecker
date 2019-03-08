import {Component, Input, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {ServerService} from '../shared/server/server.service';

@Component({
  selector: 'app-version-details',
  templateUrl: './version-details.component.html',
  styleUrls: ['./version-details.component.css']
})
export class VersionDetailsComponent implements OnInit {

  @Input()
  urlToServerVersionDetails: string;
  serverVersionDetail: any;
  subscription: Subscription;

  constructor(private serverService: ServerService) { }

  ngOnInit() {
    console.log('http://' + this.urlToServerVersionDetails);
    this.subscription = this.serverService.getServerVersionByUrl('http://' + this.urlToServerVersionDetails).subscribe(data => {
      console.log(data);
      this.serverVersionDetail = data;
    });
  }

}
