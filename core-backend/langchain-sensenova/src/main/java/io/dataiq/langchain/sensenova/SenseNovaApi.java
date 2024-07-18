package io.dataiq.langchain.sensenova;

import io.dataiq.langchain.sensenova.entities.ChatCompletionRequest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

/**
 * [简要描述类用途]
 * <p>
 * [详细描述类用途、功能等，可选]
 * <p>
 * [额外的细节描述，比如类的组成、原理等，可选]
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月12日 11:26
 */
public interface SenseNovaApi {

    @Streaming
    @POST("api/paas/v4/chat/completions")
    @Headers({"Content-Type: application/json"})
    Call<ResponseBody> streamingChatCompletion(@Body ChatCompletionRequest request);

}
