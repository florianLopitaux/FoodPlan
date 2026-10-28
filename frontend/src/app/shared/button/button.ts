import { Component, input, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'button[app-button]',
  imports: [],
  templateUrl: './button.html',
  styleUrl: './button.scss',
  encapsulation: ViewEncapsulation.None,
  host: {
    '[class]': 'styleType()'
  }
})
export class Button {
  styleType = input<string, 'normal' | 'transparent' | 'large'>('btn-primary', {
    alias: 'style-type',
    transform: (value: string) => {
      switch (value) {
        case 'transparent': return 'btn-primary--transparent';
        case 'large': return 'btn-primary--large';
        case 'normal':
        default: return 'btn-primary';
      }
    }
  });
}
