package phonebook.utils;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static phonebook.core.BasePage.takeScreenshot;

public class RunnerExtension implements AfterTestExecutionCallback, BeforeTestExecutionCallback {
    Logger logger = LoggerFactory.getLogger(RunnerExtension.class);

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        logger.info("-----------------------------------------------------------------");
        logger.info("Test is started: {} - {}", extensionContext.getTestMethod().get(), extensionContext.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Boolean result = extensionContext.getExecutionException().isPresent();
        if (result) {
            logger.info("Test '{}' - '{}' - FAILED", extensionContext.getTestMethod().get(), extensionContext.getDisplayName());
            takeScreenshot();
        } else {
            logger.info("Test '{}' - '{}' - PASSED", extensionContext.getTestMethod().get(), extensionContext.getDisplayName());
        }
        logger.info("======================================================");
    }
}
