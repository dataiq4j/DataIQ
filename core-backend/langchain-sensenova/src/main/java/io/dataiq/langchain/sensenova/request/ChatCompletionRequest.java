package io.dataiq.langchain.sensenova.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.dataiq.langchain.sensenova.entities.KnowledgeConfig;
import io.dataiq.langchain.sensenova.entities.Message;
import lombok.Data;

import javax.tools.Tool;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

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
@JsonInclude(NON_NULL)
@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatCompletionRequest {
    private String model;
    private Integer n;
    private String[] knowIds;
    private Integer maxNewTokens;
    private List<Message> messages;
    private Float repetitionPenalty;
    private Boolean stream;
    private Float temperature;
    private Double topP;
    private String user;
    private List<KnowledgeConfig> knowledgeConfig;
    private Tool plugins;
}
