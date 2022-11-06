import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedsearchComponent } from './medsearch.component';

describe('MedsearchComponent', () => {
  let component: MedsearchComponent;
  let fixture: ComponentFixture<MedsearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MedsearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MedsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
