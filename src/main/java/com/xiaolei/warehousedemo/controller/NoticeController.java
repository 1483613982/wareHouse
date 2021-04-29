package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.NoticeMapper;
import com.xiaolei.warehousedemo.entity.Notice;
import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 类注解 */
@Api(tags = {"公告"})
@RequestMapping("/api/Notice")
@RestController
public class NoticeController {

    @Autowired
    NoticeMapper noticeMapper;

    @ApiOperation(value = "分页查询")
    @GetMapping("/getNoticeList")
    public RetResult<NoticeList> getNoticeList( String title,int page,int size) {
        page = page - 1;
        List<Notice> list = noticeMapper.getNoticeList(title, page, size);
        int count = noticeMapper.getCount();
        NoticeList noticeList = new NoticeList();
        noticeList.list = list;
        noticeList.total = count;
        return RetResponse.makeOKRsp(noticeList);
    }

    @ApiOperation(value = "获取展示的公告")
    @GetMapping("/getShowNotice")
    public RetResult<List<Notice>> getShowNotice(){
        List<Notice> list = noticeMapper.getShowNotice();
        return RetResponse.makeOKRsp(list);
    }


    @ApiOperation(value = "查询信息")
    @GetMapping("/getNotice")
    public RetResult<Notice> getNotice(int id) {
        Notice notice = noticeMapper.getNotice(id);
        if (notice == null) {
            return RetResponse.makeErrRsp("为查询公告信息");
        } else {
            return RetResponse.makeOKRsp(notice);
        }
    }

    @ApiOperation(value = "添加公告")
    @PostMapping("/addNotice")
    public RetResult<String> addNotice(@RequestBody Notice notice) {

        int state = noticeMapper.addNotice(notice);
        if (state >= 1) {
            return RetResponse.makeOKRsp("添加成功");
        } else {
            return RetResponse.makeErrRsp("添加失败");
        }

    }

    @ApiOperation(value = "删除公告")
    @GetMapping("/deleteNoticeById")
    public RetResult<String> deleteNoticeById(int id) {
        int state = noticeMapper.deleteNoticeById(id);
        if (state >= 1) {
            return RetResponse.makeOKRsp("删除成功");
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @ApiOperation(value = "更新公告")
    @PostMapping("/updateNotice")
    public RetResult<String> updateNotice(@RequestBody Notice notice) {
        int state = noticeMapper.updateNotice(notice);
        if (state >= 1) {
            return RetResponse.makeOKRsp("更新成功");
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }
    }


}


class NoticeList {
    public List<Notice> list;
    public Integer total;
}
