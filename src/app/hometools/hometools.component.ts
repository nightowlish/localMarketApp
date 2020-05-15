import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hometools',
  templateUrl: './hometools.component.html',
  styleUrls: ['./hometools.component.css']
})
export class HometoolsComponent implements OnInit {

  constructor() { }
myimage1:string="assets/image/screwdriver.jpg";
myimage2:string="assets/image/stanley.jpg";
myimage3:string="assets/image/hammer.jpg";

  ngOnInit(): void {
  }

}
