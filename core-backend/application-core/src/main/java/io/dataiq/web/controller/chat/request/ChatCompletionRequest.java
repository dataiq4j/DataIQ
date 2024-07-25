package io.dataiq.web.controller.chat.request;

import io.dataiq.entities.chat.enums.ChatMode;
import io.dataiq.entities.chat.message.ChatMessage;
import io.dataiq.web.controller.common.BaseRequest;

import java.util.List;

/**
 * [简要描述类用途]
 * <p>
 * [详细描述类用途、功能等，可选]
 * <p>
 * [额外的细节描述，比如类的组成、原理等，可选]
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月22日 11:01
 */
public class ChatCompletionRequest extends BaseRequest {

    private List<ChatMessage> messages;
}
