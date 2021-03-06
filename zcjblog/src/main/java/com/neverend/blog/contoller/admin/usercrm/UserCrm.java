package com.neverend.blog.contoller.admin.usercrm;

import com.neverend.blog.entity.Account;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountServiceMyzcj;
import com.neverend.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class UserCrm {
    @Autowired
    private AccountServiceMyzcj accountServiceMyzcj;

    @Autowired
    private RoleService roleService;
    @GetMapping("/system/user/crm/vive")
    public String getAccountVive(){
        return "admin/usercrm/user";
    }
    /**
     * 查看用户信息
     * @param page 第几页
     * @param size 每页数量
     * @return
     */
    @GetMapping("/system/user/crm")
    @ResponseBody
    public Msg<Account> getAccount(@RequestParam(name = "page",defaultValue = "1",required = false) Integer page,
                                   @RequestParam(name = "size",defaultValue = "10",required = false) Integer size){
        Msg msg = accountServiceMyzcj.selectAccountmsg(page,size);
        return msg;
    }


    /**
     * 查看用户信息
     * @return
     */
    @GetMapping("/system/user/roles")
    @ResponseBody
    public Msg<Account> getRole(){
        Msg msg = roleService.getRoles();
        return msg;
    }

    /**
     * 修改用户角色
     * @return
     */
    @PostMapping("/system/edit/acc/role")
    @ResponseBody
    public Msg<Account> editRole(@RequestParam(name = "accountid") String accountid,
                                 @RequestParam(name = "roleid") String roleid){
        Msg msg = roleService.editRoles(accountid,roleid);
        return msg;
    }


    /**
     * 锁定或修改为正常
     * @return
     */
    @PostMapping("/system/acount/lock/open")
    @ResponseBody
    public Msg editlockAccount(@RequestParam(name = "accountid") String accountid,
                                 @RequestParam(name = "isLock") boolean isLock){
        Msg msg = roleService.editlockAccount(accountid,isLock);
        return msg;
    }
}
