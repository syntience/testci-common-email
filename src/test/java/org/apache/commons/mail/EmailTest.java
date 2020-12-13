package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd" };
	private static final String[] TEST_EMPTY = {  };
	private static final String TEST_EMAIL = "ab@bc.com";
	private static final String TEST_NAME = "test";
	private static final String TEST_VALUE = "test";	
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmaiLtest() throws Exception{
		
	}

	//test addBcc() with both a list of emails and an empty list
	@Test
	public void testAddBcc() throws Exception{
		email.addBcc(TEST_EMAILS);
		assertEquals(3, email.getBccAddresses().size());
		email.addBcc(TEST_EMPTY);
		assertEquals(0, email.getBccAddresses().size());
	}

	//test addCc() with one email
	@Test
	public void testAddCc() throws Exception{
		email.addCc(TEST_EMAIL);
		assertEquals(1, email.getCcAddresses().size());
	}
	
	//test addHeader() with an empty name
	@Test
	public void testAddHeader() throws Exception{
		email.addHeader("", TEST_VALUE);
		assertEquals(0, email.headers.size());
		
	}
	
	//test addHeader() with an empty value
	@Test
	public void testAddHeader2() throws Exception{
		email.addHeader(TEST_NAME, "");
		assertEquals(0, email.headers.size());
	}
	
	//test addHeader() with both name and value
	@Test
	public void testAddHeader3() throws Exception{
		email.addHeader(TEST_NAME, TEST_VALUE);
		assertEquals(1, email.headers.size());
	}
	
	//test addReplyTo() with an email and name
	@Test
	public void testAddReplyTo() throws Exception{
		email.addReplyTo(TEST_EMAIL, TEST_NAME);
		assertEquals(1, email.replyList.size());
	}
	
	//test one call of buildMimeMessage()
	@Test
	public void testBuildMimeMessage() throws Exception{
		email.setHostName(TEST_NAME);
		email.setFrom(TEST_EMAIL);
		email.setCharset("US-ASCII");
		
		email.buildMimeMessage();
		
	}

	//test two calls of buildMimeMessage()
	@Test
	public void testBuildMimeMessage2() throws Exception{
		email.buildMimeMessage();
		email.buildMimeMessage();
		
	}
	
	//test a proper getHostName() call
	@Test
	public void testGetHostName() throws Exception{
		email.setHostName(TEST_NAME);
		email.getHostName();
	}
	
	//test getHostName() without the host name being set first
	@Test
	public void testGetHostName2() throws Exception{
		email.getHostName();
	}
	
	//test getMailSession()
	@Test
	public void testGetMailSession() throws Exception{
		email.getMailSession();
		assertNotNull(email.getMailSession());
	}
	
	//test getSentDate() without setting date
	@Test
	public void testGetSentDate() throws Exception{
		email.getSentDate();
		assertNotNull(email.sentDate);
	}
	
	//test getSentDate() after setting the sent date
	@Test
	public void testGetSentDate2() throws Exception{
		email.setSentDate(new Date());
		email.getSentDate();
		assertNotNull(email.sentDate);
	}
	
	//test getSocetConnectionTimeout()
	@Test
	public void testGetSocetConnectionTimeout() throws Exception{
		email.getSocketConnectionTimeout();
		assertNotNull(email.socketConnectionTimeout);
	}
	
	//test setFrom with test email
	@Test
	public void testSetFrom() throws Exception{
		email.setFrom(TEST_EMAIL);
		assertNotNull(email.fromAddress);
	}
}
