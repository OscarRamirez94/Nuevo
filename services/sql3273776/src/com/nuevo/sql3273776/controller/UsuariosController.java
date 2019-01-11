/*Copyright (c) 2019-2020 reddcoin2.com All Rights Reserved.
 This software is the confidential and proprietary information of reddcoin2.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with reddcoin2.com*/
package com.nuevo.sql3273776.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.nuevo.sql3273776.Usuarios;
import com.nuevo.sql3273776.service.UsuariosService;


/**
 * Controller object for domain model class Usuarios.
 * @see Usuarios
 */
@RestController("sql3273776.UsuariosController")
@Api(value = "UsuariosController", description = "Exposes APIs to work with Usuarios resource.")
@RequestMapping("/sql3273776/Usuarios")
public class UsuariosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuariosController.class);

    @Autowired
	@Qualifier("sql3273776.UsuariosService")
	private UsuariosService usuariosService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new Usuarios instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Usuarios createUsuarios(@RequestBody Usuarios usuarios) {
		LOGGER.debug("Create Usuarios with information: {}" , usuarios);

		usuarios = usuariosService.create(usuarios);
		LOGGER.debug("Created Usuarios with information: {}" , usuarios);

	    return usuarios;
	}

    @ApiOperation(value = "Returns the Usuarios instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Usuarios getUsuarios(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting Usuarios with id: {}" , id);

        Usuarios foundUsuarios = usuariosService.getById(id);
        LOGGER.debug("Usuarios details with id: {}" , foundUsuarios);

        return foundUsuarios;
    }

    @ApiOperation(value = "Updates the Usuarios instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Usuarios editUsuarios(@PathVariable("id") Integer id, @RequestBody Usuarios usuarios) {
        LOGGER.debug("Editing Usuarios with id: {}" , usuarios.getId());

        usuarios.setId(id);
        usuarios = usuariosService.update(usuarios);
        LOGGER.debug("Usuarios details with id: {}" , usuarios);

        return usuarios;
    }

    @ApiOperation(value = "Deletes the Usuarios instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUsuarios(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting Usuarios with id: {}" , id);

        Usuarios deletedUsuarios = usuariosService.delete(id);

        return deletedUsuarios != null;
    }

    /**
     * @deprecated Use {@link #findUsuarios(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Usuarios instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Usuarios> searchUsuariosByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Usuarios list by query filter:{}", (Object) queryFilters);
        return usuariosService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Usuarios instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Usuarios> findUsuarios(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Usuarios list by filter:", query);
        return usuariosService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Usuarios instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Usuarios> filterUsuarios(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Usuarios list by filter", query);
        return usuariosService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUsuarios(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return usuariosService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportUsuariosAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = Usuarios.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> usuariosService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of Usuarios instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUsuarios( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Usuarios");
		return usuariosService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUsuariosAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return usuariosService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UsuariosService instance
	 */
	protected void setUsuariosService(UsuariosService service) {
		this.usuariosService = service;
	}

}