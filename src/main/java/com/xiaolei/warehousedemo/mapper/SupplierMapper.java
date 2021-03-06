package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SupplierMapper {

    List<Supplier> getSupplierList(int page,int size);

    List<Supplier> getAllSuppler();

    int addSupplier(Supplier supplier);

    List<Supplier> getSupplierBySName(String s_name);

    int deleteSupplierById(int id);

    int updateSupplier(Supplier supplier);

    int getCount();
}
