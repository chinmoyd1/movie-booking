package com.varNcremenet.authenticateservice.controller;

import com.varNcremenet.authenticateservice.commons.service.context.ContextService;
import com.varNcremenet.authenticateservice.commons.wrapper.GenericResult;
import com.varNcremenet.authenticateservice.exception.UserException;
import com.varNcremenet.authenticateservice.model.dto.AuthenticationDTO;
import com.varNcremenet.authenticateservice.model.dto.UserDTO;
import com.varNcremenet.authenticateservice.service.auth.IAuthManagement;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"Authentication"})
@RestController
@RequestMapping("/auth")
public class AuthController extends ContextService {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    IAuthManagement authManagement;

    @PostMapping("/token")
    @ApiOperation(value = "Create a new Token")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = UserDTO.class),
            @ApiResponse(code = 201, message = "Created", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity getToken(@RequestBody AuthenticationDTO data) throws UserException {
        logger.info("\nCreating a new Token for user from credentials passed.");

        GenericResult genericResult = new GenericResult();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(data.getUsername());
        userDTO.setToken(authManagement.getToken(data));

        genericResult.setStatus("Success");
        genericResult.setHttpStatus(HttpStatus.OK);
        genericResult.setResult(userDTO);

        return genericResult.getGenericResult();
    }

    @GetMapping("/token")
    @ApiOperation(value = "Get Current User from Token")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = UserDTO.class),
            @ApiResponse(code = 200, message = "OK", response = UserDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header") })
    public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails)throws UserException{
        logger.info("\nGetting Current for user details from token passed.");
        return authManagement.getCurrentUser(userDetails);
    }
}