import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../service/userservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ResponseDTO } from '../model/responseDTO.model';
import { UserDTO } from '../model/user.model';

@Component({
  selector: 'app-userdetails',
  standalone: true,
  imports: [],
  templateUrl: './userdetails.component.html',
  styleUrl: './userdetails.component.css'
})
export class UserdetailsComponent implements  OnInit {

  response!: ResponseDTO;
    userData!: UserDTO[];
    user!:UserDTO;
    healthStatus: any;
    usersByRole!: string;
    usersBySSN!: UserDTO;
    sortedUsers: string="";
    ssnId: any="";
constructor(private userService: UserserviceService,public router: Router,private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    // this.loadUserData();
   console.log(this.activatedRoute.snapshot.paramMap.get('id') )  ;
   this.ssnId=this.activatedRoute.snapshot.paramMap.get('id') ;
      this.getUsersBySSN(this.ssnId);
  }
  getUsersBySSN(ssn: string): void {
      this.userService.getUsersBySSN(ssn).subscribe(
        (data: ResponseDTO) => {
          this.response = data;
            this.userData =this.response.users;
            this.user = this.userData[0];
          console.log(`Users with SSN by Aditya aher --  ${ssn}:`, this.userData);
        },
        (error) => {
          console.error(`Error fetching users by SSN ${ssn}:`, error);
        }
      );
    }
}
