package com.example.collectionsmap;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("--\tOrdem de aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawking", new Livro("Uma breve historia", 256));
           put("Chales", new Livro("O poder do Hábito", 408));
           put("Noah", new Livro("Lições", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem de Inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking", new Livro("Uma breve historia", 256));
            put("Chales", new Livro("O poder do Hábito", 408));
            put("Noah", new Livro("Lições", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem alfabética autores\t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem alfabético nomes dos livros\t--");

        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem número de páginas\t--");

        Set<Livro> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
        meusLivros4.addAll(meusLivros.values());
        for (Livro livro : meusLivros4) {
            System.out.println(livro.getNome()+ " - " + livro.getPaginas());
        }
    }

}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Livro livro)) return false;
        return Objects.equals(getNome(), livro.getNome()) && Objects.equals(getPaginas(), livro.getPaginas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getPaginas());
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

//-------Comparando Por nome---------
class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Livro>{


    @Override
    public int compare(Livro l1, Livro l2) {
        return Integer.compare(l1.getPaginas(), l2.getPaginas());
    }
}