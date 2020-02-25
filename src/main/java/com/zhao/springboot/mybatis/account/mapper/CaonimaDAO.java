package com.zhao.springboot.mybatis.account.mapper;

import com.zhao.springboot.mybatis.account.domain.Caonima;
import com.zhao.springboot.mybatis.account.domain.CaonimaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CaonimaDAO {
    long countByExample(CaonimaExample example);

    int deleteByExample(CaonimaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Caonima record);

    int insertSelective(Caonima record);

    List<Caonima> selectByExample(CaonimaExample example);

    Caonima selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Caonima record, @Param("example") CaonimaExample example);

    int updateByExample(@Param("record") Caonima record, @Param("example") CaonimaExample example);

    int updateByPrimaryKeySelective(Caonima record);

    int updateByPrimaryKey(Caonima record);
}