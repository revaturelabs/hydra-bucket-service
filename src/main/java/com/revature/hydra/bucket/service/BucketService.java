package com.revature.hydra.bucket.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.SimpleBucket;
import com.revature.hydra.bucket.data.BucketRepository;

@Service
public class BucketService {

	private static final Logger log = Logger.getLogger(BucketService.class);

	@Autowired
	private BucketCompositionService bucketDAO;

	@Autowired
	private BucketRepository bucketRepository;

	/*
	 *******************************************************
	 * BUCKET SERVICES
	 *******************************************************
	 */

	/**
	 * Saves given bucket to database
	 * 
	 * @param bucket
	 */
	public void save(SimpleBucket bucket) {
		log.debug("save Bucket");
		bucketDAO.save(bucket);
	}

	/**
	 * Returns all buckets
	 * 
	 * @return All buckets
	 */
	public List<SimpleBucket> findAllBuckets() {
		log.debug("Find all Buckets");
		List<SimpleBucket> buckets = bucketDAO.findAll();
		return buckets;
	}

	/**
	 * Returns bucket of given id
	 * 
	 * @param bucketId Id of bucket 
	 * @return Bucket of given id
	 */
	public SimpleBucket findBucketByBucketId(Integer bucketId) {
		log.debug("Find Bucket By BucketId");
		return bucketDAO.findByBucketId(bucketId);
	}

	/**
	 * Updates given bucket to database
	 * 
	 * @param simpleBucket Updated bucket
	 */
	public void updateBucket(SimpleBucket simpleBucket) {
		bucketRepository.updateByBucketId(simpleBucket.getBucketId(), simpleBucket.getBucketCategory(),
				simpleBucket.getBucketDescription());

	}

}
