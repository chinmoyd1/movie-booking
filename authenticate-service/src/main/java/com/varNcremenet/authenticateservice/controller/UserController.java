package com.varNcremenet.authenticateservice.controller;

import com.varNcremenet.authenticateservice.commons.exception.ContextInitializationException;
import com.varNcremenet.authenticateservice.commons.context.ContextContainer;
import com.varNcremenet.authenticateservice.commons.service.context.ContextService;
import com.varNcremenet.authenticateservice.exception.UserException;
import com.varNcremenet.authenticateservice.model.User;
import com.varNcremenet.authenticateservice.model.dto.UserDTO;
import com.varNcremenet.authenticateservice.service.user.IUserManagement;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController extends ContextService {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserManagement userManagement;

    @Autowired
    private HttpServletRequest request;

    @PostMapping
    @ApiOperation(value = "Create a new User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Created", response = UserDTO.class),
            @ApiResponse(code = 201, message = "Created", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header") })
    public ResponseEntity createUser(@RequestBody User user)throws UserException{
        logger.info("\nCreating a new User.");
        return userManagement.createUser(user);
    }

    @PutMapping
    @ApiOperation(value = "Modify Current User by Token")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header") })
    public ResponseEntity modifyCurrentUserByToken(@AuthenticationPrincipal UserDetails userDetails, @RequestBody User user)throws UserException{
        logger.info("\nModifying User based on Token passed.");
        return userManagement.modifyCurrentUser(userDetails, user);
    }

    @GetMapping
    @ApiOperation(value = "Get all Users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header"),
            @ApiImplicitParam(name = "page", value = "Page", required = false, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Size", required = false, paramType = "query"),
            @ApiImplicitParam(name = "sortby", value = "Sort by", required = false, paramType = "query"),
            @ApiImplicitParam(name = "sortorder", value = "Sort order", required = false, paramType = "query") })
    public ResponseEntity getAllUsers()throws UserException,ContextInitializationException {
        logger.info("\nGetting All the Users present.");
        ContextContainer context = getContext(request);
        return userManagement.getAllUsers(context);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Modify User")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header"),
            @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "long", paramType = "path") })
    public ResponseEntity modifyUser(@PathVariable("id")long id, @RequestBody User user)throws UserException{
        logger.info("\nModifying User based on id Provided.");
        return userManagement.modifyUser(id,user);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get User by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header"),
            @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "long", paramType = "path") })
    public ResponseEntity getUser(@PathVariable("id") long id)throws UserException{
        logger.info("\nGetting a User based on id Provided.");
        return userManagement.getUser(id);
    }

}
