package com.szxs.controller;

import com.szxs.dto.ItemUtil;
import com.szxs.dto.VoFloorItems;
import com.szxs.entity.DmElasticSearchRequestParm;
import com.szxs.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//消费者
@RestController
public class ItemController {
    @Resource
    private ItemService itemService;

    //查询所有商品分类 B1
    @RequestMapping(path = "/api/p/index/queryAllType", method = RequestMethod.POST)
    public Object queryAllType() {
        return itemService.queryAllType();
    }

    //查询一级分类 B2
    @RequestMapping(path = "/api/p/index/queryTransverse", method = RequestMethod.POST)
    public Object queryTransverse() {
        return itemService.queryTransverse();
    }

    //轮播图 b3
    @RequestMapping(path = "/api/p/index/queryBanner", method = RequestMethod.POST)
    public Object queryBanner() {
        return itemService.queryBanner();
    }

    //近日推荐 b4
    @RequestMapping(path = "/api/p/index/queryTodayRecommend", method = RequestMethod.POST)
    public Object queryTodayRecommend() {
        return itemService.queryTodayRecommend();
    }

    //B5 即将开售
    @RequestMapping(path = "/api/p/index/queryToSaleItem", method = RequestMethod.POST)
    public Object queryToSaleItem(){
        return itemService.queryToSaleItem();
    }

    // B6剧场类型推荐电影
    @RequestMapping(path = "/api/p/index/queryFloorItems",method = RequestMethod.POST)
    public Object queryFloorItems(){
        return itemService.queryFloorItems();
    }
    //B7.热门演出推荐排行
    @RequestMapping(path = "/api/p/index/queryHotItems", method = RequestMethod.POST)
    public Object queryHotItems(@RequestBody ItemUtil itemUtil){
        return itemService.queryHotItems(itemUtil.getItemTypeId());
    }

    //C1 音乐会专区
    @RequestMapping(value ="/api/p/queryItemByAge", method = RequestMethod.POST)
    public Object queryItemByAge(@RequestBody ItemUtil itemUtil){
        return itemService.queryItemByAge(itemUtil.getAgeGroup(),itemUtil.getLimit());
    }

    //C2精彩聚集(2)
    @RequestMapping(value ="/api/p/queryAdvertising", method = RequestMethod.POST)
    public Object queryAdvertising(@RequestBody ItemUtil itemUtil){
        return itemService.queryAdvertising(itemUtil.getItemTypeId(),itemUtil.getLimit());
    }

    //C6 热门排行
    @RequestMapping(value ="/api/p/queryItemHot", method = RequestMethod.POST)
    public Object queryItemHot(@RequestBody ItemUtil itemUtil){
        return itemService.queryItemHot(itemUtil.getItemTypeId(),itemUtil.getLimit(),itemUtil.getAreaId());
    }

    //C7根据月份查询剧场
    @RequestMapping(value ="api/p/queryItemByMonth", method = RequestMethod.POST)
    public Object queryItemByMonth(@RequestBody ItemUtil itemUtil){
        return itemService.queryItemByMonth(itemUtil.getItemTypeId(), itemUtil.getYear(),itemUtil.getMonth());
    }

    //c3轮播图
    @RequestMapping(value ="/api/p/querySlideShowPic", method = RequestMethod.POST)
    public Object querySlideShowPic(@RequestBody ItemUtil itemUtil){
        return itemService.querySlideShowPic(itemUtil.getItemTypeId());
    }

    //c4猜你喜欢
//    @RequestMapping(value ="/api/p/queryItemLike", method = RequestMethod.POST)
//    public Object queryItemLike(@RequestParam("ageGroup")Integer ageGroup,
//                                @RequestParam("limit")Integer limit){
//        return itemService.queryItemLike(ageGroup,limit);
//    }

    //精彩聚集(1) c5
    @RequestMapping(value = "/api/p/queryItemNice",method = RequestMethod.POST)
    public Object queryItemNice(@RequestBody ItemUtil itemUtil){
        return itemService.queryItemNice(itemUtil.getItemTypeId(),itemUtil.getLimit());
    }

    //根据id查询剧场详情 e1
    @RequestMapping(value = "/api/p/area/queryItemDetail",method = RequestMethod.POST)
    public Object queryItemDetail(@RequestBody ItemUtil itemUtil){
        return itemService.queryItemDetail(itemUtil.getId());
    }

    //根据id查询剧场评论 e2
    @RequestMapping(value = "/api/p/type/queryItemComment",method = RequestMethod.POST)
    public Object queryItemComment(@RequestBody ItemUtil itemUtil){
        return itemService.queryItemDetail(itemUtil.getId());
    }

    /**
     * D1.查询城市
     * @return
     */
//    @RequestMapping(value = "api/p/area/queryCityList",method = RequestMethod.POST)
//    public Object queryCityList()throws Exception{
//        return itemService.queryCityList();
//    }

    /**
     * D2.查询类型
     * @param
     * @return
     */
    @RequestMapping(value = "api/p/type/queryItemType",method = RequestMethod.POST)
    public Object queryItemType(@RequestBody ItemUtil itemUtil){
        return itemService.queryItemType(itemUtil.getParent());
    }

    /*D3
     * 3.全文检索后的内容
     */
    @RequestMapping(value = "api/p/type/queryItemList",method = RequestMethod.POST)
    public Object queryItemRows(@RequestBody DmElasticSearchRequestParm desr) throws Exception {
        return itemService.queryItemRows(desr);
    }

    /*D4
     * 查询可能喜欢
     */
    @RequestMapping(value = "/api/p/queryItemLike",method = RequestMethod.POST)
    public Object queryVoItem(@RequestBody ItemUtil itemUtil) throws Exception {
        return itemService.queryVoItem(itemUtil.getItemTypeId(),itemUtil.getLimit());
    }
}
