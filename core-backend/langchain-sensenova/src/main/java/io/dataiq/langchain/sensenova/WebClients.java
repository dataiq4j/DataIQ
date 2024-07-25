package io.dataiq.langchain.sensenova;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 * @author luoshi@sensetime.com
 * @Description: WebClients
 * @date 2023-12-27 11:16
 */
public class WebClients {
    /**
     *
     * @param baseUrl
     * @return
     */
    public static WebClient newClient(String baseUrl) {
        HttpClient httpClient = HttpClient.newConnection().wiretap(true);
        return WebClient.builder().baseUrl(baseUrl).clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }
}
