import { Routes } from '@angular/router';
import { EmployeeCreation } from './page/employee-creation/employee-creation';
import { BrandCreation } from './page/brand-creation/brand-creation';

export const routes: Routes = [
    { path: 'employee-creation', component: EmployeeCreation},
    { path: 'brand-creation', component: BrandCreation },
];
