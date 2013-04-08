package com.acmeamalgamatedwidgets.hlwx;

import javax.persistence.*;
/**
 * POJO for Hibernate Mapping to RSSFeed Table
 * @author ljheidel
 *
 */
@Entity
@Table(name = "RSSFeed")
public class RSSFeed {
	@Id
	@GeneratedValue
	@Column(name = "idRSSFeed")
	private int idRSSFeed;

	@Column(name = "RSSFeedName")
	private String RSSFeedName;

	@Column(name = "RSSFeedURL")
	private String RSSFeedURL;

	@Column(name = "RSSFeedInterval")
	private int RSSFeedInterval;

	public RSSFeed() {
	}

	public RSSFeed(int idRSSFeed, String RSSFeedName, String RSSFeedURL, int RSSFeedInterval) {
		this.idRSSFeed = idRSSFeed;
		this.RSSFeedName = RSSFeedName;
		this.RSSFeedURL = RSSFeedURL;
		this.RSSFeedInterval = RSSFeedInterval;
	}

	public int getIdRSSFeed() {
		return idRSSFeed;
	}

	public void setIdRSSFeed(int idRSSFeed) {
		this.idRSSFeed = idRSSFeed;
	}

	public String getRSSFeedName() {
		return RSSFeedName;
	}

	public void setRSSFeedName(String rSSFeedName) {
		RSSFeedName = rSSFeedName;
	}

	public String getRSSFeedURL() {
		return RSSFeedURL;
	}

	public void setRSSFeedURL(String rSSFeedURL) {
		RSSFeedURL = rSSFeedURL;
	}

	public int getRSSFeedInterval() {
		return RSSFeedInterval;
	}

	public void setRSSFeedInterval(int rSSFeedInterval) {
		RSSFeedInterval = rSSFeedInterval;
	}
}