package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsMapper {

    List<Goods> getGoodsBypage(int page, int size);

    Goods getGoods(int id);

    List<Goods> getAllGoods();

    List<Goods> getGoodsWarning(int stock);

    int getCount();

    int addGoods(Goods goods);

    int deleteGoodsById(int id);

    int updateGoods(Goods goods);

    List<Goods> getGoodsByGoodsName(String goodsname);

    List<Goods> getGoodsByShelves(String shelvesNumber);
}
