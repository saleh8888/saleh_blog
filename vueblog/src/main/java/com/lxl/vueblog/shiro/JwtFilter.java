package com.lxl.vueblog.shiro;

import cn.hutool.json.JSONUtil;
import com.lxl.vueblog.common.Result;
import com.lxl.vueblog.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends AuthenticatingFilter {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        String jwt =request.getHeader("Authorization");
        if(StringUtils.isEmpty(jwt)){
            return null;
        }
            return new JwtToken(jwt);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        String jwt =request.getHeader("Authorization");
        if(StringUtils.isEmpty(jwt)){
            return true;
        }else {
            //校验
            Claims claim =jwtUtils.getClaimByToken(jwt);
            if(claim==null || jwtUtils.isTokenExpired(claim.getExpiration())){
                throw new ExpiredCredentialsException("token已失效，请重新登录");
            }
            //执行登录
            return executeLogin(servletRequest,servletResponse);
        }
    }
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response){
        HttpServletResponse httpServletResponse= (HttpServletResponse)response;
        Throwable throwable = e.getCause()==null?e:e.getCause();
        Result result = Result.fail(throwable.getMessage());
        String json = JSONUtil.toJsonStr(result);

        try {
            httpServletResponse.getWriter().print(json);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return false;
    }
}
