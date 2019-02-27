import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ServerService {

  public API = '//localhost:5001/api';
  public SERVERS_API = this.API + '/servers';

  /**
   * Explicit constructor.
   * @param {HttpClient} http
   */
  constructor(private http: HttpClient) { }

  getAllServers(): Observable<any> {
    return this.http.get(this.SERVERS_API);
  }

  /**
   * Get by id.
   * @param {string} id
   * @returns {Observable<Object>}
   */
  getById(id: string) {
    return this.http.get(this.SERVERS_API + '/' + id);
  }
}
