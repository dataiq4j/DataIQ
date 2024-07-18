package io.dataiq.entities.chat.message;

import io.dataiq.entities.chat.enums.ChatMessageRole;
import lombok.AllArgsConstructor;

import static io.dataiq.entities.chat.enums.ChatMessageRole.Assistant;

/**
 * [简要描述类用途]
 * <p>
 * [详细描述类用途、功能等，可选]
 * <p>
 * [额外的细节描述，比如类的组成、原理等，可选]
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月12日 10:33
 */
@AllArgsConstructor
public class AiAssistantMessage implements ChatMessage {


    private ChatText text;


    public AiAssistantMessage(String text) {


    }

    @Override
    public ChatMessageRole role() {
        return Assistant;
    }

    @Override
    public ChatText text() {
        return text;
    }
}
