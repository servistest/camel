package com.dozerannotation;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alex on 31.3.17.
 */
public class DozerExampleAnnotation {

    public static void main(String[] args) {
        Logger log= LoggerFactory.getLogger(DozerExampleAnnotation.class);

        DozerBeanMapper mapper =new DozerBeanMapper();

        User user=new User("Alexander","Smirnov",new Date());
        TargetUser targetUser=mapper.map(user,TargetUser.class);

        log.info("source user = {} ", user);
        log.info("target user = {}" ,targetUser);


    }
}
