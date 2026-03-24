package com.example.petfoster.mapper;

import com.example.petfoster.entity.PetType;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetTypeMapper {
    @Select("SELECT * FROM pet_type")
    List<PetType> selectAll();

    @Select("SELECT * FROM pet_type WHERE id = #{id}")
    PetType selectById(Long id);
}