package main;

public class LogAnalyzer {

    private WebService webService;

    public boolean isValidLogFileName(String fileName) {

        if(fileName.length() < 3 && webService != null){
            webService.logError(fileName + " file name is too short!");
            //throw new IllegalArgumentException("File name is too short.");
        }
        return getFileExtMgr() != null && getFileExtMgr().isValidLogFileName(fileName);
    }

    public void setWebService(WebService webService){
        this.webService = webService;
    }

    public FileExtMgr getFileExtMgr(){
        //return new FakeFileExtMgr();
        return null;
    }


}
