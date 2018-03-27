package com.revature.hydra.bucket.service;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.revature.beans.SimpleBucket;

@Service
public class BucketMessageReceiver {
	
	@Autowired
	private BucketReceiverProcessor bucketReceiverProcessor;
	
	/**
	 * Receives messages and returns as processed buckets
	 * 
	 * @param message Received message
	 * @return List of buckets
	 */
	@RabbitListener(queues="revature.hydra.repos.bucket")
	public List<SimpleBucket> receiveBucketListRequest(String message){
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(message);
		JsonObject request = element.getAsJsonObject();
		
		return bucketReceiverProcessor.processSimpleBucketListRequest(request);
	}
}
