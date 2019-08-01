package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.DonorRequest;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.repository.DonorRequestRepository;

@Service
public class DonorRequestService {
	@Autowired
	private DonorRequestRepository donRequestRepository;
	
	public List<DonorRequest> getAllDonorRequests() {
		List<DonorRequest> donRequests = new ArrayList<DonorRequest>();
		donRequestRepository.findAll().forEach(donRequests::add);
		return donRequests;
	}
	
	public DonorRequest getDonorRequest(Long id) throws EntityNotFoundException {
		DonorRequest donorReq = null;
		try {
			donorReq = donRequestRepository.findById(id).get();
		} catch (Exception e) {
			if (donorReq == null)
				throw new EntityNotFoundException(DonorRequest.class, "id", id.toString());
		}
		return donorReq;
	}
	
	public void addDonorRequest(DonorRequest userRequest) {
		donRequestRepository.save(userRequest);		
	}

	public void addDonorRequests(Set<DonorRequest> userRequests) {
		donRequestRepository.saveAll(userRequests);		
	}

	public void updateDonorRequest(Long id, DonorRequest userRequest) {
		userRequest.setId(id);
		donRequestRepository.save(userRequest);
	}
	
	public void deleteDonorRequest(Long id) {
		donRequestRepository.deleteById(id);
	}
	
//	public List<DonorRequest> getByInitStatus(String status) {
//		List<DonorRequest> donrequest=donRequestRepository.findByStatus(status);
//		return donrequest;
//	}

	public List<DonorRequest> findByStatusIn(List<String> statuslist) {
		List<DonorRequest> donReq=donRequestRepository.findByStatusIn(statuslist);		
		return donReq;		
	}

	}
