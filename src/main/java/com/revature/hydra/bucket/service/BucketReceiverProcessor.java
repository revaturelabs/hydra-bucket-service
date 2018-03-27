package com.revature.hydra.bucket.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.revature.beans.SimpleBucket;
import com.revature.hydra.bucket.data.BucketRepository;

@Service
public class BucketReceiverProcessor {

	@Autowired
	private BucketRepository bucketRepository;

	public List<SimpleBucket> processSimpleBucketListRequest(JsonObject request) {
		List<SimpleBucket> bucketList = new ArrayList<>();
		String methodName = request.get("methodName").getAsString();

		Gson gson = new Gson();

		List<SimpleBucket> simpleBucketList = new ArrayList<>();

		if (methodName.equals("getBucketListByIds")) {
			Type type = new TypeToken<List<Integer>>() {
			}.getType();
			List<Integer> bucketIds = (List<Integer>) gson.fromJson(request.get("bucketIds"), type);

			for (Integer bucketId : bucketIds) {
				simpleBucketList.add(bucketRepository.findOne(bucketId));
			}
		}

		return simpleBucketList;
	}

}
