package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.Frame;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.repository.FrameRequestRepository;

@Service
public class FrameRequestService {
	@Autowired
	private FrameRequestRepository frameRequestRepository;
	
	public List<FrameRequest> getAllFrameRequests() {
		List<FrameRequest> frameRequests = new ArrayList<FrameRequest>();
		frameRequestRepository.findAll().forEach(frameRequests::add);
		return frameRequests;
	}
	
	public FrameRequest getFrameRequest(Long id) throws EntityNotFoundException {
		FrameRequest frameRequest = null;
		try {
			frameRequest = frameRequestRepository.findById(id).get();
		} catch (Exception e) {
			if (frameRequest == null)
				throw new EntityNotFoundException(FrameRequest.class, "id", id.toString());
		}
		return frameRequest;
	}
	
	public void addFrameRequest(FrameRequest frameRequest) {
		frameRequestRepository.save(frameRequest);		
	}
	
	public void updateFrameRequest(Long id, FrameRequest frameRequest) {
		frameRequestRepository.save(frameRequest);
	}
	
	public void deleteFrameRequest(Long id) {
		frameRequestRepository.deleteById(id);
	}
}
