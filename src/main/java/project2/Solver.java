package project2;

import java.util.ArrayDeque;

public class Solver {
    char[][] maze;  //Двумерный массив для представления лабиринта

    ArrayDeque<Integer[]> path;  //стек используется для отслеживания местоположения

    int rows;  //Строки
    int cols;  //Столбцы


    public Solver(char[][] feild)
    {
        //инициализирует массив прохождение лабиринта и длины введенного массива
        maze = new char[feild.length][feild[1].length];

        //копирует содержимое входного массива в массив прохождения лабиринта
        for(int i=0; i<feild.length; i++){
            for(int j=0; j<feild[i].length; j++){
                maze[i][j] = feild[i][j];
            }
        }

        //установка строк и столбцов
        rows = feild.length;
        cols = feild[0].length;

        //инициализируем стек, который отслеживает путь в лабиринте в большом размере
        path = new ArrayDeque<Integer[]>(rows*cols);

    }//конструктор конец )



    //Возвращаем лабиринт

    public char[][] getMaze()
    {
        return maze;
    }

    public void setInitialLocation()
    {

        Integer[] temp = new Integer[2]; //доступ


        //перебор и поиск входа
        for(int i=0; i<maze.length; i++)
        {
            //если он находит пустое место, это вход
            if(maze[i][0] == ' '){

                //набор текущего положения
                temp[0] = i;
                temp[1] = 0;

                //устанавливаем указатель -
                maze[temp[0]][temp[1]] = '-';
                path.addFirst(temp);

            }
        }
    }


    public int canSolveUp()
    {
        Integer[] temp = new Integer[2]; //Массив для получения доступа
        temp = path.peekFirst();

        int nRow = temp[0]-1; //устанавливаем следующее местоположение
        int nCol = temp[1];

        //если рядом есть правильный путь, вернуть 1
        if(nRow > 0){
            if( maze[nRow][nCol] == ' '){
                return 1;
            }
        }

        return 0; //иначе 0

    }

    public int canSolveRight()
    {
        Integer[] temp = new Integer[2]; //получаем доступ
        temp = path.peek();

        int nRow = temp[0];   //переходим дальшн
        int nCol = temp[1]+1;

        //если рядом есть правильный путь, вернуть 1
        if(nCol < cols){
            if( maze[nRow][nCol] == ' '){
                return 2;
            }
        }

        return 0; //иначе 0

    }

    public int canSolveDown()
    {
        Integer[] temp = new Integer[2]; //проверям доступ
        temp = path.peek();

        int nRow = temp[0]+1;  //переход дальше
        int nCol = temp[1];

        //если рядом есть правильный путь, вернуть 3
        if(nRow < rows){
            if( maze[nRow][nCol] == ' '){
                return 3;
            }
        }

        return 0;  //иначе 0

    }

    public int canSolveLeft()
    {
        Integer[] temp = new Integer[2]; //проверяем доступ
        temp = path.peek();

        int nRow = temp[0];   //переходим дальше
        int nCol = temp[1]-1;


        //если рядом есть правильный путь, вернуть 4
        if(nCol > 0){
            if( maze[nRow][nCol] == ' '){
                return 4;
            }
        }

        return 0; //иначе 0

    }



    public int[] canSolve()
    {
        int[] cut = new int[4];
        int place =0;
        //проверка направления(ввех)
        if(canSolveUp() !=   0){
            cut[place] = canSolveUp();
            place++;
        }
        //проверка направления(вправо)
        if(canSolveRight() != 0){
            cut[place] = canSolveRight();
            place++;
        }
        //проверка направления(вниз)
        if(canSolveDown() != 0){
            cut[place] = canSolveDown();
            place++;
        }
        //проверка направления(влево)
        if(canSolveLeft() != 0){
            cut[place] = canSolveLeft();
            place++;
        }

        //возвращаем ноль, если нет направления
        if(place == 0){
            for(int i = 0; i<4; i++){
                cut[i] = 0;
            }
            return cut;

        } else { //иначе уменьшить массив и вернуть его
            int[] cancut = new int[place];
            for(int i=0; i<place; i++){
                cancut[i] = cut[i];
            }

            return cancut;
        }
    }



    public void solveUp()
    {
        Integer[] current = path.peek(); //текущее положение
        Integer[] temp = new Integer[2]; //получение следующего положения

        int nRow = current[0]-1;  //переход дальше
        int nCol = current[1];


        maze[nRow][nCol] = '-'; //устанавливаем указатель

        temp[0] = nRow;
        temp[1] = nCol;

        path.addFirst(temp);  //помещаем в стек, устанавливаем указатель -

    }

    public void solveRight()
    {
        Integer[] current = path.peek(); //получаем положение
        Integer[] temp = new Integer[2]; //добавляем следующее

        int nRow = current[0];   //переход дальше
        int nCol = current[1]+1;
        maze[nRow][nCol] = '-';  //устанавливаем указатель

        temp[0] = nRow;
        temp[1] = nCol;

        path.addFirst(temp); //помещаем в стек, устанавливаем указатель -

    }

    public void solveDown()
    {
        Integer[] temp = new Integer[2]; //текущее положение
        Integer[] current = path.peek(); //добавление следующего положения

        int nRow = current[0]+1;   //переход
        int nCol = current[1];
        maze[nRow][nCol] = '-';  //помещаем в стек, устанавливаем указатель -

        temp[0] = nRow;
        temp[1] = nCol;

        path.addFirst(temp); //pushes the next location to the stack

    }

    public void solveLeft()
    {
        Integer[] temp = new Integer[2]; //текущее положение
        Integer[] current = path.peek(); //добаление следующего положения

        int nRow = current[0];   //переход
        int nCol = current[1]-1;
        maze[nRow][nCol] = '-';  //помещаем в стек, устанавливаем указатель -

        temp[0] = nRow;
        temp[1] = nCol;

        path.addFirst(temp); //Добавляем в стек

    }

    public boolean nearExit()
    {
        Integer[] temp = new Integer[2];
        temp = path.peek();

        if(temp[1] == maze[0].length-2){
            if(maze[temp[0]][temp[1]+1] == ' '){
                return true;
            }
        }

        return false;
    }

    public void goToExit()
    {
        Integer[] temp = new Integer[2]; //доступ к стеку
        Integer[] current = path.peek(); //текущее положение

        temp[0] = current[0];   //Выход справа
        temp[1] = current[1]+1;

        maze[temp[0]][temp[1]] = '-'; //устанавливаем указатель  -

        path.push(temp); //добавляем в стек

    }

    public void backTrack()
    {
        path.removeFirst();

    }


    public void solvePath()
    {
        Integer[] temp = new Integer[2]; //доступ к стеку


        //если объекты в стеке
        while(path.peek() != null){

            temp = path.pop(); //текущее положение

            maze[temp[0]][temp[1]] = '+'; //устанавливаем указатель +
        }

        //cleans up the maze
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(maze[i][j] == '-')
                    maze[i][j] = ' ';
            }
        }

    }

    public void solveMaze()
    {


        int[] solve_order; //хранит возможные ходы для каждого положения

        setInitialLocation(); //поиск начала лабиринта

        while( ! nearExit() ){

            solve_order = canSolve(); /*получение возможных направлений*/

            if(solve_order[0] == 0){  //если тупик
                backTrack();    //идти назад и искать другое направление

            }else{ //выбрать направление для решения
                if(solve_order[0] == 1){
                    solveUp();
                }else if(solve_order[0] == 2){
                    solveRight();
                }else if(solve_order[0] == 3){
                    solveDown();
                }else if(solve_order[0] == 4){
                    solveLeft();
                }
            }

        }

        goToExit(); //после выхода из цикла идем прямо
        //если следующий - выход идем к нему

        solvePath(); //весь путь
        //устанавливаем указатель +


    }

    public char[][] getSolution()
    {
        return maze;
    }

    public void printSolution()
    {
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
