package com.baabbee.iframex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baabbee.iframex.EntityNotFoundException;
import com.baabbee.iframex.beans.Frame;
import com.baabbee.iframex.beans.FrameRequest;
import com.baabbee.iframex.beans.User;
import com.baabbee.iframex.repository.FrameRepository;

@Service
public class FrameService {
	@Autowired
	private FrameRepository frameRepository;
	
	public List<Frame> getAllFrames() {
		List<Frame> frames = new ArrayList<Frame>();
		frameRepository.findAll().forEach(frames::add);
		return frames;
	}
	
	public Frame getFrame(Long id) throws EntityNotFoundException {
		Frame frame = null;
		try {
			frame = frameRepository.findById(id).get();
		} catch (Exception e) {
			if (frame == null)
				throw new EntityNotFoundException(Frame.class, "id", id.toString());
		}
		return frame;
	}
	
	public void addFrame(Frame frame) {
		frameRepository.save(frame);		
	}
	
	public void updateFrame(Long id, Frame frame) {
		frameRepository.save(frame);
	}
	
	public void deleteFrame(Long id) {
		frameRepository.deleteById(id);
	}

	public List<Frame> getMatchedFrames(FrameRequest frameRequest) {
		 System.out.println(frameRequest);
		 List<Frame> prioritylevel4=frameRepository.getBySize(frameRequest.getSize());
		 System.out.println(prioritylevel4);
		 List<Frame> prioritylevel1=new ArrayList<Frame>();
		 List<Frame> prioritylevel2=new ArrayList<Frame>();;
		 List<Frame> prioritylevel3=new ArrayList<Frame>();;
		 for(int i=0;i<prioritylevel4.size();i++) {
			 System.out.println("*****************************");
			 Frame frame = prioritylevel4.get(i);
			 System.out.println(frame);
			 	if(frame.getGender().equals(frameRequest.getGender())) {
					 System.out.println("priority 3 passed with size and gender match for the obj "+frame);
			 		prioritylevel3.add(frame);
			 		System.out.println("Frame request obj to be compared is "+frameRequest);
			 		if((frame.getColor().equals(frameRequest.getColor()))||(frame.getMaterial().equals(frameRequest.getMaterial()))) {
						 System.out.println("priority 2 passed with size and gender match and mat or col match for obj "+frame);
			 			prioritylevel2.add(frame);
			 		}
			 		if((frame.getColor().equals(frameRequest.getColor()))&&(frame.getMaterial().equals(frameRequest.getMaterial()))) {
						 System.out.println("priority 1 passed with size and gender match and mat and col match for obj"+frame);
			 			prioritylevel1.add(frame);
			 		}
			 		}
		 }
		if(!prioritylevel1.isEmpty())
		 return prioritylevel1;
		 else if(!prioritylevel2.isEmpty())
	     return prioritylevel2;
		 else if(!prioritylevel3.isEmpty())
		 return prioritylevel3;
		 else 
	     return prioritylevel4;
		 }

	public void addBulkFrame(List<Frame> frame) {
		frameRepository.saveAll(frame);
	}
}
