import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TenantsService {

  public API = '//localhost:5001/api';
  public TENANTS_API = this.API + '/environment/status';

  constructor(private http: HttpClient) { }

  getAllTenants(): Observable<any> {
    return this.http.get(this.TENANTS_API);
  }
}
