package com.sph.web.controller;

import com.sph.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunph
 * @Date: 2022/09/09/10:43
 * @Description:
 */
@RestController
@RequestMapping(value = "/api/name")
public class NameController {

    private final NameService nameService;

    @Autowired(required = false)
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping()
    public String getNameFromStarter(){
        return nameService.getName();
    }
}
