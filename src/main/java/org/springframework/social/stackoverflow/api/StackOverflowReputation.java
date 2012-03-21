package org.springframework.social.stackoverflow.api;

/**
 * A users reputation on StackOverflow
 * 
 * @author robert.hinds
 * 
 */
public class StackOverflowReputation {

	public StackOverflowReputation(Integer reputationScore, Integer reputationChangeDay, Integer reputationChangeWeek, Integer reputationChangeMonth,
			Integer reputationChangeQuarter, Integer reputationChangeYear) {
		this.reputationScore = reputationScore;
		this.reputationChangeDay = reputationChangeDay;
		this.reputationChangeWeek = reputationChangeWeek;
		this.reputationChangeMonth = reputationChangeMonth;
		this.reputationChangeQuarter = reputationChangeQuarter;
		this.reputationChangeYear = reputationChangeYear;
	}

	private Integer reputationScore;
	private Integer reputationChangeDay;
	private Integer reputationChangeWeek;
	private Integer reputationChangeMonth;
	private Integer reputationChangeQuarter;
	private Integer reputationChangeYear;

	public Integer getReputationScore() {
		return reputationScore;
	}

	public void setReputationScore(Integer reputationScore) {
		this.reputationScore = reputationScore;
	}

	public Integer getReputationChangeDay() {
		return reputationChangeDay;
	}

	public void setReputationChangeDay(Integer reputationChangeDay) {
		this.reputationChangeDay = reputationChangeDay;
	}

	public Integer getReputationChangeWeek() {
		return reputationChangeWeek;
	}

	public void setReputationChangeWeek(Integer reputationChangeWeek) {
		this.reputationChangeWeek = reputationChangeWeek;
	}

	public Integer getReputationChangeMonth() {
		return reputationChangeMonth;
	}

	public void setReputationChangeMonth(Integer reputationChangeMonth) {
		this.reputationChangeMonth = reputationChangeMonth;
	}

	public Integer getReputationChangeQuarter() {
		return reputationChangeQuarter;
	}

	public void setReputationChangeQuarter(Integer reputationChangeQuarter) {
		this.reputationChangeQuarter = reputationChangeQuarter;
	}

	public Integer getReputationChangeYear() {
		return reputationChangeYear;
	}

	public void setReputationChangeYear(Integer reputationChangeYear) {
		this.reputationChangeYear = reputationChangeYear;
	}

}
