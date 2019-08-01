package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.BeneficiaryRequest;
import com.baabbee.iframex.beans.DonorRequest;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.repository.BeneficiaryRequestRepository;

@Service
public class BeneficiaryRequestService {
	@Autowired
	private BeneficiaryRequestRepository benRequestRepository;
	
	public List<BeneficiaryRequest> getAllBeneficiaryRequests() {
		List<BeneficiaryRequest> benRequests = new ArrayList<BeneficiaryRequest>();
		benRequestRepository.findAll().forEach(benRequests::add);
		return benRequests;
	}
	
	public BeneficiaryRequest getBeneficiaryRequest(Long id) throws EntityNotFoundException {
		BeneficiaryRequest benReq = null;
		try {
			benReq = benRequestRepository.findById(id).get();
		} catch (Exception e) {
			if (benReq == null)
				throw new EntityNotFoundException(BeneficiaryRequest.class, "id", id.toString());
		}
		return benReq;
	}
	
	public void addBeneficiaryRequest(BeneficiaryRequest userRequest) {
		System.out.println(userRequest);
		benRequestRepository.save(userRequest);		
	}

	public void addBeneficiaryRequests(Set<BeneficiaryRequest> userRequests) {
		benRequestRepository.saveAll(userRequests);		
	}

	public void updateBeneficiaryRequest(Long id, BeneficiaryRequest userRequest) {
		benRequestRepository.save(userRequest);
	}
	
	public void deleteBeneficiaryRequest(Long id) {
		benRequestRepository.deleteById(id);
	}

//	public List<BeneficiaryRequest> getByInitStatus(String status) {
//		List<BeneficiaryRequest> benrequest=benRequestRepository.findByStatus(status);
//		return benrequest;
//	}

	public List<BeneficiaryRequest> findByStatusIn(Collection<String> statuslist) {
		List<BeneficiaryRequest> benReq=benRequestRepository.findByStatusIn(statuslist);		
		return benReq;		
	}
	}
