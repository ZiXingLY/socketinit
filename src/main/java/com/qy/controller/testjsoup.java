package com.qy.controller;

import com.google.gson.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
* Created by zaq on 2018/05/17.
*/
@RestController
@RequestMapping("/jsoup")
public class testjsoup {

    @GetMapping("/test")
    public String parse(){

        String durl = "https://user.qzone.qq.com/1319589118/mood/fe54a74ebe3d075b240a0500.1";

        String url = "https://user.qzone.qq.com/proxy/domain/taotao.qq.com/cgi-bin/emotion_cgi_msglist_v6?uin=1319589118&ftype=0&sort=0&pos=0&num=50&replynum=100&g_tk=1743137732&callback=_preloadCallback&code_version=1&format=jsonp&need_private_comment=1&qzonetoken=f01a1417b130818c887e7e34b50fecaa97b9997faa9b8e23d0cc9e3218df7a9fe410460e845177623261&g_tk=1743137732";
        String cookie = "pgv_pvi=1292988416; RK=G+vzXQkvZ9; o_cookie=1319589118; _ga=GA1.2.1638338421.1506501429; pgv_pvid=1735309344; QZ_FE_WEBP_SUPPORT=1; ptcz=05726731cfdf176ab09d7f91832c4f87136798ca6b8805ac4caf7c3cf56c2b16; pt2gguin=o1319589118; ptui_loginuin=1319589118; __Q_w_s__QZN_TodoMsgCnt=1; tvfe_boss_uuid=d21c2d3c1e11956a; mobileUV=1_1635424395d_d654e; ptisp=cm; pgv_si=s9092982784; zzpaneluin=; zzpanelkey=; _qpsvr_localtk=0.04803201468608598; pgv_info=ssid=s5865224228; qqmusic_uin=; qqmusic_key=; qqmusic_fromtag=; __Q_w_s_hat_seed=1; rv2=8035B35754368704C3397A8AC43BF34AE5E852D70782236400; property20=886AAA9909562AF65FB5AE4A714236CDB589F87C837A4587A63B63A18BE5EF22C1251EC8470CBD96; cpu_performance_v8=2; uin=o1319589118; skey=@pAmr1KiSN; p_uin=o1319589118; pt4_token=W69Eb2pyxyxTpcY*hn5IsjMUhRExcWqt0ODlxatvvbs_; p_skey=3aOa1-ZqyrnGaUJSz-6iD5Lh1YRJ6nVhA58v9BWmAJw_; Loading=Yes; qzmusicplayer=qzone_player_1319589118_1528251380581";
        String substr = "";
        String result = "";
        String str = "";
        try{
            Document doc = Jsoup.connect(url).cookie("cookie",cookie).get();
//            Document doc = Jsoup.connect("https://user.qzone.qq.com/1319589118?_t_=0.3280103345246652").cookie("cookie","pgv_pvi=1292988416; RK=G+vzXQkvZ9; o_cookie=1319589118; _ga=GA1.2.1638338421.1506501429; pgv_pvid=1735309344; QZ_FE_WEBP_SUPPORT=1; ptcz=05726731cfdf176ab09d7f91832c4f87136798ca6b8805ac4caf7c3cf56c2b16; pt2gguin=o1319589118; qz_screen=1366x768; ptui_loginuin=1319589118; __Q_w_s__QZN_TodoMsgCnt=1; tvfe_boss_uuid=d21c2d3c1e11956a; mobileUV=1_1635424395d_d654e; ptisp=cm; pgv_si=s9092982784; zzpaneluin=; zzpanelkey=; _qz_referrer=i.qq.com; _qpsvr_localtk=0.04803201468608598; pgv_info=ssid=s5865224228; uin=o1319589118; skey=@trfQIhJO9; p_uin=o1319589118; pt4_token=E-pwMiQSXzh4cnhRPtOLLvQ9zx1pzxrGYmHZ4T0oVDw_; p_skey=iEY7J9paQm-MHVxVJuvEKmoEY9wc2rTncYrbgzGteAk_; qzone_check=1319589118_1528172849").get();
//            Elements contents = doc.getElementsByClass("show-content-free");
//            for (Element content : contents) {
//                Elements ps = content.getElementsByTag("p");
//                for(Element p :ps){
//                    String pt = p.text();
//
//                    result += pt;
//                }
//
//            }
//            String title = doc.title();
            str = doc.body().text();
            substr = str.substring(17,str.length()-2);
        }catch (IOException e){
            return e.toString();
        }

        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            JsonObject json=(JsonObject) parse.parse(substr);

            JsonArray array=json.get("msglist").getAsJsonArray();    //得到为json的数组
            for(int i=0;i<array.size();i++){
                String tid = array.get(i).getAsJsonObject().get("tid").getAsString();
                System.out.println(tid);
                try{
                    Thread.currentThread().sleep(5000);
                }catch (InterruptedException e){

                }

                try{
                    Document doc = Jsoup.connect("https://user.qzone.qq.com/1319589118/mood/"+tid+".1").cookie("cookie",cookie).get();
//            Document doc = Jsoup.connect("https://user.qzone.qq.com/1319589118?_t_=0.3280103345246652").cookie("cookie","pgv_pvi=1292988416; RK=G+vzXQkvZ9; o_cookie=1319589118; _ga=GA1.2.1638338421.1506501429; pgv_pvid=1735309344; QZ_FE_WEBP_SUPPORT=1; ptcz=05726731cfdf176ab09d7f91832c4f87136798ca6b8805ac4caf7c3cf56c2b16; pt2gguin=o1319589118; qz_screen=1366x768; ptui_loginuin=1319589118; __Q_w_s__QZN_TodoMsgCnt=1; tvfe_boss_uuid=d21c2d3c1e11956a; mobileUV=1_1635424395d_d654e; ptisp=cm; pgv_si=s9092982784; zzpaneluin=; zzpanelkey=; _qz_referrer=i.qq.com; _qpsvr_localtk=0.04803201468608598; pgv_info=ssid=s5865224228; uin=o1319589118; skey=@trfQIhJO9; p_uin=o1319589118; pt4_token=E-pwMiQSXzh4cnhRPtOLLvQ9zx1pzxrGYmHZ4T0oVDw_; p_skey=iEY7J9paQm-MHVxVJuvEKmoEY9wc2rTncYrbgzGteAk_; qzone_check=1319589118_1528172849").get();
//            Elements contents = doc.getElementsByClass("show-content-free");
//            for (Element content : contents) {
//                Elements ps = content.getElementsByTag("p");
//                for(Element p :ps){
//                    String pt = p.text();
//
//                    result += pt;
//                }
//
//            }
//            String title = doc.title();
                    result += doc.title();
//                    System.out.println(doc.body());
                    System.out.println(doc.getElementsByTag("pre").text());
                }catch (IOException e){
                    return e.toString();
                }
            }
//            JsonObject json=(JsonObject) parse.parse(new FileReader("weather.json"));  //创建jsonObject对象
//            System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //将json数据转为为int型的数据
//            System.out.println("reason:"+json.get("reason").getAsString());     //将json数据转为为String型的数据
//
//            JsonObject result=json.get("result").getAsJsonObject();
//            JsonObject today=result.get("today").getAsJsonObject();
//            System.out.println("temperature:"+today.get("temperature").getAsString());
//            System.out.println("weather:"+today.get("weather").getAsString());

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return result;
    }

    @GetMapping("/test1")
    public String test(){
        String url = "https://h5.qzone.qq.com/proxy/domain/taotao.qzone.qq.com/cgi-bin/emotion_cgi_ic_getcomments?qzonetoken=f01a1417b130818c887e7e34b50fecaa97b9997faa9b8e23d0cc9e3218df7a9fe410460e845177623261&g_tk=1743137732";
String cookie = "pgv_pvi=1292988416; RK=G+vzXQkvZ9; o_cookie=1319589118; _ga=GA1.2.1638338421.1506501429; pgv_pvid=1735309344; QZ_FE_WEBP_SUPPORT=1; ptcz=05726731cfdf176ab09d7f91832c4f87136798ca6b8805ac4caf7c3cf56c2b16; pt2gguin=o1319589118; ptui_loginuin=1319589118; __Q_w_s__QZN_TodoMsgCnt=1; tvfe_boss_uuid=d21c2d3c1e11956a; mobileUV=1_1635424395d_d654e; ptisp=cm; pgv_si=s9092982784; zzpaneluin=; zzpanelkey=; _qpsvr_localtk=0.04803201468608598; pgv_info=ssid=s5865224228; qqmusic_uin=; qqmusic_key=; qqmusic_fromtag=; __Q_w_s_hat_seed=1; rv2=8035B35754368704C3397A8AC43BF34AE5E852D70782236400; property20=886AAA9909562AF65FB5AE4A714236CDB589F87C837A4587A63B63A18BE5EF22C1251EC8470CBD96; cpu_performance_v8=2; uin=o1319589118; skey=@pAmr1KiSN; p_uin=o1319589118; pt4_token=W69Eb2pyxyxTpcY*hn5IsjMUhRExcWqt0ODlxatvvbs_; p_skey=3aOa1-ZqyrnGaUJSz-6iD5Lh1YRJ6nVhA58v9BWmAJw_; Loading=Yes; qzmusicplayer=qzone_player_1319589118_1528251380581";
      String result = "";
      String str = "";
      String substr = "";
        Map map = new HashMap();
        map.put("tid","fe54a74ebe3d075b240a0500");
        map.put("uin","1319589118");
        map.put("t1_source","1");
//        map.put("pos","0");
//        map.put("num","1");
//        map.put("cmtnum","1");
//        map.put("who","1");
//        map.put("inCharset","utf-8");
//        map.put("outCharset","utf-8");
//        map.put("plat","qzone");
//        map.put("source","ic");
//        map.put("paramstr","2");
//        map.put("feedsType","100");
//        map.put("fullContent","1");
        map.put("not_trunc_con","1");
        map.put("hostuin","1319589118");
        map.put("code_version","1");
        map.put("format","jsonp");
//        map.put("callback","_preloadCallback");

        try{
            Document doc = Jsoup.connect(url).cookie("cookie",cookie).data(map).get();
            str = doc.body().text();
System.out.println(doc.toString());
            System.out.println(str);
            substr = str.substring(10,str.length()-2);

            System.out.println(substr);

            JsonParser parse =new JsonParser();  //创建json解析器
            try {
                JsonObject json=(JsonObject) parse.parse(substr);
//                String content = json.get("content").getAsString();
//                System.out.println(content);
                result = json.toString();
            }catch (JsonIOException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
//            String title = doc.title();
//            result = doc.body().text();
//            substr = str.substring(17,str.length()-2);
        }
        catch (IOException e){
            return e.toString();
        }

        return result;
    }
}
//data tid: fe54a74ebe3d075b240a0500
//        uin: 1319589118
//        t1_source: 1
//        not_trunc_con: 1
//        hostuin: 1319589118
//        code_version: 1
//        format: fs
//        qzreferrer: https://user.qzone.qq.com/1319589118/311

//https://user.qzone.qq.com/proxy/domain/taotao.qq.com/cgi-bin/emotion_cgi_msglist_v6?uin=1319589118&ftype=0&sort=0&pos=0&num=20&replynum=100&g_tk=726086639&callback=_preloadCallback&code_version=1&format=jsonp&need_private_comment=1&qzonetoken=40febf70eeb5ba3647373081b7727a0881400fc7c8104176adae8f492ffc0cf810fa93caecfb69989b7f&g_tk=726086639