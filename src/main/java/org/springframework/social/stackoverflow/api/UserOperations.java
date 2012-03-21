package org.springframework.social.stackoverflow.api;

public interface UserOperations {

	/**
	 * Get the user profile details for the current user (the authenticated
	 * user)
	 * 
	 * @return the users profile data
	 */
	StackOverflowUser getUser();
}
