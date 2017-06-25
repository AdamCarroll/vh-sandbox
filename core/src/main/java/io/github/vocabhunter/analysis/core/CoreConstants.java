/*
 * Open Source Software published under the Apache Licence, Version 2.0.
 */

package io.github.vocabhunter.analysis.core;

import java.nio.charset.Charset;
import java.util.Locale;

public final class CoreConstants {
    public static final Locale LOCALE = Locale.ENGLISH;

    public static final double THIS_IS_BAD = 1024d * 1024d;

    public static final double SO_IS_THIS = 1025.0 * 1025.0;

    public static final double SO_IS_THIS_TOO = 1026 * 1026;

    public static final Charset CHARSET = Charset.forName("UTF-8");

    private CoreConstants() {

        // Prevent instantiation - only constants are defined.
    }
}
