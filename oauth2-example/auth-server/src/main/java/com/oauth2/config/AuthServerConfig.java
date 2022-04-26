package com.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @auther gz
 * @date 2022-04-26  16:57
 * @description 授权服务配置
 */
@EnableAuthorizationServer
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 用于用户带着token访问资源服务器时，资源服务器去认证服务器来检验用户发过来的token的合法性，
        // permitAll()，标识任何客户端都可以访问  /oauth/token_check
        security.checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("gzhen")
                .secret("123456")
                .authorizedGrantTypes("authorization_code,refresh_token")
                .scopes("all")
                .redirectUris("http://localhost:9000/res/index.html");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authorizationCodeServices(authorizationCodeServices())
                .tokenServices(tokenServices(null));
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices(ClientDetailsService clientDetailsService) {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        // 配置客户端详情信息给tokenService对象
        tokenServices.setClientDetailsService(clientDetailsService);
        // 设置token保存的位置
        tokenServices.setTokenStore(tokenStore());
        // 设置token的有效时间
        tokenServices.setAccessTokenValiditySeconds(10 * 60);
        // 支持动态令牌刷新
        tokenServices.setSupportRefreshToken(true);
        // 设置刷新token的有效时间
        tokenServices.setRefreshTokenValiditySeconds(60 * 60);
        return tokenServices;
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}
