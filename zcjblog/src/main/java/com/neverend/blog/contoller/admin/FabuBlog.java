package com.neverend.blog.contoller.admin;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.moudel.ActicleTree;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountServiceMyzcj;
import com.neverend.blog.service.ArticleService;
import com.neverend.blog.service.SuperArticleSortService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;

/**
 * 发布预览文章
 *
 * @author zcj
 */
@Controller
@RequestMapping("/system")
public class FabuBlog {


    @Autowired
    private AccountServiceMyzcj accountServiceMyzcj;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SuperArticleSortService superArticleSortService;

    /**
     * context articleName briefIntroduction
     * 保存预览
     *
     * @param articleWithBLOBs
     * @return
     */
    @ApiOperation(value = "保存文章进行预览页面", httpMethod = "POST",
            notes = "保存并且预览文章，返回信息中设置了跳转的url", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleSortSuperId", value = "文章属于那些分类，是使用" +
                    "layui tree的树形插件，数据格式参照layui tree数据格式传递",
                    required = true, dataType = "String", paramType = "query"),

            @ApiImplicitParam(name = "context", value = "富文本编辑器中的html文本内容",
                    required = true, dataType = "String", paramType = "query", defaultValue = "0"),

            @ApiImplicitParam(name = "articleName", value = "文章名称",
                    required = true, dataType = "String", paramType = "query"),

            @ApiImplicitParam(name = "briefIntroduction", value = " 文章简介",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "articlelevel", value = " 文章级别，数值越大级别越高",
                    required = true, dataType = "String", paramType = "query", defaultValue = "0")})
    @PostMapping("/yulan")
    @ResponseBody
    public Msg yulanBlogjson(HttpServletRequest request, ArticleWithBLOBs articleWithBLOBs,
                         @RequestParam(name = "articleSortSuperId") String articleSortId,
                         @RequestParam(name = "articlelevel", defaultValue = "0")
                                         String articlelevel, Device device) {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        Msg msg = articleService.saveylanArticle(account, articleWithBLOBs, "-1", articleSortId,articlelevel);
        return msg;
    }

    /**
     * 发布文章
     *
     * @param request
     * @param articleWithBLOBs
     * @param articleSortId
     * @return
     */
    @ApiOperation(value = "发布文章", httpMethod = "POST",
            notes = "发布文章", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleSortSuperId", value = "文章属于那些分类，是使用" +
                    "layui tree的树形插件，数据格式参照layui tree数据格式传递",
                    required = true, dataType = "String", paramType = "query"),

            @ApiImplicitParam(name = "context", value = "富文本编辑器中的html文本内容",
                    required = true, dataType = "String", paramType = "query", defaultValue = "0"),

            @ApiImplicitParam(name = "articleName", value = "文章名称",
                    required = true, dataType = "String", paramType = "query"),

            @ApiImplicitParam(name = "briefIntroduction", value = " 文章简介",
                    required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "articlelevel", value = " 文章级别，数值越大级别越高",
                    required = true, dataType = "String", paramType = "query", defaultValue = "0")})

    @PostMapping("/publish/articles")
    @ResponseBody
    public Msg publishArticlejson(HttpServletRequest request, ArticleWithBLOBs articleWithBLOBs,
                              @RequestParam(name = "articleSortSuperId") String articleSortId,
                              @RequestParam(name = "articlelevel", defaultValue = "0") String articlelevel
            , Device device) {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        Msg msg = articleService.saveArticle(account, articleWithBLOBs, "3", articleSortId,articlelevel);
        return msg;
    }
    /**
     * 发布文章页面
     *
     * @return
     */
    @ApiIgnore
    @GetMapping("/admin/fabu/wen")
    public String AdminFabuWenZhang(HttpServletRequest request) {
        return "admin/indexWenZhang";
    }

    /**
     * 树形分类菜单
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "树形分类菜单", httpMethod = "GET",
            notes = "返回树形分类菜单数据", protocols = "http")
    @GetMapping("/admin/acticle/tree")
    @ResponseBody
    public Msg<List<ActicleTree>> treeActiclesjson(HttpServletRequest request, Device device) {
        Msg msg = superArticleSortService.getClassTypeNameS(true);
        return msg;
    }

    /**
     * 发布文章页面2
     *
     * @return
     */
    @ApiIgnore
    @GetMapping("/admin/fabu/yulan")
    public String Yulan(@RequestParam(name = "articleId", required = false) String articleId, HttpServletRequest request) {
        ArticleWithBLOBs articleWithBLOBs = articleService.getArticle(articleId);
        request.setAttribute("articelName", articleWithBLOBs.getArticleName());
        request.setAttribute("contextht", articleWithBLOBs.getContext());

        return "admin/yulan";
    }

    @ApiOperation(value = "查看发布的文章", httpMethod = "GET",
            notes = "查看发布的文章所有信息", protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章唯一id",
                    required = true, dataType = "String", paramType = "query")})
    @GetMapping("/admin/fabu/yulan/json")
    @ResponseBody
    public Msg<ArticleWithBLOBs> YulanApijson(@RequestParam(name = "articleId", required = true)
                                                  String articleId, Device device) {
        ArticleWithBLOBs articleWithBLOBs = articleService.getArticle(articleId);
        Msg msg = new Msg();
        msg.setData(articleWithBLOBs);
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        return msg;
    }



}
