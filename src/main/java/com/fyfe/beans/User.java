package com.fyfe.beans;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * DTO / Model Bean（数据传输对象/实体类）
 * 用于描述请求体、响应体的字段含义。使用 @Schema 注解。
 *
 * 注解	作用	添加位置	示例
 * @Schema 描述模型、字段、属性	类、属性、枚举等	@Schema(description = "用户ID", example = "1001")
 *
 * @Schema(description = "用户实体")
 * public class User {
 *     @Schema(description = "用户唯一标识", example = "1001", required = true)
 *     private Long id;
 *
 *     @Schema(description = "用户名", example = "张三", minLength = 2, maxLength = 20)
 *     private String username;
 *
 *     @Schema(description = "邮箱", format = "email", example = "zhangsan@example.com")
 *     private String email;
 *     // getter/setter...
 * }
 */

@Data
@Schema(description = "用户实体")
public class User {
    @Schema(description = "用户唯一标识", example = "1001", required = true)
    private Integer id;
    private String name;
    private Integer age;
}
