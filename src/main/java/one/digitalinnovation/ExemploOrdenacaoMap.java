package one.digitalinnovation;

/*
* Dadas as seguintes informacoes sobre meus livros favoritos e seus autores,
* crie um dicionário e ordene este dicionário.
* exibindo (Nome autor - Nome livro);
*
* Autor Hawking, Stephen - Livro = Nome: uma breve historia do tempo
 * Autor Duhigg, Charles - Livro = Nome: o poderdo hábito
 * Autor Hararim, Yuval - Livro = Nome: 21 licoes para o seculo 21
* */

import java.util.*;

public class ExemploOrdenacaoMap {
  public static void main(String[] args) {

    Map<String, Livro> meusLivros = new HashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma breve historia do tempo", 256));
      put("Duhigg, Charles", new Livro("O poder do habito.", 408));
      put("Hararim, Yuval", new Livro("21 licoes para o seculo 21", 432));
    }};

    System.out.println("--\tOrdem aleatoria\t--");
    for(Map.Entry<String, Livro> livro:meusLivros.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
      put("Hawking, Stephen", new Livro("Uma breve historia do tempo", 256));
      put("Duhigg, Charles", new Livro("O poder do habito.", 408));
      put("Hararim, Yuval", new Livro("21 licoes para o seculo 21", 432));
    }};

    System.out.println("--\tOrdem de insercao\t--");
    for(Map.Entry<String, Livro> livro:meusLivros1.entrySet()){
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }

    System.out.println("--\tOrdem alfabetica dos autores\t--");
    Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
    for(Map.Entry<String, Livro> livros : meusLivros2.entrySet()){
      System.out.println(livros.getKey() + " - " + livros.getValue().getNome());
    }

    System.out.println("--\tOrdem alfabetica dos livros\t--");
    Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
    meusLivros3.addAll(meusLivros.entrySet());
    for(Map.Entry<String, Livro> livros: meusLivros3){
      System.out.println(livros);
    }

    System.out.println("--\tOrdem número de paginas\t--");
    Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparaNumeroPagina());
    meusLivros4.addAll(meusLivros.entrySet());
    for(Map.Entry<String, Livro> livro: meusLivros4) {
      System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - " + livro.getValue().getPaginas());
    }
  }

}

class Livro{
  private String nome;
  private Integer paginas;

  public Livro(String nome, Integer paginas){
    this.nome = nome;
    this.paginas = paginas;
  }

  public String getNome() {
    return nome;
  }

  public Integer getPaginas() {
    return paginas;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Livro livro = (Livro) o;
    return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, paginas);
  }

  @Override
  public String toString() {
    return "Livros{" +
            "nome='" + nome + '\'' +
            ", paginas='" + paginas + '\'' +
            '}';
  }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

  @Override
  public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
    return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());

  }
}

class ComparaNumeroPagina implements Comparator<Map.Entry<String, Livro>> {

  @Override
  public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
    return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
  }
}