package com.szxs.service;

import com.szxs.dto.VoDmw;
import com.szxs.entity.DmElasticSearchRequestParm;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**热门排行*/
    VoDmw queryItemHot(Integer itemTypeId,Integer limit,Integer areaId);

    /**精彩聚集*/
    VoDmw queryItemNice(int itemTypeId,int limit);

    /**根据id查询剧场详情*/
    VoDmw queryItemDetail(int id);

    /**根据id查询剧场评论*/
    VoDmw queryItemComment(int id);


    /**全文检索后的内容*/
    VoDmw queryItemRows(DmElasticSearchRequestParm desr);

    /**查询可能喜欢*/
    VoDmw queryVoItem(Integer itemTypeId,Integer limit);


    /**查询城市*/
    VoDmw queryCityList();

    /**查询类型*/
    VoDmw queryItemType(Integer parentId);

}
