/**
 * 
 */
package com.acmeamalgamatedwidgets.hlwx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/** 
 * Class to access an RSS Feed
 * 
 * @author	ljheidel
 * @param 	aFeedURL		The URL of the RSS feed to be ingested
 *
 */
@SuppressWarnings("unused")
public class GetRSS {

	private String iFeedURL;
	private SyndFeed iSyndFeed;

	public GetRSS(String aFeedURL){
		setFeedURL(aFeedURL);
		System.out.println("GetRSS");
	}

	/** 
	 * Get the feed at the determined URL, set the iSyndFeed ivar and return the ivar
	 * 
	 * @return 				A SynFeed object containing the return data from the RSS feed.
	 * @throws 				Exception
	 */
	public void doFeed() throws Exception {
		XmlReader xmlReader = null;
		try {
			URL url = new URL(getFeedURL());
			xmlReader = new XmlReader(url);
			SyndFeed feeder = new SyndFeedInput().build(xmlReader);
			setSyndFeed(feeder);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (xmlReader != null)
				xmlReader.close();
		}
	}

	/** 
	 * Get the contents of the feed when last polled.
	 * 
	 * @return 				A SynFeed object containing the return data from the RSS feed.
	 */
	public SyndFeed getSyndFeed() {
		return iSyndFeed;
	}

	/** Set the ivar for the SyndFeed
	 * 
	 * @param	aSyndFeed	A SyndFeed object.
	 */
	public void setSyndFeed(SyndFeed aSyndFeed) {
		this.iSyndFeed = aSyndFeed;
	}

	/** 
	 * Set the URL of the feed.
	 * 
	 * 
	 * @return				The URL of the feed.
	 */
	public String getFeedURL(){
		return iFeedURL;
	}

	/** 
	 * Get the URL of the feed.
	 * 
	 * @param aFeedURL		The URL of the feed.
	 */
	public void setFeedURL(String aFeedURL){
		this.iFeedURL = aFeedURL;
	}
	
	/** 
	 * Standard toString method.
	 * 
	 * @return 				The object as a String.
	 */
	@Override
	public String toString() {
		return "GetRSS [iFeedURL=" + iFeedURL + ", iSyndFeed=" + iSyndFeed
				+ "]";
	}
}
