package com.ex.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.test.Entity.Accounting;

public interface AccountingRepo extends JpaRepository<Accounting , Integer>{

	void deleteByIdIn(List<Integer> id);

	List<Accounting> findByIdIn(List<Integer> id);

}
