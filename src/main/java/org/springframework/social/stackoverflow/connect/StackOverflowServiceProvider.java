package org.springframework.social.stackoverflow.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.stackoverflow.api.StackOverflow;
import org.springframework.social.stackoverflow.api.impl.StackOverflowTemplate;

/**
 * StackOverflow Service Provider implementation (based on OAuth2)
 * 
 * @author robert.hinds
 * 
 */
public class StackOverflowServiceProvider extends AbstractOAuth2ServiceProvider<StackOverflow> {

	public StackOverflowServiceProvider(String clientId, String clientSecret) {
		super(new OAuth2Template(clientId, clientSecret, "https://github.com/login/oauth/authorize", "https://github.com/login/oauth/access_token"));
	}

	@Override
	public StackOverflow getApi(String accessToken) {
		return new StackOverflowTemplate(accessToken);
	}

}
