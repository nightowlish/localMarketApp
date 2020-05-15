import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dairy',
  templateUrl: './dairy.component.html',
  styleUrls: ['./dairy.component.css']
})
export class DairyComponent implements OnInit {

  constructor() { }
myimage1:string="assets/image/milk.jpg";
myimage2:string="assets/image/cheese.jpg";
myimage3:string="assets/image/Eggs.jpg";
myimage4:string="assets/image/youghurt.jpg";
myimage5:string="assets/image/butter.jpeg";

  ngOnInit(): void {
  }

}
