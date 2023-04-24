import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BankListComponent } from './bank-list/bank-list.component';
import { CreateBankComponent } from './create-bank/create-bank.component';
import { UpdateBankComponent } from './update-bank/update-bank.component';
import { BankDetailsComponent } from './bank-details/bank-details.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import {AuthGaurdService} from './auth-gaurd.service';
import{SignupComponent} from'./signup/signup.component';
const routes: Routes = [
  {path: 'banks', component: BankListComponent,canActivate:[AuthGaurdService]},
  {path: 'create-bank', component: CreateBankComponent,canActivate:[AuthGaurdService]},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'update-bank/:id', component: UpdateBankComponent,canActivate:[AuthGaurdService]},
  {path: 'bank-details/:id', component: BankDetailsComponent,canActivate:[AuthGaurdService]},
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService]  },
  {path:'singup',component: SignupComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
