package edu.nuaa.watermeter.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtils {
	/**
     * ����json��ʽ���ݵ�ҳ��
     * 
     * @param response
     * @param content
     */
    public static void send(HttpServletResponse response, String content) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            //����������Ϊnull ��Ĭ��Ϊ""
            if(content == null){
                content = "";
            }
            out.write(content);
        }
        catch (IOException e) {
            //log.error(e.getLocalizedMessage(), e);
        }
        finally {
            if (out != null){
                out.close();
            }
        }
    }

}
