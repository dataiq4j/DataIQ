package io.dataiq.web.service.impl;

import io.dataiq.data.common.web.response.Response;
import io.dataiq.web.controller.chat.request.ChatCompletionRequest;
import io.dataiq.web.controller.response.chat.ChatCompletionResponse;
import io.dataiq.web.service.ChatApplicationService;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
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
 * @date 2024年07月22日 11:34
 */
@Service
public class ChatApplicationServiceImpl implements ChatApplicationService {






    @Override
    public Response<ChatCompletionResponse> chatCompletion(ChatCompletionRequest request) {
        return null;
    }

    @Override
    public Flux<ServerSentEvent<String>> chatCompletionStream(ChatCompletionRequest request) {


        return null;
    }
}
