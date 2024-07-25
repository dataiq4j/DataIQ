package io.dataiq.web.controller.chat;


import io.dataiq.data.common.web.response.Response;
import io.dataiq.web.controller.chat.request.ChatCompletionRequest;
import io.dataiq.web.controller.response.chat.ChatCompletionResponse;
import io.dataiq.web.service.ChatApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

/**
 * 无历史对话
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月19日 17:24
 */
@RequestMapping("/api/v1/chat")
public class ChatCompletionController {


    @Autowired
    private ChatApplicationService chatApplicationService;


    @PostMapping("/completion")
    public Response<ChatCompletionResponse> chatCompletion(ChatCompletionRequest request) {
        return chatApplicationService.chatCompletion(request);
    }


    /**
     * 流式对话
     *
     * @param request
     * @return
     */
    @PostMapping("/completion/stream")
    public Flux<ServerSentEvent<String>> chatCompletionStream(ChatCompletionRequest request) {
        return chatApplicationService.chatCompletionStream(request);
    }
}
