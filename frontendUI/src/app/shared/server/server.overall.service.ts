import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ServerOverallService {

  public API = '//localhost:5001/api';
  public SERVER_OVERAL_API = this.API + '/servers/{id}/overall';

  /**
   * Explicit constructor.
   * @param {HttpClient} http
   */
  constructor(private http: HttpClient) { }

  getFromUrl(url: string) {
    return this.http.get(url);
  }
}
