package com.newspaper.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userSubscriptionId;

	private boolean subscribeValue = false;
	
	private long duration;
	private long amount;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	private NewsPaper newsPaper;

	public long getUserSubscriptionId() {
		return userSubscriptionId;
	}

	public void setUserSubscriptionId(long userSubscriptionId) {
		this.userSubscriptionId = userSubscriptionId;
	}

	public boolean isSubscribeValue() {
		return subscribeValue;
	}

	public void setSubscribeValue(boolean subscribeValue) {
		this.subscribeValue = subscribeValue;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public NewsPaper getNewsPaper() {
		return newsPaper;
	}

	public void setNewsPaper(NewsPaper newsPaper) {
		this.newsPaper = newsPaper;
	}

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscription(long userSubscriptionId, boolean subscribeValue, long duration, long amount, User user,
			NewsPaper newsPaper) {
		super();
		this.userSubscriptionId = userSubscriptionId;
		this.subscribeValue = subscribeValue;
		this.duration = duration;
		this.amount = amount;
		this.user = user;
		this.newsPaper = newsPaper;
	}


}
