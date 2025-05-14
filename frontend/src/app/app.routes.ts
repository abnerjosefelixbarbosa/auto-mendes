import { Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { EmployeeListingComponent } from './page/employee.listing/employee.listing.component';
import { EmployeeRegistrationComponent } from './page/employee.registration/employee.registration.component';

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
