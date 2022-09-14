package com.ex.test.Service;

import java.util.stream.Collectors;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ex.test.Entity.Accounting;
import com.ex.test.Entity.Sales;
import com.ex.test.Repository.AccountingRepo;
import com.ex.test.Repository.SalesRepo;

@Service
public class MainService {

	@Autowired
	private AccountingRepo ar;
	
	
	@Autowired
	private SalesRepo sr;
	
	public Accounting add(Accounting account)
	{
		return ar.save(account);
	}
	
	public Sales add1(Sales sales)
	{
		return sr.save(sales);
	}
	//update Accounting
	public String update( Accounting account,  int id )
	{
		try {
			Optional<Accounting> ob=ar.findById(id);
			if(!ob.isEmpty()) {
				ar.save(account);
				return "update";
			}else {
				return "id not exisit";
			}
			
		}catch(Exception e)
		{
			return e.getMessage();
			
		}
		
	}
	//update Sales 
	public String update1(Sales sales, Integer sid)
	{
		try {
			Optional<Sales> ob1=sr.findById(sid);
			if(!ob1.isEmpty()) {
				sr.save(sales);
				return "update";
			}else {
				return "id not exist";
			}
			}	catch(Exception e)
			{
				return e.getMessage();
			}
		}
	
		
	
	//delete
	/*public String delete( int id)
	{
		 ar.deleteById(id);
		 return "Sucessfuly deleted";
	}*/
	
	//miltiple delete
	public String mult(List<Integer> id)
	{
		List<Accounting> accountDetails = ar.findByIdIn(id);
		System.out.println(accountDetails);
		for(Accounting accounting:accountDetails) {
			ar.delete(accounting);
		}
		return "Deleted";
	}
	
}
