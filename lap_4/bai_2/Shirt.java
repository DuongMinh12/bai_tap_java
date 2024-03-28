public class Shirt {
    private ColorEnum color;
    private SizeEnum size;

    public Shirt(ColorEnum color, SizeEnum size) {
        this.color = color;
        this.size = size;
    }

    public ColorEnum getColor() {
        return color;
    }

    public SizeEnum getSize() {
        return size;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public void setSize(SizeEnum size) {
        this.size = size;
    }

    public void Xuat() {
        System.out.println("Shirt {\nColor: " + getColor());
        System.out.println("Size: " + getSize() + " }");
        System.out.println();
    }
}

// Em xin phép sửa tên biến để dễ nhìn, em code mobile nên trong Framework của
// em có kiểu dữ liệu Color và Size nên em bị nhầm ạ.
// Em xin hứa thi em không làm như thế đâu (T^T)

enum ColorEnum {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum SizeEnum {
    S, M, L, XL, XXL
}
