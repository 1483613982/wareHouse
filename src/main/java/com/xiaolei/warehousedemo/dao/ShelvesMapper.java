package com.xiaolei.warehousedemo.dao;

import com.xiaolei.warehousedemo.entity.Shelves;
import com.xiaolei.warehousedemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShelvesMapper {
    List<Shelves> getShelvesBypage(int page,int size);

    Shelves getShelves(int id);

    int getCount();

    int addShelves(Shelves shelves);

    int deleteShelvesById(int id);

    int updateShelves(Shelves shelves);
}
