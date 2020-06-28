package com.gammago.utils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * project: Java-Utils
 * @author: GammaGo
 * date: 2020/6/28
 * desc: URL工具类
 */
public class UrlUtil {

    /**
     * 路由校验表达式
     */
    private static final String ROUTES_EXPRESSION;

    /**
     * 路径校验表达式
     */
    private static final String PATH_EXPRESSION;

    static {
        /*
          (https或http或ftp):// 可有可无
          ftp的user@ 可有可无
          // IP形式的URL- 3位数字.3位数字.3位数字.3位数字
          / 允许IP和DOMAIN（域名）
          //匹配localhost
          // 域名- 至少一个[英文或数字_!~*\'()-]加上.
          // 一级域名 -英文或数字 加上.
          // 顶级域名- 1-6位英文
          // 端口- :80 ,1-5位数字
          // url无参数结尾 - 斜杆或这没有
          //请求参数结尾- 英文或数字和[]内的各种字符
         */
        ROUTES_EXPRESSION = "^((https|http|ftp)://)?"
                + "(([\\w_!~*\'()\\.&=+$%-]+: )?[\\w_!~*\'()\\.&=+$%-]+@)?"
                + "(([0-9]{1,3}\\.){3}[0-9]{1,3}"
                + "|"
                + "(localhost)|"
                + "([\\w_!~*\'()-]+\\.)*"
                + "\\w+\\."
                + "[a-zA-Z]{1,6})"
                + "(:[0-9]{1,5})?"
                + "((/?)|"
                + "(/[\\w_!~*\'()\\.;?:@&=+$,%#-]+)+/?)$";

        PATH_EXPRESSION = "^(\\/[a-zA-Z0-9-\\_\\:\\.\\!\\/\\{\\}}])*(\\/[a-zA-Z0-9-\\*\\_\\:\\.\\!\\/\\{\\}}]{0,249})$";
    }

    private static final Pattern PATH_PATTERN = Pattern.compile(PATH_EXPRESSION);

    private static final Pattern ROUTE_PATTERN = Pattern.compile(ROUTES_EXPRESSION);

    /**
     * 路由匹配
     *
     * @param route 待匹配路由
     * @return 结果
     * true: 匹配成功
     * false: 匹配失败
     */
    public static Boolean matchesRoute(String route) {
        if (Objects.isNull(route)) {
            return false;
        }
        return ROUTE_PATTERN.matcher(route).matches();
    }

    /**
     * 路径匹配
     *
     * @param path 待匹配路径
     * @return 结果
     * true: 匹配成功
     * false: 匹配失败
     */
    public static Boolean matchesPath(String path) {
        if (Objects.isNull(path)) {
            return false;
        }
        return PATH_PATTERN.matcher(path).matches();
    }
}
