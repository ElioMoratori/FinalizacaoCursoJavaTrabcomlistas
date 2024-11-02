import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Saldo saldoCartao = new Saldo();

        System.out.println("Insira o valor do saldo do cartão de crédito:");
        saldoCartao.setSaldo(entrada.nextDouble());
        System.out.println(saldoCartao.getSaldo());

        ArrayList<Produtos> produtos = new ArrayList<>();
        int menu = 1;


        while (menu == 1) {
            Produtos inserir = new Produtos();
            Scanner usuario = new Scanner(System.in);
            System.out.println("Escolha um produto:");
            inserir.setProduto(usuario.next());

            System.out.println("Insira o valor");
            inserir.setPreco(usuario.nextDouble());

            if (inserir.getPreco() < saldoCartao.getSaldo()) {
                saldoCartao.setSaldo(saldoCartao.getSaldo() - inserir.getPreco());
            } else {
                System.out.println("Saldo Insuficiente");
                break;
            }

            produtos.add(inserir);
            System.out.println("Seu novo saldo é de: R$" + saldoCartao.getSaldo());

            System.out.println("Para comprar um novo produto digite 1. Para sair, digite 0");
            menu = entrada.nextInt();

        }

        produtos.sort(Comparator.comparing(Produtos::getPreco));

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("Cupom Fiscal:");
        for (Produtos produto : produtos) {
            System.out.println(produto);
        }
        System.out.println("Saldo do cartão: R$" + saldoCartao.getSaldo());
    }
}
