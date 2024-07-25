package io.dataiq.entities.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xienng
 * @version 1.0
 * @date 2024年07月19日 18:03
 */
@AllArgsConstructor
@Data
public class AiServiceException extends RuntimeException {
    private final Integer httpStatus;
    private final String message;
}
