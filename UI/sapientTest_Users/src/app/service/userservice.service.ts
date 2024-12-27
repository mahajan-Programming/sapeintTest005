import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  private baseUrl = 'http://localhost:8889/users';

  constructor(private http: HttpClient) {}

  /**
   * Load user data
   * @returns Observable<any>
   */
  loadUserData(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/loadUserData`);
  }

  /**
   * Check service health
   * @returns Observable<any>
   */
  getHealth(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/health`);
  }

  /**
   * Get users by role
   * @param role - User role
   * @returns Observable<any>
   */
  getUsersByRole(role: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getUsersByRole/${role}`);
  }

  /**
   * Get users by SSN
   * @param ssn - User SSN
   * @returns Observable<any>
   */
  getUsersBySSN(ssn: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getUsersBySSN/${ssn}`);
  }

  /**
   * Get sorted users by age
   * @param order - Sorting order (asc/desc)
   * @returns Observable<any>
   */
  getSortedUsersByAge(order: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getSortedUsersByAge/${order}`);
  }
}
