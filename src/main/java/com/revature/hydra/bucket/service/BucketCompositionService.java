package com.revature.hydra.bucket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.revature.beans.Bucket;
import com.revature.beans.SimpleBucket;
import com.revature.hydra.bucket.data.BucketRepository;

@Service
public class BucketCompositionService {

	@Autowired
	private BucketRepository bucketRepository;
	
	/*
	 * Saving a simple Bucket bean.
	 */
	public void save (SimpleBucket bucket) {
		bucketRepository.save(bucket);
	}
	
	public List<SimpleBucket> findAll (){
		List<SimpleBucket> buckets = bucketRepository.findAll();
		return buckets;
	}
	
	public SimpleBucket findByBucketId(Integer bucketId) {
		SimpleBucket bucket = bucketRepository.findOne(bucketId);
		return bucket;
	}
	
}
