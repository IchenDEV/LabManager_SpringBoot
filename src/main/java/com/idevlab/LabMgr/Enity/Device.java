package com.idevlab.LabMgr.Enity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.JSONObject;

public class Device {

    @Excel(name = "Equipment id", orderNum = "0")
    private int equipmentId;
    @Excel(name = "Equipment Name", orderNum = "1")
    private String equipmentName;
    @Excel(name = "Utilization", orderNum = "2")
    private double utilization;

    public Device(JSONObject jsonObject) {
        this.equipmentId =          jsonObject.getInteger("id");
        this.equipmentName =        jsonObject.getString("name");
        this.utilization =          jsonObject.getDoubleValue("rate");
    }

    /**
     * @return the equipmentId
     */
    public int getEquipmentId() {
        return equipmentId;
    }

    /**
     * @param equipmentId the equipmentId to set
     */
    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * @return the equipmentName
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * @param equipmentName the equipmentName to set
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * @return the utilization
     */
    public double getUtilization() {
        return utilization;
    }

    /**
     * @param utilization the utilization to set
     */
    public void setUtilization(double utilization) {
        this.utilization = utilization;
    }

}