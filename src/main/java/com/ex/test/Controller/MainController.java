package com.ex.test.Controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.test.Entity.Accounting;
import com.ex.test.Entity.Sales;
import com.ex.test.Repository.AccountingRepo;
import com.ex.test.Repository.SalesRepo;
import com.ex.test.Service.MainService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
	@Autowired
	private MainService ms;
	
	@Autowired
	private AccountingRepo accountingRepo;
	@Autowired
	private SalesRepo salesrepo;
	@PostMapping("/add")
	public Accounting add(@RequestBody Accounting account)
	{
		return ms.add(account);
	}
	@PostMapping("/add1")
	public Sales add1(@RequestBody Sales sales)
	{
		return ms.add1(sales);
	}
//	@Autowired
//	private AccountingRepo arc;

	
	@PutMapping("/Accounting/{id}")
	public String update(@RequestBody Accounting account, @PathVariable int id)
	{
		return ms.update(account, id);
	}
	@PutMapping("/Sales/{sid}")
	public String update1(@RequestBody Sales sales, @PathVariable Integer sid)
	{
		return ms.update1(sales, sid);
	}
	
	
	
	
	
	/*@DeleteMapping("/Accounting/{id}")
	public String delete(@PathVariable("id")Integer id) {
		 return ms.delete(id);
	}*/
	
	@PostMapping("/addData")
	public String addDataAPI(@RequestBody HashMap<String, List<JSONObject>> object) {
		try {
			List<Sales> salesList= new ArrayList<>();
			List<JSONObject> accounting = object.get("accounting");
			List<JSONObject> salesData=object.get("sales");
			List<Accounting> accountList= new ArrayList<>();
			for(int i=0;i<accounting.size();i++) {
				Accounting accountingData= new Accounting();
				accountingData.setId(Integer.parseInt(accounting.get(i).get("id").toString()));
				accountingData.setAge(Integer.parseInt(accounting.get(i).get("age").toString()));
				accountingData.setFname(accounting.get(i).get("firstName").toString());
				accountingData.setLname(accounting.get(i).get("lastName").toString());
				accountList.add(accountingData);
			}
			//System.out.println(accountList);
			accountingRepo.saveAll(accountList);
			//sales
			//List<Sales> saleslist =new ArrayList<>();
			for(int i=0;i<salesData.size();i++) {
				Sales salesitems =new Sales();
				salesitems.setSid(Integer.parseInt(salesData.get(i).get("sid").toString()));
				salesitems.setAge(Integer.parseInt(salesData.get(i).get("age").toString()));
				salesitems.setFname(salesData.get(i).get("firstName").toString());
				salesitems.setLname(salesData.get(i).get("lastName").toString());
				//System.out.println(salesitems);
				salesList.add(salesitems);
			}
			
			System.out.println(salesList);
			salesrepo.saveAll(salesList);
			return null;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	////////////////Deleting /multiple id at a time=======================/
	
	@DeleteMapping("/Delete")
	public String mult(@RequestBody List<Integer> id) {
		return this.ms.mult(id);
	
	}
}
