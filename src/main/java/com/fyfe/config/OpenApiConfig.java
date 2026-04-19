package com.fyfe.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

/**
 *  配置类 Bean（@Configuration 类）
 * 用于配置全局 API 元信息（如标题、版本、安全方案等）。直接加在 @Configuration 类上。
 *
 * 注解	作用	示例
 * @OpenAPIDefinition 定义 API 全局信息（标题、版本、联系人、许可证等）	见下方
 * @SecurityScheme 定义安全认证方案（如 JWT、OAuth2）	常与 @OpenAPIDefinition 同用
 * 示例：
 *
 * java
 * @Configuration
 * @OpenAPIDefinition(
 *     info = @Info(
 *         title = "Spring Boot User API",
 *         version = "v1.0.0",
 *         description = "用户服务 API 文档",
 *         contact = @Contact(name = "Support", email = "support@fyfe.com")
 *     )
 * )
 * @SecurityScheme(
 *     name = "BearerAuth",
 *     type = SecuritySchemeType.HTTP,
 *     scheme = "bearer",
 *     bearerFormat = "JWT"
 * )
 * public class OpenAPIConfig {
 *     // 可以空着，或者添加一些 @Bean 用于定制（如 GroupedOpenApi）
 * }
 * 4. 其他自定义 Bean（如 GroupedOpenApi）
 * 如果您需要分组（不同包/路径的接口生成独立文档），可以定义 GroupedOpenApi 的 @Bean。
 *
 * java
 * @Configuration
 * public class OpenAPIConfig {
 *
 *     @Bean
 *     public GroupedOpenApi userApi() {
 *         return GroupedOpenApi.builder()
 *                 .group("user-api")
 *                 .displayName("用户服务接口")
 *                 .pathsToMatch("/api/users/**")
 *                 .build();
 *     }
 *
 *     @Bean
 *     public GroupedOpenApi orderApi() {
 *         return GroupedOpenApi.builder()
 *                 .group("order-api")
 *                 .displayName("订单服务接口")
 *                 .pathsToMatch("/api/orders/**")
 *                 .build();
 *     }
 * }
 * 此时不需要在 application.yml 中配置 group-configs，完全用代码配置更可靠，避免之前的属性绑定错误。
 *
 * 总结：注解与 Bean 类型对照表
 * Bean 类型	常用注解	添加位置
 * Controller	@Tag, @Operation, @Parameter	类、方法、参数上
 * DTO / Entity	@Schema	类、字段上
 * Configuration 类	@OpenAPIDefinition, @SecurityScheme	类上
 * 普通 @Bean 方法（返回 GroupedOpenApi）	无需额外注解，用 builder 构建	方法上
 * 注意事项
 * 不需要在 @Service 或 @Repository 上添加任何 OpenAPI 注解，这些不会被扫描。
 *
 * springdoc-openapi 默认会扫描所有 @RestController 及其方法，即使不加任何注解也会生成基础文档（路径、方法、参数名等）。添加注解只是为了增强描述。
 *
 * 如果您之前使用了 springfox 的 @Api、@ApiOperation 等注解，需要全部替换为上面列出的 io.swagger.v3.oas.annotations 包下的注解（包名不同）。
 *
 * 如果您有具体的 Bean（比如某个配置类或某个特殊的 Controller）不确定如何添加注解，欢迎贴出代码片段，我可以给出更精准的建议。
 */

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot User API",
                version = "v1.0.0",
                description = "This is a sample Spring Boot RESTful service using springdoc-openapi.",
                contact = @Contact(
                        name = "API Support",
                        email = "support@fyfe.com"
                ),
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0")
        )
)
public class OpenApiConfig {
}