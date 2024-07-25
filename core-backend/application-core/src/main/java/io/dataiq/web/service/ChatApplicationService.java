package io.dataiq.web.service;


import io.dataiq.data.common.web.response.Response;
import io.dataiq.web.controller.chat.request.ChatCompletionRequest;
import io.dataiq.web.controller.response.chat.ChatCompletionResponse;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

/**
 * [简要描述类用途]
 * <p>
 * [详细描述类用途、功能等，可选]
 * <p>
 * [额外的细节描述，比如类的组成、原理等，可选]
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月19日 17:27
 */
public interface ChatApplicationService {
    Response<ChatCompletionResponse> chatCompletion(ChatCompletionRequest request);



    Flux<ServerSentEvent<String>> chatCompletionStream(ChatCompletionRequest request);
}
