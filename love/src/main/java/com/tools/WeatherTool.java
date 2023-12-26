package com.tools;

import com.alibaba.fastjson.JSONObject;
import com.entity.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author:YiXia
 * @create: 2022-11-17 11:30:38
 * @Description: 天气
 */

@Slf4j
@Component
public class WeatherTool {

    private Weather weather = null;


    public Weather getWeather(String cityCode) {

        // 石家庄 101090101
        //http://t.weather.itboy.net/api/weather/city/101090101


        try {
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/" + cityCode);
            InputStreamReader isReader = new InputStreamReader(url.openStream(), "UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str = br.readLine();
//            log.info("查询出的天气json信息：" + str);
            //使用Fastjson处理天气信息，封装Java对象
            if (str != null && str != "") {
                //开始处理天气Json
                weather = JSONObject.parseObject(str, Weather.class);
            }

            //网上资源使用结束后，数据流及时关闭
            br.close();
            isReader.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }
        return weather;
    }


}






