package com.szxs.service.impl;


import com.szxs.VoUtil;
import com.szxs.dto.*;
import com.szxs.entity.DmElasticSearchRequestParm;
import com.szxs.feign.DmItemTypeFeignClient;
import com.szxs.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//消费者--业务服务层
@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private DmItemTypeFeignClient dmItemTypeFeignClient;

    //查询所有商品分类 b1
    @Override
    public VoDmw queryAllType() {

        List<VoItemType> typeList = dmItemTypeFeignClient.queryAllType(); //查询voItemType集合

        if (typeList != null) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", typeList);
        } else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //查询一级分类 b2
    @Override
    public VoDmw queryTransverse() {

        List<VoTransverse> voTransverseList = dmItemTypeFeignClient.queryVoTransverse();
        if (null != voTransverseList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voTransverseList);
        } else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    /*轮播图*/
    @Override
    public VoDmw queryBanner() {
        List<VoItem> voItemList = dmItemTypeFeignClient.queryBanner();
        for (VoItem voItem:voItemList){
            voItem.setImgUrl("http://192.168.83.99:8888/default_carousel.jpg");
        }
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //今日推荐
    @Override
    public VoDmw queryTodayRecommend() {
        List<VoItem> voItemList = dmItemTypeFeignClient.queryTodayRecommend();
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //即将开售
    @Override
    public VoDmw queryToSaleItem() {
        List<VoItem> voItemList = dmItemTypeFeignClient.queryToSaleItem();
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //B6剧场类型推荐电影（1F/2F。。。）
    @Override
    public VoDmw queryFloorItems() {
        List<VoFloorItems> voFloorItemsList = dmItemTypeFeignClient.queryFloorItems();
        if (null != voFloorItemsList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voFloorItemsList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    @Override
    //C6
    public VoDmw queryItemHot(Integer itemTypeId,Integer limit,Integer areaId) {
        List<VoItems> voItemList = dmItemTypeFeignClient.queryItemHot(itemTypeId,limit,areaId);
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //精彩聚集
    @Override
    public VoDmw queryItemNice(Integer itemTypeId,Integer limit) {
        List<VoItems> voItemList = dmItemTypeFeignClient.queryItemNice(itemTypeId, limit);
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    @Override
    public VoDmw queryCityList() {
        List<VoCity> voCities = null;
        try {
            voCities = dmItemTypeFeignClient.queryCityList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != voCities) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voCities);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    @Override
    public VoDmw queryItemType(Integer parentId) {
        List<VoItemType> voItemTypes = dmItemTypeFeignClient.queryItemType(parentId);
        if (null != voItemTypes) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemTypes);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //根据id查询剧场详情
    @Override
    public VoDmw queryItemDetail(Integer id) {
        List<VoItemDetail> voItemList = dmItemTypeFeignClient.queryItemDetail(id);
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //根据id查询剧场评论
    @Override
    public VoDmw queryItemComment(Integer id) {
        List<VoItemComment> voItemList = dmItemTypeFeignClient.queryItemComment(id);
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    @Override
    public VoDmw queryItemRows(DmElasticSearchRequestParm desr) {
        VoEsEntity voEsEntity = null;
        try {
            voEsEntity = dmItemTypeFeignClient.queryItemRows(desr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != voEsEntity) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voEsEntity);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //B7.	热门演出推荐排行
    @Override
    public VoDmw queryHotItems(Integer itemTypeId) {
        List<VoItem> voItemList = dmItemTypeFeignClient.queryHotItems(itemTypeId);
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //C1 音乐会专区
    @Override
    public VoDmw queryItemByAge(Integer ageGroup, Integer limit) {
        List<VoItems> voItemsList = dmItemTypeFeignClient.queryItemByAge(ageGroup, limit);
        if (null != voItemsList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemsList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //C2精彩聚集
    @Override
    public VoDmw queryAdvertising(Integer itemTypeId, Integer limit) {
        List<VoItems> voItemsList = dmItemTypeFeignClient.queryAdvertising(itemTypeId,limit);
        if (null != voItemsList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemsList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //C7.根据月份查询剧场
    @Override
    public VoDmw queryItemByMonth(Integer itemTypeId, Integer year, Integer month) {
        String start = ""+year+"-"+ month + "-01";
        String end ;
        if(month == 11){
            year += 1;
            end = ""+year+"01-01";
        }else{
            month += 1;
            end = ""+ year + "-" + month + "-" + "-01";
        }
        List<VoItems> voItemsList = dmItemTypeFeignClient.queryItemByMonth(itemTypeId,start,end);
        if (null != voItemsList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemsList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    //c3轮播图
    @Override
    public VoDmw querySlideShowPic(Integer itemTypeId) {
        List<VoItem> voItemList = dmItemTypeFeignClient.querySlideShowPic(itemTypeId);
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }
    //c4猜你喜欢
    @Override
    public VoDmw queryItemLike(Integer ageGroup, Integer limit) {
        List<VoItems> voItemList = dmItemTypeFeignClient.queryItemLike(ageGroup,limit);
        if (null != voItemList) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItemList);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }

    @Override
    public VoDmw queryVoItem(Integer itemTypeId, Integer limit) {
        List<VoItem> voItem =null;
        try {
            voItem = dmItemTypeFeignClient.queryVoItem(itemTypeId,limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != voItem) {
            //成功
            return VoUtil.getDmw("true", "0000", "成功", voItem);
        }else {
            //失败
            return VoUtil.getDmw("false", "1006", "失败");
        }
    }
}
