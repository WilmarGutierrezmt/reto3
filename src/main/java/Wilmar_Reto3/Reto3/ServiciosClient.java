package Wilmar_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClient {

    @Autowired
    private RepositorioClient metodosCrud;

    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Client> e = metodosCrud.getCliente((int) client.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = metodosCrud.getCliente((int) client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName((String) client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge((Integer) client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword((String) client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
