import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user: any = {};

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getUserProfile().subscribe(data => {
      this.user = data;
    });
  }

  updateProfile(): void {
    this.apiService.updateUserProfile(this.user).subscribe(() => {
      console.log('Profile updated successfully');
    });
  }
}