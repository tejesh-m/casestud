package com.reader.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reader.Entity.Subscription;
import com.reader.repo.SubscribeRepository;

@Service
public class SubscribeServiceImpl implements SubscribeService {
	
	@Autowired
	SubscribeRepository subscribeRepo;

	@Override
	public List<Subscription> getSubscriptionByReaderId(Integer readerId) {
		List<Subscription> listSub = subscribeRepo.findByReaderId(readerId);
		return listSub;
	}

	@Override
	public Subscription saveSubscription(Subscription subscribe) {
		Subscription saveSub = subscribeRepo.save(subscribe);
		return saveSub;
	}

	@Override
	public Subscription getSubscriptionBySubscriptionId(Integer subscriptionId) {
		Subscription subscriptionbyId = subscribeRepo.findBySubscriptionId(subscriptionId);
		return subscriptionbyId;
	}

}
