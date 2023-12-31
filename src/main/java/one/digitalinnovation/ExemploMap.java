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
      put("HB20", 14.5);
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
    Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
    String modeloMenosEficiente = "";
    for(Map.Entry<String, Double> entry: carrosPopulares.entrySet()){
      if(entry.getValue().equals(consumoMenosEficiente)){
        modeloMenosEficiente = entry.getKey();
        System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - Consumo: " + consumoMenosEficiente);
      }
    }

    Iterator<Double> iterator = carrosPopulares.values().iterator();
    Double soma = 0d;
    while(iterator.hasNext()) {
      soma += iterator.next();
    }
    System.out.println("Exiba a soma dos consumos: " + soma);

    System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));

    System.out.println("Remova os modelos com consumo igual a 15,6km/l: ");
    Iterator<Double> iterator1 = carrosPopulares.values().iterator();
    while (iterator1.hasNext()) {
      if (iterator1.next().equals(15.6)) iterator1.remove();
    }
    for(Map.Entry<String, Double> carros: carrosPopulares.entrySet()) {
      System.out.println(carros);
    }

    System.out.println("Exiba todos os carros na ordem em que foram informados: ");
    Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
      //nao temos o metodo add em map
      //as chaves tem de ser unicas, ja os valores podem ser duplicados
      put("Gol", 14.4);
      put("Uno", 15.6);
      put("Mobi", 16.1);
      put("HB20", 14.5);
      put("Kwid", 15.6);
    }};

    System.out.println(carrosPopulares1.toString());

    System.out.println("Exiba o dicionário ordenado pelo modelo: ");
    Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
    System.out.println(carrosPopulares2);

    System.out.println("Apague o dicionário de carros: ");
    carrosPopulares2.clear();
    System.out.println(carrosPopulares2);

    System.out.println("Confira se o dicionário está vazio: " + carrosPopulares2.isEmpty());
  }
  }
