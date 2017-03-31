package com.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alex on 31.3.17.
 */
public class DozerExample {

    public static void main(String[] args) {
        Logger log= LoggerFactory.getLogger(DozerExample.class);


        List mappingFilesList=new ArrayList();
        mappingFilesList.add("dozer-mapper.xml");

        DozerBeanMapper mapper =new DozerBeanMapper();
        mapper.setMappingFiles(mappingFilesList);

        User user=new User("Alexander","Smirnov",new Date());
        TargetUser targetUser=mapper.map(user,TargetUser.class);

        log.info("source user = {} ", user);
        log.info("target user = {}" ,targetUser);


    }
}
