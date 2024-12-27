import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomepageComponent } from './homepage/homepage.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
export const routes: Routes = [

    {path:"dashboard",component:DashboardComponent},
    {path:"userdetails/:id",component:UserdetailsComponent},
    { path: '**', redirectTo: '/dashboard' }
];
