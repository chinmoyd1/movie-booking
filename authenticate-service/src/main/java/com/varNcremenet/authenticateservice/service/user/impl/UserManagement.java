package com.varNcremenet.authenticateservice.service.user.impl;

import com.varNcremenet.authenticateservice.commons.exception.ContextInitializationException;
import com.varNcremenet.authenticateservice.commons.context.ContextContainer;
import com.varNcremenet.authenticateservice.commons.model.Pagination;
import com.varNcremenet.authenticateservice.commons.model.dto.GenericDTO;
import com.varNcremenet.authenticateservice.commons.service.filter.FilterService;
import com.varNcremenet.authenticateservice.commons.service.paginationsorting.PaginationSortingService;
import com.varNcremenet.authenticateservice.commons.util.DtoUtils;
import com.varNcremenet.authenticateservice.dao.UserDAO;
import com.varNcremenet.authenticateservice.exception.UserException;
import com.varNcremenet.authenticateservice.model.User;
import com.varNcremenet.authenticateservice.model.dto.UserDTO;
import com.varNcremenet.authenticateservice.commons.wrapper.GenericResult;
import com.varNcremenet.authenticateservice.service.user.IUserManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserManagement implements IUserManagement {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FilterService filterService;

    @Autowired
    private PaginationSortingService paginationSortingService;

    private static final Logger logger = LoggerFactory.getLogger(UserManagement.class);

    @Override
    public ResponseEntity createUser(User user) throws UserException {
        logger.debug("Inside Method [createUser]");
        GenericResult genericResult = new GenericResult();

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userDAO.save(user);
        logger.info("User Created Successfully with id ["+user.getId()+"]");

        genericResult.setStatus("Success");
        genericResult.setHttpStatus(HttpStatus.CREATED);
        genericResult.setResult(new DtoUtils().convertToDto(user, new UserDTO()));
        return genericResult.getGenericResult();
    }

    @Override
    public ResponseEntity modifyCurrentUser(UserDetails userDetails, User data)throws UserException {
        logger.debug("Inside Method [modifyCurrentUser]");
        Optional<User> user = this.userDAO.findByUsername(userDetails.getUsername());

        GenericResult genericResult = new GenericResult();

        if (user.isPresent()){

            if (data.getPassword() != null) {
                user.get().setPassword(passwordEncoder.encode(data.getPassword()));
            }
            if (data.getUsername() != null) {
                user.get().setUsername(data.getUsername());
            }
            this.userDAO.save(user.get());
            logger.info("User Modified Successfully with id ["+user.get().getId()+"]");

            genericResult.setStatus("Success");
            genericResult.setHttpStatus(HttpStatus.OK);
            genericResult.setResult(new DtoUtils().convertToDto(user.get(), new UserDTO()));
            return genericResult.getGenericResult();
        }
        genericResult.setStatus("Failure");
        genericResult.setHttpStatus(HttpStatus.NOT_FOUND);
        logger.info("No User found with id ["+user.get().getId()+"]");
        genericResult.setMessage("No User found");
        return genericResult.getGenericResult();
    }

    @Override
    public ResponseEntity getAllUsers(ContextContainer context)throws ContextInitializationException, UserException{
        logger.debug("Inside Method [getAllUsers]");
        List<GenericDTO> genericDTOs = new ArrayList<GenericDTO>();
        GenericResult genericResult = new GenericResult();

        Specification<User> specification = filterService.getProcessedFilter(context.getFilterContext().getFilter());
        Pageable pageable = paginationSortingService.getPageableFilter(context.getPaginationSortingContext());

        Page<User> users = this.userDAO.findAll(specification,pageable);

        users.stream()
                    .forEach(user -> genericDTOs.add(new DtoUtils().convertToDto(user, new UserDTO())));

        logger.info("All Users fetched Successfully.");

        Pagination pagination = new Pagination();
        pagination.setPage(context.getPaginationSortingContext().getLongPage());
        pagination.setSize(context.getPaginationSortingContext().getLongSize());
        pagination.setTotalelements(users.getTotalElements());
        pagination.setTotalpages(users.getTotalPages());

        genericResult.setStatus("Success");
        genericResult.setHttpStatus(HttpStatus.OK);
        genericResult.setPagination(pagination);
        genericResult.setResult(genericDTOs);
        return genericResult.getGenericResult();
    }

    @Override
    public ResponseEntity modifyUser(long id, User data)throws UserException{
        logger.debug("Inside Method [modifyUser]");
        Optional<User> user = this.userDAO.findById(id);
        GenericResult genericResult = new GenericResult();

        if(user.isPresent()){
            if(!data.getRoles().isEmpty()) {
                user.get().setRoles(Stream.concat(
                        data.getRoles().stream().distinct(),
                        user.get().getRoles().stream().distinct()).distinct().collect(Collectors.toList()));
            }
            if(data.getPassword() != null){
                user.get().setPassword(passwordEncoder.encode(data.getPassword()));
            }
            if(data.getUsername() != null){
                user.get().setUsername(data.getUsername());
            }
            this.userDAO.save(user.get());
            logger.info("User Modified Successfully with id ["+user.get().getId()+"]");

            genericResult.setStatus("Success");
            genericResult.setHttpStatus(HttpStatus.OK);
            genericResult.setResult(new DtoUtils().convertToDto(user.get(), new UserDTO()));
            return genericResult.getGenericResult();
        }
        genericResult.setStatus("Failure");
        genericResult.setHttpStatus(HttpStatus.NOT_FOUND);
        logger.info("No User found with id ["+id+"]");
        genericResult.setMessage("No User found with id: "+id);
        return genericResult.getGenericResult();
    }

    @Override
    public ResponseEntity getUser(long id)throws UserException{
        logger.debug("Inside Method [getUser]");
        Optional<User> user = this.userDAO.findById(id);
        GenericResult genericResult = new GenericResult();

        if(!user.isPresent()){
            logger.info("No User found with id ["+id+"]");
            genericResult.setStatus("Failure");
            genericResult.setHttpStatus(HttpStatus.NOT_FOUND);
            genericResult.setMessage("No User found with id: "+id);
            return genericResult.getGenericResult();
        }

        logger.info("User fetched Successfully with id ["+user.get().getId()+"]");

        genericResult.setStatus("Success");
        genericResult.setHttpStatus(HttpStatus.OK);
        genericResult.setResult(new DtoUtils().convertToDto(user.get(), new UserDTO()));
        return genericResult.getGenericResult();
    }
}
