package com.kgc.filter;

import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() {
        System.out.println("进入过滤器");
        //根据请求参数判断token
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(token==null || token.equals("")){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            //给用户提示
            currentContext.setResponseBody("no token");
            return "fail";
        }
        return "pass";
    }
}
