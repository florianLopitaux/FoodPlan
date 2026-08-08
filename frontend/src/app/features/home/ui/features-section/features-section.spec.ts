import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturesSection } from './features-section';

describe('FeaturesSection', () => {
  let component: FeaturesSection;
  let fixture: ComponentFixture<FeaturesSection>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeaturesSection],
    }).compileComponents();

    fixture = TestBed.createComponent(FeaturesSection);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
