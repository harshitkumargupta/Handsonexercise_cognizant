# Code Quality and SonarQube

To integrate SonarQube, add the `sonar-maven-plugin` to your `pom.xml` build section:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.sonarsource.scanner.maven</groupId>
            <artifactId>sonar-maven-plugin</artifactId>
            <version>3.9.1.2184</version>
        </plugin>
    </plugins>
</build>
```

Run the analysis using:
`mvn clean verify sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=YOUR_TOKEN`
