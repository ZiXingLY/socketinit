package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.SysUser;
import com.qy.service.SysUserService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by hang on 2018/06/03.
*/
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PostMapping("/add")
    public Result add(@RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        sysUserService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysUser sysUser = sysUserService.findById(id);
        return ResultGenerator.successResult(sysUser);
    }

    @GetMapping("/list")
    public Result list(PageBean<SysUser> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<SysUser> list = sysUserService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
