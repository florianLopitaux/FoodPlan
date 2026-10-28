import { Component } from '@angular/core';

import { Badge } from '@shared/badge';

@Component({
  selector: 'section[app-about-section]',
  imports: [Badge],
  templateUrl: './about-section.html',
  styleUrl: './about-section.scss',
})
export class AboutSection {}
