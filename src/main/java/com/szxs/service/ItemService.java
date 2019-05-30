package com.szxs.service;

import com.szxs.dto.VoDmw;
import com.szxs.dto.VoFloorItems;
import com.szxs.entity.DmElasticSearchRequestParm;

import java.util.List;

//服务接口
public interface ItemService {

/**查询所有商品分类*/
    VoDmw queryAllType();

    /**查询一级分类*/
    VoDmw queryTransverse();

    /**轮播图*/
    VoDmw queryBanner();

    /**近日推荐*/
    VoDmw queryTodayRecommend();

    /**即将开售*/
    VoDmw queryToSaleItem();

    /**B6 剧场类型推荐电影（1F/2F。。。）*/
    VoDmw queryFloorItems();

    /**热门排行*/
    VoDmw queryItemHot(Integer itemTypeId,Integer limit,Integer areaId);

    /**精彩聚集*/
    VoDmw queryItemNice(Integer itemTypeId,Integer limit);

    /**根据id查询剧场详情*/
    VoDmw queryItemDetail(Integer id);

    /**根据id查询剧场评论*/
    VoDmw queryItemComment(Integer id);

    //B7.	热门演出推荐排行
    VoDmw queryHotItems(Integer itemTypeId);

    //C1 音乐会专区
    VoDmw queryItemByAge(Integer ageGroup,Integer limit);

    //C2精彩聚集
    VoDmw queryAdvertising(Integer itemTypeId,Integer limit);

    //C7.根据月份查询剧场
    VoDmw queryItemByMonth(Integer itemTypeId,Integer year, Integer month);

    /**c3轮播图*/
    VoDmw querySlideShowPic(Integer itemTypeId);

    /**c4猜你喜欢*/
    VoDmw queryItemLike(Integer ageGroup,Integer limit);


    /**全文检索后的内容*/
    VoDmw queryItemRows(DmElasticSearchRequestParm desr);

    /**查询可能喜欢*/
    VoDmw queryVoItem(Integer itemTypeId,Integer limit);


    /**查询城市*/
    VoDmw queryCityList();

    /**查询类型*/
    VoDmw queryItemType(Integer parentId);

}
