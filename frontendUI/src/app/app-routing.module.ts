import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ServersComponent} from './servers/servers.component';
import {TenantsComponent} from './tenants/tenants.component';
import {HealthCheckComponent} from './health-check/health-check.component';

const routes: Routes = [
  { path: 'tenants', component: TenantsComponent },
  { path: 'servers', component: ServersComponent },
  { path: 'healthchecks/:linkToHealthChecks', component: HealthCheckComponent },
  { path: '', redirectTo: '/servers', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
