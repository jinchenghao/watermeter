package edu.nuaa.watermeter.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class RequestUtils {
	/**
     * �����ַ���,ɾ������β�ո�,����������򷵻�null
     * 
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (StringUtils.isEmpty(value)) {
            return StringUtils.trimWhitespace(value);
        }
        return value;
    }
}
