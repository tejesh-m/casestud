package com.reader.Service;

import java.util.List;

import com.reader.Entity.Subscription;

public interface SubscribeService {
	
	public List<Subscription> getSubscriptionByReaderId(Integer readerId);
	public Subscription saveSubscription(Subscription subscribe);
	public Subscription getSubscriptionBySubscriptionId(Integer subscriptionId);
	

}
