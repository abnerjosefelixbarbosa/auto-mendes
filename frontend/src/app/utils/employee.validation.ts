import { Injectable } from "@angular/core";
import { FormGroup } from "@angular/forms";

@Injectable({
    providedIn: 'root'
})
export class EmployeeValidation {
    constructor() {}

    validateRegisterForm(form: FormGroup) {
        const matriculation = new String(form.get('matriculation')?.value);
    
        if (matriculation.length != 10) {
          form.get('matriculation')?.setErrors({ matriculationInvalid: true })
        }
    }
}