
### Without Jigsaw

![text ](image/project-structure-without-jigsaw.PNG)

```bash
$ java -classpath ~/java-module-sample/target/classes com.heowc.LoggerModule
```

### With Jigsaw

![text ](image/project-structure-with-jigsaw.PNG)

```bash
$ java -p ~/java-module-sample/target/classes -m com.heowc/com.heowc.LoggerModule
```

- `-p`: `--module-path`
- `-m`: `--module`

