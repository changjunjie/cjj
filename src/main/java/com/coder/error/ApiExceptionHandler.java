package com.coder.error;

import com.coder.entity.base.WebRspEntity;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 *
 * @author changjunjie
 * @since 26.05.2017
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseException defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {

        return new BaseException(-1, e.getMessage());
    }

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public WebRspEntity<String> jsonErrorHandler(BaseException e) throws Exception {
        return new WebRspEntity(e);
    }

}

