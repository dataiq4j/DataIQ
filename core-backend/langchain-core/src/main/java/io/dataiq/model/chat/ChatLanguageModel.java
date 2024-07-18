package io.dataiq.model.chat;

import io.dataiq.entities.chat.message.AiAssistantMessage;
import io.dataiq.entities.chat.message.ChatMessage;
import io.dataiq.entities.output.Response;

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
 * @date 2024年07月11日 18:17
 */
public interface ChatLanguageModel {
    Response<AiAssistantMessage> generate(List<ChatMessage> messages);
}
