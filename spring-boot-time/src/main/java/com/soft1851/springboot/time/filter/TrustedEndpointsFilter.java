package com.soft1851.springboot.time.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Johnny
 * @Date: 2020/5/18 09:37
 * @Description:
 */
@Slf4j
public class TrustedEndpointsFilter implements Filter {

    private int trustedPortNum = 0;
    private String trustedPathPrefix;


    public TrustedEndpointsFilter(String trustedPort, String trustedPathPrefix) {
        if (trustedPort != null && trustedPathPrefix != null && !"null".equals(trustedPathPrefix)) {
            trustedPortNum = Integer.valueOf(trustedPort);
            this.trustedPathPrefix = trustedPathPrefix;
        }
    }

    /**
     * 判断请求是外部接口还是内部接口
     * @param servletRequest
     * @return
     */
    private boolean isRequestForTrustedEndpoint(ServletRequest servletRequest) {
        return ((RequestFacade) servletRequest).getRequestURI().startsWith(trustedPathPrefix);
    }

        @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入过滤器");
        if (trustedPortNum != 0) {
            // 通过外部端口试图访问内部接口，拒绝请求
            if (isRequestForTrustedEndpoint(servletRequest) && servletRequest.getLocalPort() != trustedPortNum) {
                log.warn("通过外部端口试图访问内部接口，拒绝请求");
                ((ResponseFacade) servletResponse).setStatus(404);
                servletResponse.getOutputStream().close();
                return;
            }

            // 通过内部端口试图访问外部接口，拒绝请求
            if (!isRequestForTrustedEndpoint(servletRequest) && servletRequest.getLocalPort() == trustedPortNum) {
                log.warn("通过内部端口试图访问外部接口，拒绝请求");
                ((ResponseFacade) servletResponse).setStatus(404);
                servletResponse.getOutputStream().close();
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
