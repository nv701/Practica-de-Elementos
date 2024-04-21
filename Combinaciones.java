import java.util.ArrayList;
import java.util.List;
public class Combinaciones {
    public static void main(String[] args)  {
        String[] a = {"1","1","2"};
        String x = "112";
        Combinaciones combinacion = new Combinaciones();
        System.out.println(combinacion.puedoGenerar(a,x));
    }
    public boolean puedoGenerar(String a[], String x) {
        List<Integer> combinaciones = new ArrayList<>();
        int[] listaInt = convertirLista(a);
        return genComb(listaInt, 0, new ArrayList<>(), combinaciones, x);
    }
    private boolean genComb(int[] a, int indice, List<Integer> combAct, List<Integer> combinaciones, String x) {
        if (indice == a.length) {
            if (combAct.size() > 0) {
                int valor = 0;
                for (int num : combAct) {
                    valor = valor * 10 + num;
                }
                combinaciones.add(valor);
                if (valor == Integer.parseInt(x)) {
                    return true;
                }
            }
            return false;
        }
        if (genComb(a, indice + 1, combAct, combinaciones, x)) {
            return true;
        }
        combAct.add(a[indice]);
        if (genComb(a, indice + 1, combAct, combinaciones, x)) {
            return true;
        }
        combAct.remove(combAct.size() - 1);
        return false;
    }
    private static int[] convertirLista(String[] listaDeCadenas) {
        int[] listaDeEnteros = new int[listaDeCadenas.length];
        for (int i = 0; i < listaDeCadenas.length; i++) {
            listaDeEnteros[i] = Integer.parseInt(listaDeCadenas[i]);
        }
        return listaDeEnteros;
    }
}