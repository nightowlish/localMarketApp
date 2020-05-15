import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cleanindproducts',
  templateUrl: './cleanindproducts.component.html',
  styleUrls: ['./cleanindproducts.component.css']
})
export class CleanindproductsComponent implements OnInit {

  constructor() { }
myimage1:string="assets/image/broom.jpg";
myimage2:string="assets/image/cloth.jpeg";
myimage3:string="assets/image/vacuum.jpg";


  ngOnInit(): void {
  }

}
