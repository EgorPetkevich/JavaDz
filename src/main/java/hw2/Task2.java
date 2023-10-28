package hw2;

public class Task2 {
        // Интерфейс Shape определяет общие методы и свойства для фигур.
        public interface Shape {
            int getWidth();
            int getHeight();
            double area();
        }

        // Класс Rectangle реализует интерфейс Shape и представляет прямоугольник.
        public static class Rectangle implements Shape {
            private final int width;
            private final int height;

            // Конструктор для создания прямоугольника с заданными шириной и высотой.
            public Rectangle(int width, int height) {
                this.width = width;
                this.height = height;
            }

            // Реализация метода getWidth для прямоугольника.
            public int getWidth() {
                return width;
            }

            // Реализация метода getHeight для прямоугольника.
            public int getHeight() {
                return height;
            }

            // Реализация метода area для вычисления площади прямоугольника.
            public double area() {
                return width * height;
            }
        }

    public static class Square extends Rectangle {
        private  int side;
        public Square(int width, int height) {
            super(width, height);
            this.side = width;
            this.side = height;
        }

        public int getSide(){
            return side;
        }
    }

    public static void main(String[] args) {
        var rectangle = new Rectangle( 4 ,7);
        var square = new Square(4,4);

        System.out.println(rectangle.area() );
        System.out.println(square.area() );
    }
}
