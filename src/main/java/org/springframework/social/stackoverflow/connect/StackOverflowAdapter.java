package org.springframework.social.stackoverflow.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.stackoverflow.api.StackOverflow;
import org.springframework.social.stackoverflow.api.StackOverflowUser;

/**
 * StackOverflow API Adapter implementation
 * 
 * @author robert.hinds
 * 
 */
public class StackOverflowAdapter implements ApiAdapter<StackOverflow> {

	public boolean test(StackOverflow stackoverflow) {
		try {
			stackoverflow.userOperations().getUser();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(StackOverflow stackoverflow, ConnectionValues values) {
		// StackOverflowUser user = stackoverflow.userOperations().getUser();
		// values.setProviderUserId(Long.toString(user.getUserId()));
		// values.setDisplayName(user.getDisplayName());
		// values.setProfileUrl(user.getProfileUrl());
		// values.setImageUrl(user.getProfileImageUrl());
	}

	public UserProfile fetchUserProfile(StackOverflow stackoverflow) {
		StackOverflowUser user = stackoverflow.userOperations().getUser();
		return new UserProfileBuilder().setName(user.getDisplayName()).setUsername(user.getDisplayName()).build();
	}

	public void updateStatus(StackOverflow api, String message) {
		// not supported
	}

}
