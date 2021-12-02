package mundo;

import controlador.Controlador;

public class GameOfLife {
    // Relaciones

    private Simulation sim;
    private Controlador ctrl;

    // Atributos
    private String matrix[][];
    private String copia[][];
    private int generation;
    private int population;

    public GameOfLife(Controlador ctrl) {
        this.ctrl = ctrl;
        sim = new Simulation(ctrl, this);
        copia = new String[35][35];
        matrix = new String[35][35];
        copia = rellenar(matrix.length);
        matrix = rellenar(matrix.length);
        //copia = rellenar(matrix.length);
        generation = population = 0;
       // System.out.println("Se creo GameOfLife");

    }

    public void jugar() { // revisar porque no se cambian los valores correctamente
        int vecinas = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0) {
                    //System.out.println("entro al 1 en " + i + " " + j);
                    if (j == 0) {
                        vecinas += matrix[i][j + 1].equals("C") ? 1 : 0;
                        vecinas += matrix[i + 1][j + 1].equals("C") ? 1 : 0;
                    } else if (j == matrix.length - 1) {
                        vecinas += matrix[i][j - 1].equals("C") ? 1 : 0;
                        vecinas += matrix[i + 1][j - 1].equals("C") ? 1 : 0;
                    } else {
                        vecinas += matrix[i][j - 1].equals("C") ? 1 : 0;
                        vecinas += matrix[i][j + 1].equals("C") ? 1 : 0;
                        vecinas += matrix[i + 1][j - 1].equals("C") ? 1 : 0;
                        vecinas += matrix[i + 1][j + 1].equals("C") ? 1 : 0;
                    }
                    vecinas += matrix[i + 1][j].equals("C") ? 1 : 0;
                } else if (j == 0) {
                    //System.out.println("entro al 2 en " + i + " " + j);
                    if (i == matrix.length - 1) {
                        vecinas += matrix[i - 1][j].equals("C") ? 1 : 0;
                    } else {
                        vecinas += matrix[i - 1][j].equals("C") ? 1 : 0;
                        vecinas += matrix[i + 1][j].equals("C") ? 1 : 0;
                        vecinas += matrix[i + 1][j + 1].equals("C") ? 1 : 0;
                    }
                    vecinas += matrix[i - 1][j + 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i][j + 1].equals("C") ? 1 : 0;
                } else if (j == matrix.length - 1) {
                    //System.out.println("entro al 3 en " + i + " " + j);
                    if (i != matrix.length - 1) {
                        vecinas += matrix[i + 1][j].equals("C") ? 1 : 0;
                        vecinas += matrix[i + 1][j - 1].equals("C") ? 1 : 0;
                    }
                    vecinas += matrix[i - 1][j].equals("C") ? 1 : 0;
                    vecinas += matrix[i - 1][j - 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i][j - 1].equals("C") ? 1 : 0;
                } else if (i == matrix.length - 1) {
                    //System.out.println("entro al 4 en " + i + " " + j);
                    vecinas += matrix[i - 1][j].equals("C") ? 1 : 0;
                    vecinas += matrix[i - 1][j + 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i - 1][j - 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i][j - 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i][j + 1].equals("C") ? 1 : 0;
                } else {
                    //System.out.println("entro al 5 en " + i + " " + j);
                    vecinas += matrix[i - 1][j - 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i - 1][j].equals("C") ? 1 : 0;
                    vecinas += matrix[i - 1][j + 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i][j + 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i + 1][j + 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i + 1][j].equals("C") ? 1 : 0;
                    vecinas += matrix[i + 1][j - 1].equals("C") ? 1 : 0;
                    vecinas += matrix[i][j - 1].equals("C") ? 1 : 0;
                }

                verificar(vecinas, i, j);
                vecinas = 0;
            }
            //vecinas = 0;
        }
        matrix = copia;
        copia = rellenar(matrix.length);
        //generation++;
        //System.out.println(population);
       contar();
    }

    private void verificar(int vecinas, int x, int y) {
        //System.out.println(vecinas+" en "+x+" "+y);
        if (vecinas == 3) {
            copia[x][y] = "C";
        } else if (vecinas == 2 || vecinas == 3) {
            if (matrix[x][y].equals("C")) {
                copia[x][y] = "C";
            } else {
                copia[x][y] = "-";
            }
        }
    }

    private String[][] rellenar(int tam) {
        String matrix[][] = new String [tam][tam];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = "-";
            }
        }
        return matrix;
    }
public void reiniciarMatriz(){
    matrix = rellenar(matrix.length);
    copia = rellenar(matrix.length);
    population = 0;
    generation = 0;
}
    public void contar() {
        int contador = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == "C") {
                    contador++;
                }
            }
        }
        population = contador;
    }

    public void imprimir(String matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void ponerCelula(int x, int y, String cell) {
        matrix[x][y] = cell;
        population += cell.equals("C") ? 1 : -1;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // agregar metodos de botones
    public void start() {
        sim = new Simulation(ctrl, this);
        sim.start(70);
    }

    public void stop() {
        sim.stop();
        //System.exit(0);
    }

    public void pause() {
        sim.pause();
    }

}
