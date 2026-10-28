import { Component, input, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'span[app-badge]',
  imports: [],
  templateUrl: './badge.html',
  styleUrl: './badge.scss',
  encapsulation: ViewEncapsulation.None,
  host: {
    '[class]': 'styleType()'
  }
})
export class Badge {
  styleType = input<string, 'normal' | 'accent'>('badge', {
    alias: 'style-type',
    transform: (value: string) => {
      switch (value) {
        case 'accent': return 'badge--accent';
        case 'normal':
        default: return 'badge';
      }
    }
  });
}
