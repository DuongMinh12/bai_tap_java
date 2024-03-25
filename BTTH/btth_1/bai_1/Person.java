public class Person {
    protected String name;
    protected int age;
    protected String address;

    public Person() {
        this.name = "";
        this.age = 0;
        this.address = "";
    }

    public Person(String ten, int tuoi, String diachi) {
        this.name = ten;
        this.age = tuoi;
        this.address = diachi;
    }

    public void in4() {
        System.out.println("Ho ten: " + this.name);
        System.out.println("Tuoi: " + this.age);
        System.out.println("Dia chi: " + this.address);
    }

}
