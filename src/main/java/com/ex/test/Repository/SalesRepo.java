package com.ex.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.test.Entity.Sales;

public interface SalesRepo extends JpaRepository<Sales , Integer>{

}
