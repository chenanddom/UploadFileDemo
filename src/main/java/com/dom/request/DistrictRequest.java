package com.dom.request;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-03-30
 * Time: 10:02
 */
public class DistrictRequest {
    @NotNull(message = "地区id不能为空")
    private String districtId;

    private String districtName;


    public DistrictRequest() {
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
