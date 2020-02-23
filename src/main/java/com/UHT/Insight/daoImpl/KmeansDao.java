package com.UHT.Insight.daoImpl;


import com.UHT.Insight.pojo.Kmean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "KmeansDao")
public interface KmeansDao {
    @Select("SELECT label FROM kmean WHERE G_ID=#{gameId} ORDER BY label DESC LIMIT 1")
    Integer maxLabelIndex(Integer gameId);

    @Select("SELECT * FROM kmean WHERE G_ID=#{gameId} AND label = #{label}")
    List<Kmean> getKmeanForLabel(Integer label, Integer gameId);

    @Select("SELECT cindex FROM kmean WHERE G_ID=#{gameId} AND label = #{label}")
    List<String> getCindexForLabel(Integer label, Integer gameId);
}
