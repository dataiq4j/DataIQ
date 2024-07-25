package io.dataiq;

import okhttp3.OkHttpClient;


public abstract class AbstractAiClient {
    protected String baseUrl;
    protected OkHttpClient okHttpClient;
}
