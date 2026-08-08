import { Component } from '@angular/core';
import { HeroBanner } from "../../ui/hero-banner/hero-banner";
import { FeaturesSection } from "../../ui/features-section/features-section";
import { AboutSection } from "../../ui/about-section/about-section";

@Component({
  selector: 'app-page-home',
  imports: [HeroBanner, FeaturesSection, AboutSection],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home {}
