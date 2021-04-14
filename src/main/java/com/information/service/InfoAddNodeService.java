package com.information.service;

import com.information.domain.InfoEntity;
import com.information.domain.InfoNode;
import com.information.domain.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoAddNodeService {

    @Autowired
    private InfoNodeService infoNodeService;

    @Autowired
    private InformationService informationService;

    private List<InfoNode> infoNodeList;
    private int nodeIndex = 0;

    public List<InfoEntity> initInfo(String category){
        infoNodeList = infoNodeService.queryInfoNodeListByCategory(category);
        List<InfoEntity> infoEntityList = new ArrayList<InfoEntity>();
        this.nodeIndex = 24;
        for(int i=0; i<24; i++){
            InfoNode infoNode = infoNodeList.get(i);
            List<Information> informationList = informationService.queryInfoByNode(category,infoNode.getNode_name(),infoNode.getNode_type());
            infoEntityList.add(new InfoEntity(infoNode,informationList));
        }
        return infoEntityList;
    }

    public List<InfoEntity> getMoreNodes(String category){
        List<InfoEntity> infoEntityList = new ArrayList<InfoEntity>();
        for(int i=0; i<24 && (this.nodeIndex < infoNodeList.size()); i++){
            InfoNode infoNode = infoNodeList.get(this.nodeIndex);
            List<Information> informationList = informationService.queryInfoByNode(category,infoNode.getNode_name(),infoNode.getNode_type());
            infoEntityList.add(new InfoEntity(infoNode,informationList));
            this.nodeIndex++;
        }
        return infoEntityList;
    }
}
