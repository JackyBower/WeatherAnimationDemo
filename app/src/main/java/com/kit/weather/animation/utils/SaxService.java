package com.kit.weather.animation.utils;

import android.content.Context;
import android.content.res.AssetManager;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Desc：描述模块内容
 * User: ZhouJing
 * Date: 2016/11/3 10:56
 */
public class SaxService {

    private static SaxService ourInstance = new SaxService();

    public static SaxService getInstance() {
        return ourInstance;
    }

    private SaxService() {

    }

    /**
     * 使用SAX解析器解析XML文件的方法，返回XMLActorData对象
     *
     * @param context
     * @param pathName
     * @return
     * @throws Exception
     */
    public static List<XMLActorData> readXML(Context context, String pathName) throws Exception {
        InputStream is = null;
        XMLContentHandler contentHandler = null;
        try {
            // 获取AssetManager管理器对象
            AssetManager as = context.getAssets();
            // 通过AssetManager的open方法获取到beauties.xml文件的输入流
            is = as.open(pathName);
            // 通过获取到的InputStream来得到InputSource实例
            InputSource is2 = new InputSource(is);
            // 使用工厂方法初始化SAXParserFactory变量spf
            SAXParserFactory spf = SAXParserFactory.newInstance();
            // 通过SAXParserFactory得到SAXParser的实例
            SAXParser sp = spf.newSAXParser();
            // 通过SAXParser得到XMLReader的实例
            XMLReader xr = sp.getXMLReader();
            // 初始化自定义的类MySaxHandler的变量msh，将beautyList传递给它，以便装载数据
            contentHandler = new XMLContentHandler();
            // 将对象msh传递给xr
            xr.setContentHandler(contentHandler);
            // 调用xr的parse方法解析输入流
            xr.parse(is2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return contentHandler.getXMLActorData();    //返回XML文档中的数据列表
    }
}
