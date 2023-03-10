package com.reader.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reader.Entity.Subscription;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscription, Integer> {
	
	List<Subscription> findByReaderId(Integer readerId);
	Subscription findBySubscriptionId(Integer subscriptionId);
	LocalDateTime getDateBySubscriptionId(Integer subscriptionId);
	

}
