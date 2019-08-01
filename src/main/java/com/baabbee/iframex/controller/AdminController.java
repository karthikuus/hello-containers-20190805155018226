//package com.baabbee.iframex.controller;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import org.hibernate.mapping.Collection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.baabbee.iframex.beans.Frame;
//import com.baabbee.iframex.beans.FrameRequest;
//import com.baabbee.iframex.beans.UserRequest;
//import com.baabbee.iframex.service.AdminService;
//import com.baabbee.iframex.service.FrameRequestService;
//import com.baabbee.iframex.service.FrameService;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class AdminController {
//
//		@Autowired
//		private AdminService adminservice;
//	
//		@RequestMapping("/admin/processdonor/{status}")
//		//pass 'initiated' status as path variable in the above request for 'process donor request' button and 'labelprinted' status for 'send envelope' button
//		public List<UserRequest> getByInitStatus(@PathVariable String status){
//			System.out.println("inside block");
//			List<UserRequest> userrequest=adminservice.getByInitStatus(status);
//			return userrequest;
//		}
//	
//		@RequestMapping("/admin/receiveframe/{status1}/{status2}")
//		//pass 'prepaid sent' and 'don_received' statuses for the 'receive and validate button' 
//		public List<UserRequest> getValidationRequests(@PathVariable String status1,@PathVariable String status2){
//			List<String> statuslist=new ArrayList<String>();
//			Collections.addAll(statuslist,status1,status2);
//			System.out.println("inside validate frame block");
//			List<UserRequest> userrequest=adminservice.findByStatusIn(statuslist);
//			return userrequest;
//		}
////		@RequestMapping(method=RequestMethod.POST,value="/admin/validateframedetails")
////		public void validateFrameDetails(@RequestBody Frame frame) {
//		//method already available in the FrameService class
////			frameservice.addFrame(frame);
////		}
////		
//}
//
