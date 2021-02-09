package itmo.java_base.lesson5;

public class Main5 {
    public static void main(String[] args) {
     Vector vector1 = new Vector(1, 2, 3);
     Vector vector2 = new Vector(5, 2, 4);
        System.out.println("Task1");
        System.out.println(vector1.getVectorLength());
        System.out.println(vector2.getVectorLength());
        System.out.println();


        System.out.println("Task2");
        System.out.println(Vector.scalarMultiplication(vector1, vector2));
        System.out.println();

        System.out.println("Task3");
        Vector vector3 = Vector.multiplyVectors(vector1, vector2);
        System.out.println("New Vector: " + vector3.getX() + "," + vector3.getY() + ", " + vector3.getZ());
        System.out.println();

        System.out.println("Task4");
        System.out.println(Vector.getCornerValue(vector1, vector2));
        System.out.println();

        System.out.println("Task5");
        Vector vec = Vector.minus(vector1, vector2);
        Vector vec2 = Vector.plus(vector1, vector2);
        System.out.println("Vectors minus: " + vec.getX() + ", " + vec.getY() + ", " + vec.getZ());
        System.out.println("Vectors plus: " + vec2.getX() + ", " + vec2.getY() + ", " + vec2.getZ());
        System.out.println();

        System.out.println("Task6");
        Vector[] vectors = Vector.vectors(5);
        for(Vector vector : vectors)
            System.out.println("Vector: " + vector.toString());

    }
}

class Vector{
    private int x, y, z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getVectorLength(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public static int scalarMultiplication(Vector vector1, Vector vector2){
        return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z;
    }

    public static Vector multiplyVectors(Vector vector1, Vector vector2){
        return new Vector(vector2.y * vector1.z - vector2.z * vector1.y,
                          vector2.z * vector1.x - vector2.x * vector1.z,
                          vector2.x * vector1.y - vector2.y * vector1.x);
    }

    public static double getCornerValue(Vector vector1, Vector vector2){
        int scalar = scalarMultiplication(vector1, vector2);

        double length1 = Math.abs(vector1.getVectorLength()) ;
        double length2 = Math.abs(vector2.getVectorLength());

        return scalar/(length1 * length2);
    }

    public static   Vector minus(Vector vector1, Vector vector2){
        return new Vector(vector1.x - vector2.x, vector1.y - vector2.y, vector1.z - vector2.z);
    }
    public static   Vector plus(Vector vector1, Vector vector2){
        return new Vector(vector1.x + vector2.x, vector1.y + vector2.y, vector1.z + vector2.z);
    }

    public static Vector[] vectors (int n){
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector((int)(Math.random() * 10),(int)(Math.random() * 10),(int) (Math.random() * 10));
        }
        return vectors;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
