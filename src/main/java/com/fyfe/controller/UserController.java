package com.fyfe.controller;

import com.fyfe.beans.Result;
import com.fyfe.beans.User;
import com.fyfe.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 这些注解直接加在 @RestController 或 @Controller 类及其方法上。
 * 注解	作用	添加位置	示例
 * @Tag 描述 Controller 分组（相当于 swagger 的 @Api）	类上	@Tag(name = "用户管理", description = "用户相关接口")
 * @Operation 描述一个 API 接口（相当于 @ApiOperation）	方法上	@Operation(summary = "查询用户", description = "根据ID获取用户详情")
 * @Parameter 描述方法参数（路径参数、请求参数等）	方法参数前	@Parameter(description = "用户ID", example = "1001") @PathVariable Long id
 * @Parameters 多个 @Parameter 的容器	方法上（包裹多个 @Parameter）	少见，通常直接用多个 @Parameter 在参数上
 * @RequestBody 结合 @Schema	描述请求体结构	实体类属性上	见下方 DTO 部分
 *
 * @RestController
 * @RequestMapping("/api/users")
 * @Tag(name = "用户管理", description = "提供用户的增删改查接口")
 * public class UserController {
 *
 *     @GetMapping("/{id}")
 *     @Operation(summary = "根据ID查询用户", description = "路径参数为用户唯一标识")
 *     public User getUser(
 *             @Parameter(description = "用户ID", example = "1001", required = true)
 *             @PathVariable Long id) {
 *         return userService.getById(id);
 *     }
 *
 *     @PostMapping
 *     @Operation(summary = "创建新用户")
 *     public User createUser(@RequestBody User user) {
 *         return userService.create(user);
 *     }
 * }
 */


@RestController
@RequestMapping("/user")
@Tag(name = "用户管理", description = "提供用户的增删改查接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @Operation(summary = "根据ID查询用户", description = "通过用户ID获取用户详细信息")
    public Result getUser(@PathVariable("id") Integer id) {
        User user = userService.getUserById(1);
        return  Result.buildSuccess(user, "查询成功");
    }

    // 新增 /user/add
    // RequestBody表示只能接收JSON数据，否则接收表单数据
    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        userService.add(user);
        return Result.buildSuccess("添加成功");
    }

    // 修改 /user1
    @PostMapping("/update")
    public Result editUser(@RequestBody User user) {
        userService.update(user);
        return Result.buildSuccess("修改成功");
    }

    // 删除 /user1
    @DeleteMapping("/{id}")
    public Result editUser(@PathVariable Integer id) {
        userService.delete(id);
        return Result.buildSuccess("删除成功");
    }
}
