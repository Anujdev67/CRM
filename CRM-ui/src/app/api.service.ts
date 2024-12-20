import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  // User API calls
  login(email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/login`, { email, password });
  }

  getUserProfile(): Observable<any> {
    return this.http.get(`${this.apiUrl}/users/profile`);
  }

  updateUserProfile(user: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/users/profile`, user);
  }

  // Customer API calls
  getCustomers(): Observable<any> {
    return this.http.get(`${this.apiUrl}/customers`);
  }

  getCustomerById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/customers/${id}`);
  }

  addCustomer(customer: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/customers`, customer);
  }

  updateCustomer(id: number, customer: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/customers/${id}`, customer);
  }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/customers/${id}`);
  }

  // Interaction API calls
  getInteractions(customerId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/customers/${customerId}/interactions`);
  }

  addInteraction(customerId: number, interaction: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/customers/${customerId}/interactions`, interaction);
  }

  // Report API calls
  generateReport(report: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/reports`, report);
  }

  getReportById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/reports/${id}`);
  }

  deleteReport(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/reports/${id}`);
  }
}