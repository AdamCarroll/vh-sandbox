/*
 * Open Source Software published under the Apache Licence, Version 2.0.
 */

package io.github.vocabhunter.gui.common;

import java.util.Collections;
import java.util.Set;

public final class GuiConstants {
    public static final String UNTITLED = "Untitled";

    public static final String WEBSITE = "https://vocabhunter.github.io/";

    public static final String WEBPAGE_HELP = WEBSITE + "help/";

    public static final String WEBPAGE_ISSUE = WEBSITE + "issues/";

    public static final String TWITTER = "https://twitter.com/vocabhunterapp";

    public static final Set<Integer> DEFAULT_COLUMNS = Collections.singleton(0);

    private GuiConstants() {
        // Prevent instantiation - only constants are defined.
    }
}
