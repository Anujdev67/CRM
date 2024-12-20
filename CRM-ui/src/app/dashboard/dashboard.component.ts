import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  standalone: true,
  imports: [CommonModule]
})
export class DashboardComponent implements OnInit {
  customers: any[] = [];

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.apiService.getCustomers().subscribe({
      next: (data) => {
        this.customers = data;
      },
      error: (error) => {
        console.error('Error loading customers:', error);
      }
    });
  }

  addCustomer(): void {
    this.router.navigate(['/customer-detail', 0]);
  }

  editCustomer(id: number): void {
    this.router.navigate(['/customer-detail', id]);
  }

  deleteCustomer(id: number): void {
    this.apiService.deleteCustomer(id).subscribe({
      next: () => {
        this.loadCustomers();
      },
      error: (error) => {
        console.error('Error deleting customer:', error);
      }
    });
  }
}