package telran.employees;

import static telran.employees.Config.FILE_NAME;
import telran.net.Protocol;
import telran.net.TcpServer;

public class MainServer {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        Company company = new CompanyImpl();
        Protocol protocol = new ProtocolEmployee(company);
        TcpServer server = new TcpServer(protocol, PORT);
        if (company instanceof Persistable persistable) {
            persistable.restoreFromFile(FILE_NAME);
        }
        server.run();
    }
}