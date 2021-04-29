package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.GoodsOut;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsOutMapper {

    List<GoodsOut> getGoodsOutBypage(int page, int size);

    GoodsOut getGoodsOut(int id);

    int getCount();

    int addGoodsOut(GoodsOut goodsOut);

    int deleteGoodsOutById(int id);

    int updateGoodsOut(GoodsOut goodsOut);

    List<GoodsOut> getGoodsOutByGoodsName(String goodname);

}
