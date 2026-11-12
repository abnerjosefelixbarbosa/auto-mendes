import { Injectable } from '@angular/core';
import Toastify from 'toastify-js';

@Injectable({
  providedIn: 'root'
})
export class ToastService {
  success(message: string): void {
    Toastify({
      text: message,
      duration: 3000,
      close: true,
      gravity: 'top',
      position: 'right',
      style: {
        background: '#198754'
      }
    }).showToast();
  }

  error(message: string): void {
    Toastify({
      text: message,
      duration: 3000,
      close: true,
      gravity: 'top',
      position: 'right',
      style: {
        background: '#dc3545'
      }
    }).showToast();
  }

  info(message: string): void {
    Toastify({
      text: message,
      duration: 3000,
      close: true,
      gravity: 'top',
      position: 'right',
      style: {
        background: '#0d6efd'
      }
    }).showToast();
  }

  warning(message: string): void {
    Toastify({
      text: message,
      duration: 3000,
      close: true,
      gravity: 'top',
      position: 'right',
      style: {
        background: '#ffc107',
        color: '#212529'
      }
    }).showToast();
  }
}