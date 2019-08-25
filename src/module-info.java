module com.codingotaku.jEdenManga {
	exports com.codingotaku.api.jmanga.manga;
	exports com.codingotaku.api.jmanga.args;
	exports com.codingotaku.api.jmanga;
	exports com.codingotaku.api.jmanga.exception;
	exports com.codingotaku.api.jmanga.request;

	requires gson;
	requires junit;
	requires org.apache.httpcomponents.httpclient;
	requires org.apache.httpcomponents.httpcore;
	requires org.hamcrest.core;
	requires org.junit.jupiter.api;
}