package io.github.opencubicchunks.gradle.fgfix;

import net.minecraftforge.gradle.user.patcherUser.PatcherUserConstants;
import net.minecraftforge.gradle.user.patcherUser.forge.ForgePlugin;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.javadoc.Javadoc;

public class ForgePluginFixed extends ForgePlugin {
    @Override protected void configureCompilation() {
        JavaPluginConvention javaConv = (JavaPluginConvention)this.project.getConvention().getPlugins().get("java");
        SourceSet main = javaConv.getSourceSets().getByName("main");
        SourceSet test = javaConv.getSourceSets().getByName("test");
        SourceSet api = javaConv.getSourceSets().create("api");
        api.setCompileClasspath(api.getCompileClasspath().plus(this.project.getConfigurations().getByName("forgeGradleMc")).plus(this.project.getConfigurations().getByName("forgeGradleMcDeps")).plus(this.project.getConfigurations().getByName("provided")));
        main.setCompileClasspath(main.getCompileClasspath().plus(api.getOutput()).plus(this.project.getConfigurations().getByName("forgeGradleMc")).plus(this.project.getConfigurations().getByName("forgeGradleMcDeps")).plus(this.project.getConfigurations().getByName("provided")));
        main.setRuntimeClasspath(main.getRuntimeClasspath().plus(api.getOutput()).plus(this.project.getConfigurations().getByName("forgeGradleMc")).plus(this.project.getConfigurations().getByName("forgeGradleMcDeps")).plus(this.project.getConfigurations().getByName("forgeGradleGradleStart")));
        test.setCompileClasspath(test.getCompileClasspath().plus(api.getOutput()).plus(this.project.getConfigurations().getByName("forgeGradleMc")).plus(this.project.getConfigurations().getByName("forgeGradleMcDeps")).plus(this.project.getConfigurations().getByName("provided")));
        test.setRuntimeClasspath(test.getRuntimeClasspath().plus(api.getOutput()).plus(this.project.getConfigurations().getByName("forgeGradleMc")).plus(this.project.getConfigurations().getByName("forgeGradleMcDeps")));
        this.project.getConfigurations().getByName("compile").extendsFrom(this.project.getConfigurations().getByName("forgeGradleResolvedDeobfCompile"));
        this.project.getConfigurations().getByName("provided").extendsFrom(this.project.getConfigurations().getByName("forgeGradleResovledDeobfProvided"));
        this.project.getConfigurations().getByName(api.getCompileConfigurationName()).extendsFrom(this.project.getConfigurations().getByName("compile"));
        this.project.getConfigurations().getByName("testCompile").extendsFrom(this.project.getConfigurations().getByName("apiCompile"));
        Javadoc javadoc = (Javadoc)this.project.getTasks().getByName("javadoc");
        javadoc.setClasspath(main.getOutput().plus(main.getCompileClasspath()));
        this.project.getDependencies().add("compile", this.project.fileTree("libs"));
        javaConv.setSourceCompatibility("1.8");
        javaConv.setTargetCompatibility("1.8");
    }
}