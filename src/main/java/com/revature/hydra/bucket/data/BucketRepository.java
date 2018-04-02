package com.revature.hydra.bucket.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleBucket;

public interface  BucketRepository extends JpaRepository<SimpleBucket, Integer> {

	/**
	 * Update bucket table's category and description based on given bucketId
	 * 
	 * @param simpleBucket Updated info 
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Modifying(clearAutomatically = true)
	@Query("update SimpleBucket sb set bucketCategory = ?2, bucketDescription = ?3 where bucketId = ?1")
	void updateByBucketId(Integer bucketId, String bucketCategory, String bucketDescription);

}
