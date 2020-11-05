package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.SaleAccount;

public interface SaleAccountRepository extends JpaRepository<SaleAccount, Long> {
	        //SELECT d FROM Employee e JOIN e.department d
//	@Query("SELECT r FROM SaleAccount r "
//			+ "LEFT JOIN FETCH r.seller "
//			+ "LEFT JOIN FETCH r.customer "
//			+ "LEFT JOIN FETCH r.driver "
//			+ "LEFT JOIN FETCH r.user "
//			+ "LEFT JOIN FETCH r.details "
//			+ "WHERE r.total < :total")
//	@Query(value = "SELECT * ")
	
//	List<SaleAccount> listUp(@Param("total") Double weight, Pageable pageable);
}