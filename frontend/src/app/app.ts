import { Component, signal } from '@angular/core';
import { Header } from "./shared/header/header";
import { Footer } from "./shared/footer/footer";
import { Home } from './features/home/pages/home/home';

@Component({
  selector: 'app-root',
  imports: [Header, Footer, Home],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend');
}
