import { Component } from '@angular/core';

import { HeroBanner } from "@features/home/ui/hero-banner";
import { FeaturesSection } from "@features/home/ui/features-section";
import { AboutSection } from "@features/home/ui/about-section";

@Component({
  selector: 'main[app-page-home]',
  imports: [HeroBanner, FeaturesSection, AboutSection],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home {}
