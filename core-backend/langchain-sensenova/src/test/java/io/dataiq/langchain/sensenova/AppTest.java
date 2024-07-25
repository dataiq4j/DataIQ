package io.dataiq.langchain.sensenova;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest {


    public static void main(String[] args) {
            WebClient client = WebClients.newClient(eduManagementConfig.getBaseUrl());
            LlmRequest body = LlmBuilder.build(input, eduManagementConfig);

            ParameterizedTypeReference<ServerSentEvent<String>> type =
                    new ParameterizedTypeReference<ServerSentEvent<String>>() {};

            Flux<ServerSentEvent<String>> eventStream = client.post()
                    .uri(eduManagementConfig.getGenerateStreamPath())
                    .bodyValue(body)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .header()
                    .retrieve()
                    .bodyToFlux(type)
                    .timeout(Duration.ofMillis(eduManagementConfig.getStreamTimeOutInMilliSeconds()));
            return eventStream.map(stringServerSentEvent -> {
                ServerSentEvent<String> event = ServerSentEvent.<String>builder()
                        .event(EduConstants.CHAT_EVENT_TYPE)
                        .data(stringServerSentEvent.data()).build();
                return event;
            });
        }
    }

}
