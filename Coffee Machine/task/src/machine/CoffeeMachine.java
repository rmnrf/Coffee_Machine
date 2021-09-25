package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    enum States {
        PENDING_ACTION, CHOOSE_COFFEE, FILL_WATER, FILL_MILK, FILL_COFFEE_BEANS, ADD_CUPS
    }

    static States state = States.PENDING_ACTION;

    public  static void showInfo() {
        switch (state) {
            case PENDING_ACTION:
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case CHOOSE_COFFEE:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case FILL_WATER:
                System.out.println("Write how many ml of water you want to add:");
                break;
            case FILL_MILK:
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case FILL_COFFEE_BEANS:
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case ADD_CUPS:
                System.out.println("Write how many disposable cups of coffee you want to add:");
                break;
            default:
                break;
        }
    }

    public static void doAction(String input) {
        switch (state) {
            case PENDING_ACTION:
                switch (input) {
                    case "buy":
                        state = States.CHOOSE_COFFEE;
                        break;
                    case "fill":
                        state = States.FILL_WATER;
                        break;
                    case "take":
                        System.out.println();
                        System.out.println("I gave you $" + money);
                        money = 0;
                        state = States.PENDING_ACTION;
                        break;
                    case "remaining":
                        System.out.println();
                        System.out.println("The coffee machine has:");
                        System.out.println(water + " ml of water");
                        System.out.println(milk + " ml of milk");
                        System.out.println(coffeeBeans + " g of coffee beans");
                        System.out.println(cups + " disposable cups");
                        System.out.println("$" + money + " of money");
                        state = States.PENDING_ACTION;
                        break;
                    case "exit":
                        break;
                    default:
                        break;
                }
                break;
            case CHOOSE_COFFEE:
                switch (input) {
                    case "1":
                        if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250;
                            coffeeBeans -= 16;
                            cups--;
                            money += 4;
                        } else if (water < 250) {
                            System.out.println("Sorry, not enough water!");
                        } else if (coffeeBeans < 16) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (cups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                        break;
                    case "2":
                        if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350;
                            milk -= 75;
                            coffeeBeans -= 20;
                            cups--;
                            money += 7;
                        } else if (water < 350) {
                            System.out.println("Sorry, not enough water!");
                        } else if (milk < 75) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (coffeeBeans < 20) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (cups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                        break;
                    case "3":
                        if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 200;
                            milk -= 100;
                            coffeeBeans -= 12;
                            cups--;
                            money += 6;
                        } else if (water < 200) {
                            System.out.println("Sorry, not enough water!");
                        } else if (milk < 100) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (coffeeBeans < 12) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (cups < 1) {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                        break;
                    default:
                        break;
                }
                state = States.PENDING_ACTION;
                break;
            case FILL_WATER:
                water += Integer.parseInt(input);
                state = States.FILL_MILK;
                break;
            case FILL_MILK:
                milk += Integer.parseInt(input);
                state = States.FILL_COFFEE_BEANS;
                break;
            case FILL_COFFEE_BEANS:
                coffeeBeans += Integer.parseInt(input);
                state = States.ADD_CUPS;
                break;
            case ADD_CUPS:
                cups += Integer.parseInt(input);
                state = States.PENDING_ACTION;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            CoffeeMachine.showInfo();
            input = scanner.next();
            CoffeeMachine.doAction(input);
            System.out.println();
        } while (!input.equals("exit"));
    }
}

