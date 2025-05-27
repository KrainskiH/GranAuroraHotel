// Importa a classe Menu, que está na pasta 'view'

import view.Menu;
package main;
// Classe principal do programa
public class Main {

    // Métotodo principal onde o programa inicia
    public static void main (String[] args){

        // Cria um objeto da classe Menu
        Menu menu = new Menu();

        // Chama o metodo que exibe o menu e permite a interação com o usuario
        menu.exibirMenu();
    }
}