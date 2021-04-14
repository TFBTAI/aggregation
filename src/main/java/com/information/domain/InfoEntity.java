package com.information.domain;

import java.util.List;

public class InfoEntity {

    private String nodeName;
    private String logo;
    private String nodeType;
    private String updateTime;
    private List<Information> informationList;

    public InfoEntity(InfoNode infoNode, List<Information> informations){
        this.nodeName = infoNode.getNode_name();
        this.logo = infoNode.getLogo();
        this.nodeType = infoNode.getNode_type();
        this.updateTime = infoNode.getUpdate_time();
        this.informationList = informations;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<Information> getInformationList() {
        return informationList;
    }

    public void setInformationList(List<Information> informationList) {
        this.informationList = informationList;
    }
}
