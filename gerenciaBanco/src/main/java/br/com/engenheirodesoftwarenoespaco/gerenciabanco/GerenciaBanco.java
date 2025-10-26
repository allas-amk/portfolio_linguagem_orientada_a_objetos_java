package br.com.engenheirodesoftwarenoespaco.gerenciabanco;
import java.util.Scanner;

public class GerenciaBanco {

    public static class ContaBancaria {
        private String nome;
        private String sobrenome;
        private String cpf;
        private double saldo;

        public ContaBancaria(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = 0.0;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("OK - Depósito de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            } else {
                System.out.println("X - Erro: O valor do depósito deve ser positivo.");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("OK - Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            } else if (valor > saldo) {
                System.out.println("X - Erro: Saldo insuficiente.");
            } else {
                System.out.println("X - Erro: O valor do saque deve ser positivo.");
            }
        }

        public void consultarSaldo() {
            System.out.println("\n--- INFORMAÇÕES DO CLIENTE ---");
            System.out.println("Nome: " + nome + " " + sobrenome);
            System.out.println("CPF: " + cpf);
            System.out.println("Saldo Atual: R$" + String.format("%.2f", saldo));
            System.out.println("-----------------------------\n");
        }
    }
    
    public static void exibirMenu() {
        System.out.println("\n==================================");
        System.out.println("|           MENU PRINCIPAL         |");
        System.out.println("==================================");
        System.out.println("1 - Consultar Saldo e Dados");
        System.out.println("2 - Depósito");
        System.out.println("3 - Saque");
        System.out.println("0 - Sair");
        System.out.println("==================================");
        System.out.print("Escolha uma opção: ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- BEM-VINDO AO GERENCIADOR BANCÁRIO ---");
        System.out.print("Informe seu Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Informe seu Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Informe seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("------------------------------------------");
        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);
        
        int opcao;
        do {
            exibirMenu();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("X -️ Entrada inválida. Por favor, digite um número.");
                scanner.next();
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 0:
                    System.out.println("\nObrigado por utilizar o Gerenciador Banco! Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção do menu.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
