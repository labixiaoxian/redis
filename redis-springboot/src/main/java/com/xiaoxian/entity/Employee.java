package com.xiaoxian.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 小贤
 * @PackageName:entity
 * @ClassName:Employee
 * @Description:
 * @date 2021/1/27 13:59
 */
@Data
@Accessors(chain = true)
public class Employee implements Serializable {
    private String id;
    private String name;
}
