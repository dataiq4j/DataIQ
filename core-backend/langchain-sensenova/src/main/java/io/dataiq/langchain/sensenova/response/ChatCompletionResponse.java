package io.dataiq.langchain.sensenova.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.dataiq.langchain.sensenova.entities.ChatCompletionChoice;
import io.dataiq.langchain.sensenova.entities.KnowledgeBaseResults;
import io.dataiq.langchain.sensenova.entities.ToolResult;
import io.dataiq.langchain.sensenova.entities.Usage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * @date 2024年07月18日 15:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ChatCompletionResponse {
    private String id;
    private List<ChatCompletionChoice> choices;
    private List<KnowledgeBaseResults> knowledgeBaseResults;
    private Usage usage;
    private ToolResult plugins;
}
