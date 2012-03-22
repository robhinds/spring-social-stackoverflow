package org.springframework.social.stackoverflow.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.stackoverflow.api.StackOverflow;

/**
 * StackOverflow ConnectionFactory implementation
 * 
 * @author robert.hinds
 * 
 */
public class StackOverflowConnectionFactory extends OAuth2ConnectionFactory<StackOverflow> {

	public StackOverflowConnectionFactory(String clientId, String clientSecret) {
		super("stackoverflow", new StackOverflowServiceProvider(clientId, clientSecret), new StackOverflowAdapter());
	}

}