import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fructe',
  templateUrl: './fructe.component.html',
  styleUrls: ['./fructe.component.css']
})
export class FructeComponent implements OnInit {

  constructor() { }
myimage1:string="assets/image/apple.jpg";
myimage2:string="assets/image/pears.jpg";
myimage3:string="assets/image/strawberry.jpg";
myimage4:string="assets/image/Bananas.jpg";

  ngOnInit(): void {
  }

}
