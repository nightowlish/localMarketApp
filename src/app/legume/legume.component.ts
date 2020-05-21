
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-legume',
  templateUrl: './legume.component.html',
  styleUrls: ['./legume.component.css']
})
export class LegumeComponent implements OnInit {

  constructor() { }

myimage1:string="assets/image/rosii.jpg";
myimage2:string="assets/image/castraveti.jpg";
myimage3:string="assets/image/ceapa.jpg";
myimage4:string="assets/image/cartofi.jpg";

  ngOnInit(): void {
  }

}
