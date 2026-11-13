import { Component } from '@angular/core';
import { Navbar } from '../../components/navbar/navbar';

@Component({
  imports: [Navbar],
  standalone: true,
  selector: 'app-home',
  styleUrl: './home.css',
  templateUrl: './home.html',
})
export class Home {}
