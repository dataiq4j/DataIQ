package io.dataiq.internal.utils;

import static io.dataiq.internal.utils.Exceptions.illegalArgument;

/**
 * [简要描述类用途]
 * <p>
 * [详细描述类用途、功能等，可选]
 * <p>
 * [额外的细节描述，比如类的组成、原理等，可选]
 *
 * @author xienng
 * @version 1.0
 * @date 2024年07月12日 10:46
 */
public class ValidationUtils {

    public static <T> T ensureNotNull(T object, String format, Object... args) {
        if (object == null) {
            throw illegalArgument(format, args);
        }
        return object;
    }
}
