package org.springframework.social.stackoverflow.api.impl;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.stackoverflow.api.StackOverflow;
import org.springframework.social.stackoverflow.api.UserOperations;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestOperations;

public class StackOverflowTemplate extends AbstractOAuth2ApiBinding implements StackOverflow {

	private UserOperations userOperations;

	/**
	 * Constructs a StackOverflowTemplate using an accessToken (SO uses OAuth2)
	 * 
	 * @param accessToken
	 *            - token provided on authorisation
	 */
	public StackOverflowTemplate(String accessToken) {
		super(accessToken);
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
	}

	public UserOperations userOperations() {
		return userOperations;
	}

	public RestOperations restOperations() {
		return getRestTemplate();
	}

}
