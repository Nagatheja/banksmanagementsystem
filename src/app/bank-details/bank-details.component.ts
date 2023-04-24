import { Component,OnInit } from '@angular/core';
import { Bank } from '../bank';
import { ActivatedRoute } from '@angular/router';
import { BankService } from '../bank.service';

@Component({
  selector: 'app-bank-details',
  templateUrl: './bank-details.component.html',
  styleUrls: ['./bank-details.component.css']
})
export class BankDetailsComponent  implements OnInit {
  id: number=0;
  bank: any = [];
  constructor(private route: ActivatedRoute, private bankService: BankService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.bank= new Bank();
    this.bankService.getBankById(this.id).subscribe( data => {
      this.bank = data;
    });
  }


}
