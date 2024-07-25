package io.dataiq.data.common.web.response;

import lombok.Data;

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
 * @date 2024年07月19日 18:10
 */
@Data
public class Error {
    private Integer code;
    private String message;
    private List<String> details;
}
