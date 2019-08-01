package com.baabbee.iframex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.service.FrameRequestService;

@RestController
public class FrameRequestController {
	
	@Autowired
	private FrameRequestService frameRequestService;
	
	@RequestMapping("/frameRequests")
	public List<FrameRequest> getAllFrameRequests() {
		return frameRequestService.getAllFrameRequests();
	}
	
	@RequestMapping("/frameRequests/{id}")
	public FrameRequest getFrameRequest(@PathVariable("id") Long id) throws EntityNotFoundException {
		return frameRequestService.getFrameRequest(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/frameRequests")
	public void addFrameRequest(@RequestBody FrameRequest frameRequest) {
		frameRequestService.addFrameRequest(frameRequest);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/frameRequests/{id}")
	public void updateFrameRequest(@RequestBody FrameRequest frameRequest, @PathVariable Long id) {
		frameRequest.setId(id);
		frameRequestService.updateFrameRequest(id, frameRequest);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/frameRequests/{id}")
	public void deleteFrameRequest(@PathVariable Long id) {
		frameRequestService.deleteFrameRequest(id);
	}
}
