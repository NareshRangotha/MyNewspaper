package com.newspaper.dao;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.newspaper.model.Subscription;

@Repository
public interface ISubscriptionDao extends JpaRepository<Subscription, Long> {

	

	@Query("SELECT subscription FROM Subscription subscription WHERE subscription.user.id =:user_id")
	public Set<Subscription> getAllSubscription(@Param("user_id") long user_id);
	
	
	@Query("SELECT subscription FROM Subscription subscription WHERE newsPaper.vendor.id =:user_id")
	public Set<Subscription> getAllSubscriptionForVendor(@Param("user_id") long user_id);
	
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM subscription WHERE user_subscription_id=:user_id", nativeQuery=true)
	public void deleteBySubsriptionId(@Param("user_id") long user_id);


}
