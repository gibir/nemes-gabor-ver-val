package test;
import org.junit.*;
import org.mockito.Mockito;

import main.FakeFileExtMgr;
import main.LogAnalyzer;
import main.ManualWebService;
import main.TestableLogAnalyzer;
import main.WebService;


public class ValidFileNameTest {

    private static final String validFileName = "dasd.slr";
    private static final String invalidFileName = "dasd.sl";

    private FakeFileExtMgr fileExtMgr;
    private TestableLogAnalyzer testableLogAnalyzer;
    private WebService manualWebService;
    private LogAnalyzer logAnalyzer;

    @Before
    public void setUp() throws Exception{

        fileExtMgr = new FakeFileExtMgr();
        manualWebService = new ManualWebService();
        logAnalyzer = new LogAnalyzer();
        logAnalyzer.setWebService(manualWebService);
        //logAnalyzer.setFileExtMgr(fileExtMgr);
    }
    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void isValidFileNameReturnTrue(){

        fileExtMgr.setValid(true);
        testableLogAnalyzer = new TestableLogAnalyzer(fileExtMgr);
        Assert.assertEquals(true, testableLogAnalyzer.isValidLogFileName(validFileName));
    }

    @Test
    public void isValidFileName_FileNameTooShort_CallManualWebService() {
        logAnalyzer.isValidLogFileName("ad");
        Assert.assertEquals("should be too short", manualWebService.getLastError(), "ad file name is too short!");
    }
    
    @Test
    public void isValidFileName_FileNameTooShort_CallMockWebService() {
        WebService mockWebService = Mockito.mock(WebService.class);
        logAnalyzer.setWebService(mockWebService);
        Mockito.when(mockWebService.getLastError()).thenReturn("sd file name is too short!");
        logAnalyzer.isValidLogFileName("sd");
        Mockito.verify(mockWebService, Mockito.times(1)).logError("sd file name is too short!");
    }

}
