package com.revature.hydra.bucket.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Bucket;
import com.revature.beans.SimpleBucket;
import com.revature.hydra.bucket.service.BucketService;

@RestController
@CrossOrigin("*")
@ComponentScan("com.revature.hydra.bucket.*")
public class BucketController {

	private static final Logger log = Logger.getLogger(BucketController.class);
	private BucketService bucketService;
	
	@Autowired 
	public void setBucketService(BucketService bucketService) {
		this.bucketService = bucketService;
	}
	
	/**
	 * Get list of all the buckets
	 * 
	 * @return
	 */
	@RequestMapping(value="/bucket/getBuckets", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SimpleBucket>> getAllBuckets(){
		List<SimpleBucket> buckets = bucketService.findAllBuckets();
		return new ResponseEntity<>(buckets, HttpStatus.OK);
	}
	
	/**
	 * Create a new SimpleBucket
	 * 
	 * @param bucket Information to be passed to newly created bucket
	 * @return The created bucket
	 */
	@RequestMapping(value="/bucket/createBucket", method= RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleBucket> createNewBucket(@Valid @RequestBody SimpleBucket bucket){
		log.info("Saving bucket:" + bucket);
		bucket.setIsActive(true);
		bucketService.save(bucket);
		
		return new ResponseEntity<>(bucket, HttpStatus.CREATED);
	}
	
	/**
	 * Get a single bucket by bucketId
	 * 
	 * @param id Id of bucket
	 * @return Bucket of given id
	 */
	@RequestMapping(value="/bucket/{id}", method=RequestMethod.GET)
	public ResponseEntity<SimpleBucket> getBucketByBucketId(@PathVariable int id){
		SimpleBucket bucket = bucketService.findBucketByBucketId(id);
		return new ResponseEntity<>(bucket, HttpStatus.OK);
	}
	
	/**
	 * Update bucket table's category and description based on given bucketId
	 * 
	 * @param simpleBucket Updated info 
	 * @return 
	 */
	@RequestMapping(value="/bucket/updateBucket", method = RequestMethod.POST)
	public ResponseEntity<Void> updateBucket(@RequestBody SimpleBucket simpleBucket) {
		bucketService.updateBucket(simpleBucket);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
