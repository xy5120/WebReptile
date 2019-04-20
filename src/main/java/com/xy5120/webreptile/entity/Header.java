package com.xy5120.webreptile.entity;

public class Header {

	private String accept;
	private String acceptEncoding;
	private String acceptLanguage;
	private String cacheControl;
	private String cookie;
	private String referer;
	private String upgradeInsecureRequests;
	private String userAgent;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Header [accept=" + accept + ", acceptEncoding=" + acceptEncoding + ", acceptLanguage=" + acceptLanguage
				+ ", cacheControl=" + cacheControl + ", cookie=" + cookie + ", referer=" + referer
				+ ", upgradeInsecureRequests=" + upgradeInsecureRequests + ", userAgent=" + userAgent + "]";
	}
	public Header() {
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getAcceptEncoding() {
		return acceptEncoding;
	}
	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}
	public String getAcceptLanguage() {
		return acceptLanguage;
	}
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}
	public String getCacheControl() {
		return cacheControl;
	}
	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	public String getUpgradeInsecureRequests() {
		return upgradeInsecureRequests;
	}
	public void setUpgradeInsecureRequests(String upgradeInsecureRequests) {
		this.upgradeInsecureRequests = upgradeInsecureRequests;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
	
	
}
