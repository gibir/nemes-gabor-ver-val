package main;

public class TestableLogAnalyzer extends LogAnalyzer{

    private FakeFileExtMgr fakeFileExtMgr;

    public  TestableLogAnalyzer(FakeFileExtMgr fakeFileExtMgr){
        this.fakeFileExtMgr = fakeFileExtMgr;
    }

    @Override
    public FileExtMgr getFileExtMgr(){
        return fakeFileExtMgr;
    }

}
