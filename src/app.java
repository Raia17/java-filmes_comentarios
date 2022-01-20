import java.util.Scanner; // Import do Scanner


public class app {

    // Variáveis e arrays declarados publicamente para puder usar em qualquer parte da class "app"
    public static boolean runApp = true; // Variável para abrir e fechar o loop no main method

    // Scanners e estética
    public static Scanner in = new Scanner(System.in);
    public static int nextline;
    public static String line = "----------------------------";

    // 2D Arrays em que o primeiro valor define o FILME e o segundo define INFORMAÇÃO EXTRA
    public static String[][] filmes = new String[100][2];  // INFORMAÇÃO EXTRA = [ID, Titulo]
    public static String[][] comentario = new String[100][100]; //INFORMAÇÃO EXTRA = [Comentários]



    // MAIN APP
    public static void main(String[] args) {

        // Cria dados básicos do filme
        for (int i = 0; i < 5; i++) {
            filmes[i][0] = String.valueOf(i);
            filmes[i][1] = String.valueOf(i);
        }

        // Inicia a app
        while (runApp == true) {
            // Chama a função appMenu() - ln. 90
            appMenu();

            // Menu
            System.out.print("Escolha uma opção: ");
            nextline = in.nextInt();

            // Switch case que pega o valor de nextline
            switch (nextline) {
                case 1:
                    filmeMenu(); // ln. 55
                    break;
                case 2:
                    encerrarLoop(); // ln. 82
                    break;
            }


        }
    }




    static void filmeMenu() {
        System.out.println(line + "CATÁLOGO DE FILMES" + line);

        // Enquanto i for menos que o tamanho de filmes
        for (int i = 0; i < filmes.length; i++) {
            // Se o filme selecionado com i for diferente de NULL
            if (filmes[i] != null) {
                // Dá print nos dados do filme
                System.out.println("ID: " + filmes[i][0]);
                System.out.println("Título: " + filmes[i][1]);
                System.out.println("----------------------------");
            }
        }

        // Enquanto o input estiver fora do escopo dos filmes, pede para escrever um novo valor
        do {
            System.out.print("Escolha um filme (por ID): ");
            nextline = in.nextInt();
        } while (nextline > filmes.length || nextline < 0);

        // Corre o method comentarioMenu() usando nextline como parâmetro
        comentarioMenu(nextline); // ln. 101
    }




    static void encerrarLoop() {
        System.out.println("Saiu com sucesso! Volte sempre");
        runApp = false; // Troca o estado do loop para FALSE e termina o programa
    }




    static void appMenu() {
        // Literalmente, só texto
        System.out.println(line + "MENU" + line + "\n" +
                "1. Ver Filmes\n" +
                "2. Sair\n" +
                "----------------------------");
    }




    static void comentarioMenu(int id) {
        // Ao usar a var filmes é preciso mostrar a qual filme nos referimos
        // por isso o uso do parâmetro ID
        // Quando este method é chamado (ln. 76) o parâmetro ID - que contêm um valor vazio
        // Troca para a input do utilizador (variável NEXTLINE)
        System.out.println(line + "FILME" + line);
        System.out.println("ID: " + filmes[id][0]);
        System.out.println("Título: " + filmes[id][1]);
        System.out.println(line + "Comentários" + line);

        // Loop para dar print nos comentários
        for (int i = 0; i < comentario[id].length; i++) {
            // Se o valor for diferente de NULL dá print
            if (comentario[id][i] != null) {
                System.out.println((i + 1) + ". " + comentario[id][i]);
            }
        }

        System.out.println("----------------------------\n" +
                "1. Adicionar Comentário\n" +
                "2. Escolher outro filme\n" +
                "----------------------------");

        // Enquanto o input estiver fora do escopo do menu, pede para escrever um novo valor
        do {
            System.out.print("Escolha uma opção: ");
            nextline = in.nextInt();
        } while (nextline > 2 || nextline < 1);

        switch (nextline) {
            case 1:
                addComentario(id); // ln.144
                break;
            case 2:
                filmeMenu(); // Volta para o 2º menu
                break;
        }

    }




    public static void addComentario(int id) {
        // Estética e inputs
        System.out.println(line + line);
        in.nextLine(); // Este comando foi declarado devido a um bug em que passava o próximo in.nextLine()
        System.out.print("Escreva o seu comentário: ");
        String s_comentario = in.nextLine();

        // Loop para percorrer o array COMENTARIO
        for (int i = 0; i < comentario.length; i++) {
            // Se o campo no array naquele filme e naquele "espaço" no comentário estiver vazio
            if (comentario[id][i] == null) {
                // Troca o valor de NULL para o valor escrito pelo utilizador
                comentario[id][i] = s_comentario;
                comentarioMenu(id);
            }
        }
    }
}
