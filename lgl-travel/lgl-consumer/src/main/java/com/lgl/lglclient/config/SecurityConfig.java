//package com.lgl.lglclient.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity//开启Spring Security对WebMVC的支持
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        //设置X-Frame-Options响应头为SAMEORIGIN
//        http.headers().frameOptions().sameOrigin();
//        //放行不用权限的资源（去登录页面当然不需要用权限，否则你都看不到登录界面，还怎么登录，所以去登录界面必须放行）
//        http.authorizeRequests().antMatchers("/toLogin","/desAll").permitAll();
//        //设置自定义登录界面
//        http.formLogin()//启用表单登录
//                .loginPage("/tologin")//登录页面地址，只要你还没登录，默认就会来到这里
//                .loginProcessingUrl("/loginna")//登录处理程序，Spring Security内置控制器方法
//                .usernameParameter("username")//登录表单form中用户名输入框input的name名，不修改的话默认是username
//                .passwordParameter("password")//登录表单form中密码框输入框input的name名，不修改的话默认是password
//                .defaultSuccessUrl("/desAll")//登录认证成功后默认转跳的路径
//                //.successForwardUrl("/main")//登录成功跳转地址，使用的是请求转发
//                .failureForwardUrl("/tologin")//登录失败跳转地址，使用的是请求转发
//                .permitAll();
//        //设置自定义登出界面
//        http.logout()//启用退出登录
//                .logoutUrl("/logoutProcess")//退出处理程序，Spring Security内置控制器方法，(即前端登出请求地址)
//                .logoutSuccessUrl("/login")//退出成功跳转地址
//                .invalidateHttpSession(true)//清除当前会话
//                .deleteCookies("JSESSIONID")//删除当前Cookie
//                .permitAll();
//        http.csrf().disable();
//
//    }
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        //配置不被拦截的系统资源
//        web.ignoring().antMatchers("/css/**");
//        web.ignoring().antMatchers("/images/**");
//        web.ignoring().antMatchers("/js/**");
//        web.ignoring().antMatchers("/fonts/**");
//        web.ignoring().antMatchers("/error");
////        web.ignoring().antMatchers("/swagger-ui.html#/");
////        web.ignoring().antMatchers("/scenic_list.html");
//
//    }
//
//
//}
