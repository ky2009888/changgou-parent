package org.changgou.goods.dao;

import org.apache.ibatis.annotations.Select;
import org.changgou.goods.pojo.Spec;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:ky2009888
 * @Description:Spec的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface SpecMapper extends Mapper<Spec> {
    /**
     * 根据模板id查询规格列表
     *
     * @param templateId 模板ID
     * @return List<Spec>
     */
    @Select(" select * from tb_spec t where t.template_id = #{templateId} ")
    List<Spec> findSpecByTemplateId(Integer templateId);
}
