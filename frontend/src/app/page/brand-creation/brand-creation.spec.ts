import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BrandCreation } from './brand-creation';

describe('BrandCreation', () => {
  let component: BrandCreation;
  let fixture: ComponentFixture<BrandCreation>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BrandCreation],
    }).compileComponents();

    fixture = TestBed.createComponent(BrandCreation);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
