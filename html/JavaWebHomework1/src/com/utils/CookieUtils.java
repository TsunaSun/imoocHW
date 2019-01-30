package com.utils;

import javax.servlet.http.Cookie;

/*
 * Cookie查找类
 * 
 */
public class CookieUtils {
	public static Cookie findCookie(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
			return null;
		}

	}
}
