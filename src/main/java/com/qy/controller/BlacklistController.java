package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Blacklist;
import com.qy.service.BlacklistService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/05/17.
*/
@RestController
@RequestMapping("/blacklist")
public class BlacklistController {
    @Resource
    private BlacklistService blacklistService;

    @PostMapping("/add")
    public Result add(@RequestBody Blacklist blacklist) {
        blacklistService.save(blacklist);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        blacklistService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Blacklist blacklist) {
        blacklistService.update(blacklist);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Blacklist blacklist = blacklistService.findById(id);
        return ResultGenerator.successResult(blacklist);
    }

    @GetMapping("/list")
    public Result list(PageBean<Blacklist> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Blacklist> list = blacklistService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
