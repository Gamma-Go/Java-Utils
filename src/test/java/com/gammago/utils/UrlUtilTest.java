package com.gammago.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UrlUtilTest {

    @Test
    public void testMatchesRoute() {
        assertTrue(UrlUtil.matchesRoute("http://testRoute.com/a"));
        assertTrue(UrlUtil.matchesRoute("ftp://www.baidu.com"));
        assertFalse(UrlUtil.matchesRoute("http://127.0.01"));
    }

    @Test
    public void testMatchesPath() {
        assertTrue(UrlUtil.matchesPath("/testPath"));
        assertFalse(UrlUtil.matchesPath("20.3f495i23ig."));
    }
}