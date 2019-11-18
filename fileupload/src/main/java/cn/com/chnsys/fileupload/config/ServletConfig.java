package cn.com.chnsys.fileupload.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletConfigAware;

/**
 * @Class: ServletConfig
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-05 15:09
 */
@Configuration
public class ServletConfig implements ServletConfigAware {

    @Autowired
    private javax.servlet.ServletConfig servletConfig;


    @Override
    public void setServletConfig(javax.servlet.ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    public javax.servlet.ServletConfig getServletConfig() {
        return servletConfig;
    }
}

