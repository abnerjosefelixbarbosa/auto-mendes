import { Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { VehiclesComponent } from './page/vehicles/vehicles.component';
import { EmployeesComponent } from './page/employees/employees.component';

export const routes: Routes = [
    {
        path: "",
        component: HomeComponent,
    },
    {
        path: "employees",
        component: EmployeesComponent,
    },
    {
        path: "vehicles",
        component: VehiclesComponent,
    }
];
