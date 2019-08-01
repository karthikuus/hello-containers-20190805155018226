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
import com.baabbee.iframex.beans.DonorRequest;
import com.baabbee.iframex.service.DonorRequestService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DonorRequestController {

	@Autowired
	private DonorRequestService donRequestService;

	@RequestMapping("/donorRequests")
	public List<DonorRequest> getAllUserRequests() {
		return donRequestService.getAllDonorRequests();
	}

	@RequestMapping("/donorRequests/{id}")
	public DonorRequest getUserRequest(@PathVariable("id") Long id) throws EntityNotFoundException {
		return donRequestService.getDonorRequest(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/donorRequests")
	public void addUserRequest(@RequestBody DonorRequest userRequest) {
		donRequestService.addDonorRequest(userRequest);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/donorRequests/{id}")
	public void updateUserRequest(@RequestBody DonorRequest userRequest, @PathVariable Long id) {
		userRequest.setId(id);
		donRequestService.updateDonorRequest(id, userRequest);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/donorRequests/{id}")
	public void deleteUserRequest(@PathVariable Long id) {
		donRequestService.deleteDonorRequest(id);

	}

//	@RequestMapping("/donorRequests/{status}")
//	public List<DonorRequest> getByInitStatus(@PathVariable String status) {
//		List<DonorRequest> userrequest = donRequestService.getByInitStatus(status);
//		return userrequest;
//	}

	@RequestMapping(value= "/donorRequests/search", method=RequestMethod.GET)
	// pass 'prepaid sent' and 'don_received' statuses for the 'receive and validate
	// button'
	public List<DonorRequest> getValidationRequests(@RequestParam("status") List<String> status) {
		List<DonorRequest> userrequest = donRequestService.findByStatusIn(status);
		return userrequest;
	}
}
