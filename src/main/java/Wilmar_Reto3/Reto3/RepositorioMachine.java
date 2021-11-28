/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wilmar_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioMachine {

    @Autowired
    private InterfaceMachine crud;

    public List<Machine> getAll() {
        return (List<Machine>) crud.findAll();
    }

    public Optional<Machine> getMachine(int id) {
        return crud.findById(id);
    }

    public Machine save(Machine machine) {
        return crud.save(machine);
    }

    public void delete(Machine machine) {
        crud.delete(machine);
    }

}
