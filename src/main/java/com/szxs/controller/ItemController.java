package com.szxs.controller;

import com.szxs.entity.DmElasticSearchRequestParm;
import com.szxs.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//消费者
@RestController
@RequestMapping("/api/p/index")
public class ItemController {
    @Resource
    private ItemService itemService;

    //查询所有商品分类 B1
    @RequestMapping(path = "/queryAllType", method = RequestMethod.POST)
    public Object queryAllType() {
        return itemService.queryAllType();
    }

    //查询一级分类 B2
    @RequestMapping(path = "/queryTransverse", method = RequestMethod.POST)
    public Object queryTransverse() {
        return itemService.queryTransverse();
    }

    //轮播图 b3
    @RequestMapping(path = "/queryBanner", method = RequestMethod.POST)
    public Object queryBanner() {
        return itemService.queryBanner();
    }

    //近日推荐 b4
    @RequestMapping(path = "/queryTodayRecommend", method = RequestMethod.POST)
    public Object queryTodayRecommend() {
        return itemService.queryTodayRecommend();
    }

    //即将开售
    @RequestMapping(path = "/queryToSaleItem", method = RequestMethod.POST)
    public Object queryToSaleItem(){
        return itemService.queryToSaleItem();
    }

    //B7.	热门演出推荐排行
    @RequestMapping(path = "/queryHotItems", method = RequestMethod.POST)
    public Object queryHotItems(@RequestParam Integer itemTypeId){
        return itemService.queryHotItems(itemTypeId);
    }

    //C1 音乐会专区
    @RequestMapping(value ="/queryItemByAge", method = RequestMethod.POST)
    public Object queryItemByAge(@RequestParam("ageGroup") Integer ageGroup, @RequestParam("limit") Integer limit){
        return itemService.queryItemByAge(ageGroup,limit);
    }

    //c3轮播图
    @RequestMapping(value ="/querySlideShowPic", method = RequestMethod.POST)
    public Object querySlideShowPic(@RequestParam("itemTypeId")Integer itemTypeId){
        return itemService.querySlideShowPic(itemTypeId);
    }

    //c4猜你喜欢
    @RequestMapping(value ="/queryItemLike", method = RequestMethod.POST)
    public Object queryItemLike(@RequestParam("ageGroup")Integer ageGroup,
                                @RequestParam("limit")Integer limit){
        return itemService.queryItemLike(ageGroup,limit);
    }


    //C6 热门排行
    @RequestMapping(value ="/queryItemHot", method = RequestMethod.POST)
    public Object queryItemHot(@RequestParam("itemTypeId")Integer itemTypeId,
                               @RequestParam("limit")Integer limit,
                               @RequestParam("areaId")Integer areaId){
        return itemService.queryItemHot(itemTypeId,limit,areaId);
    }
    //精彩聚集(1) c5

    @RequestMapping(value = "/queryItemNice")
    public Object queryItemNice(@RequestParam("itemTypeId")Integer itemTypeId, @RequestParam("limit")Integer limit){
        return itemService.queryItemNice(itemTypeId,limit);
    }
    //根据id查询剧场详情 e1
    @RequestMapping(value = "/queryItemDetail")
    public Object queryItemDetail(@RequestParam("id")Integer id){
        return itemService.queryItemDetail(id);
    }
    //根据id查询剧场评论 e2
    @RequestMapping(value = "/queryItemComment")
    public Object queryItemComment(@RequestParam("id")Integer id){
        return itemService.queryItemDetail(id);
    }


    /**
     * D1.查询城市
     * @return
     */
    @RequestMapping(value = "/queryCityList",method = RequestMethod.POST)
    public Object queryCityList()throws Exception{
        return itemService.queryCityList();
    }

    /**
     * D2.查询类型
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/queryItemType",method = RequestMethod.POST)
    public Object queryItemType(@RequestParam("parent") Integer parentId){
        return itemService.queryItemType(parentId);
    }

    /*D3
     * 3.全文检索后的内容
     */
    @RequestMapping(value = "/queryItemList")
    public Object queryItemRows(@RequestBody DmElasticSearchRequestParm desr) throws Exception {
        return itemService.queryItemRows(desr);
    }

    /*D4
     * 查询可能喜欢
     */
    @RequestMapping(value = "/queryItemLike")
    public Object queryVoItem(@RequestParam("itemTypeId")Integer itemTypeId, @RequestParam("limit")Integer limit) throws Exception {
        return itemService.queryVoItem(itemTypeId,limit);
    }
}
