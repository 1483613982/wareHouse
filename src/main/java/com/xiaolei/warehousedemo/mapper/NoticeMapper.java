package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface NoticeMapper {

    List<Notice> getNoticeList(String title, int page, int size);

    List<Notice> getShowNotice();

    Notice getNotice(int id);

    int getCount();

    int addNotice(Notice notice);

    int deleteNoticeById(int id);

    int updateNotice(Notice notice);


}
