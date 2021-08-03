package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author wmy
 * @date 2021/8/2 18:22
 */
//下载器
public class WebDownloader {
    //下载方法
    public void downLoader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，下载失败");
        }
    }
}
