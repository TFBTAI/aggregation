package com.information.mapper;

import com.information.domain.InfoNode;
import com.information.domain.Information;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InfoNodeMapper {

    public List<InfoNode> queryInfoNodeListByCategory(String category);

    public List<Information> queryInfoByNode(@Param("tableName") String tableName, @Param("node") String node, @Param("type") String type);

}
