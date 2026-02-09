package utils.formatter;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.reducers.ReducingMethod;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.util.Objects.requireNonNull;

public final class ConfigFactory {

    private static final String DEFAULT_FILENAME = "cucumber-reporting.properties";
    private static final String TAGS_TO_EXCLUDE_FROM_CHART_PATTERN = "^tagsToExcludeFromChart\\.\\d+$";
    private static final String PRESENTATION_MODE_PREFIX = "presentationMode.";
    private static final String REDUCING_METHOD_PREFIX = "reducingMethod.";
    private static final String CLASSIFICATIONS_PREFIX = "classifications.";
    public static final String CONFIG_FILE_PROPERTY = "cucumber.reporting.config.file";

    private ConfigFactory() {}

    public static Configuration getConfiguration(final java.io.File outputDir) {
        final Properties properties = loadProperties();
        final String projectName = properties.getProperty("projectName", "MticketAndroidMobile BDD Report");

        final Configuration configuration = new Configuration(outputDir, projectName);

        configureBuildNumber(configuration, properties);
        configureSortingMethod(configuration, properties);
        configureTagsToExcludeFromChart(configuration, properties);
        configureTrendsStatsFile(configuration, properties);
        configureRepeatableKeys(configuration, properties);

        return configuration;
    }

    private static void configureBuildNumber(final Configuration configuration, final Properties properties) {
        configuration.setBuildNumber(properties.getProperty("buildNumber"));
    }

    private static void configureSortingMethod(final Configuration configuration, final Properties properties) {
        final String sortingMethod = properties.getProperty("sortingMethod");
        if (sortingMethod != null && !sortingMethod.isBlank()) {
            configuration.setSortingMethod(Enum.valueOf(SortingMethod.class, sortingMethod));
        }
    }

    private static void configureTagsToExcludeFromChart(final Configuration configuration, final Properties properties) {
        final String[] tagsToExclude = properties.entrySet().stream()
                .filter(entry -> ((String) entry.getKey()).matches(TAGS_TO_EXCLUDE_FROM_CHART_PATTERN))
                .map(e -> String.valueOf(e.getValue()))
                .toArray(String[]::new);

        configuration.setTagsToExcludeFromChart(tagsToExclude);
    }

    private static void configureTrendsStatsFile(final Configuration configuration, final Properties properties) {
        final String trendsStatsFile = properties.getProperty("trendsStatsFile");
        if (trendsStatsFile != null && !trendsStatsFile.isBlank()) {
            configuration.setTrendsStatsFile(new java.io.File(trendsStatsFile));
        }
    }

    private static void configureRepeatableKeys(final Configuration configuration, final Properties properties) {
        final Enumeration<Object> keys = properties.keys();
        while (keys.hasMoreElements()) {
            final String qualifiedKey = String.valueOf(keys.nextElement());

            if (qualifiedKey.startsWith(PRESENTATION_MODE_PREFIX) && parseBoolean(properties.getProperty(qualifiedKey))) {
                final String name = qualifiedKey.substring(PRESENTATION_MODE_PREFIX.length());
                configuration.addPresentationModes(Enum.valueOf(PresentationMode.class, name));
            }

            if (qualifiedKey.startsWith(REDUCING_METHOD_PREFIX) && parseBoolean(properties.getProperty(qualifiedKey))) {
                final String name = qualifiedKey.substring(REDUCING_METHOD_PREFIX.length());
                configuration.addReducingMethod(Enum.valueOf(ReducingMethod.class, name));
            }

            if (qualifiedKey.startsWith(CLASSIFICATIONS_PREFIX)) {
                final String key = qualifiedKey.substring(CLASSIFICATIONS_PREFIX.length());
                configuration.addClassifications(key, properties.getProperty(qualifiedKey));
            }
        }
    }

    private static Properties loadProperties() {
        final Properties properties = new Properties();
        final String filename = System.getProperty(CONFIG_FILE_PROPERTY, DEFAULT_FILENAME);

        try (InputStream is = ConfigFactory.class.getClassLoader().getResourceAsStream(filename)) {
            if (is == null) {
                // properties zorunlu olmasın: yoksa defaultlarla devam et
                return properties;
            }
            properties.load(is);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("cucumber-reporting.properties okunamadı: " + filename, e);
        }
    }
}
