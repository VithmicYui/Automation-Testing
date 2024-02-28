package steps;

import core.KeywordAndroid;
import core.LogHelper;
import org.slf4j.Logger;
import org.testng.annotations.AfterClass;

public class BaseECartSteps {
    public static Logger log = LogHelper.getLogger();
    protected KeywordAndroid mobile;

    public BaseECartSteps() {
        this.mobile = new KeywordAndroid();
    }

    @AfterClass
    public void teardownTestSuite() {
        mobile.closeApplication();
    }
}
