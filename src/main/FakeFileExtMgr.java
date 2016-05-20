package main;


public class FakeFileExtMgr implements FileExtMgr {

    private boolean valid;

    @Override
    public boolean isValidLogFileName(String fileName) {
        return valid;
    }

    public void setValid(boolean valid){
        this.valid = valid;
    }
}
