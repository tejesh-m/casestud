import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegbooksComponent } from './regbooks.component';

describe('RegbooksComponent', () => {
  let component: RegbooksComponent;
  let fixture: ComponentFixture<RegbooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegbooksComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegbooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
