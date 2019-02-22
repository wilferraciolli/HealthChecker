import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ServersComponent } from './servers/servers.component';
import { OverallComponent } from './overall/overall.component';

import { ServerService } from './shared/server/server.service';
import { ServerOverallService } from './shared/server/server.overall.service';

@NgModule({
  declarations: [
    AppComponent,
    ServersComponent,
    OverallComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ServerService,
    ServerOverallService
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
