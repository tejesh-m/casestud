package com.reader.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.reader.Entity.Book;
import com.reader.Entity.Reader;
import com.reader.Entity.Subscription;
import com.reader.Service.ReaderService;
import com.reader.Service.SubscribeService;

@RestController
@RequestMapping("api/v1/digitalbooks")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReaderController {
	
	@Autowired
	private ReaderService readerService;
	
	@Autowired
	private SubscribeService subscribeService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/reader/signup")
       public Integer registerReader(@RequestBody Reader reader) {
		Reader signupReader = readerService.createReader(reader);
		return signupReader.getReaderId();
	}
	
	@GetMapping("/reader/signin")
	public Boolean readerSignin(@RequestParam("remailid") String remailid, @RequestParam("rpassword") String rpassword) {
		Reader signinReader = readerService.getReaderbyremailid(remailid);
		if(signinReader.getRpassword().equals(rpassword))
			return true;
		return false;
			}
	
	@PostMapping("/{bookid}/{readerId}/subscribe")
	public Subscription subscribeBook(@PathVariable Integer bookid, @PathVariable Integer readerId) {
		Book getbook = restTemplate.getForObject("http://localhost:8086/api/v1/digitalbooks/read/"+bookid, Book.class);
        Subscription newSub = new Subscription();
		newSub.setBookid(bookid);
		newSub.setReaderId(readerId);
		java.time.LocalDateTime date = java.time.LocalDateTime.now();
		newSub.setDate(date);
		Subscription saveSub = subscribeService.saveSubscription(newSub);
		return saveSub;
	}
	
	@GetMapping("/reader/{remailid}/books")
		public List<Book> getSubscribedbooks(@PathVariable String remailid){
			Reader reader = readerService.getReaderbyremailid(remailid);
			Integer readerId = reader.getReaderId();
			List<Subscription> subscriptionList = subscribeService.getSubscriptionByReaderId(readerId);
			List<Book> book = new ArrayList<Book>();
			subscriptionList.stream().forEach(
					(sub) -> {book.add(
							restTemplate.getForObject("http://localhost:8086/api/v1/digitalbooks/read/"+sub.getBookid(), Book.class)
							);}
						);
		
		return book;
	
		}
	
	@GetMapping("/reader/{remailid}/books/{subscriptionId}")
	public Book getBookbysubid(@PathVariable String remailid, @PathVariable Integer subscriptionId) {
		Subscription sub = subscribeService.getSubscriptionBySubscriptionId(subscriptionId);
		Integer readid = sub.getReaderId();
		Integer bookid = sub.getBookid();
		Reader read = readerService.getReaderbyReaderid(readid);
		if(read.getRemailid().equals(remailid)) {
			Book book = restTemplate.getForObject("http://localhost:8086/api/v1/digitalbooks/read/"+bookid, Book.class);
		return book;
		}
		return null;
	}
	}

