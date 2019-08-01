package com.baabbee.iframex.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.baabbee.iframex.beans.DonorRequest;

public interface DonorRequestRepository extends CrudRepository<DonorRequest, Long>{
	public List<DonorRequest> findByStatus(String status);

	public List<DonorRequest> findByStatusIn(List<String> statuslist);
	
}
