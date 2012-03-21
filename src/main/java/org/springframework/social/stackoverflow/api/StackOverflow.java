package org.springframework.social.stackoverflow.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 * Specifies core operations available on StackOverflow. Currently a limited
 * subset to just {@link StackOverflowUser} operations, but should be extended
 * to handle Questions,Answers,Badges etc as per the full SO API
 * 
 * @author robert.hinds
 * 
 */
public interface StackOverflow extends ApiBinding {

	/**
	 * Used to expose the StackOverflow API relating to Users.
	 * 
	 * @return user operations
	 */
	UserOperations userOperations();

	/**
	 * Returns the underlying {@link RestOperations} to be used for any aspects
	 * of the SO API that are not yet supported by this binding
	 */
	RestOperations restOperations();
}
