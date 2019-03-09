package cn.mosorg.hellodemo;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

import cn.mosorg.hellodemo.service.Demo;

public class fastjson_1_2_2_Demo {
    private static Logger logger = Logger.getLogger(fastjson_1_2_2_Demo.class);
    public static void main(String[] args) {
        System.out.println("jsonTest 此方法返回:"+jsonTest());
        logger.info("这是打印的第一条日志");
    }

    public static String jsonTest(){
        Demo demo = new Demo();
        demo.setName("沈万三");
        demo.setAge(56);
        demo.setSex("男");
        demo.setBirthday("1569-08-01");
        System.out.println("获取某个元素的具体值:"+JSON.toJSONString(demo.getName()));
        return JSON.toJSONString(demo);
    }

}