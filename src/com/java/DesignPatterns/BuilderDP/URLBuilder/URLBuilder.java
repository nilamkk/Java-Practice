package com.java.DesignPatterns.BuilderDP.URLBuilder;

public class URLBuilder {
	
	public static class Builder{
		
		private String protocol;
		private String hostname;
		private String port;
		private String pathParam;
		private String queryParam;
		
		public Builder protocol(String pProtocol) {
			this.protocol = pProtocol;
			return this;
		}
		
		public Builder hostname(String pHostname) {
			this.hostname = pHostname;
			return this;
		}
		
		public Builder port(String pPort) {
			this.port = pPort;
			return this;
		}
		
		public Builder pathParam(String pPathParam) {
			this.pathParam = pPathParam;
			return this;
		}
		
		public Builder queryParam(String pQueryParam) {
			this.queryParam = pQueryParam;
			return this;
		}
		
		public URLBuilder build() {
			return new URLBuilder(this);
		}
		
	}
	
	private final String protocol;
	private final String hostname;
	private final String port;
	private final String pathParam;
	private final String queryParam;

	private URLBuilder(Builder builder) {
		this.protocol = builder.protocol;
		this.hostname = builder.hostname;
		this.port = builder.port != null ? builder.port : "" ;
		this.pathParam = builder.pathParam != null ? builder.pathParam : "" ;
		this.queryParam = builder.queryParam != null ? builder.queryParam : "" ;
	}
	
	public String getURL() {
		return new StringBuilder()
				.append(this.protocol)
				.append(this.hostname)
				.append(this.port)
				.append(this.pathParam)
				.append(this.queryParam)
				.toString();
	}
	
}
