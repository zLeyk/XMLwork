package com.example.demo.util;

import com.example.demo.Bean.City;
import com.example.demo.Bean.County;
import com.example.demo.Bean.Prov;
import com.example.demo.mapper.CityMapper;
import com.example.demo.mapper.CountyMapper;
import com.example.demo.service.*;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlJXQ {

    @Autowired
    private static CountyServiceImpl countyService;
    @Autowired
    private static CityServiceImpl cityService;
    @Autowired
    private static ProvServiceImpl provService;
//
//    CityServiceImpl cityService = new CityServiceImpl();
//    CountyServiceImpl countyService = new CountyServiceImpl();
//    ProvServiceImpl provService = new ProvServiceImpl();
    public static void main(String[] args) throws Exception {



        List<Prov> provs = new ArrayList();
        List<City> citys = new ArrayList();
        List<County> countys = new ArrayList();
        
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = reader.read(new File("E:\\各科作业\\数据库\\demo\\src\\main\\java\\com\\example\\demo\\util\\Sheng-Shi-Xian.xml"));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Prov a;
            City b;
            County c;
            String id ="";
            String name = "";
            Element prov = (Element) iterator.next();//省
            List<Attribute> attributes = prov.attributes();//当前省的属性
            System.out.println("=========获取省份=========");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getName()+":"+attribute.getValue());
                if(attribute.getName()=="id") id=attribute.getValue();
                if(attribute.getName()=="text") name=attribute.getValue();
            }
            a=new Prov(id,name);
            provs.add(a);
         //   provService.addProv(a);



            Iterator iterator1 = prov.elementIterator();
            while (iterator1.hasNext()){
                Element city = (Element) iterator1.next();
                List<Attribute> attributes2 = city.attributes();
                System.out.println("===获取市===");
                for (Attribute attribute : attributes2) {
                    System.out.println(attribute.getName()+":"+attribute.getValue());
                    if(attribute.getName()=="id") id=attribute.getValue();
                    if(attribute.getName()=="text") name=attribute.getValue();
                }
                b=new City(id,a.getId(),name);
                citys.add(b);
                cityService.addCity(b);

                System.out.println("=获取县=");
                Iterator iterator2 = city.elementIterator();
                while (iterator2.hasNext()){
                    Element county = (Element) iterator2.next();
                    List<Attribute> attributes3 = county.attributes();
                    for (Attribute attribute : attributes3) {
                        System.out.println(attribute.getName()+":"+attribute.getValue());
                        if(attribute.getName()=="id") id=attribute.getValue();
                        if(attribute.getName()=="text") name=attribute.getValue();
                    }
                    c=new County(id,a.getId(),name);
                    countys.add(c);
                    countyService.addCounty(c);
                }
            }
        }
        System.out.println(provs.size()+" "+citys.size()+" "+countys.size());


    }
}
