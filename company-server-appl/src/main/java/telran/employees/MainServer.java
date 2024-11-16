package telran.employees;

import telran.net.TcpServer;

public class MainServer {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        Company company = new CompanyImpl();
        TcpServer server = new TcpServer(new CompanyProtocol(company), PORT);
        if (company instanceof Persistable persistable) {
            persistable.restoreFromFile(Config.FILE_NAME);
            SaveThread autoSaveThread = new SaveThread(persistable);
            autoSaveThread.start();
        }
        server.run();
    }
}