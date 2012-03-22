package org.springframework.social.stackoverflow.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * Based on {@link AbstractTwitterOperations}
 * 
 * @author robert.hinds
 * 
 */
public class AbstractStackOverflowOperations {

	private final boolean isAuthorized;

	public AbstractStackOverflowOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException();
		}
	}

	protected String buildUri(String path) {
		// return
		// "https://api.stackexchange.com/2.0/users/258813?site=stackoverflow";
		return API_URL_BASE + path + API_SO_FILTER;
	}

	private static final String API_URL_BASE = "https://api.stackexchange.com/2.0/";
	private static final String API_SO_FILTER = "?site=stackoverflow";
}