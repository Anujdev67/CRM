import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgIf, NgFor,  } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-customer-detail',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.css']
})
export class CustomerDetailComponent implements OnInit {
  customer: any = {};
  interactions: any[] = [];
  newInteraction: any = {};

  constructor(private route: ActivatedRoute, private router: Router, private apiService: ApiService) { }

  ngOnInit(): void {

  }

  saveCustomer(): void {
    if (this.customer.id) {
      this.apiService.updateCustomer(this.customer.id, this.customer).subscribe(() => {
        this.router.navigate(['/dashboard']);
      });
    } else {
      this.apiService.addCustomer(this.customer).subscribe(() => {
        this.router.navigate(['/dashboard']);
      });
    }
  }

  addInteraction(): void {
    const customerId = this.customer.id;
    this.apiService.addInteraction(customerId, this.newInteraction).subscribe(() => {
      this.apiService.getInteractions(customerId).subscribe(data => {
        this.interactions = data;
      });
    });
  }
}