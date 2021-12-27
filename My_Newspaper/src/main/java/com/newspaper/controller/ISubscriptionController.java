package com.newspaper.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.newspaper.model.Subscription;


public interface ISubscriptionController {

	
	/**
	 * This method is used to get subscriptions by user
	 * @param user_id
	 * @return set of subscriptions
	 */
	@GetMapping("/getAllSubscriptionsByUser/{user_id}")
	public ResponseEntity<Set<Subscription>> getAllSubscriptions(@PathVariable("user_id") long user_id);


	/**
	 * This method is used to get subscription details for vendors
	 * @param user_id
	 * @return set of subscription
	 */
	@GetMapping("/getAllSubscriptionsForVendor/{user_id}")
	public ResponseEntity<Set<Subscription>> getAllSubscriptionsForVendor(@PathVariable("user_id") long user_id);

	
	/**
	 * This method is used to subscribe newspaper
	 * @param sub
	 * @return subscription
	 */
	@PostMapping("/doSubscribe/")
	public ResponseEntity<Subscription> doSubscribe(@RequestBody Subscription sub);



	/**
	 * This method is used to delete subscription
	 * @param subscription_id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/deleteSubscriptionById/{subscription_id}")
	public ResponseEntity<?> deleteSubscriptionById(@PathVariable("subscription_id") long subscription_id)throws Exception;

}
