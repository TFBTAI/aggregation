package com.information.controller;

import com.information.domain.InfoEntity;
import com.information.domain.InfoNode;
import com.information.service.IndexNodeService;
import com.information.service.InfoAddNodeService;
import com.information.service.InfoNodeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class InfoNodeController {

    @Autowired
    private InfoAddNodeService infoAddNodeService;

    @Autowired
    private InfoNodeService infoNodeService;

    @Autowired
    private IndexNodeService indexNodeService;

    @RequestMapping("/initPage")
    @ResponseBody
    public List<InfoEntity> initPage(String category){
        return infoAddNodeService.initInfo(category);
    }

    @RequestMapping("/getNodesSize")
    @ResponseBody
    public int getNodesSize(String category){
        return infoNodeService.getNodeSize(category);
    }

    @RequestMapping("/getMoreNodes")
    @ResponseBody
    public List<InfoEntity> getMoreNodes(String category){
        return infoAddNodeService.getMoreNodes(category);
    }

    @RequestMapping("/initIndexPage")
    @ResponseBody
    public List<InfoEntity> initIndexPage(){
        return indexNodeService.initIndexPage();
    }

    @RequestMapping("/userCollNode")
    @ResponseBody
    public List<InfoEntity> userCollNode(String username){
        return indexNodeService.userCollNode(username);
    }
}
