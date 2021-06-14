package com.douzone.container.config.videosystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.videosystem.DigitalVideoDisc;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= CDPlayerConfig.class)
@ContextConfiguration(locations = {"classpath:com/douzone/container/config/videosystem/DVDPlayerConfig.xml"})
public class DVDPlayerXmlConfigTest {
	
	@Rule
	public final SystemOutRule systemOutRul = new SystemOutRule().enableLog();
	
	
	// @Autowired
	// 예외 발생.
	// XML 빈 설정시 id는 자동으로 부여 되지 않는다. 
	// @Qualifier 사용불가 
	DigitalVideoDisc dvd1;
	
	@Autowired
	@Qualifier("ironMan")
	DigitalVideoDisc dvd2;

	@Ignore
	@Test
	public void testDVD01() {
	 assertNotNull(dvd1);	
	}
	
	
	@Test
	public void testDVD02() {
	 assertNotNull(dvd2);	
	}
}
