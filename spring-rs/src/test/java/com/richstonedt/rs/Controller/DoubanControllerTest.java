package com.richstonedt.rs.Controller;

import com.richstonedt.cs.mapper.DoubanMapper;
import com.richstonedt.model.po.Douban;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoubanControllerTest {
    @Autowired
    private DoubanMapper doubanMapper;


    @Test
    public void listDouban() {
        System.out.println(("--------selectAll method test--------"));
        List<Douban> doubanList = doubanMapper.selectList(null);
        Assert.assertEquals(490,doubanList.size());
        doubanList.forEach(System.out::println);
    }
}