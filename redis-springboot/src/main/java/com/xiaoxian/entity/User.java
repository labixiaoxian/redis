package com.xiaoxian.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 小贤
 * @PackageName:entity
 * @ClassName:User
 * @Description:
 * @date 2021/1/26 15:46
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private Date bir;
}
