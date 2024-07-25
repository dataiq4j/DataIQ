package io.dataiq.langchain.sensenova;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.dataiq.AbstractAiClient;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static retrofit2.converter.jackson.JacksonConverterFactory.create;

/**
 * [简要描述类用途]
 * <p>
 * [详细描述类用途、功能等，可选]
 * <p>
 * [额外的细节描述，比如类的组成、原理等，可选]
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月19日 11:44
 */
public class SenseNovaAiClient extends AbstractAiClient {
    private final String baseUrl;
    private final SenseNovaApi senseNovaApi;
    private final OkHttpClient okHttpClient;
    private final Boolean logResponses;


    public static Builder builder() {
        return new Builder();
    }


    public SenseNovaAiClient(Builder builder) {
        this.baseUrl = builder.baseUrl;
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .callTimeout(builder.callTimeout)
                .connectTimeout(builder.connectTimeout)
                .readTimeout(builder.readTimeout)
                .writeTimeout(builder.writeTimeout)
                .addInterceptor(new AuthorizationInterceptor(builder.apiKey));

        if (builder.logRequests) {
            okHttpClientBuilder.addInterceptor(new RequestLoggingInterceptor());
        }

        this.logResponses = builder.logResponses;
        if (builder.logResponses) {
            okHttpClientBuilder.addInterceptor(new ResponseLoggingInterceptor());
        }

        this.okHttpClient = okHttpClientBuilder.build();
        Retrofit retrofit = (new Retrofit.Builder())
                .baseUrl(formattedUrlForRetrofit(this.baseUrl))
                .client(this.okHttpClient)
                .addConverterFactory(create(OBJECT_MAPPER))
                .build();
        this.senseNovaApi = retrofit.create(senseNovaApi.class);
    }


    public SenseNovaAiClient build() {
        return new SenseNovaAiClient(this);
    }

    public static class Builder {
        private String baseUrl;
        private String ak;
        private String sk;
        private Integer expiredAtRelatively;
        private Integer notBeforeAtRelatively;
        private Duration callTimeout;
        private Duration connectTimeout;
        private Duration readTimeout;
        private Duration writeTimeout;

        private Builder() {
            this.baseUrl = "https://open.bigmodel.cn/";
            this.callTimeout = Duration.ofSeconds(60L);
            this.connectTimeout = Duration.ofSeconds(60L);
            this.readTimeout = Duration.ofSeconds(60L);
            this.writeTimeout = Duration.ofSeconds(60L);
        }


        public Builder baseUrl(String baseUrl) {
            if (baseUrl != null && !baseUrl.trim().isEmpty()) {
                this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
                return this;
            } else {
                throw new IllegalArgumentException("baseUrl cannot be null or empty");
            }
        }

        public Builder ak(String ak) {
            if (ak != null && !ak.trim().isEmpty()) {
                this.ak = ak;
                return this;
            } else {
                throw new IllegalArgumentException("apiKey cannot be null or empty. ");
            }
        }

        public Builder sk(String sk) {
            if (sk != null && !sk.trim().isEmpty()) {
                this.sk = sk;
                return this;
            } else {
                throw new IllegalArgumentException("apiKey cannot be null or empty. ");
            }
        }

        public Builder callTimeout(Duration callTimeout) {
            if (callTimeout == null) {
                throw new IllegalArgumentException("callTimeout cannot be null");
            } else {
                this.callTimeout = callTimeout;
                return this;
            }
        }

        public Builder connectTimeout(Duration connectTimeout) {
            if (connectTimeout == null) {
                throw new IllegalArgumentException("connectTimeout cannot be null");
            } else {
                this.connectTimeout = connectTimeout;
                return this;
            }
        }

        public Builder readTimeout(Duration readTimeout) {
            if (readTimeout == null) {
                throw new IllegalArgumentException("readTimeout cannot be null");
            } else {
                this.readTimeout = readTimeout;
                return this;
            }
        }

        public Builder writeTimeout(Duration writeTimeout) {
            if (writeTimeout == null) {
                throw new IllegalArgumentException("writeTimeout cannot be null");
            } else {
                this.writeTimeout = writeTimeout;
                return this;
            }
        }

    }


    static String sign(String ak, String sk, Integer expiredAtRelatively, Integer
            notBeforeAtRelatively) {
        try {
            Date expiredAt = new Date(System.currentTimeMillis() + expiredAtRelatively);
            Date notBefore = new Date(System.currentTimeMillis() - notBeforeAtRelatively);
            Algorithm algo = Algorithm.HMAC256(sk);
            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            return JWT.create()
                    .withIssuer(ak)
                    .withHeader(header)
                    .withExpiresAt(expiredAt)
                    .withNotBefore(notBefore)
                    .sign(algo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
