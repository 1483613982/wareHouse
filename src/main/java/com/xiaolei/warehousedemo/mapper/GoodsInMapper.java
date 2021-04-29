package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.GoodsIn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsInMapper {

    List<GoodsIn> getGoodsInBypage(int page, int size);

    GoodsIn getGoodsIn(int id);

    int getCount();

    int addGoodsIn(GoodsIn goodsIn);

    int deleteGoodsInById(int id);

    int updateGoodsIn(GoodsIn goodsIn);

    List<GoodsIn> getGoodsInByGoodsName(String goodname);

}
