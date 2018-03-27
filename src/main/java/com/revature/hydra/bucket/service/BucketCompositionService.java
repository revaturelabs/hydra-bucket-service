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
	
	/**
	 * Saves given bucket to database
	 * 
	 * @param bucket
	 */
	public void save (SimpleBucket bucket) {
		bucketRepository.save(bucket);
	}
	
	/**
	 * Returns all buckets
	 * 
	 * @return All buckets
	 */
	public List<SimpleBucket> findAll (){
		List<SimpleBucket> buckets = bucketRepository.findAll();
		return buckets;
	}
	
	/**
	 * Returns bucket of given id
	 * 
	 * @param bucketId Id of bucket 
	 * @return Bucket of given id
	 */
	public SimpleBucket findByBucketId(Integer bucketId) {
		SimpleBucket bucket = bucketRepository.findOne(bucketId);
		return bucket;
	}
	
}
