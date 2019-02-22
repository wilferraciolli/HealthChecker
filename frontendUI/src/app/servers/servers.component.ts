import { Component, OnInit } from '@angular/core';
import { Subscription } from "rxjs/Subscription";
import { ServerService } from '../shared/server/server.service';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  servers: Array<any>;
  subscription: Subscription;

  constructor(private serverService: ServerService) { }

  ngOnInit() {
    this.subscription = this.serverService.getAll().subscribe(data => {
      this.servers = data;
    });
  }

}
