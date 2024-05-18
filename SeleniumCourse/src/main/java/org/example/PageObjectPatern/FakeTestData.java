package org.example.PageObjectPatern;

public class FakeTestData {
    public static String getRandomEmailAddress() {
        return String.format("john-%d@gmail.com", System.currentTimeMillis());
    }
}
