import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {ServerService} from '../shared/server/server.service';
import {TenantsService} from '../shared/tenants/tenants.service';

@Component({
  selector: 'app-tenants',
  templateUrl: './tenants.component.html',
  styleUrls: ['./tenants.component.css']
})
export class TenantsComponent implements OnInit, OnDestroy {

  tenants: Array<any>;
  subscription: Subscription;


  constructor( private tenantsService: TenantsService) { }

  ngOnInit() {
    this.subscription = this.tenantsService.getAllTenants().subscribe(data => {
      this.tenants = data;
    });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
