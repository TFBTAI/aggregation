package com.information.service;

import com.information.domain.InfoNode;
import com.information.mapper.InfoNodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoNodeService {

    @Autowired
    private InfoNodeMapper infoNodeMapper;

    private List<InfoNode> infoNodes;

    public List<InfoNode> queryInfoNodeListByCategory(String category){
        List<InfoNode> infoNodes = infoNodeMapper.queryInfoNodeListByCategory(category);
        return infoNodes;
    }

    public int getNodeSize(String category){
        List<InfoNode> infoNodes = infoNodeMapper.queryInfoNodeListByCategory(category);
        return infoNodes.size();
    }
}
