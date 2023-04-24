package com.example.demo.BankservInter;

import java.util.List;
import com.example.demo.model.BankDetails;
public interface BankServ {
	BankDetails saveBank(BankDetails bank);
	List<BankDetails>  getBanksFromDb();
	BankDetails getBankDetailsById(int id);
	BankDetails updateBankDetails(BankDetails bank, int id);
	void deleteBankId(int id);
	
}
