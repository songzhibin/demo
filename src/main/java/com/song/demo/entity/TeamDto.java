package com.song.demo.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class TeamDto {
    private Integer teamId;

    /**
     * 班组id
     */
    private Integer groupId;

    /**
     * 团队名称
     */
    @NotBlank(message = "团队名称不能为空")
    private String name;

    /**
     * 添加人
     */
    private String createId;

    /**
     * 修改人
     */
    private String modifyId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;

    /**
     * 状态 1-正常 2-删除
     */
    private Integer status;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 路径id用 |隔开
     */
    private String pathId;

    /**
     * 负责人
     */
    private String contactsName;

    /**
     * 负责人手机号
     */
    private String contactsMobile;
}
