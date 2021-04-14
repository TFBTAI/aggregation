package com.information.service;

import com.information.domain.InfoEntity;
import com.information.domain.InfoNode;
import com.information.domain.Information;
import com.information.domain.User;
import com.information.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexNodeService {

    @Autowired
    private InfoNodeService infoNodeService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private UserMapper userMapper;

    public List<InfoEntity> initIndexPage(){
        List<InfoEntity> infoEntityList = new ArrayList<>();
        String[] cateArray = {"news","tech","ent","community","finance","developer"};
        for(int i=0; i<cateArray.length; i++){
            List<InfoNode> nodeList = infoNodeService.queryInfoNodeListByCategory(cateArray[i]);
            for(int j=0; j<4; j++){
                InfoNode infoNode = nodeList.get(j);
                List<Information> informationList = informationService.queryInfoByNode(cateArray[i],infoNode.getNode_name(),infoNode.getNode_type());
                infoEntityList.add(new InfoEntity(infoNode,informationList));
            }
        }
        return infoEntityList;
    }

    public List<InfoEntity> userCollNode(String username){
        List<InfoEntity> infoEntityList = new ArrayList<>();
        String[] cateArray = {"news","tech","ent","community","finance","developer"};
        User user = userMapper.getUser(username);
        String collection = user.getCollection();
        String[] collArray = collection.split(",");
        for(int i=0; i<collArray.length; i++){
            String temp = collArray[i];
            String nodeName = temp.split(";")[0];
            String nodeType = collArray[i].split(";")[1];
            for(int j=0; j<cateArray.length; j++){
                List<InfoNode> nodeList = infoNodeService.queryInfoNodeListByCategory(cateArray[j]);
                for(InfoNode infoNode : nodeList){
                    if(nodeName.equals(infoNode.getNode_name()) && nodeType.equals(infoNode.getNode_type())){
                        List<Information> informationList = informationService.queryInfoByNode(cateArray[i],infoNode.getNode_name(),infoNode.getNode_type());
                        infoEntityList.add(new InfoEntity(infoNode,informationList));
                    }
                }
            }
        }
        return infoEntityList;
    }
}
