package com.giant.coursework.utils;

import org.openqa.selenium.interactions.Actions;

public class Action {

    private static Actions action;

    public static Actions getAction() {
        return new Actions(Driver.getDriver());
    }
}
