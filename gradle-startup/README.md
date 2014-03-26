# What

# Why

# How

## Download and install
    - http://www.gradle.org/downloads
    - set GRADLE_HOME/bin to your PATH environment variable
        * GRADLE_HOME=''
        * PATH==



## gradle --help
```groovy
➜  /home/depeng  >gradle --help

USAGE: gradle [option...] [task...]

-?, -h, --help          帮助
-a, --no-rebuild        不重新编译依赖
-b, --build-file        指定build file
-C, --cache             Specifies how compiled build scripts should be cached. Possible values are: 'rebuild' and 'on'. Default value is 'on' [deprecated - Use '--rerun-tasks' or '--recompile-scripts' instead]
-c, --settings-file     指定settings file.
--configure-on-demand   仅跑相关项目？Only relevant projects are configured in this build run. This means faster build for large multi-project builds. [incubating]
--continue              忽略失败的task，继续往下跑
-D, --system-prop       设JVM属性(e.g. -Dmyprop=myvalue).
-d, --debug             ‘第八个’模式

--daemon                Uses the Gradle daemon to run the build. Starts the daemon if not running.
--no-daemon             Do not use the Gradle daemon to run the build.

--foreground            Starts the Gradle daemon in the foreground. [incubating]
-g, --gradle-user-home  指名Specifies the gradle user home directory.
--gui                   开个GUI
-I, --init-script       指定初始化脚本
-i, --info              设置日记等级位INFO
-m, --dry-run           build但是不跑task （Runs the builds with all task actions disabled.）
--no-color              色盲

--no-opt                忽略task优化. [deprecated - Use '--rerun-tasks' instead]
--offline               强制声明不联网操作

-P, --project-prop      Set project property for the build script (e.g. -Pmyprop=myvalue).
-p, --project-dir       Specifies the start directory for Gradle. Defaults to current directory.

--parallel              并行编译。Build projects in parallel. Gradle will attempt to determine the optimal number of executor threads to use. [incubating]
--parallel-threads      并行编译，指定线程，难道不是并发？。Build projects in parallel, using the specified number of executor threads. [incubating]

--profile               生成profile报告。Profiles build execution time and generates a report in the <build_dir>/reports/profile directory.
--project-cache-dir     Specifies the project-specific cache directory. Defaults to .gradle in the root project directory.

-q, --quiet             静悄悄的。仅仅打印错误日记。 Log errors only.
--recompile-scripts     强制重新编译脚本。 Force build script recompiling.

--refresh               刷新依赖。Refresh the state of resources of the type(s) specified. Currently only 'dependencies' is supported. [deprecated - Use '--refresh-dependencies' instead.]
--refresh-dependencies  刷新依赖。Refresh the state of dependencies.

--rerun-tasks           忽略之前缓存的任务结果。

-S, --full-stacktrace   Print out the full (very verbose) stacktrace for all exceptions.
-s, --stacktrace        Print out the stacktrace for all exceptions.

--stop                  Stops the Gradle daemon if it is running.
-u, --no-search-upward  Don't search in parent folders for a settings.gradle file.
-v, --version           Print version info.
-x, --exclude-task      Specify a task to be excluded from execution.

```