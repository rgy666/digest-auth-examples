package com.marklogic.support.notworking;

import com.marklogic.support.Configuration;
import io.airlift.http.client.HttpClient;
import io.airlift.http.client.HttpClientConfig;
import io.airlift.http.client.StatusResponseHandler;
import io.airlift.http.client.jetty.JettyHttpClient;
import io.airlift.units.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static io.airlift.http.client.Request.Builder.prepareGet;
import static io.airlift.http.client.StatusResponseHandler.createStatusResponseHandler;

public class AirliftHttpClientAuthenticationExample {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) throws Exception {

        HttpClient client = new JettyHttpClient(new HttpClientConfig().setConnectTimeout(new Duration(2.0, TimeUnit.SECONDS)));

        StatusResponseHandler.StatusResponse response = client.execute(prepareGet().setUri(new URI(Configuration.URI).resolve("/")).build(), createStatusResponseHandler());

        if (response != null) {
            LOG.info("Response Status: " + response.getStatusCode());
        }
    }
}