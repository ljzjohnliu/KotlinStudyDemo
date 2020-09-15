# KotlinStudyDemo

## Android Studio无法执行Java main方法的问题

    方案：修改.idea/gradle.xml文件
    Android Studio使用gradle作为构建工具，所以归根到底还是gradle配置的问题。我先找一个没问题的项目，再打开新创建的项目，对比着看他们的gradle配置。经过对比和尝试，发现.idea/gradle.xml文件内部不同，并且参照老项目进行修改是有效的。
    老项目的.idea/gradle.xml：
    <?xml version="1.0" encoding="UTF-8"?>
    <project version="4">
      <component name="GradleMigrationSettings" migrationVersion="1" />
        <component name="GradleSettings">
    <option name="linkedExternalProjectsSettings">
      <GradleProjectSettings>
        <option name="delegatedBuild" value="false" />
        <option name="testRunner" value="PLATFORM" />
        <option name="distributionType" value="DEFAULT_WRAPPED" />
        <option name="externalProjectPath" value="$PROJECT_DIR$" />
        <option name="modules">
          <set>
            <option value="$PROJECT_DIR$" />
            <option value="$PROJECT_DIR$/app" />
            ...
          </set>
        </option>
        <option name="resolveModulePerSourceSet" value="false" />
      </GradleProjectSettings>
    </option>
      </component>
      </project>
      新项目的.idea/gradle.xml:
      <?xml version="1.0" encoding="UTF-8"?>
      <project version="4">
        <component name="GradleMigrationSettings" migrationVersion="1" />
          <component name="GradleSettings">
              <option name="linkedExternalProjectsSettings">
      <GradleProjectSettings>
        <option name="testRunner" value="PLATFORM" />
        <option name="distributionType" value="DEFAULT_WRAPPED" />
        <option name="externalProjectPath" value="$PROJECT_DIR$" />
        <option name="modules">
          <set>
            <option value="$PROJECT_DIR$" />
            <option value="$PROJECT_DIR$/app" />
          </set>
        </option>
        <option name="resolveModulePerSourceSet" value="false" />
      </GradleProjectSettings>
    </option>
      </component>
      </project>
      经过对比发现，新项目的<GradleProjectSettings>标签下少了<option name="delegatedBuild" value="false" />这行配置，然后给新项目添加这行配置，运行代码发现成功了。
      根据配置的字面意思理解，这个设置的意思是不委托gradle进行构建。现实效果也是加了这行配置之后就是jvm执行Java类的main方法了，而不是gradle当做task来执行了。
