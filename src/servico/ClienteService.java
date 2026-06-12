package servico;

import dominio.Cliente;

import java.util.ArrayList;

public class ClienteService {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public boolean cadastraCliente(Cliente cliente){
        for (Cliente clienteExistente : clientes) {
            if (clienteExistente.getId() == cliente.getId()){
                System.out.println("Cliente já cadastrado!");
                return false;
            }
        }
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!!");
        return true;
    }

    public void listarClientes(){
        if (clientes.isEmpty()){
            System.out.println("lista de Cliente Vazia!");
            return;
        }
        for (Cliente addCliente : clientes) {
            System.out.println(addCliente);
        }
    }
    
    public boolean possuiCliente(){
        return !clientes.isEmpty();
    }

    public Cliente buscarClientePorId(int id){
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
}
