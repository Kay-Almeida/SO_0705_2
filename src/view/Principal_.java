package view;

import controller.SteamController;

public class Principal_ {
    public static void main(String[] args) {
        SteamController controller = new SteamController();
        
        controller.filtrarJogos(2021, "February", 10000);
        controller.gerarArquivoFiltrado(2021, "February", "C:\\TEMP\\aula", "jogos_filtrados.csv");
    }
}