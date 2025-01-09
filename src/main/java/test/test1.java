/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.Scanner;

/**
 *
 * @author hungk
 */
class Item {
    protected int value;
    protected String creator;

    public Item() {
        value = 0;
        creator = "";
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void input(Scanner scanner) {
        try {
            System.out.println("Enter value:");
            value = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter creator:");
            creator = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public String toString() {
        return value + " " + creator;
    }
}

class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
        super();
        height = 0;
        material = "";
    }

    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void input(Scanner scanner) {
        super.input(scanner);
        try {
            System.out.println("Enter height:");
            height = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter material:");
            material = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public String toString() {
        return super.toString() + " " + height + " " + material;
    }
}

class Statue extends Item {
    private int weight;
    private String colour;

    public Statue() {
        super();
        weight = 0;
        colour = "";
    }

    public Statue(int value, String creator, int weight, String colour) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void input(Scanner scanner) {
        super.input(scanner);
        try {
            System.out.println("Enter weight:");
            weight = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter colour:");
            colour = scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public String toString() {
        return super.toString() + " " + weight + " " + colour;
    }
}

class Painting extends Item {
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {
        super();
        height = 0;
        width = 0;
        isWatercolour = false;
        isFramed = false;
    }

    public Painting(int value, String creator, int height, int width, boolean isWatercolour, boolean isFramed) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isWatercolour() {
        return isWatercolour;
    }

    public void setWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    public void input(Scanner scanner) {
        super.input(scanner);
        try {
            System.out.println("Enter height:");
            height = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter width:");
            width = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Enter if it's watercolour (true/false):");
            isWatercolour = Boolean.parseBoolean(scanner.nextLine().trim());
            System.out.println("Enter if it's framed (true/false):");
            isFramed = Boolean.parseBoolean(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public String toString() {
        return super.toString() + " " + height + " " + width + " " + isWatercolour + " " + isFramed;
    }
}

class ItemList {
    Item[] list;
    int numOfItem;
    final int MAX = 100;

    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }

    public boolean addItem(Item item) {
        if (item == null || numOfItem >= MAX) {
            return false;
        }
        list[numOfItem] = item;
        numOfItem++;
        return true;
    }

    public void displayAll() {
        if (numOfItem == 0) {
            System.out.println("The list is empty");
        }
        for (int i = 0; i < numOfItem; i++) {
            System.out.println(list[i]);
        }
    }

    public Item findItem(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equals(creator)) {
                return list[i];
            }
        }
        return null;
    }

    public int findItemIndex(String creator) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().equals(creator)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateItem(int index, Scanner scanner) {
        if (index >= 0 && index < numOfItem) {
            list[index].input(scanner);
            return true;
        }
        return false;
    }

    public boolean removeItem(int index) {
        if (index >= 0 && index < numOfItem) {
            for (int j = index; j < numOfItem - 1; j++) {
                list[j] = list[j + 1];
            }
            list[numOfItem - 1] = null; // clear the last element
            numOfItem--;
            return true;
        }
        return false;
    }

    public void displayItemsByType(String type) {
        if (type.equals("Vase")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i]);
                }
            }
        } else if (type.equals("Statue")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i]);
                }
            }
        } else if (type.equals("Painting")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i]);
                }
            }
        }
    }

    public void sortItems() {
        for (int i = 0; i < numOfItem; i++) {
            for (int j = numOfItem - 1; j > i; j--) {
                if (list[j].getValue() < list[j - 1].getValue()) {
                    Item tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
    }
}

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList obj = new ItemList();

        int choice = 0;
        do {
            System.out.println("1. add a new vase");
            System.out.println("2. add a new statue");
            System.out.println("3. add a new painting");
            System.out.println("4. display all items");
            System.out.println("5. find the items by the creator");
            System.out.println("6. update the item by its index");
            System.out.println("7. remove the item by its index");
            System.out.println("8. display the list of vase items");
            System.out.println("9. sorts items in ascending order based on their values");
            System.out.println("10. exit");
            System.out.println("input your choice:");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: {
                    Item tmp = new Vase();
                    tmp.input(sc);
                    if (obj.addItem(tmp)) {
                        System.out.println("One vase added");
                    }
                    break;
                }
                case 2: {
                    Item tmp = new Statue();
                    tmp.input(sc);
                    if (obj.addItem(tmp)) {
                        System.out.println("One statue added");
                    }
                    break;
                }
                case 3: {
                    Item tmp = new Painting();
                    tmp.input(sc);
                    if (obj.addItem(tmp)) {
                        System.out.println("One painting added");
                    }
                    break;
                }
                case 4: {
                    obj.displayAll();
                    break;
                }
                case 5: {
                    System.out.println("Enter creator:");
                    String creator = sc.nextLine().trim();
                    Item item = obj.findItem(creator);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter index to update:");
                    int index = sc.nextInt();
                    sc.nextLine(); // consume newline
                    if (obj.updateItem(index - 1, sc)) {
                        System.out.println("One item updated");
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Enter index to remove:");
                    int index = sc.nextInt();
                    sc.nextLine(); // consume newline
                    if (obj.removeItem(index - 1)) {
                        System.out.println("One item removed");
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                }
                case 8: {
                    System.out.println("Enter type (Vase, Statue, Painting):");
                    String type = sc.nextLine().trim();
                    obj.displayItemsByType(type);
                    break;
                }
                case 9: {
                    obj.sortItems();
                    obj.displayAll();
                    break;
                }
                case 10: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                }
            }
        } while (choice != 10);

        sc.close();
    }
}
