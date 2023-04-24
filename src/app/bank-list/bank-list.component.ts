import { Component,OnInit  } from '@angular/core';
import { Bank } from '../bank'
import { BankService } from '../bank.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-bank-list',
  templateUrl: './bank-list.component.html',
  styleUrls: ['./bank-list.component.css']
})
export class BankListComponent implements OnInit {
  bank: Bank[] = [];
  manager : string = '';

  constructor(private bankService: BankService,
    private router: Router) { }

  ngOnInit(): void {
    this.getBank();
  }

  private getBank(){
    this.bankService.getBankList().subscribe(data => {
      this.bank = data;

    });
  }

  bankDetails(id: number){
    this.router.navigate(['bank-details', id]);
  }

  updateBank(id: number){
    this.router.navigate(['update-bank', id]);
  }
  confirmDelete(id : number){
    var status= confirm("You want to delete this record?");
     if (status==true) {
       this.deleteBank(id);
          }
     else{
      this.getBank();
          }
  }
  deleteBank(id: number)
  {
    console.log(id);
    this.bankService.deleteBank(id).subscribe( data => {
      console.log(data);
      this.getBank();
    })
  }
  confirmDeleteall(){
    var status= confirm("You want to  delete all records?");
     if (status==true) {
       this.removeAllBanks();
          }
     else{
      this.getBank();
          }
  }
  removeAllBanks(): void {
    this.bankService.deleteAll().subscribe(
        data => {
          console.log(data);
         // this.refreshList();
        },
        error => {
          console.log(error);
        });
  }
  searchByName(){
    this.bankService.findByName(this.manager)
    .subscribe(
      data => {
        this.bank = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
 
  }
  fetchBanksInMadanapalle(){
    this.bankService.findByCityMadanapalle().subscribe(
      data => {
        this.bank = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  fetchBanksInAnantapur(){
    this.bankService.findByCityAnantapur().subscribe(
      data => {
        this.bank = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  fetchBanksInBukkapatnam(){
    this.bankService.findByCityBukkapatnam().subscribe(
      data => {
        this.bank = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }


}
