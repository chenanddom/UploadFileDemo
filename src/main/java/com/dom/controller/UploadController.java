package com.dom.controller;

import com.dom.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-03-21
 * Time: 9:15
 */
@Controller
public class UploadController {
@Autowired
private UploadService uploadService;

@Autowired
private RedisTemplate redisTemplate;



    @RequestMapping("/uploadFile")
    public boolean uploadFileMethod(MultipartHttpServletRequest httpServletRequest){
        String id = httpServletRequest.getParameter("id");
        MultiValueMap<String, MultipartFile> fileMap = httpServletRequest.getMultiFileMap();
        List<MultipartFile> fileList = fileMap.get("files");
        for (int i=0;i<fileList.size();i++){
        MultipartFile multipartFile = fileList.get(i);
            try {
                InputStream inputStream = multipartFile.getInputStream();
                uploadService.saveFile(inputStream);
                uploadService.saveFileInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }







        return false;
    }
@RequestMapping("/testRedis")
public void testRedis(){
/*
    redisTemplate.opsForValue().set("key_03", "value_003");
       String value = (String) redisTemplate.opsForValue().get("key_03");
*/
    boolean flag = uploadService.set("key_01", "value_003");
    String value = (String) uploadService.get("key_01");
    System.out.println("flag:"+flag+"-------"+value);
    }

    /**
     * 尝试按照一定得时间规定插入数据
     * @return
     */
    @RequestMapping("testRedisInsertDataByTime")
    @ResponseBody
    public String testRedisInsertData(){
    boolean flag = uploadService.set("key_02","value_002",5L);
    String value = (String) uploadService.get("key_02");
    System.out.println("flag:"+flag+"-------"+value);
    return "flag:"+flag+"-------"+value;
    }

    /**
     * 再缓存数据没有过期时时正常得，一旦过期了就没办法获取到刚刚缓存得数据了
     * @return
     */
    @RequestMapping("testGetRedisDataByTime")
    @ResponseBody
    public String testGetRedisInsertData(){
        String value = (String) uploadService.get("key_02");
        return StringUtils.isEmpty(value)?"缓存过期了":value;
    }
//------------------------------------------------------测试Redis移除键--------------------------------------------------

    /**
     * 移除掉缓存内得键
     * @return
     */
    @RequestMapping("/testRedisRemoveKey")
    @ResponseBody
    public String removeKey() {
        uploadService.set("key_02", "value_02");
        uploadService.set("key_03", "value_03");
        uploadService.set("key_04", "value_04");
        String value_01 = (String) uploadService.get("key_02");
        String value_02 = (String) uploadService.get("key_03");
        String value_03 = (String) uploadService.get("key_04");
        String[] keyArray = {"key_04","key_02","key_03"};
        uploadService.remove(keyArray);
        String value_001 = (String) uploadService.get("key_02");
        String value_002 = (String) uploadService.get("key_03");
        String value_003 = (String) uploadService.get("key_04");
        return "before:"+value_01+"-"+value_02+"-"+value_03+"after:"+value_001+"-"+value_002+"-"+value_003;
    }
//--------------------------------------------------测试判断是否包含对应得键得值------------------------------------------
@RequestMapping("/testRedisHashKey")
@ResponseBody
public String testHashKey(){
uploadService.set("key_01","value_01");
    return uploadService.exists("key_01")?"true":"false";
}
//------------------------------------------------测试添加哈希-----------------------------------------------------------
@RequestMapping("/addHashSet")
@ResponseBody
public HashSet<String> addHashValue(){
    HashSet<String> hs = new HashSet();
    hs.add("value_01");
    hs.add("value_02");
    hs.add("value_03");
    uploadService.hmSet("hkey_01","hashKey_01",hs);
    HashSet<String> hashSet = (HashSet<String>) uploadService.hmGet("hkey_01","hashKey_01");
    return hashSet;
}
//----------------------------------------------测试添加列表-------------------------------------------------------------
    @RequestMapping("/addList")
    @ResponseBody
    public List< List<Object>> addListData(){
    List<String> list = new ArrayList<>();
    list.add("key_001");
    list.add("key_002");
    list.add("key_003");
    uploadService.lPush("lkey_001",list);
    List<Object> list1 = uploadService.lRange("lkey_001",0,-1);
    List<List<Object>> objects=new ArrayList<>();
    objects.add(list1);
        return  objects;
    }



}
