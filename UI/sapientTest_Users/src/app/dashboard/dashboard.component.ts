import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../service/userservice.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserDTO } from '../model/user.model';
import { AgGridAngular } from 'ag-grid-angular';
import { ColDef } from 'ag-grid-community';
import { CommonModule } from '@angular/common';
import { ResponseDTO } from '../model/responseDTO.model';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements  OnInit{
  response!: ResponseDTO;
  userData!: UserDTO[];
  healthStatus: any;
  usersByRole!: string;
  usersBySSN!: UserDTO;
  sortedUsers: string="";
  public ssn!:string;


  rowData = [
    { make: "Tesla", model: "Model Y", price: 64950, electric: true },
    { make: "Ford", model: "F-Series", price: 33850, electric: false },
    { make: "Toyota", model: "Corolla", price: 29600, electric: false },
];

// Column Definitions: Defines the columns to be displayed.
colDefs: ColDef[] = [
    { field: "make" },
    { field: "model" },
    { field: "price" },
    { field: "electric" }
];



  constructor(private userService: UserserviceService,public router: Router) {}

  ngOnInit(): void {
    // this.loadUserData();
    this.checkHealth();
  }

  /**
   * Load user data
   */
  loadUserData(): void {
    this.userService.loadUserData().subscribe(
      (data: ResponseDTO) => {
          this.response = data;
          this.userData =this.response.users;
        
        console.log('User Data:', this.userData);
      },
      (error) => {
        console.error('Error loading user data:', error);
      }
    );
  }
  /**
   * Check health status
   */
  checkHealth(): void {
    this.userService.getHealth().subscribe(
      (status) => {
        this.healthStatus = status;
        console.log('Health Status:', this.healthStatus);
      },
      (error) => {
        console.error('Error checking health status:', error);
      }
    );
  }

  /**
   * Get users by role
   * @param role - The role to filter users by
   */
  getUsersByRole(): void {
    this.userService.getUsersByRole(this.usersByRole).subscribe(
      (data: ResponseDTO) => {
        this.response = data;
          this.userData =this.response.users;
        console.log(`Users with role ${this.usersByRole}:`, this.userData);
      },
      (error) => {
        console.error(`Error fetching users by role ${this.usersByRole}:`, error);
      }
    );
  }

  /**
   * Get users by SSN
   * @param ssn - The SSN to filter users by
   */
  getUsersBySSN(ssn: string): void {
    this.userService.getUsersBySSN(ssn).subscribe(
      (data: ResponseDTO) => {
        this.ssn=ssn;
        this.response = data;
          this.userData =this.response.users;
          this.router.navigateByUrl("/userdetails/"+ssn);
        console.log(`Users with SSN ${ssn}:`, this.usersBySSN);
      },
      (error) => {
        console.error(`Error fetching users by SSN ${ssn}:`, error);
      }
    );
  }

  /**
   * Get sorted users by age
   * @param order - The order to sort users by (asc/desc)
   */
  getSortedUsersByAge(): void {
    this.userService.getSortedUsersByAge(this.sortedUsers).subscribe(
      (data: ResponseDTO) => {
        this.response = data;
        this.userData =this.response.users;
        console.log(`Users sorted by age (${this.sortedUsers}):`, this.userData);
      },
      (error) => {
        console.error(`Error sorting users by age (${this.sortedUsers}):`, error);
      }
    );
  }
  
}
