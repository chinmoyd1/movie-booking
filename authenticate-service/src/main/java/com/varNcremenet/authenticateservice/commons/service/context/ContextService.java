package com.varNcremenet.authenticateservice.commons.service.context;

import com.varNcremenet.authenticateservice.commons.exception.ContextInitializationException;
import com.varNcremenet.authenticateservice.commons.context.ContextContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class ContextService {
    private static final Logger logger = LoggerFactory.getLogger(ContextService.class);

    protected ContextContainer getContext(HttpServletRequest request) throws ContextInitializationException {
        logger.debug("Getting context saved in Context Container.");

        if(null != request) {
            ContextContainer context = (ContextContainer) request.getAttribute(ContextContainer.CONTEXT_CONTAINER);
            if(null == context) {

                throw new ContextInitializationException("Request Parameters retreival error.");
            }
            return context;
        }
        else {
            throw new ContextInitializationException("HTTP Request Object is Null.");
        }
    }
}
