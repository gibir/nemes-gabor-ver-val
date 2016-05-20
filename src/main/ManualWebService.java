package main;

public class ManualWebService implements WebService{


    private String lastError;

    public void logError(String lastError){
        this.lastError = lastError;
    }

    @Override
    public String getLastError() {
        return lastError;
    }


}
