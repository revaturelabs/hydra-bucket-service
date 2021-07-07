# hydra-bucket-service
### Hydra MSA element for persisting and accessing skill buckets. 

This service contains the following methods for interacting with data:
*  createNewBucket
	*  Description
		*  Takes a request body as a SimpleBucket object and saves it to the database.
	*  Endpoint
		*  /bucket/createBucket

*  updateBucket
	*  Description
		*  Takes a request body as a SimpleBucket object and updates the relevant bucket within the database.
	*  Endpoint
		*  /bucket/updateBucket

*  getAllBuckets
	*  Description
		*  Returns all buckets found in the database.
	*  Endpoint
		*  /bucket/getBuckets
		
*  getBucketByBucketId
	*  Description
		*  Returns a single bucket from the database from the given bucket id.
	*  Endpoint
		*  /bucket/{id}
		
The Bucket service communicates with the following services:
*  SkillType
*  Question
