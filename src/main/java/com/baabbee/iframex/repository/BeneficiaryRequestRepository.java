package com.baabbee.iframex.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.baabbee.iframex.beans.BeneficiaryRequest;
public interface BeneficiaryRequestRepository extends CrudRepository<BeneficiaryRequest, Long> {
	//public List<BeneficiaryRequest> findByStatus(String status);

	public List<BeneficiaryRequest> findByStatusIn(Collection<String> statuslist);

}
