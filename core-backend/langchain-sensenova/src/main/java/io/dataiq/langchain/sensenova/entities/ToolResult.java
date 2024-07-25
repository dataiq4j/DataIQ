package io.dataiq.langchain.sensenova.entities;

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
 * @date 2024年07月18日 15:36
 */
public class ToolResult {
    private WebSearch webSearch;


    public static class WebSearch {

        private Integer onlineSearchCount;


        private List<Result> results;


        public static class Result {
            private Integer index;
            private String url;
            private String urlSource;
            private String title;
            private String icon;
        }
    }
}
