# SpringInitializer

### How to Use
| SpringApplicationSetting
``` java
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class <ApplicationName> {

	public static void main(String[] args) {
		// Run Spring Application with .ini Initializer
		new SpringApplicationBuilder(<ApplicationName>.class)
				.initializers(new IniConfigApplicationContextInitializer())
				.run(args);
	}

}
```

| Usage (For POJO Class) - Define Configuration Class
``` java
@ConfigurationProperties(prefix = "datasource.tag")
@Component
@Getter @Setter
public class CustomConfiguration {
    private String url;
    private String username;
    private String password;
    ...
}
```

| Usage (For Spring Class)
``` java
@Component // or Service or Bean
public class Sample {
    @Value("${datasource.tag.url}")
    private String url;
    @Value("${datasource.tag.username}")
    private String username;
    @Value("${datasource.tag.password}")
    private String password;
}
```
