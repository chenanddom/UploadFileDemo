package com.dom.service;

import com.dom.bean.DistrictEntity;
import com.dom.mapper.DistrictMapper;
import com.dom.request.DistrictRequest;
import com.dom.response.AppResponseData;
import com.dom.rootbean.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-03-30
 * Time: 10:05
 */
@Service
public class DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *
     * @return
     */
    public ResponseData<List<DistrictEntity>> getDistrict(){
        List<DistrictEntity> districtEntities=null;
        boolean isContain = redisTemplate.hasKey("province");
        if (!isContain) {
            districtEntities = districtMapper.getAllProvice();
            if (districtEntities == null || districtEntities.size() == 0) {
                return new ResponseData<List<DistrictEntity>>(0, "返回的数据为空");
            }
            redisTemplate.opsForList().leftPush("province",districtEntities);
        }else {
            districtEntities = redisTemplate.opsForList().range("province",0,-1);
            if (districtEntities == null || districtEntities.size() == 0) {
                return new ResponseData<List<DistrictEntity>>(0, "返回的数据为空");
            }
        }
        return new ResponseData<List<DistrictEntity>>(districtEntities,1,"sucess");
    }

    /**
     *
     * @param districtRequest
     * @return
     */
    public AppResponseData<List<DistrictEntity>> getDistrictById(DistrictRequest districtRequest){
        if (districtRequest==null) {
        return new AppResponseData<List<DistrictEntity>>(0,"参数不能为空");
        }
        List<DistrictEntity> districtEntities=null;
        String districtKey = districtRequest.getDistrictId();
        boolean isContain = redisTemplate.hasKey(districtKey);
        if (!isContain) {
            districtEntities = districtMapper.getAllChild(Long.parseLong(districtRequest.getDistrictId()));
            if (districtEntities == null || districtEntities.size() == 0) {
                return new AppResponseData<List<DistrictEntity>>(0, "返回的数据为空");
            }
            redisTemplate.opsForList().leftPush(districtKey,districtEntities);
            redisTemplate.expire(districtKey,100, TimeUnit.SECONDS);
        }else {
            districtEntities = redisTemplate.opsForList().range(districtKey,0,-1);
            if (districtEntities == null || districtEntities.size() == 0) {
                return new AppResponseData<List<DistrictEntity>>(0, "返回的数据为空");
            }
        }
        return AppResponseData.success(districtEntities,"获取数据成功");
    }
}
