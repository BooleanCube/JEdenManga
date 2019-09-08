module jeden_manga {
	exports com.codingotaku.api.jmanga.manga;
	exports com.codingotaku.api.jmanga.args;
	exports com.codingotaku.api.jmanga;
	exports com.codingotaku.api.jmanga.exception;
	exports com.codingotaku.api.jmanga.request;

	requires gson;
	requires org.apache.httpcomponents.httpclient;
	requires org.apache.httpcomponents.httpcore;
}