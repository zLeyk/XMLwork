package com.example.demo.controller;

import com.example.demo.Bean.City;
import com.example.demo.Bean.County;
import com.example.demo.Bean.Data;
import com.example.demo.Bean.Prov;
import com.example.demo.service.CityService;
import com.example.demo.service.CountyService;
import com.example.demo.service.ProvService;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class Xmlcontroller {

     @Autowired
     private CityService cityService;
    @Autowired
    private CountyService countyService;
    @Autowired
    private ProvService provService;

    @CrossOrigin
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @CrossOrigin
    @RequestMapping("/add")
    @ResponseBody
    public void add(){
        City a = new City("1","2","sdf");
        cityService.addCity(a);
    }
    @CrossOrigin
    @RequestMapping("/getAllProv")
    public List<Prov> getAllProv(){
        return provService.getAllProv();
    }

    @CrossOrigin
    @RequestMapping("/getProvByname")
    public List<Prov> getProvByname(@RequestParam("Name") String Name){
        return provService.getAllProvByname(Name);
    }
    @CrossOrigin
    @RequestMapping("/getProvByid")
    public List<Prov> getProvByid(@RequestParam("id") String id){
        return provService.getProvByid(id);
    }


    @CrossOrigin
    @RequestMapping("/getAllCity")
    public List<City> getAllCityv(){
        return cityService.getAllCity();
    }

    @CrossOrigin
    @RequestMapping("/getCityByname")
    public List<City> getCityByname(@RequestParam("Name") String Name){
        return cityService.getAllCityByname(Name);
    }
    @CrossOrigin
    @RequestMapping("/getCityByid")
    public List<City> getCityByid(@RequestParam("id") String id){
        return cityService.getCityByid(id);
    }


    @CrossOrigin
    @RequestMapping("/getAllCounty")
    public List<County> getAllCounty(){
        return countyService.getAllCounty();
    }

    @CrossOrigin
    @RequestMapping("/getCountyByname")
    public List<County> getCountyByname(@RequestParam("Name") String Name){
        System.out.println(Name);
        return countyService.getAllCountyByname(Name);
    }
    @CrossOrigin
    @RequestMapping("/getCountyByid")
    public List<County> getCountyByid(@RequestParam("id") String id){
        return countyService.getCountyByid(id);
    }

    @CrossOrigin//搜索县 省-市-县
    @RequestMapping("/getCounty")
    public List<Data> getCounty(@RequestParam("Name") String Name){
        List<County> countyList = new ArrayList<County>();
        List<Data> dataList = new ArrayList<Data>();
        String cid,cname,pname,pid;
        countyList = countyService.getAllCountyByname(Name);
        for (int i = 0; i < countyList.size(); i++) {
            cname=cityService.getCityByid(countyList.get(i).getPid()).get(0).getName();
            pname=provService.getProvByid(cityService.getCityByid(countyList.get(i).getPid()).get(0).getPid()).get(0).getName();
            Data a = new Data(pname,cname,countyList.get(i).getName());
            dataList.add(a);
        }
        return dataList;
    }

    @CrossOrigin
    @RequestMapping("/getAllByname")
    public List<String> getAllByname(@RequestParam("Name") String name){
        List<String> Data = new ArrayList<String>();
        List<County> countyList = new ArrayList<County>();
        List<City> cityList = new ArrayList<City>();
        List<Prov> provList = new ArrayList<Prov>();
        provList = provService.getAllProvByname(name);
        for (int i = 0; i < provList.size(); i++) {
            Data.add(provList.get(i).getName());
        }
        cityList = cityService.getAllCityByname(name);
        for (int i = 0; i < cityList.size(); i++) {
            Data.add(cityList.get(i).getName());
        }
        countyList = countyService.getAllCountyByname(name);
        for (int i = 0; i < countyList.size(); i++) {
            Data.add(countyList.get(i).getName());
        }
        return Data;

    }

    /*@CrossOrigin
    @RequestMapping("/getAllByname")
    public List<Data> getAllByname(@RequestParam("Name") String name){
        List<Data> Data = new ArrayList<Data>();
        List<County> countyList = new ArrayList<County>();
        List<City> cityList = new ArrayList<City>();
        List<Prov> Prov = new ArrayList<Prov>();
        return Data;

    }*/

    /*@CrossOrigin
    @RequestMapping("/sjk")
    @ResponseBody
    public void sjk() throws DocumentException {
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
            provService.addProv(a);



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
                    c=new County(id,b.getId(),name);
                    countys.add(c);
                    countyService.addCounty(c);
                }
            }
        }
        System.out.println(provs.size()+" "+citys.size()+" "+countys.size());

    }*/
}
