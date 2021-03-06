/*Copyright (c) 2019-2020 reddcoin2.com All Rights Reserved.
 This software is the confidential and proprietary information of reddcoin2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with reddcoin2.com*/
package com.nuevo.sql3273776.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;

@Service
public class Sql3273776QueryExecutorServiceImpl implements Sql3273776QueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sql3273776QueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("sql3273776WMQueryExecutor")
    private WMQueryExecutor queryExecutor;


}