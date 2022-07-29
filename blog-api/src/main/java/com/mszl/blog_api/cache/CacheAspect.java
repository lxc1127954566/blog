package com.mszl.blog_api.cache;


import com.alibaba.fastjson.JSON;
import com.mszl.blog_api.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import java.lang.reflect.Method;
import java.time.Duration;

//aop 定义一个切面，切面定义一个切点和通知的关系
@Aspect
@Component
@Slf4j
public class CacheAspect {

    @Autowired
    private RedisTemplate<String,String > redisTemplate;

    @Pointcut("@annotation(com.mszl.blog_api.cache.Cache)")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        try {
            Signature signature = pjp.getSignature();

            String className = pjp.getTarget().getClass().getSimpleName();

            String methodName = signature.getName();

            Class[] parameterTypes = new Class[pjp.getArgs().length];
            Object[] args = pjp.getArgs();

            String params = "";
            for (int i = 0; i < args.length; i++) {
                if (args[i] != null) {
                    params += JSON.toJSONString(args[i]);
                    parameterTypes[i] = args[i].getClass();
                } else {
                    parameterTypes[i] = null;
                }
            }
            if (StringUtils.isEmpty(params)) {
                params = DigestUtils.md5Hex(params);
            }
            //获取方法
            Method method = pjp.getSignature().getDeclaringType().getMethod(methodName, parameterTypes);
            //获取缓存对象
            Cache annotation = method.getAnnotation(Cache.class);
            //获取过期时常
            long expire = annotation.expire();
            String name = annotation.name();
            String redisKey = name + ":" + className + ":" + methodName + ":" + params;

            //获取缓存参数
            String redisValue = redisTemplate.opsForValue().get(redisKey);
            /*
            * 判断redisValue值是否为空
            * 不为空   解析缓存记录
            * 为空    记录数据到缓存中
            * */
            if (StringUtils.isNotEmpty(redisValue)){
                log.info("走了缓存-----{}:{}",className,methodName);
                System.out.println(JSON.parseObject(redisValue, Result.class));
                return JSON.parseObject(redisValue, Result.class);
            }
            Object proceed = pjp.proceed();
            redisTemplate.opsForValue().set(redisKey, JSON.toJSONString(proceed), Duration.ofMillis(expire));
            log.info("存入缓存-----{}:{}",className,methodName);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return Result.fail(-999,"系统错误");
    }
}
