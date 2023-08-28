package br.com.alura.oobj.cli;

import br.com.alura.oobj.application.MainPage;
import br.com.alura.oobj.application.NcmPage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        /*
        String numeroRomano = s.nextLine();
        int ncmDefinido = romanToInt(numeroRomano);

        if(ncmDefinido > 21 ||  ncmDefinido < 1){
            throw new IllegalArgumentException("Numero deve estar entre I e XXI");
        }

         */

        int ncmDefinido = 8;

        MainPage paginaPrincipal = new MainPage();
        String ncm = paginaPrincipal.retornaNCMdefinido(ncmDefinido);
        System.out.println(ncm);

        NcmPage paginaDoNCM = new NcmPage(ncm);
        paginaDoNCM.retornaItensDoNCM();

        paginaPrincipal.fechar();
        paginaDoNCM.fechar();

    }

}
