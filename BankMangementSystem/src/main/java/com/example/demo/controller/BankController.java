package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BankDetails;
import com.example.demo.repository.BankRepo;
import com.example.demo.service.BankServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BankController {
public BankServiceImpl bankServ;
public BankRepo bankRepo;

	
	@Autowired
	public BankController(BankServiceImpl bankServ,BankRepo bankRepo) {
		this.bankServ = bankServ;
		this.bankRepo=bankRepo;
	}



	@PostMapping("/bank")
	
	public ResponseEntity<BankDetails> saveBank(@RequestBody BankDetails bank){
		return new ResponseEntity<BankDetails>(bankServ.saveBank(bank), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/bank/{id}")
	public ResponseEntity<BankDetails> updateBankDetailsById(@PathVariable("id") int id,
			@RequestBody BankDetails bank){
		return new ResponseEntity<BankDetails>(bankServ.updateBankDetails(bank, id), HttpStatus.OK);
		
	}
//	@GetMapping("/bank")
//	public List<BankDetails> getAllBanks(){
//		return bankServ.getBanksFromDb();
//	}
	
	@GetMapping("/bank/{id}")
	public ResponseEntity<BankDetails>  getBankDetailsById(@PathVariable("id")  int id){
		return new ResponseEntity<BankDetails>(bankServ.getBankDetailsById(id), HttpStatus.OK);
	}
	@GetMapping("/bank")
	public ResponseEntity<List<BankDetails>> getAllBanks(@RequestParam(required=false)String name){
		try {
			List<BankDetails>bankList=new ArrayList<BankDetails>();
			if(name!=null) {
				bankRepo.findBymanagerContaining(name).forEach(bankList::add);
				return new ResponseEntity<>(bankList,HttpStatus.OK);
			}
			else {
				bankList=bankRepo.findAll();
				return new ResponseEntity<>(bankList,HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/bank/{id}")
	public ResponseEntity<String> deleteBankDetailsById(@PathVariable("id")  int id){
		
		bankServ.deleteBankId(id);
		System.out.println("delted");
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}
	@DeleteMapping("/bank")
	public ResponseEntity<HttpStatus> deleteAllEmps() {
		try {
			bankRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/bank/fetchByCityMadanapalle")
	public ResponseEntity<List<BankDetails>> findByPublished() {
		try {
			List<BankDetails> techDomainEmpList = bankRepo.findByCity("Madanapalle");

			if (techDomainEmpList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(techDomainEmpList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/bank/fetchByCityAnantapur")
	public ResponseEntity<List<BankDetails>> findByPublished1() {
		try {
			List<BankDetails> techDomainEmpList = bankRepo.findByCity("Anantapur");

			if (techDomainEmpList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(techDomainEmpList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/bank/fetchByCityBukkapatnam")
	public ResponseEntity<List<BankDetails>> findByPublished2() {
		try {
			List<BankDetails> techDomainEmpList = bankRepo.findByCity("Bukkapatnam");

			if (techDomainEmpList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(techDomainEmpList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
