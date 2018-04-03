package com.dom.controller;

import com.dom.bean.DistrictEntity;
import com.dom.request.DistrictRequest;
import com.dom.response.AppResponseData;
import com.dom.rootbean.ResponseData;
import com.dom.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-03-30
 * Time: 10:01
 */
@Controller
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/searchDistrict")
    @ResponseBody
    public ResponseData<List<DistrictEntity>> getDistrict(){
     return districtService.getDistrict();
    }

    @RequestMapping("/searchDistrictById")
    @ResponseBody
    public AppResponseData<List<DistrictEntity>> getDistrictById(@Validated @RequestBody DistrictRequest districtRequest){
        return districtService.getDistrictById(districtRequest);
    }

}
