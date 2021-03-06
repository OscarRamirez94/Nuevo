/*Copyright (c) 2019-2020 reddcoin2.com All Rights Reserved.
 This software is the confidential and proprietary information of reddcoin2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with reddcoin2.com*/
package com.nuevo.sql3273776.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import com.nuevo.sql3273776.service.Sql3273776ProcedureExecutorService;

@RestController(value = "Sql3273776.ProcedureExecutionController")
@RequestMapping("/sql3273776/procedureExecutor")
@Api(value = "ProcedureExecutionController", description = "controller class for procedure execution")
public class ProcedureExecutionController {


    @Autowired
    private Sql3273776ProcedureExecutorService procedureService;


}