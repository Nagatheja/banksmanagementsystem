import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule} from '@angular/forms';
import { CreateBankComponent } from './create-bank/create-bank.component';
import { BankDetailsComponent } from './bank-details/bank-details.component';
import { BankListComponent } from './bank-list/bank-list.component';
import { UpdateBankComponent } from './update-bank/update-bank.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SignupComponent } from './signup/signup.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateBankComponent,
    BankDetailsComponent,
    BankListComponent,
    UpdateBankComponent,
    LoginComponent,
    LogoutComponent,
    SignupComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }