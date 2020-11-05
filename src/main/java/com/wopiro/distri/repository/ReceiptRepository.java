package com.wopiro.distri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wopiro.distri.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
//	
//	@Query("SELECT r FROM Receipt r "
//			+ "LEFT JOIN FETCH r.user "
//			+ "LEFT JOIN FETCH r.customer "
//			+ "LEFT JOIN FETCH r.seller "
//			//+ "LEFT JOIN FETCH r.zone "
//			//+ "LEFT JOIN FETCH r.details "
//			//+ "LEFT JOIN FETCH r.cheques "
//			+ "LEFT JOIN FETCH r.others "
//			+ "WHERE r.total = :total")
//	List<Receipt> listUp(@Param("total") Double weight, Pageable pageable);
}