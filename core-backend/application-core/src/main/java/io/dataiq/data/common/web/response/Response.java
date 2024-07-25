package io.dataiq.data.common.web.response;

import lombok.Data;

/**
 * [简要描述类用途]
 * <p>
 * [详细描述类用途、功能等，可选]
 * <p>
 * [额外的细节描述，比如类的组成、原理等，可选]
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月19日 14:32
 */
@Data
public class Response<T> {
    private T data;

    /**
     * 当出现错误时的返回
     */
    private Error  error;
}
