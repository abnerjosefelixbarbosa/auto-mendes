import { Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { EmployeeRegistrationComponent } from './page/employee/employee-registration/employee-registration.component';
import { EmployeeListingComponent } from './page/employee/employee-listing/employee-listing.component';

export const routes: Routes = [
    {
        path: "",
        component: HomeComponent,
    },
    {
        path: "employee-registration",
        component: EmployeeRegistrationComponent,
    },
    {
        path: "employee-listing",
        component: EmployeeListingComponent,
    }
];
