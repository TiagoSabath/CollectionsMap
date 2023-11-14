package com.example.collectionsmap;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        Map<String, Double> carrosPopulares = new HashMap<>(){{
           put("Gol", 14.4);
           put("Uno", 15.6);
           put("Mobi", 16.1);
           put("HB20", 14.5);
           put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("Gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo Tucson está no dicionário: " + carrosPopulares.containsKey("Tucson"));

        System.out.println("Exiba o consumo do Uno: " + carrosPopulares.get("Uno"));

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);

        System.out.println("Exiba os consumo dos carros: ");
        Collection<Double> consumo = carrosPopulares.values();
        System.out.println(consumo);

        System.out.println("Exiba o modelo mais economico e seu consumo ");
        Double max = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";

        for (Map.Entry<String, Double> entry : entries){
            if (entry.getValue().equals(max)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo Mais eficiente: " + modeloMaisEficiente + " - " + max);
            }
        }


        System.out.println("Exiba o modelo menos economico e seu consumo: ");
        Double min = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : entries){
            if (entry.getValue().equals(min)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo Mais eficiente: " + modeloMenosEficiente + " - " + min);
            }
        }

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma os consumos dos carros: " + soma);


        System.out.println("Exiba a media dos consumos dos carros: " + (soma/carrosPopulares.size()));

        System.out.println(carrosPopulares);
        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }

        System.out.println(carrosPopulares);

        System.out.println("----- Exiba os carros na ordem ------");

        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("HB20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares1);


        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }
}
