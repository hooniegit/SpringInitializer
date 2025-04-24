# SpringInitializer

### How to Use
1. SpringApplicationSetting
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

2. Usage
``` java


```
