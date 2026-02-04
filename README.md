# Pitest History Plugin

Adds support for basic incremental analysis to Pitest.

This functionality was originally included in the main pitest codebase, but has been moved to this plugin
for easier maintenance.

## Usage

Install the plugin as described below. Incremental analysis can then be enabled as described in the 
[Incremental Analysis](https://pitest.org/quickstart/incremental_analysis/) section of the pitest website.

### Maven

```xml
    <plugins>
      <plugin>
        <groupId>org.pitest</groupId>
        <artifactId>pitest-maven</artifactId>
        <version>1.23.0</version>
        <dependencies>
          <dependency>
            <groupId>org.pitest</groupId>
            <artifactId>pitest-history</artifactId>
            <version>0.0.1</version>
          </dependency>
        </dependencies>
      </plugin>
   </plugins>
```

