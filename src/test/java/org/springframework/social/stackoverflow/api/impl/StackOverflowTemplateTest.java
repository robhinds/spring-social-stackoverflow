package org.springframework.social.stackoverflow.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.RequestMatchers.method;
import static org.springframework.test.web.client.RequestMatchers.requestTo;
import static org.springframework.test.web.client.ResponseCreators.withResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.stackoverflow.api.StackOverflowUser;
import org.springframework.test.web.client.MockRestServiceServer;

public class StackOverflowTemplateTest {

	private StackOverflowTemplate stackoverflow;
	private MockRestServiceServer mockServer;
	private HttpHeaders responseHeaders;

	@Before
	public void setup() {
		stackoverflow = new StackOverflowTemplate("accessToken");
		mockServer = MockRestServiceServer.createServer(stackoverflow.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	}

	@Test
	public void getUser() {
		mockServer
				.expect(requestTo("https://api.stackexchange.com/2.0/me?site=stackoverflow"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(
								"{\"items\": [{\"user_id\": 258813,\"user_type\": \"registered\",\"creation_date\": 1264456091,\"display_name\": \"rhinds\","
										+ "\"profile_image\": \"http://www.gravatar.com/avatar/fddf529b3635cac589c2a302f8a1071f?d=identicon&r=PG\",\"reputation\": 965,"
										+ "\"reputation_change_day\": 0,\"reputation_change_week\": 0,\"reputation_change_month\": 25,\"reputation_change_quarter\": 75,"
										+ "\"reputation_change_year\": 75,\"last_access_date\": 1332341455,\"last_modified_date\": 1332302225,\"is_employee\": false,"
										+ "\"link\": \"http://stackoverflow.com/users/258813/rhinds\",\"website_url\": \"http://automateddeveloper.blogspot.com/\","
										+ "\"account_id\": 94899,\"badge_counts\": {\"gold\": 0,\"silver\": 6,\"bronze\": 12},\"accept_rate\": 87}],\"quota_remaining\": 9984,"
										+ "\"quota_max\": 10000,\"has_more\": false}", responseHeaders));

		StackOverflowUser profile = stackoverflow.userOperations().getUser();
		assertEquals("rhinds", profile.getDisplayName());
	}
}
