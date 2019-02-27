import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class HealthCheckService {

  public API = '//localhost:5001/api';
  public HEALTH_CHECKS_API = this.API + '/servers/{id}/healthchecks';

  /**
   * Explicit constructor.
   * @param {HttpClient} http
   */
  constructor(private http: HttpClient) { }

  getHealthChecks(url: string): Observable<any> {
    return this.http.get(url);
  }

}
