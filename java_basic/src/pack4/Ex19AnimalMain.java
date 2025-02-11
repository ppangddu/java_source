package pack4;

public class Ex19AnimalMain {
    public static void main(String[] args) {
//        Ex19Animal animal = new Ex19Animal(); //X, 추상 클래스는 new 할 수 없다.
        Ex19Cow cow = new Ex19Cow();
        System.out.println(cow.name() + " " + cow.eat() + " " + cow.action());
        cow.print(); //cow에 print메서드 없으니까 부모 클래스에서 찾는다.

        Ex19Lion lion = new Ex19Lion();
        System.out.println(lion.name() + " " + lion.eat() + " " + lion.action());
        lion.print();
        lion.eatOther();

        System.out.println();
        Ex19Animal animal;
        animal = cow;
        System.out.println(animal.name() + " " + animal.eat() + " " + animal.action());
        animal = lion;
        System.out.println(animal.name() + " " + animal.eat() + " " + animal.action());

        if (cow instanceof Ex19Cow) {
            System.out.println("ㅇㅇ");
        } else {
            System.out.println("ㄴㄴ");
        }

        System.out.println(cow instanceof Ex19Animal);
        System.out.println(lion instanceof Ex19Animal);

        System.out.println("\n 메소드 호출하여 매개변수에 주소 치환");
        Ex19AnimalFind animalFind = new Ex19AnimalFind(); //클래스의 포함 관계
        animalFind.find(cow); //animal = 주소를 치환한다는 점에서 animal = cow;와 같은 의미

        System.out.println();
        animalFind.find(lion); //animal = lion;과 똑같다. 메서드에 매개변수를 넘긴 것



    }
}
