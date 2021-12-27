package com.newspaper.controller.impl;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newspaper.controller.ISubscriptionController;
import com.newspaper.model.Subscription;
import com.newspaper.services.ISubscriptionService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/subscription")
public class SubscriptionController implements ISubscriptionController {

	private Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

	@Autowired
	private ISubscriptionService subService;
	
	@Override
	public ResponseEntity<?> deleteSubscriptionById(@PathVariable("subscription_id") long subscription_id) throws Exception {
		logger.info("Inside @class :SubscriptionController @Method :deleteSubscriptionById");
		subService.deleteSubscription(subscription_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Set<Subscription>> getAllSubscriptions(@PathVariable("user_id") long user_id) {
		logger.info("Inside @class :SubscriptionController @Method :getAllSubscriptions");
		Set<Subscription> subslist=null; 
		subslist=this.subService.getAllSubscription(user_id);
		return new ResponseEntity<Set<Subscription>>(subslist, HttpStatus.OK);
		
	}
	
	
	@Override
	public ResponseEntity<Set<Subscription>> getAllSubscriptionsForVendor(long user_id) {
		Set<Subscription> subslist=null; 
		subslist=this.subService.getAllSubscriptionForVendor(user_id);
		return new ResponseEntity<Set<Subscription>>(subslist, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Subscription> doSubscribe(@RequestBody Subscription sub) {

		try {
			logger.info("Inside @class :SubscriptionController @Method :doSubscribe");
			
			this.subService.addSubscription(sub);
			return ResponseEntity.of(Optional.of(sub));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}

}
