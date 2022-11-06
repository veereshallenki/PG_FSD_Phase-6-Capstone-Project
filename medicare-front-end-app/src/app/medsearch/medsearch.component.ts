import { Component, OnInit } from '@angular/core';
import { Medicines } from '../medicines';
import { MedicinesService } from '../medicines.service';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Medsearch } from '../medsearch';


@Component({
  selector: 'app-medsearch',
  templateUrl: './medsearch.component.html',
  styleUrls: ['./medsearch.component.css']
})
export class MedsearchComponent implements OnInit {

  selMedicne: String = "";
  MedicineName: string = "";
  m1: Array<Medicines> = []; // medicines array
  m2: Array<Medicines> =[];  //it holds filtered proucts 
  storeMsg: string = "";

  //below is created to get user input details through View
  SearchRef = new FormGroup({
    name: new FormControl()
  })

  // let medsearch = this.SearchRef.value;   

  constructor(public ms: MedicinesService, public router: Router,
    private formBuilder: FormBuilder,
    private httpClient: HttpClient
  ) { } // DI 

  ngOnInit(): void {

    
    console.log(this.MedicineName); 
    /*
    this.SearchRef = this.formBuilder.group(
      { MedicineName: [''] }
    );
    */

//    this.loadMedicines();
  }

  radioChnageHandler(event: any) {
    this.selMedicne = event.target.value;
  }

  //show medicines lit to the user
  loadMedicines() {
    this.ms.loadMedicines().subscribe(data => this.m1 = data,
      error => console.log(error), () => console.log("done")
    );
  }

  // serach by medicine name


  serachMedicine() {
    //MedicineName = this.SearchRef.value;

    //this.SearchRef.value 

    console.log(this.MedicineName); 

    /*
    this.ms.searchMedicines(this.MedicineName).subscribe(
      result => console.log(result), error => console.log(error),
      () => console.log("done")
    );*/

    this.ms.searchMedicines(this.MedicineName).subscribe(
      result => this.m2= result , error => console.log(error),
      () => console.log("done")
    );



   // console.log(this.SearchRef.value);
  }

 /*
  onSearch() {
    let m2 = this.SearchRef.value;
    console.log(m2); //show the search text on the UI

    this.ms.searchMedicines(m2).subscribe(
      result => console.log(result), error => console.log(error),
      () => console.log("done")
    );

  } */

}
