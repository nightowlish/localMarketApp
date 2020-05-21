import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nonpersihable',
  templateUrl: './nonpersihable.component.html',
  styleUrls: ['./nonpersihable.component.css']
})
export class NonpersihableComponent implements OnInit {

  constructor() {}
myimage1:string="assets/image/salt.jpg";
myimage2:string="assets/image/flour.jpg";
myimage3:string="assets/image/honey.jpg";
myimage4:string="assets/image/sugar.jpg";

 

  ngOnInit(): void {
  }

}
