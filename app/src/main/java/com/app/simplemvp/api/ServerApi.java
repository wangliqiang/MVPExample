package com.app.simplemvp.api;

/**
 * Created by 王立强 on 2016/10/9.
 */

public class ServerApi {

    public static String BASEURL = "https://api.douban.com/v2/movie/";

    //豆瓣电影top250
    public static String TOP250 = BASEURL + "top250";
    //豆瓣电影详情
    public static String MOVIEDETAIL = BASEURL + "subject/";
}
