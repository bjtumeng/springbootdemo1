package com.dudu.springbootdemo1.check;

import com.dudu.springbootdemo1.domain.User;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/16 11:28 上午
 */
@Slf4j
public class UserValidation<T extends Annotation> implements ConstraintValidator<T, User> {

    protected Predicate<User> predicate = c -> true;

//    @Resource
//    protected UserRepository userRepository;

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
//        return userRepository == null || predicate.test(user);
        return true;
    }

    /**
     * 校验用户是否唯一
     * 即判断数据库是否存在当前新用户的信息，如用户名，手机，邮箱
     */
    public static class UniqueUserValidator extends UserValidation<UniqueUser>{
        @Override
        public void initialize(UniqueUser uniqueUser) {
//            predicate = c -> !userRepository.existsByUserNameOrEmailOrTelphone(c.getUserName(),c.getEmail(),c.getTelphone());
        }
    }

    /**
     * 校验是否与其他用户冲突
     * 将用户名、邮件、电话改成与现有完全不重复的，或者只与自己重复的，就不算冲突
     */
    public static class NotConflictUserValidator extends UserValidation<NotConflictUser>{
        @Override
        public void initialize(NotConflictUser notConflictUser) {
            predicate = c -> {
                log.info("user detail is {}",c);
//                List<String> collection = new ArrayList<>();
//                Collection<User> collection = userRepository.findByUserNameOrEmailOrTelphone(c.getUserName(), c.getEmail(), c.getTelphone());
                // 将用户名、邮件、电话改成与现有完全不重复的，或者只与自己重复的，就不算冲突
                return true;
//                return collection.isEmpty() || (collection.size() == 1 && collection.iterator().next().getId().equals(c.getId()));
            };
        }
    }

}
