package com.information.service;

import com.information.domain.Information;
import com.information.mapper.InfoNodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {

    @Autowired
    private InfoNodeMapper infoNodeMapper;

    public List<Information> queryInfoByNode(String category, String node, String type){

        String tableName = category + "_info";

        return infoNodeMapper.queryInfoByNode(tableName,node,type);
    }
}
