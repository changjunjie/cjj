package com.coder.mapper.user;

import com.coder.entity.User;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {

    //    @OptimisticLock(expect = 1)
    int updateSelective(User user);


    /**
     * 插入记录
     *
     * @param record
     * @param <T>
     * @return
     */
    <T> int insert(T record);

    /**
     * 插入记录
     *
     * @param obj
     * @return int
     */
    int insertBySelect(Object obj);

    /**
     * 根据主键修改全部属性
     *
     * @param record
     * @return int
     */
    <T> int updateByPrimaryKey(T record);

    /**
     * 根据条件修改有效数据
     *
     * @param record
     * @return int
     */
    <T> int updateSelective(T record);

    /**
     * 根据条件修改数据
     *
     * @param param
     * @return int
     */
    int update(Map<String, Object> param);

    /**
     * 根据条件修改数据
     *
     * @param record
     * @return int
     */
    <T> int update(T record);

    /**
     * 根据主键删除
     *
     * @param key
     * @return int
     */
    int deleteByPrimaryKey(Object key);

    /**
     * 根据主键删除
     *
     * @param keys
     * @return int
     */
    int deleteInPrimaryKey(List<Object> keys);

    /**
     * 根据条件删除
     *
     * @param key
     * @return int
     */
    int delete(Object key);

    /**
     * 根据主键查询单一记录
     *
     * @param key
     * @return T
     */
    <T> T selectByPrimaryKey(Object key);


    /**
     * 根据条件查询多条记录
     *
     * @param param
     * @return List<T>
     */
    <T> List<T> select(Map<String, Object> param);

    /**
     * 根据条件查询多条记录，带分页
     *
     * @param param
     * @param rowRound
     * @return List<T>
     */
    <T> List<T> select(Map<String, Object> param, RowBounds rowRound);

    /**
     * 根据条件查询多条记录，带分页
     *
     * @param record
     * @param rowRound
     * @return List<T>
     */
    <T> List<T> select(T record, RowBounds rowRound);


    /**
     * 根据条件查询多条记录
     *
     * @param record
     * @return List<T>
     */
    <T> List<T> select(T record);

    /**
     * 批量插入
     *
     * @param entitys
     * @return int
     */
    <T> int insertBatch(List<T> entitys);

    /**
     * 批量修改
     *
     * @param entitys
     * @return int
     */
    <T> int updateBatch(List<T> entitys);

    /**
     * 批量删除
     *
     * @param entitys
     * @return int
     */
    <T> int deleteBatch(List<T> entitys);

}