package org.springframework.social.stackoverflow.api.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.social.stackoverflow.api.StackOverflowReputation;
import org.springframework.social.stackoverflow.api.StackOverflowUser;
import org.springframework.social.stackoverflow.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractStackOverflowOperations implements UserOperations {

	private final RestTemplate restTemplate;

	private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.ENGLISH);

	public UserTemplate(RestTemplate restTemplate, boolean isAuthorised) {
		super(isAuthorised);
		this.restTemplate = restTemplate;
	}

	@SuppressWarnings("unchecked")
	public StackOverflowUser getUser() {
		Map<String, ?> jsonWrapper = restTemplate.getForObject(buildUri("me"), Map.class);
		List<?> userList = (List<?>) jsonWrapper.get("items");
		Map<String, ?> userJson = (Map<String, ?>) userList.get(0);

		Long userId = Long.valueOf(String.valueOf(userJson.get("user_id")));
		String displayName = String.valueOf(userJson.get("display_name"));
		String profileImageUrl = String.valueOf(userJson.get("profile_image"));
		String profileUrl = String.valueOf(userJson.get("link"));
		String websiteUrl = String.valueOf(userJson.get("website_url"));
		Long accountId = Long.valueOf(String.valueOf(userJson.get("account_id")));
		Integer acceptRate = Integer.valueOf(String.valueOf(userJson.get("accept_rate")));
		Date accountCreationDate = toDate(String.valueOf(userJson.get("creation_date")), dateFormat);
		Date lastAccessedDate = toDate(String.valueOf(userJson.get("last_access_date")), dateFormat);
		Date lastModifiedDate = toDate(String.valueOf(userJson.get("last_modified_date")), dateFormat);

		Integer reputationScore = Integer.valueOf(String.valueOf(userJson.get("reputation")));
		Integer reputationChangeDay = Integer.valueOf(String.valueOf(userJson.get("reputation_change_day")));
		Integer reputationChangeWeek = Integer.valueOf(String.valueOf(userJson.get("reputation_change_week")));
		Integer reputationChangeMonth = Integer.valueOf(String.valueOf(userJson.get("reputation_change_month")));
		Integer reputationChangeQuarter = Integer.valueOf(String.valueOf(userJson.get("reputation_change_quarter")));
		Integer reputationChangeYear = Integer.valueOf(String.valueOf(userJson.get("reputation_change_year")));

		Map<String, ?> badgeJson = (Map<String, ?>) userJson.get("badge_counts");
		Integer goldBadgeCount = Integer.valueOf(String.valueOf(badgeJson.get("gold")));
		Integer silverBadgeCount = Integer.valueOf(String.valueOf(badgeJson.get("silver")));
		Integer bronzeBadgeCount = Integer.valueOf(String.valueOf(badgeJson.get("bronze")));
		StackOverflowReputation reputation = new StackOverflowReputation(reputationScore, reputationChangeDay, reputationChangeWeek, reputationChangeMonth,
				reputationChangeQuarter, reputationChangeYear);

		StackOverflowUser user = new StackOverflowUser(userId, accountCreationDate, displayName, profileImageUrl, reputation, lastAccessedDate,
				lastModifiedDate, profileUrl, websiteUrl, accountId, goldBadgeCount, silverBadgeCount, bronzeBadgeCount, acceptRate);

		return user;
	}

	private Date toDate(String dateString, DateFormat dateFormat) {
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

}
