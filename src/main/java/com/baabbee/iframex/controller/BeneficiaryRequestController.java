package com.baabbee.iframex.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.BeneficiaryRequest;
import com.baabbee.iframex.service.BeneficiaryRequestService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BeneficiaryRequestController {

	@Autowired
	private BeneficiaryRequestService benRequestService;

	@RequestMapping("/beneficiaryRequests")
	public List<BeneficiaryRequest> getAllUserRequests() {
		return benRequestService.getAllBeneficiaryRequests();
	}

	@RequestMapping("/beneficiaryRequests/{id}")
	public BeneficiaryRequest getUserRequest(@PathVariable("id") Long id) throws EntityNotFoundException {
		return benRequestService.getBeneficiaryRequest(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/beneficiaryRequests")
	public void addUserRequest(@RequestBody BeneficiaryRequest userRequest) {
		System.out.println(userRequest);
		userRequest.getTotalOrderedQty();
		benRequestService.addBeneficiaryRequest(userRequest);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/beneficiaryRequests/{id}")
	public void updateUserRequest(@RequestBody BeneficiaryRequest userRequest, @PathVariable Long id) {
		benRequestService.updateBeneficiaryRequest(id, userRequest);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/beneficiaryRequests/{id}")
	public void deleteUserRequest(@PathVariable Long id) {
		benRequestService.deleteBeneficiaryRequest(id);

	}

//	@RequestMapping("/beneficiaryRequests/{status}")
//	public List<BeneficiaryRequest> getByInitStatus(@PathVariable String status) {
//		List<BeneficiaryRequest> userrequest = benRequestService.getByInitStatus(status);
//		return userrequest;
//	}
	 
	// pass 'prepaid sent' and 'don_received' statuses for the 'receive and validate
	// button'
	@RequestMapping(value = "/beneficiaryRequests/search", method = RequestMethod.GET )
	public List<BeneficiaryRequest> getValidationRequests(@RequestParam("status") List<String> status) {
//		List<String> statuslist = new ArrayList<String>();
//		String[] statuses = status.split(",");
//		Collections.addAll(statuslist, statuses);
		List<BeneficiaryRequest> userrequest = benRequestService.findByStatusIn(status);
		return userrequest;
	}
		
}
