package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SteamController {

    public void filtrarJogos(int ano, String mes, double mediaEsperada) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\TEMP\\aula\\SteamCharts.csv"))) {
            reader.readLine();
        	String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nomeJogo = dados[0];
                int anoJogo = Integer.parseInt(dados[1]);
                String mesJogo = dados[2];
                double mediaJogadores = Double.parseDouble(dados[3]);
                if (anoJogo == ano && mesJogo.equalsIgnoreCase(mes) && mediaJogadores >= mediaEsperada) {
                    System.out.println(nomeJogo + " | " + mediaJogadores);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gerarArquivoFiltrado(int ano, String mes, String caminho, String nomeArquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\TEMP\\aula\\SteamCharts.csv"))) {
            reader.readLine();
        	String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int anoJogo = Integer.parseInt(dados[1]);
                String mesJogo = dados[2];
                if (anoJogo == ano && mesJogo.equalsIgnoreCase(mes)) {
                    linhas.add(dados[0] + ";" + dados[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho + "\\" + nomeArquivo))) {
            for (String linha : linhas) {
                writer.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}