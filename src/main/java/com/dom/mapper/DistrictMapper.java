package com.dom.mapper;

import com.dom.bean.DistrictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-03-30
 * Time: 9:56
 */
@Mapper
public interface DistrictMapper {
    /**
     * 得到所有的省
     * @return
     */
    public List<DistrictEntity> getAllProvice();

    /**
     *根据父id得到其下的所有的地区
     */
    public List<DistrictEntity> getAllChild(Long id);




}
