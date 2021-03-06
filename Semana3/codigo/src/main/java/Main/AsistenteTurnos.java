package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class AsistenteTurnos {

  private ArrayList<Cliente> clientes;
  private Scanner sc;

  /**
   * Constructor para la clase AsistenteTurnos
   * 
   * @param sc scanner para leer informacion desde el teclado
   */
  public AsistenteTurnos(Scanner sc) {
    this.clientes = new ArrayList<>();
    this.sc = sc;
  }

  /**
   * Funcion para validar que el cliente no sere pita en la fila
   * 
   * @return cliente validado
   */
  private Cliente verificarCliente() {
    // Con el atributo scanner pida por pantalla la cédula del cliente
    System.out.print("Ingrese su cédula: ");
    String cedula = sc.nextLine();

    // Con el atributo scanner pida por pantalla el nombre del cliente
    System.out.print("Ingrese su nombre: ");
    String nombre = sc.nextLine();

    // Crear un nuevo objeto cliente con esos datos
    Cliente cliente = new Cliente(cedula, nombre);

    // Evalaur si el objeto creado no esta presente ya en el arreglo de clientes
    // Si no esta presente retornar al cliente creado
    // Si ya esta presente retornar null
    if (!this.clientes.contains(cliente)) {

      return cliente;
    }

    // Tambien se puede usar el siguiente codigo
    // Esto es el operador Ternario o Elvis

    // return !this.clientes.contains(cliente) ? cliente : null;

    // Su esctructura es:
    // condicion ? valor si se cumple : valor si no se cumple

    return null;
  }

  /**
   * Registrar al cliente en la fila
   * 
   * @return true si se registro al cliente, false si no
   */
  public boolean registrarTurno() {

    // llamar a la funcion verificarCliente
    Cliente cliente = verificarCliente();

    if (cliente != null) {
      // Pedir por el scanner el motivo del cliente (string)
      System.out.print("Ingrese su motivo: ");
      String motivo = sc.nextLine();

      // Setear el motivo ingresado por teclado en el atributo motivo del cliente
      // Usando el metodo setMOtivo()
      // Setear el numero de la fila en la que se encuentra el cliente
      // el numero debe ser la cantidad de elementos en el arreglo clientes
      cliente.setMotivo(motivo);
      cliente.setNumero(this.clientes.size());

      System.out.println("Cliente registrado en la fila correctamente");
      // Añadir el cleinte al arreglo y retornar true (la funcion .add() de ArrayList
      // retorna true si se añade el elemento)
      return this.clientes.add(cliente);
    }

    System.out.println("Cliente ya presente en la fila");
    return false;
  }

  /**
   * Quita al cliente que estaba primero en la fila
   */
  public void terminarTurno() {

    // Remover del arreglo cliente al que este en la primera posicion
    this.clientes.remove(0);
  }

  /**
   * Imprime a los clientes y su información en el orden en el que se encunetran
   */
  public void mostrarClientes() {
    /**
     * Usando tecnicas de Java del 1998 sería asi
     */

    System.out.println("---------------------------------");

    if (this.clientes.isEmpty())
      System.out.println("La fila está vacía");

    // Iterar y mostrar por pantalla la informacion de los clientes
    for (Cliente cliente : this.clientes) {
      System.out.println(cliente);
    }

    /**
     * Usando nuesvas caracteristicas, o una manera mas PRO, sería asi. Puede
     * parecer mas codigo pero cuando se tiene que hacer mas cosas como filtrar,
     * ordenas y demas, es aconsejable usar los metodos que dispone .stream(),
     * debidoa que hace el codigo mas sencillo y legible
     */

    // this.clientes.stream().forEach(cliente -> {
    // System.out.println(cliente);
    // });
    System.out.println("---------------------------------");

  }

  /**
   * Muestra las opciones disponibles del sistema
   */
  public void mostrarMenu() {

    String texto = "1 -> Mostrar Fila\n2 -> Registrar Turno\n3 -> Terminar Turno\n4 ->Salir";
    System.out.println(texto);
  }

}
