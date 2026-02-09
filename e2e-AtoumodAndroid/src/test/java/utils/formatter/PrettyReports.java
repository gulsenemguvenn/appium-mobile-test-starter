package utils.formatter;

import io.cucumber.core.plugin.JsonFormatter;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Configuration;

import java.io.*;
import java.nio.file.Files;
import java.util.Collections;

public class PrettyReports implements Plugin, EventListener {

    private final File outputDir;
    private final File jsonFile;
    private final EventListener delegateJsonEventListener;

    public PrettyReports() {
        this(new File("target" + File.separator + "cucumber"));
    }

    public PrettyReports(final File outputDir) {
        this.outputDir = outputDir;
        this.jsonFile = new File(outputDir, "cucumber.json");
        this.delegateJsonEventListener = createJsonEventListener(jsonFile);
    }

    private static EventListener createJsonEventListener(final File jsonFile) {
        try {
            Files.createDirectories(jsonFile.getParentFile().toPath());
            OutputStream outputStream = new FileOutputStream(jsonFile);
            return (EventListener) new JsonFormatter(outputStream);
        } catch (Exception e) {
            throw new RuntimeException("PrettyReports json oluşturulamadı.", e);
        }
    }

    @Override
    public void setEventPublisher(final EventPublisher publisher) {
        this.delegateJsonEventListener.setEventPublisher(publisher);
        publisher.registerHandlerFor(TestRunFinished.class, onFinish());
    }

    private EventHandler<TestRunFinished> onFinish() {
        return event -> generateReport(this.jsonFile, this.outputDir);
    }

    private static void generateReport(final File jsonFile, final File outputDir) {
        Configuration configuration = ConfigFactory.getConfiguration(outputDir);
        new ReportBuilder(Collections.singletonList(jsonFile.getAbsolutePath()), configuration)
                .generateReports();
    }
}
