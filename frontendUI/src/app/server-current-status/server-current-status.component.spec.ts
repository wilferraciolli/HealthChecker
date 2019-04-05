import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServerCurrentStatusComponent } from './server-current-status.component';

describe('ServerCurrentStatusComponent', () => {
  let component: ServerCurrentStatusComponent;
  let fixture: ComponentFixture<ServerCurrentStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServerCurrentStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServerCurrentStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
