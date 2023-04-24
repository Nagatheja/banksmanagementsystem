import { Component,OnInit } from '@angular/core';
import { BankService } from '../bank.service';
import { Bank } from '../bank';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-update-bank',
  templateUrl: './update-bank.component.html',
  styleUrls: ['./update-bank.component.css']
})
export class UpdateBankComponent implements OnInit{
  id : number = 0;
  bank: Bank = new Bank();
  constructor(private bankService: BankService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.bankService.getBankById(this.id).subscribe(data => {
      this.bank = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.bankService.updateBank(this.id, this.bank).subscribe( data =>{
      this.goToBankList();
    }
    , error => console.log(error));
  }

  goToBankList(){
    this.router.navigate(['/banks']);
  }

}
