/**
 * 
 */
package com.example.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Service;

/**
 * @author vivek
 *
 */
@Service
@EnableScheduling
public class RateService {
	
	private static Map<String,Integer> defaultMap = new HashMap<>(Map.of("default", 2,"tenant1", 5, "tenant2", 10));
	private static Map<String,Integer> limitMap = new HashMap<>(Map.of("default", 2,"tenant1", 5, "tenant2", 10));
	
	public int checkLimit(String tenant) {
		int currentUsage = limitMap.get(tenant);
		
		if(currentUsage > 0) {
			limitMap.put(tenant, currentUsage-1);
		}
		return currentUsage;
	}
	
	@Scheduled(cron = "0 0 0/1 1/1 * ?")
	public void scheduleTaskUsingCronExpression() {
		
		limitMap.clear();
		limitMap.putAll(defaultMap);
		
		System.out.println("Tenant limit renewed");
	}

}
