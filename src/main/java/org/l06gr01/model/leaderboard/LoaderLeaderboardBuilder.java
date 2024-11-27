package org.l06gr01.model.leaderboard;

import org.l06gr01.model.Position;
import org.l06gr01.model.game.Score;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LoaderLeaderboardBuilder extends LeaderboardBuilder{
    @Override
    protected int getWidth() {
        return 90;
    }

    @Override
    protected int getHeight() {
        return 30;
    }

    @Override
    protected Position createInput() {
        return new Position(0,10);
    }

    @Override
    protected Position createTitle() {
        return new Position(39,2);
    }

    @Override
    protected Map<String,Integer> createUsers() {
        return loadUsersFromFile("src/main/resources/Pontos");
    }

    public Map<String, Integer> loadUsersFromFile(String filePath) {
        Map<String, Integer> userMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;


            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                if (parts.length == 2) {

                    String nome = parts[0].trim();
                    int pontuacao = Integer.parseInt(parts[1].trim());


                    userMap.put(nome, pontuacao);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return order(userMap);
    }
    public Map<String, Integer> order(Map<String, Integer> mapa){
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(mapa.entrySet());
        lista.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entrada : lista) {
            mapaOrdenado.put(entrada.getKey(), entrada.getValue());
        }

        return mapaOrdenado;
    }
}
