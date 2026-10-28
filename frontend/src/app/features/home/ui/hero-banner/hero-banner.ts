import { Component } from '@angular/core';
import { Button } from '../../../../shared/button/button';

@Component({
  selector: 'section[app-hero-banner]',
  imports: [Button],
  templateUrl: './hero-banner.html',
  styleUrl: './hero-banner.scss',
})
export class HeroBanner {}
