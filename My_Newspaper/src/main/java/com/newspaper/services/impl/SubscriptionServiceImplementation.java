package com.newspaper.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newspaper.dao.ISubscriptionDao;
import com.newspaper.model.Subscription;
import com.newspaper.services.ISubscriptionService;

@Service
public class SubscriptionServiceImplementation implements ISubscriptionService {

	@Autowired
	private ISubscriptionDao subscriptionDao;

	@Override
	public void addSubscription(Subscription subscription) {
		this.subscriptionDao.save(subscription);

	}

	@Override
	public Set<Subscription> getAllSubscription(long user_id) {

		return this.subscriptionDao.getAllSubscription(user_id);

	}

	@Override
	public Set<Subscription> getAllSubscriptionForVendor(long user_id) {

		return this.subscriptionDao.getAllSubscriptionForVendor(user_id);
	}

	@Override
	public void deleteSubscription(long subsId) throws Exception {
		this.subscriptionDao.deleteBySubsriptionId(subsId);
	}

}
