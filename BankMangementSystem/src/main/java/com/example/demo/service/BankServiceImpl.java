package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BankservInter.BankServ;
import com.example.demo.model.BankDetails;
import com.example.demo.repository.BankRepo;
@Service
public class BankServiceImpl implements BankServ{

	BankRepo bankRepo;

	public BankServiceImpl(BankRepo bankRepo) {
		this.bankRepo= bankRepo;
	}

	public BankDetails saveBank(BankDetails bank) {
		return bankRepo.save(bank);
	}

	@Override
	public List<BankDetails> getBanksFromDb() {
		return bankRepo.findAll();
	}

	@Override//5
	public BankDetails getBankDetailsById(int Id) {
		Optional<BankDetails> bank = bankRepo.findById(Id);
		if(bank.isPresent()) {
			return bank.get();
		}
		else {
			return null;
		}
	}

	@Override
	public BankDetails updateBankDetails(BankDetails newVal, int Id) {
		Optional<BankDetails> bank = bankRepo.findById(Id);
		if(bank.isPresent()) {
			BankDetails existingBank = bank.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingBank.setBankName(newVal.getBankName());
			existingBank.setIfsc_code(newVal.getIfsc_code());
			existingBank.setManager(newVal.getManager());
			existingBank.setCity(newVal.getCity());
			existingBank.setPincode(newVal.getPincode());
			bankRepo.save(existingBank);
			return existingBank;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteBankId(int id) {
		Optional<BankDetails> bank = bankRepo.findById(id);
		
		System.out.println(bank);
		if(bank.isPresent()) {
			bankRepo.deleteById(id);
		}	
	}
}
