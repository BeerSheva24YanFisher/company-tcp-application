package telran.employees;

public class SaveThread extends Thread {
    private final Persistable persistable;
    private final String filePath;
    private final int saveInterval;

    public SaveThread(Persistable persistable) {
        this.persistable = persistable;
        this.filePath = Config.FILE_NAME;
        this.saveInterval = Config.SAVE_INTERVAL;
    }

    @Override
    public void run() {
        while (true) {
            try {
                persistable.saveToFile(filePath);
                Thread.sleep(saveInterval);
            } catch (InterruptedException e) {

            }
        }
    }
}