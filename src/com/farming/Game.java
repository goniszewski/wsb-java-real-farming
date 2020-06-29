package com.farming;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Integer week = 0;
    private Player player;
    private ArrayList<Farm> availableFarms = new ArrayList<>();
    private ArrayList<Building> availableBuildings = new ArrayList<>();
    private ArrayList<Seeds> availableSeeds = new ArrayList<>();
    private ArrayList<Crop> availableCrops = new ArrayList<>();
    private ArrayList<Yield> availableYields = new ArrayList<>();
    private ArrayList<Animal> availableAnimals = new ArrayList<>();
    private Integer harvestLeftovers = 0;

    private String menu = "";
    private String choice = "";
    private Boolean wasInitiated = false;


    public Game(Player player) {
        this.week = 0;
        this.player = player;
    }

    //getters
    public Integer getWeek() {
        return week;
    }

    public String getChoice() {
        return choice;
    }

    public ArrayList<Farm> getAvailableFarms() {
        return availableFarms;
    }

    public String getMenu() {
        return menu;
    }

    //setters
    public void setWeek(Integer week) {
        this.week = week;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setAvailableFarms(Farm farm) {
        this.availableFarms.add(farm);
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getWeeklyExpenses() {
        Integer weeklyExpenses = 0;
        if (player.getFarm() != null) {
            for (Crop crop : player.getFarm().getCrops()) {
                weeklyExpenses += crop.getProtectionCostPerH();
            }
        }
        return weeklyExpenses;
    }


    public void nextWeek() {
        setWeek(week + 1);
        player.setCash(player.getCash() - getWeeklyExpenses());
        Integer foodEaten = 0;
        for (Animal animal : player.getFarm().getAnimals()) {
            foodEaten += animal.getEats();
            animal.setAge(animal.getAge() + 1);
        }
        for (Crop crop : player.getFarm().getCrops()) {
            crop.setAge(crop.getAge() + 1);
        }
    }

    public void startGame() {
        setWeek(0);
        player.setCash(500000);
        player.setFarm(null);
        availableFarms = new ArrayList<>();
        availableBuildings = new ArrayList<>();
        availableSeeds = new ArrayList<>();
        availableYields = new ArrayList<>();
        availableCrops = new ArrayList<>();
        availableAnimals = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            this.availableFarms.add(generateFarm(randInt(0, 1), randInt(0, 1)));
        }
        for (int i = 0; i < 5; i++) {
            this.availableBuildings.add(generateBuilding("obora"));
            this.availableBuildings.add(generateBuilding("stodoła"));
        }
        if (!wasInitiated) {
            initiateGame();
        }
    }

    public String userInput(String nextMenu) {
        Scanner scanner = new Scanner(System.in);
        this.choice = scanner.nextLine();
        this.menu = nextMenu;
        choiceSelector(choice);
        return choice;
    }

    public void showMenu() {
        System.out.println("\n\n" + "-".repeat(20));
        System.out.println("Tydzień " + this.week + ", stan konta: " + this.player.getCash() + " zł, wydatki: " + getWeeklyExpenses() + " zł/tyg.\n");
        if (player.getFarm() != null) {
            System.out.println("1. Kolejny tydzień");
        } else {
            System.out.println("1. Nowa gra");
        }
        if (this.player.getFarm() != null) {
            System.out.println("2. Informacje o farmie 🏘");
            System.out.println("3. Pokaż uprawy");
            System.out.println("4. Pokaż posiadane nasiona");
            System.out.println("5. Pokaż posiadane zbiory");
            System.out.println("6. Pokaż posiadane zwierzęta");
            System.out.println("\nN. Zakończ grę i rozpocznij nową");
        } else {
            System.out.println("2. Kup farmę");
            System.out.println("Aby kupić sadzonki potrzebujesz farmy");
            System.out.println("Aby kupić zwierzęta potrzebujesz farmy");
            System.out.println("\n'N' -> Zakończ grę i rozpocznij nową 🧨");
        }
        System.out.println("-".repeat(20) + "\n");
        userInput("main");
    }

    public void choiceSelector(String selectedChoice) {
        switch (selectedChoice) {
            case "1":
                switch (menu) {
                    case "main":
                        if (player.getFarm() != null) {
                            nextWeek();
                        } else {
                            startGame();
                        }
                        showMenu();
                }
            case "2":
                switch (menu) {
                    case "main":
                        if (this.player.getFarm() != null) {
                            System.out.println("\nInformacje o farmie:\n");
                            System.out.println(player.getFarm().toString());
                            System.out.println("\nNaciśnij 'L' aby przejść do zakupu ziemi.");
                            System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.\n\n");
                            userInput("main");
                        } else {
                            int farmNo = 1;
                            System.out.println("\nKtórą farmę chcesz kupić?\n");
                            for (Farm farm : availableFarms) {
                                System.out.println(farmNo + ". " + ((farm.toString() == null) ? "Brak farmy." : farm.toString()));
                                farmNo++;
                            }
                            System.out.println("\nWybierz numer farmy, którą chcesz kupić albo naciśnij '0' aby wrócić do głównego menu.\n\n");
                            String selected = "";
                            Scanner scanner = new Scanner(System.in);
                            selected = scanner.nextLine();
                            if (selected.equals("0")) {
                                choiceSelector("menu");
                            }
                            try {
                                availableFarms.get((Integer.parseInt(selected) - 1)).buyFarm(player);
                                showMenu();
                            } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                                choiceSelector(selected);
                            }
                        }
                }
            case "3":
                switch (menu) {
                    case "main":
                        if (player.getFarm().getCrops().isEmpty()) {
                            System.out.println("\nObecnie nie posiadasz żadnych upraw.");
                            System.out.println("\nNaciśnij 'P' aby przejść do sadzenia roślin.");
                            System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.\n\n");
                            userInput("main");
                        } else {
                            int cropNo = 1;
                            System.out.println("\n\n" + "-".repeat(20));
                            System.out.println("\nLista upraw:\n");
                            for (Crop crop : player.getFarm().getCrops()) {
                                System.out.println(cropNo + ". " + ((crop == null) ? "Brak upraw w posiadaniu." : crop.toString()));
                                cropNo++;
                            }
                            System.out.println("\nDokonaj zbiorów danej rośliny albo naciśnij '0' aby wrócić do głównego menu.\n\n");
                            String selected = "";
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.\n\n");
                            selected = scanner.nextLine();
                            if (selected.equals("0")) {
                                choiceSelector("menu");
                            }
                            try {
                                player.getFarm().getCrops().get((Integer.parseInt(selected)-1)).harvestCrop(player);
                                choiceSelector("3");
                            } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                                choiceSelector(selected);
                            }
                        }
                }

            case "4":
                switch (menu) {
                    case "main":
                        int seedsNo = 1;
                        if (player.getFarm().getSeeds().isEmpty()) {
                            System.out.println("\n\n" + "-".repeat(20));
                            System.out.println("\nObecnie nie posiadasz żadnych nasion.\n");
                            System.out.println("\nNaciśnij 'S' aby przejść do zakupu nasion.");
                            System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.\n\n");
                            userInput("main");
                        } else {
                            System.out.println("\n\n" + "-".repeat(20));
                            System.out.println("\nWykaz nasion na stanie:\n");
                            for (Seeds seeds : player.getFarm().getSeeds()) {
                                System.out.println(seedsNo + ". " + ((seeds == null) ? "Brak nasion w posiadaniu." : seeds.toString()));
                                seedsNo++;
                            }
                            String selected = "";
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("\nNaciśnij 'S' aby przejść do zakupu nasion.");
                            System.out.println("\nSprzedaj 1 tonę danych nasion albo naciśnij '0' aby wrócić do głównego menu.\n\n");
                            selected = scanner.nextLine();
                            if (selected.equals("0")) {
                                choiceSelector("menu");
                            }
                            try {
                                player.getFarm().sellSeeds(player,(Integer.parseInt(selected)-1),1000);
                                choiceSelector("4");
                            } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                                choiceSelector(selected);
                            }
                        }
                }
            case "5":
                switch (menu) {
                    case "main":
                        int yieldNo = 1;
                        if (player.getFarm().getYields().isEmpty()) {
                            System.out.println("\n\n" + "-".repeat(20));
                            System.out.println("\nObecnie nie posiadasz żadnych zbiorów.");
                            System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.");
                            userInput("main");
                        } else {
                            System.out.println("\n\n" + "-".repeat(20));
                            System.out.println("\nWykaz zbiorów:\n");
                            for (Yield yield : player.getFarm().getYields()) {
                                System.out.println(yieldNo + ". " + ((yield == null) ? "Brak zbiorów w posiadaniu." : yield.toString()));
                                yieldNo++;
                            }
                            String selected = "";
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("\nSprzedaj 1 tonę danych zbiorów albo naciśnij '0' aby wrócić do głównego menu.\n\n");
                            selected = scanner.nextLine();
                            if (selected.equals("0")) {
                                choiceSelector("menu");
                            }
                            try {
                                player.getFarm().sellYields(player,Integer.parseInt(selected)-1,1000);
                                choiceSelector("4");
                            } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                                choiceSelector(selected);
                            }
                        }
                }
            case "6":
                switch (menu) {
                    case "main":
                        int animalNo = 1;
                        if (player.getFarm().getAnimals().isEmpty()) {
                            System.out.println("\nObecnie nie posiadasz żadnych zwierząt.");
                            System.out.println("\n\nNaciśnij 'A' aby przejść do zakupu zwierząt.");
                            System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.\n\n");
                            userInput("main");
                        } else {
                            for (Animal animal : player.getFarm().getAnimals()) {
                                System.out.println(animalNo + ". " + ((animal == null) ? "Brak zwierząt w posiadaniu." : animal.toString()));
                                animalNo++;
                            }


                            String selected = "";
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("\nSprzedaj dane zwierzę albo naciśnij '0' aby wrócić do głównego menu.\n\n");
                            selected = scanner.nextLine();
                            if (selected.equals("0")) {
                                choiceSelector("menu");
                            }
                            try {
                                player.getFarm().sellAnimal
                                choiceSelector("4");
                            } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                                choiceSelector(selected);
                            }



                            System.out.println("\nNaciśnij 'A' aby przejść do zakupu zwierząt.");
                            System.out.println("\nSprzedaj dane zwierzę albo naciśnij '0' aby wrócić do głównego menu.\n\n");
                            userInput("sellAnimal");
                        }
                }
            case "7":
                switch (menu) {
                    case "main":

                }
            case "0":
                setMenu("main");
                showMenu();
            case "n":
            case "N":
                wasInitiated = false;
                startGame();
                showMenu();
            case "s":
            case "S":
                System.out.println("\n\n" + "-".repeat(20));
                System.out.println("W budynkach jest miejsca na: " + (player.getFarm().canHoldStocks() - player.getFarm().nowHoldsStocks()) + " kg, tydzień: " + week + ", PLN: " + this.player.getCash() + "\n");
                if (!availableSeeds.isEmpty()) {
                    int seedsNo = 1;
                    for (Seeds seeds : availableSeeds) {
                        System.out.println(seedsNo + ". " + seeds.getName() + " (materiał na zasianie 1 ha: " + seeds.getNeedsKgPerH() + " kg) - " + seeds.getBuyPricePerKg() * seeds.getNeedsKgPerH() + " zł.");
                        seedsNo++;
                    }
                    System.out.println("\nWybierz nasiona do zakupu albo naciśnij '0' aby wrócić do głównego menu.\n\n");
                    if (player.getFarm() == null) {
                        showMenu();
                    } else {
                        String selected = "";
                        Scanner scanner = new Scanner(System.in);
                        selected = scanner.nextLine();
                        if (selected.equals("0")) {
                            choiceSelector("menu");
                        }
                        try {
                            player.getFarm().buySeeds(player, availableSeeds.get((Integer.parseInt(selected) - 1)));
                            choiceSelector("s");
                        } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                            choiceSelector(selected);
                        }
                    }
                } else {
                    System.out.println("\nOho, ktoś tutaj nie zainicjował instancji!");
                    System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.\n\n");
                    setMenu("main");
                }
                System.out.println("-".repeat(20) + "\n");
            case "a":
            case "A":
                setMenu("buyAnimal");
                showMenu();
            case "p":
            case "P":
                System.out.println("\n\n" + "-".repeat(20));
                System.out.println("Ilość wolnych pól: " + player.getFarm().displayFreeHectares() + " ha, tydzień: " + week + ", stan konta: " + this.player.getCash() + " zł\n");
                if (!availableCrops.isEmpty()) {
                    int seedsNo = 1;
                    for (Seeds seeds : player.getFarm().getSeeds()) {
                        System.out.println(seedsNo + ". " + seeds.getName() + " ( sadzić po/przed: " + seeds.getCanBePlantedStartedIn() + "/" + seeds.getMustBePlantedBefore() + " tyg, koszt przygotowania ziemi: " + seeds.getGroundPreparingCost() + " zł)");
                        seedsNo++;
                    }
                    System.out.println("\nWybierz nasiona do zasadzenia albo naciśnij '0' aby wrócić do głównego menu.");
                    String selected = "";
                    Scanner scanner = new Scanner(System.in);
                    selected = scanner.nextLine();
                    if (selected.equals("0")) {
                        choiceSelector("menu");
                    }
                    try {
                        player.getFarm().getSeeds().get((Integer.parseInt(selected) - 1)).plantSeeds(player);
                        userInput("p");
                    } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                        choiceSelector(selected);
                    }
                } else if (player.getFarm() == null) {
                    showMenu();
                } else {
                    System.out.println("\nOho, ktoś tutaj nie zainicjował instancji!");
                    System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.");
                    setMenu("main");
                }

                System.out.println("-".repeat(20) + "\n");
            case "h":
            case "H":
              choiceSelector("3");
            case "l":
            case "L":
                if (player.getFarm() == null) {
                    System.out.println("\n\n\nNie masz jeszcze farmy.\n\n\n");
                } else {
                    System.out.println("\n\n\nWpisz ile hektarów ziemi chcesz kupić (1 ha = " + player.getFarm().getCashPerHectare() + " zł).\n\n\n");
                    System.out.println("\nNaciśnij '0' aby wrócić do głównego menu.");
                    String selected = "";
                    Scanner scanner = new Scanner(System.in);
                    selected = scanner.nextLine();
                    if (selected.equals("0")) {
                        choiceSelector("menu");
                    }
                    try {
                        player.getFarm().buyField(player, Integer.parseInt(selected));
                        choiceSelector("2");
                    } catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
                        choiceSelector(selected);
                    }
                }


                // cheats
            case "timetravel":
                if (player != null) {
                    System.out.println("\n\n\nIle tygodni do przodu chcesz się przenieść?\n\n\n");
                    String typeWeek;
                    Scanner scanner = new Scanner(System.in);
                    typeWeek = scanner.nextLine();
                    for (Integer i = 0; i < Integer.parseInt(typeWeek); i++) {
                        nextWeek();
                    }
                    showMenu();
                }
            case "gimmegold":
                if (player != null) {
                    System.out.println("\n\n\nIle PLN chcesz mieć w śwince-skarbonce?\n\n\n");
                    String typeWeek;
                    Scanner scanner = new Scanner(System.in);
                    typeWeek = scanner.nextLine();
                    player.setCash(Integer.parseInt(typeWeek));
                    showMenu();
                }
            default:
                System.out.println("Nieprawidłowa opcja, spróbuj jeszcze raz.");
                showMenu();
        }
    }

    private static Integer randInt(Integer min, Integer max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public Building generateBuilding(String type) {
        int canHoldA = 0;
        int canHoldS = 0;
        if (type.equals("obora")) {
            canHoldA = randInt(5, 50);
        } else if (type.equals("stodoła")) {
            canHoldS = randInt(1, 5);
            canHoldS *= 10000;
        }
        Integer thisPrice = (canHoldA + (canHoldS / 10000)) * 5000;
        return new Building(type, canHoldA, canHoldS, thisPrice);
    }

    public Farm generateFarm(Integer buildingsForAnimals, Integer buildingsForSeeds) {
        ArrayList<Building> thisBuildings = new ArrayList<>();
        for (int i = 0; i <= buildingsForAnimals; i++) {
            thisBuildings.add(generateBuilding("obora"));
        }
        for (int i = 0; i <= buildingsForSeeds; i++) {
            thisBuildings.add(generateBuilding("stodoła"));
        }
        Integer hectares = randInt(3, 5);
        Integer thisPrice = 0;
        thisPrice += hectares * 20000;
        for (Building building : thisBuildings) {
            thisPrice += building.getPrice();
        }
        return new Farm(thisPrice, thisBuildings, hectares);
    }

    public void initiateGame() {
        // crops
        Crop pszenica = new Crop("pszenica 🌾", 25, 50, "pszenica", null, 600, 4000);
        Crop kukurydza = new Crop("kukurydza 🌽", 26, 70, "kukurydza", null, 800, 5000);
        Crop rzepak = new Crop("rzepa 🌱", 22, 30, null, "rzepak", 5000, 5500);
        Crop burak = new Crop("burak pastewny 🌱", 30, 40, null, "burak pastewny", 4000, 5000);

        // seeds
        Seeds pszenicaZiarno = new Seeds("pszenica", 2, 1, 0, 12, 16, true, 1000, 250, pszenica);
        Seeds kukurydzaZiarno = new Seeds("kukurydza", 3, 2, 0, 15, 18, true, 1200, 180, kukurydza);

        // yields
        Yield rzepakZbior = new Yield("rzepak", 3, true, 0);
        Yield burakZbior = new Yield("burak pastewny", 1, true, 0);

        // animals


        availableSeeds.add(pszenicaZiarno);
        availableSeeds.add(kukurydzaZiarno);
        availableCrops.add(pszenica);
        availableCrops.add(kukurydza);
        availableCrops.add(rzepak);
        availableCrops.add(burak);
        availableYields.add(rzepakZbior);
        availableYields.add(burakZbior);

        wasInitiated = true;
    }


}
