import org.example.builder.DataBuilder;
import org.example.model.MonsterModel;
import org.example.pages.CreateMonsterPage;
import org.example.utils.MyLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.Map;

import static org.example.utils.Utils.forceWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    private WebDriver driver;
    private CreateMonsterPage mainPage;
    private static final Logger logger = MyLogger.getLogger();

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:3000/");

        mainPage = new CreateMonsterPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void successfulMonsterCreation(){

        long startTime = System.currentTimeMillis();

        MonsterModel monster = DataBuilder.monsterBuilder();
        Map<String, String> data = DataBuilder.dataBuilder(monster);
        logger.info("Monster created = {}", monster);

        mainPage.dismissError(driver);

        logger.info("Get App Name = {}", mainPage.getAppName());
        assertTrue(mainPage.isMainPageOpened());

        mainPage.clickOnMonster(driver, monster.getId());
        assertTrue(mainPage.isIconMonsterEnabled(driver, String.valueOf(monster.getId())));

        mainPage.completeAttributes(data, driver);



        long endTime = (System.currentTimeMillis() - startTime);
        logger.info("Tiempo de ejecución = {}", endTime);
        forceWait(2000L);
    }


}
