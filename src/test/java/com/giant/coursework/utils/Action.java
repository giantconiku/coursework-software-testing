package com.giant.coursework.utils;

import com.giant.coursework.enums.BrowserType;
import org.openqa.selenium.interactions.Actions;

public class Action {

    private static final BrowserType DEFAULT_BROWSER_TYPE = BrowserType.EDGE;

    private static Actions action;

    public static Actions getAction() {

        if (action == null) {
            action = initAction(DEFAULT_BROWSER_TYPE);
        }
        return action;
    }

    public static Actions getAction(BrowserType browserType) {

        if (action == null || browserType != DEFAULT_BROWSER_TYPE) {
            action = initAction(browserType);
        }
        return action;
    }

    private static Actions initAction(BrowserType browserType) {

        return switch (browserType) {
            case CHROME -> new Actions(Driver.getDriver(BrowserType.CHROME));
            case FIREFOX -> new Actions(Driver.getDriver(BrowserType.FIREFOX));
            default -> new Actions(Driver.getDriver());
        };
    }
}
