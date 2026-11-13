import { Routes } from '@angular/router';
import { EmployeeCreation } from './page/employee-creation/employee-creation';
import { BrandCreation } from './page/brand-creation/brand-creation';
import { Home } from './page/home/home';

export const routes: Routes = [
    { path: '', component: Home },
    { path: 'employee-creation', component: EmployeeCreation},
    { path: 'brand-creation', component: BrandCreation },
];
