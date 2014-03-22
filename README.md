Sorry, This project is only the translation of Japanese ;-(

## Java Samples

主にJava8を学ぶために作成したスタンドアローンアプリケーションの雛形用プロジェクトです。  
(ブランチベースで学んだサンプルを随時追加予定)

こちらは[Maven Archetype][original-archetype]としても公開してます。  
Java8のMavenプロジェクトが今すぐ作成できます。

### 実行環境

* [JDK8][jdk8]
* [Maven3][maven]

### ビルドとアプリ実行

```shell
mvn clean package -Djava.mainClass=com.ogaclejapan.Bootstrap
java -jar target/java-samples-1.0.0-jar-with-dependencies.jar
```

[jdk8]: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[maven]: http://maven.apache.org/download.cgi
[original-archetype]: http://github.com/ogaclejapan/maven-archetypes
