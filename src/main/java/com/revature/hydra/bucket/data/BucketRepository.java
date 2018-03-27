package com.revature.hydra.bucket.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleBucket;

public interface  BucketRepository extends JpaRepository<SimpleBucket, Integer> {

	/*
	 * find a list of SimpleBucket
	 * @return List of SimpleBucket
	 */
	List<SimpleBucket> findAll();
	
	/*
	 * find a SimpleBucket by bucketId
	 * @param bucketId
	 * @return SimpleBucket
	 */
	SimpleBucket findByBucketId(Integer bucketId);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Modifying(clearAutomatically = true)
	@Query("update SimpleBucket sb set bucketCategory = ?2, bucketDescription = ?3 where bucketId = ?1")
	void updateByBucketId(Integer bucketId, String bucketCategory, String bucketDescription);
}
