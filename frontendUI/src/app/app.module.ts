import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ServersComponent } from './servers/servers.component';
import { OverallComponent } from './overall/overall.component';
import { HealthCheckComponent } from './health-check/health-check.component';

import { ServerService } from './shared/server/server.service';
import { ServerOverallService } from './shared/server/server.overall.service';
import { HealthCheckService } from './shared/server/health-check.service';
import { VersionDetailsComponent } from './version-details/version-details.component';
import { ServerCurrentStatusComponent } from './server-current-status/server-current-status.component';

// const appRoutes: Routes = [
//   { path: 'health-checks/:url', component: HealthCheckComponent },
//   { path: 'health-check', component: HealthCheckComponent },
//   // { path: '**', component: PageNotFoundComponent }
// ];

@NgModule({
  declarations: [
    AppComponent,
    ServersComponent,
    OverallComponent,
    HealthCheckComponent,
    VersionDetailsComponent,
    ServerCurrentStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ServerService,
    ServerOverallService,
    HealthCheckService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
