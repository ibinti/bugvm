package com.bugvm.gradle;

import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class DownConfiguration {

    private static final String DEPENDENCY_GROUP = "com.gluonhq";
    private static final String DEPENDENCY_NAME_PREFIX = "charm-down-plugin-";
    private static final Map<String, String> DEPENDENCY_NAME_SUFFIXES = new HashMap<>();
    static {
        DEPENDENCY_NAME_SUFFIXES.put("compile", "");
        DEPENDENCY_NAME_SUFFIXES.put("androidRuntime", "-android");
        DEPENDENCY_NAME_SUFFIXES.put("iosRuntime", "-ios");
        DEPENDENCY_NAME_SUFFIXES.put("desktopRuntime", "-desktop");
        DEPENDENCY_NAME_SUFFIXES.put("embeddedRuntime", "-desktop");
    }

    private Project project;

    private String version = "3.0.0";
    private NamedDomainObjectContainer<DownPluginDefinition> plugins;

    public DownConfiguration(Project project) {
        this.project = project;
        this.plugins = project.container(DownPluginDefinition.class);
    }

    public void version(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Collection<DownPluginDefinition> getPlugins() {
        return plugins;
    }

    public void plugins(String... plugins) {
        if (plugins != null) {
            for (String plugin : plugins) {
                this.plugins.create(plugin);
            }
        }
    }

    /**
     * Configures down plugins.
     */
    public void plugins(Action<? super NamedDomainObjectContainer<DownPluginDefinition>> action) {
        action.execute(plugins);
    }

    /**
     * Add dependencies to the specified configuration. Only dependencies to plugins that support the provided
     * configuration will be included.
     *
     * @param configuration the configuration where the plugin dependencies are added to
     */
    public void applyConfiguration(Configuration configuration) {
        if (plugins != null) {
            plugins.stream()
                    .filter(pluginDefinition -> pluginDefinition.isConfigurationSupported(configuration))
                    .forEach(pluginDefinition -> project.getDependencies().add(configuration.getName(), generateDependencyNotation(configuration, pluginDefinition)));
        }
    }

    private Object generateDependencyNotation(Configuration configuration, DownPluginDefinition pluginDefinition) {
        Map<String, String> dependencyNotationMap = new HashMap<>();
        dependencyNotationMap.put("group", DEPENDENCY_GROUP);
        dependencyNotationMap.put("name", getDependencyName(configuration, pluginDefinition));
        dependencyNotationMap.put("version", getDependencyVersion(pluginDefinition));

        project.getLogger().info("Adding dependency for {} in configuration {}: {}", pluginDefinition.getPlugin().getPluginName(), configuration.getName(), dependencyNotationMap);
        return dependencyNotationMap;
    }

    private String getDependencyName(Configuration configuration, DownPluginDefinition pluginDefinition) {
        return DEPENDENCY_NAME_PREFIX + pluginDefinition.getName() + DEPENDENCY_NAME_SUFFIXES.get(configuration.getName());
    }

    private String getDependencyVersion(DownPluginDefinition pluginDefinition) {
        return pluginDefinition.getVersion() == null ? version : pluginDefinition.getVersion();
    }
}
