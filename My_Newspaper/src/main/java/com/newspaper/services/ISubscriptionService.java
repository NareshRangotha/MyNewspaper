package com.newspaper.services;

import java.util.Set;

import com.newspaper.model.Subscription;

public interface ISubscriptionService {

	/**
	 * This method is used to add subscription
	 * 
	 * @param subscription
	 */
	public void addSubscription(Subscription subscription);

	/**
	 * This method is used to delete subscription by subscriptionid
	 * 
	 * @param subsId
	 * @throws Exception
	 */
	public void deleteSubscription(long subsId) throws Exception;

	/**
	 * This method is used to get all subscription by userid
	 * 
	 * @param user_id
	 * @return set of subscription
	 */
	public Set<Subscription> getAllSubscription(long user_id);

	/**
	 * This method is used to get all subscription by vendorid
	 * 
	 * @param user_id
	 * @return set of subscription
	 */
	public Set<Subscription> getAllSubscriptionForVendor(long user_id);

}
