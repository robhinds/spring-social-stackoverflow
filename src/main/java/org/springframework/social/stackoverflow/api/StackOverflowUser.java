/**
 * 
 */
package org.springframework.social.stackoverflow.api;

import java.util.Date;

/**
 * A StackOverflow user
 * 
 * @author robert.hinds
 * 
 */
public class StackOverflowUser {

	public StackOverflowUser(Long userId, Date accountCreationDate, String displayName, String profileImageUrl, StackOverflowReputation reputation,
			Date lastAccessedDate, Date lastModifiedDate, String profileUrl, String websiteUrl, Long accountId, Integer goldBadgeCount,
			Integer silverBadgeCount, Integer bronzeBadgeCount, Integer acceptRate) {
		this.userId = userId;
		this.accountCreationDate = accountCreationDate;
		this.displayName = displayName;
		this.profileImageUrl = profileImageUrl;
		this.reputation = reputation;
		this.lastAccessedDate = lastAccessedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.profileUrl = profileUrl;
		this.websiteUrl = websiteUrl;
		this.accountId = accountId;
		this.goldBadgeCount = goldBadgeCount;
		this.silverBadgeCount = silverBadgeCount;
		this.bronzeBadgeCount = bronzeBadgeCount;
		this.acceptRate = acceptRate;
	}

	private Long userId;
	private Date accountCreationDate;
	private String displayName;
	private String profileImageUrl;
	private StackOverflowReputation reputation;
	private Date lastAccessedDate;
	private Date lastModifiedDate;
	private String profileUrl;
	private String websiteUrl;
	private Long accountId;
	private Integer goldBadgeCount;
	private Integer silverBadgeCount;
	private Integer bronzeBadgeCount;
	private Integer acceptRate;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public StackOverflowReputation getReputation() {
		return reputation;
	}

	public void setReputation(StackOverflowReputation reputation) {
		this.reputation = reputation;
	}

	public Date getLastAccessedDate() {
		return lastAccessedDate;
	}

	public void setLastAccessedDate(Date lastAccessedDate) {
		this.lastAccessedDate = lastAccessedDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getGoldBadgeCount() {
		return goldBadgeCount;
	}

	public void setGoldBadgeCount(Integer goldBadgeCount) {
		this.goldBadgeCount = goldBadgeCount;
	}

	public Integer getSilverBadgeCount() {
		return silverBadgeCount;
	}

	public void setSilverBadgeCount(Integer silverBadgeCount) {
		this.silverBadgeCount = silverBadgeCount;
	}

	public Integer getBronzeBadgeCount() {
		return bronzeBadgeCount;
	}

	public void setBronzeBadgeCount(Integer bronzeBadgeCount) {
		this.bronzeBadgeCount = bronzeBadgeCount;
	}

	public Integer getAcceptRate() {
		return acceptRate;
	}

	public void setAcceptRate(Integer acceptRate) {
		this.acceptRate = acceptRate;
	}

}
