package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BankDetails;

@Repository
public interface BankRepo extends JpaRepository<BankDetails, Integer>{

	

	List<BankDetails> findBymanagerContaining(String manager);
	List<BankDetails> findByCity(String city);

}
