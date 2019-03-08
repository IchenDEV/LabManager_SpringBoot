package com.idevlab.LabMgr.Enity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.util.Date;
import com.alibaba.fastjson.JSONObject;

public class Book {

    @Excel(name = "ApplicantName", orderNum = "0")
    private String applicantName;
    @Excel(name = "ApplicantUsername", orderNum = "1")
    private String applicantUsername;
    @Excel(name = "ApplicantId", orderNum = "2")
    private int applicantId;
    @Excel(name = "ProjectId", orderNum = "3")
    private int projectId;
    @Excel(name = "ProjectName", orderNum = "4")
    private String projectName;
    @Excel(name = "BeginTime", orderNum = "5")
    private Date beginTime;
    @Excel(name = "EndTime", orderNum = "6")
    private Date endTime;
    @Excel(name = "CreateTime", orderNum = "7")
    private Date createTime;
    @Excel(name = "DeviceId", orderNum = "8")
    private int deviceId;
    @Excel(name = "DeviceName", orderNum = "9")
    private String deviceName;

    public Book(JSONObject jsonObject) {
        this.applicantUsername =    jsonObject.getString("applicantUsername");
        this.applicantName =        jsonObject.getString("applicantNickname");
        this.applicantId =          jsonObject.getInteger("applicant");
        this.projectName=           jsonObject.getString("projectName");
        this.projectId =            jsonObject.getInteger("project");
        this.createTime=            jsonObject.getDate("createTime");
        this.beginTime=             jsonObject.getDate("beginTime");
        this.endTime=               jsonObject.getDate("endTime");
        this.deviceId=              jsonObject.getInteger("device");
        this.deviceName=            jsonObject.getString("deviceName");            
    }

    /**
     * @return the applicantName
     */
    public String getApplicantName() {
        return applicantName;
    }

    /**
     * @param applicantName the applicantName to set
     */
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    /**
     * @return the applicantUsername
     */
    public String getApplicantUsername() {
        return applicantUsername;
    }

    /**
     * @param applicantUsername the applicantUsername to set
     */
    public void setApplicantUsername(String applicantUsername) {
        this.applicantUsername = applicantUsername;
    }

    /**
     * @return the applicantId
     */
    public int getApplicantId() {
        return applicantId;
    }

    /**
     * @param applicantId the applicantId to set
     */
    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the beginTime
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime the beginTime to set
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the deviceId
     */
    public int getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId the deviceId to set
     */
    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return the deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName the deviceName to set
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

	
}