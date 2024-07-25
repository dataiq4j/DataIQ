package io.dataiq.web.controller.chat;


import io.dataiq.web.controller.chat.request.ChatCompletionRequest;
import io.dataiq.data.common.web.response.Response;
import io.dataiq.web.controller.response.chat.ChatCompletionResponse;

/**
 * 带上下文的对话
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月19日 17:24
 */
public class ChatSessionController {


    public Response<ChatCompletionResponse> chatCompletion(ChatCompletionRequest request) {
        return null;
    }


    /**
     * 流式对话
     *
     * @param request
     * @return
     */
    public Response<ChatCompletionResponse> chatCompletionStream(ChatCompletionRequest request) {
        return null;
    }


}
