package com.dudu.springbootdemo1.config.mybatis;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Properties;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/25 5:05 下午
 */
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        //该方法才能拦截查询sql语句
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class MyBatisInterceptor implements Interceptor {
    Properties properties = null;

    /**
     * 拦截方法逻辑
     * 这里主要是通过反射去获取要执行的SQL相关信息，然后进行操作
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs(); //方法参数
        MappedStatement mappedStatement = (MappedStatement) args[0];
        try{
            if (SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())) {
                Object paramObject = args[1];
                BoundSql boundSql = mappedStatement.getBoundSql(paramObject);
                Field sql = boundSql.getClass().getDeclaredField("sql");
                sql.setAccessible(true);
                String subSql = boundSql.getSql().substring(0,boundSql.getSql().length());
                String newSql = "select * from ("+subSql+")tmp where name = '王华'";
                sql.set(boundSql,newSql);
                if(args.length == 4) {
                    args[2] = boundSql;
                }else{
                    args[5] = boundSql;
                }
            }
        }catch (Exception exception){
           throw new RuntimeException("拦截失败");
        }finally {
            return invocation.proceed();
        }
    }

    /**
     * 生成MyBatis拦截器代理对象
     */
    @Override
    public Object plugin(Object target) {
        if(target instanceof Executor){
            // 调用插件
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * 设置插件属性（直接通过Spring的方式获取属性，所以这个方法一般也用不到）
     * 项目启动的时候数据就会被加载
     */
    @Override
    public void setProperties(Properties properties) {
        // 赋值成员变量，在其他方法使用
        this.properties = properties;
    }

}