import { Component } from '@angular/core';

import { Button } from '@shared/button';
import { Badge } from '@shared/badge';

@Component({
  selector: 'section[app-hero-banner]',
  imports: [Badge, Button],
  templateUrl: './hero-banner.html',
  styleUrl: './hero-banner.scss',
})
export class HeroBanner {}
