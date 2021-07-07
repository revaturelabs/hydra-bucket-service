package com.revature.hydra.bucket.test.unit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.beans.SimpleBucket;
import com.revature.hydra.bucket.data.BucketRepository;
import com.revature.hydra.test.util.TestContext;
import com.revature.hydra.test.util.WebAppContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, WebAppContext.class })
@DataJpaTest
@WebAppConfiguration
public class BucketRepositoryTests {

	@Autowired
	BucketRepository br;
	
	Integer id;
	
	@Before
	public final void init() {
		SimpleBucket sb = new SimpleBucket("Test category", "Test description", true);
		id = br.save(sb).getBucketId();
	}
	
	@After
	public final void end() {
		br.deleteAll();
	}
	
	@Test
	public final void testUpdateByBucketId() {
		Assert.assertEquals(br.findOne(id).getBucketDescription(), "Test description");
		br.updateByBucketId(id, "New category", "New description");
		Assert.assertEquals(br.findOne(id).getBucketDescription(), "New description");
	}
	
}
