import { Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { EmployeeListingComponent } from './page/employee.listing/employee.listing.component';
import { EmployeeRegistrationComponent } from './page/employee.registration/employee.registration.component';
import { BrandRegistrationComponent } from './page/brand.registration/brand.registration.component';
import { ModelRegistrationComponent } from './page/model.registration/model.registration.component';
import { VehicleRegistrationComponent } from './page/vehicle.registration/vehicle.registration.component';
import { BrandListingComponent } from './page/brand.listing/brand.listing.component';
import { ModelListingComponent } from './page/model.listing/model.listing.component';
import { VehicleListingComponent } from './page/vehicle.listing/vehicle.listing.component';
import { EmployeeUpdateByIdComponent } from './page/employee.update-by-id/employee.update-by-id.component';

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'employee-registration',
    component: EmployeeRegistrationComponent,
  },
  {
    path: 'employee-update-by-id',
    component: EmployeeUpdateByIdComponent,
  },
  {
    path: 'employee-listing',
    component: EmployeeListingComponent,
  },
  {
    path: 'brand-registration',
    component: BrandRegistrationComponent,
  },
  {
    path: 'model-registration',
    component: ModelRegistrationComponent,
  },
  {
    path: 'vehicle-registration',
    component: VehicleRegistrationComponent,
  },
  {
    path: 'brand-listing',
    component: BrandListingComponent,
  },
  {
    path: 'model-listing',
    component: ModelListingComponent,
  },
  {
    path: 'vehicle-listing',
    component: VehicleListingComponent,
  },
];
