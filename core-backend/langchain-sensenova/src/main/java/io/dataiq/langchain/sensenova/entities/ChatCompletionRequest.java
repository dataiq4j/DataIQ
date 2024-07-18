package io.dataiq.langchain.sensenova.entities;

import io.dataiq.langchain.sensenova.entities.chat.Message;
import lombok.Data;

import javax.tools.Tool;
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
 * @date 2024年07月12日 11:32
 */
@Data
public class ChatCompletionRequest {
    private String model;
    private List<Message> messages;
    private String requestId;
    private String doSample;
    private Boolean stream;
    private Double temperature;
    private Double topP;
    private Integer maxTokens;
    private List<String> stop;
    private List<Tool> tools;
    private Object toolChoice;
}
