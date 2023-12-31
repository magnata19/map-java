package one.digitalinnovation;

import java.util.*;

public class ExemploMap {
  public static void main(String[] args) {
    /*
     * Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
     * modelo = gol - consumo = 14,4km/l
     * modelo = uno - consumo = 15,6km/l
     * modelo = mobi - consumo 16,1km/l
     * modelo = hb20 - consumo = 15,6km/l
     * modelo = kwid - consumo = 15,6km/l
     * */

    System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos.");
    //a interface usa key/value
    Map<String, Double> carrosPopulares = new HashMap<>() {{
      //nao temos o metodo add em map
      //as chaves tem de ser unicas, ja os valores podem ser duplicados
      put("Gol", 14.4);
      put("Uno", 15.6);
      put("Mobi", 16.1);
      put("HB20", 15.6);
      put("Kwid", 15.6);
    }};

    System.out.println(carrosPopulares);

    System.out.println("Substitua o consumo do gol por 15,2km/l");
    carrosPopulares.put("Gol", 15.2);
    System.out.println(carrosPopulares);

    System.out.println("Confira se o modelo tucson está no dicionário. " + carrosPopulares.containsKey("tucson"));

    System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("Uno"));

//    System.out.println("Exiba o terceiro modelo adicionado."); nao tenho metodo para retornar o indice igual o set

    Set<String> modelos = carrosPopulares.keySet();
    System.out.println("Exiba os modelos: " + modelos);

    Collection<Double> values = carrosPopulares.values();
    System.out.println("Exiba os consumos dos carros: " + values);

    System.out.println("Exiba o modelo mais econômico e seu consumo :");
    Double consumoMaisEconomico = Collections.max(carrosPopulares.values());
    Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
    String modeloMaisEconomico = "";
    for(Map.Entry<String, Double> entry: entries) {
      if(entry.getValue().equals(consumoMaisEconomico)) {
        modeloMaisEconomico = entry.getKey();
      }
    }
    System.out.println("Modelo mais economico: " + modeloMaisEconomico + " - Consumo: " + consumoMaisEconomico);

    System.out.println("Exiba o modelo menos econômico e seu consumo.");
    Double consumoMenosEconomico = Collections.min(carrosPopulares.values());
    Set<Map.Entry<String, Double>> entries2 = carrosPopulares.entrySet();
    String modeloMenosEconomico = "";
    for(Map.Entry<String, Double> entry: entries2) {
      if(entry.getValue().equals(consumoMenosEconomico)){
        modeloMenosEconomico = entry.getKey();
      }
    }
    System.out.println("Modelo menos economico: " + modeloMenosEconomico + " consumo " + consumoMenosEconomico);
  }
  }
