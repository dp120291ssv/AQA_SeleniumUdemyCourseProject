//package common;
//
//import io.qameta.allure.Attachment;
//import org.junit.jupiter.api.extension.AfterEachCallback;
//import org.junit.jupiter.api.extension.BeforeAllCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import java.time.LocalTime;
//import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;
//
//public class Listener implements TestWatcher, BeforeAllCallback, AfterEachCallback, ExtensionContext.Store.CloseableResource {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
//
//	/**
//	 * Initial setup of system.
//	 *
//	 * @param context junit context
//	 */
//	@Override
//	public void beforeAll(ExtensionContext context) {
//		context.getRoot().getStore(GLOBAL).put(true, this);
//	}
//
//	@Override
//	public void testFailed(ExtensionContext context, Throwable cause) {
//		String screenshotName = context.getTestMethod().get().getName() + "." + String.valueOf(System.currentTimeMillis()).substring(9, 13);
//		attachScreenshotToAllure();
//	}
//
//	@Override
//	public void testSuccessful(ExtensionContext context) {
//	}
//
//	/**
//	 * This method is clearing browser cookies and local storage and close all secondary windows
//	 *
//	 * @param context junit context
//	 */
//	@Override
//	public void afterEach(ExtensionContext context) {
//
//	}
//
//	/**
//	 * CloseableResource implementation, adding value into GLOBAL context is required to  registers a callback hook
//	 * With such steps close() method will be executed only once in the end of test execution
//	 */
//	@Override
//	public void close() {
//
//	}
//
//	@Attachment(value = "PageModel screenshot", type = "image/png")
//	private byte[] attachScreenshotToAllure() {
//	}
//}
