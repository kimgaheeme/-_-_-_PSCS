public abstract class Application {

    public boolean open(String fileName) {
        boolean canRead = false;

        canRead = checkFile(fileName);
        if ( canRead == false ) return false;

        boolean result = false;
        result = processFile(fileName);
        return result;
    }

    protected abstract boolean processFile(String fileName);
    protected abstract boolean checkFile(String fileName);

}

class Xls extends Application {

    @Override
    protected boolean processFile(String fileName) {
        // / 주어진 file이 Xls 파일의 내용을 처리함
        return false;
    }

    @Override
    protected boolean checkFile(String fileName) {
        // 주어진 file이 Xls의 format인지 확인함
        return fileName.toUpperCase().endsWith(".XLS");
    }

}

class Doc extends Application {

    @Override
    protected boolean processFile(String fileName) {
        // / 주어진 file이 DOC 파일의 내용을 처리함
        return false;
    }

    @Override
    protected boolean checkFile(String fileName) {
        // 주어진 file이 DOC의 format인지 확인함
        return fileName.toUpperCase().endsWith(".DOC");
    }

}
