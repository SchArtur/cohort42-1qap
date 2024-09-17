package theIntertet.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Listener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(Listener.class);

    @Override
    public void beforeGet(WebDriver driver, String url) {
        WebDriverListener.super.beforeGet(driver, url);
        logger.info("Переход по адресу - {}", url);
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        WebDriverListener.super.afterGetTitle(driver, result);
        logger.info("Получен заголовок страницы - {}", result);
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logger.info("Поиск элемента по локатору  - {}", locator);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.error("Что-то пошло не так!!!");
        logger.error("================================");
        logger.error("Метод - {}", method);
        logger.error("================================");
        logger.error("Target - {}", target);
        logger.error("================================");
        logger.error("Exception - {}", e.getMessage());
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        logger.info("Клик по элементу - {}", element);
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.afterSendKeys(element, keysToSend);
        logger.info("Заполнено поле {} значением - {}", element, keysToSend);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logger.info("Найдены элементы {} по локатору - {}", result.toString(), locator);
    }

    @Override
    public void beforeAlert(WebDriver.TargetLocator targetLocator) {
        WebDriverListener.super.beforeAlert(targetLocator);
        logger.info("Получено всплывающее уведомление с текстом - '{}'", targetLocator.alert().getText());
    }
}
