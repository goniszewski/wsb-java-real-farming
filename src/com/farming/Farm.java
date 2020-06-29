package com.farming;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Farm {
    private Integer price;
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private ArrayList<Crop> crops = new ArrayList<Crop>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Seeds> seeds = new ArrayList<Seeds>();
    private ArrayList<Yield> yields = new ArrayList<Yield>();
    private Integer fieldsInHectares = 0;
    private Integer usedHectares = 0;
    private final Integer cashPerHectare = 50000;


    public Farm(Integer price, ArrayList<Building> buildings, Integer fieldsInHectares) {
        this.buildings = buildings;
        this.crops = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.fieldsInHectares = ThreadLocalRandom.current().nextInt(1, 11);
        this.price = (fieldsInHectares * cashPerHectare);
    }

    @Override
    public String toString() {
        return "Farma " +
                "\ncena zakupu: " + price +
                ", \nbudynki: " + displayBuildings() +
                " \nzasiano: " + displayCrops() +
                " \nnasiona: " + displaySeeds() +
                " \nzwierzęta: " + displayAnimals() +
                " \nhektarów ziemi: " + fieldsInHectares +
                ", \nhektarów w użyciu: " + usedHectares + "\n";
    }

    public String displayBuildings() {
        StringBuilder list = new StringBuilder();
        for (Building building : buildings) {
            list.append(building.getType());
            if (building.getCanHoldAnimals() != 0) {
                list.append(" (max zwierząt: ").append(building.getCanHoldAnimals()).append("), ");
            }
            if (building.getCanHoldStocks() != 0) {
                list.append(" (max ton zbiorów: ").append(building.getCanHoldStocks() / 1000).append("), ");
            }

        }
        return list.toString();
    }

    public String displayCrops() {
        StringBuilder list = new StringBuilder();
        for (Crop crop : crops) {
            list.append(crop.getName()).append(" (tygodni: ").append(crop.getAge()).append("/").append(crop.getGrowingTime()).append("), ");
        }
        return (list.toString().length() < 10 ? "brak" : list.toString());
    }

    public String displaySeeds() {
        StringBuilder list = new StringBuilder();
        for (Seeds seed : seeds) {
            list.append(seed.getName()).append(" (").append(seed.getQuantityInKg()).append(" kg)").append(", ");
        }
        return (list.toString().length() < 3 ? "brak" : list.toString());
    }

    public String displayAnimals() {
        StringBuilder list = new StringBuilder();
        for (Animal animal : animals) {
            list.append(animal.getSpecies()).append(" (tygodni: ").append(animal.getAge()).append("/").append(animal.getMatureInWeeks()).append(",");
        }
        return (list.toString().length() < 10 ? "brak" : list.toString());
    }

    public Integer displayFreeHectares() {
        return fieldsInHectares - usedHectares;
    }

    public void reserveField(Integer hectares) {
        setUsedHectares(usedHectares + hectares);
        System.out.println("Pozostało " + displayFreeHectares() + " ha wolnej ziemi uprawnej.");
    }

    public void releaseField(Integer hectares) {
        setUsedHectares(usedHectares - hectares);
        System.out.println("Pozostało " + displayFreeHectares() + " ha wolnej ziemi uprawnej.");
    }

    public void buyField(Player player, Integer howManyH) {
        if (fieldsInHectares+howManyH > 25) {
            System.out.println("Nie możesz mieć więcej niż 25 ha ziemi.");
        } else if (player.getCash() > cashPerHectare) {
            fieldsInHectares += howManyH;
            player.setCash(player.getCash() - (cashPerHectare*howManyH));
            System.out.println("Kupiono "+howManyH+" hektar(ów) ziemi!");
        } else {
            System.out.println("Brak wystarczających funduszy.");
        }
    }

    public void sellField(Player player, Integer howManyH) {
        if (displayFreeHectares()-howManyH <0) {
            System.out.println("Nie można sprzedać większej ilości ziemi niż jest obecnie wolne od upraw.");
        } else {
            fieldsInHectares -= howManyH;
            player.setCash(player.getCash() + (cashPerHectare*howManyH));
            System.out.println("Kupiono "+howManyH+" hektar(ów) ziemi!");
        }
    }

    public Integer canHoldAnimals() {
        Integer canHold = 0;
        for (Building building : buildings) {
            canHold += building.getCanHoldAnimals();
        }
        return canHold;
    }

    public Integer nowHoldsAnimals() {
        return animals.size();
    }

    public Integer canAddAnimals() {
        return canHoldAnimals() - nowHoldsAnimals();
    }

    public Integer canHoldStocks() {
        Integer canHold = 0;
        for (Building building : buildings) {
            canHold += building.getCanHoldStocks();
        }
        return canHold;
    }

    public Integer nowHoldsStocks() {
        Integer nowHolds = 0;
        for (Seeds seeds : seeds) {
            nowHolds += seeds.getQuantityInKg();
        }
        for (Yield yield : yields) {
            nowHolds += yield.getQuantityInKg();
        }
        return nowHolds;
    }

    public void buySeeds(Player player, Seeds seeds) {
        if (player.getCash() < (seeds.getBuyPricePerKg() * seeds.getNeedsKgPerH())) {
            System.out.println("Brak wystarczających funduszy na koncie.");
        } else if ((canHoldStocks() - nowHoldsStocks()) < seeds.getNeedsKgPerH()) {
            System.out.println("Brak wystrarczającej ilości miejsca.");
        } else {
            addStock(seeds);
            player.setCash(player.getCash() - (seeds.getBuyPricePerKg() * seeds.getNeedsKgPerH()));
        }
    }
    public void sellSeeds(Player player, Integer index, Integer quantityInKg) {
        if (player.getFarm().getSeeds().get(index).getQuantityInKg()<quantityInKg) {
            System.out.println("Brak wystarczających ilości na stanie.");
        } else {
            player.getFarm().getSeeds().get(index).setQuantityInKg(player.getFarm().getSeeds().get(index).getQuantityInKg()-quantityInKg);
            player.setCash(player.getCash() + (player.getFarm().getSeeds().get(index).getSellPricePerKg() * quantityInKg));
        }
    }

    public void sellYields(Player player, Integer index, Integer quantityInKg) {
        if (player.getFarm().getYields().get(index).getQuantityInKg()<quantityInKg) {
            System.out.println("Brak wystarczających ilości na stanie.");
        } else {
            player.getFarm().getYields().get(index).setQuantityInKg(player.getFarm().getYields().get(index).getQuantityInKg()-quantityInKg);
            player.setCash(player.getCash() + (player.getFarm().getYields().get(index).getSellPricePerKg() * quantityInKg));
        }
    }

    public void sellAnimal(Player player, Integer index){
        if (player.getFarm().getAnimals().get(index) == null){
            System.out.println("Nie posiadasz takiego zwierzęcia.");
        } else if (player.getFarm().getAnimals().get(index).getMatureInWeeks()>0){
            System.out.println("Zwierzę jest jeszcze za młode, poczekaj "+player.getFarm().getAnimals().get(index).getMatureInWeeks()+" tygodni.");
        } else {
            player.setCash(player.getCash()+player.getFarm().getAnimals().get(index).getSellPrice());
            player.getFarm().getAnimals().get(index).
        }
    }

    //getters

    public Integer getPrice() {
        return price;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public ArrayList<Seeds> getSeeds() {
        return seeds;
    }

    public ArrayList<Yield> getYields() {
        return yields;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void listBuildings() {
        for (Building building : buildings) {
            System.out.println(building);
        }
    }

    public void listCrops() {
        for (Crop crop : crops) {
            System.out.println(crop);
        }
    }

    public void listAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public void listSeeds() {
        for (Seeds seeds : seeds) {
            System.out.println(seeds);
        }
    }

    public Integer getCashPerHectare() {
        return cashPerHectare;
    }
    //setters

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void AddBuilding(Building building) {
        this.buildings.add(building);
    }

    public void addCrop(Crop crop) {
        this.crops.add(crop);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void addStocks(Crop crop) {
        if (crop.getSeedsFromHarvest() != null) {
            for (Seeds seeds : seeds) {
                if (seeds.getName().equals(crop.getSeedsFromHarvest())) {
                    seeds.setQuantityInKg(seeds.getQuantityInKg() + crop.getGivesKgPerH());
                }
            }

        } else if (crop.getYieldFromHarvest() != null) {
            for (Yield yield : yields) {
                if (yield.getName().equals(crop.getYieldFromHarvest())) {
                    yield.setQuantityInKg(yield.getQuantityInKg() + crop.getGivesKgPerH());
                }
            }

        }
    }

    public void addStock(Seeds incomingSeeds) {
        boolean foundIt = false;

        for (Seeds storedSeeds : seeds) {
            if (storedSeeds.getName().equals(incomingSeeds.getName())) {
                storedSeeds.setQuantityInKg(storedSeeds.getQuantityInKg() + incomingSeeds.getNeedsKgPerH());
                foundIt = true;
            }

        }
        if (!foundIt) {
            seeds.add(incomingSeeds);
            for (Seeds storedSeeds : seeds) {
                if (storedSeeds.getName().equals(incomingSeeds.getName())) {
                    storedSeeds.setQuantityInKg(storedSeeds.getQuantityInKg() + incomingSeeds.getNeedsKgPerH());
                }
            }
        }
    }

    public void removeStock(Seeds removeSeeds) {
        for (Seeds storedSeeds : seeds) {
            if (storedSeeds.getName().equals(removeSeeds.getName())) {
                storedSeeds.setQuantityInKg(storedSeeds.getQuantityInKg() - removeSeeds.getNeedsKgPerH());
            }

        }
    }

    public void setUsedHectares(Integer usedHectares) {
        this.usedHectares = usedHectares;
    }

    public void buyFarm(Player player) {
        if (player.getFarm() != null) {
            System.out.println("Już masz swoją farmę, chcesz od razu mieć dwie?! Szalony.");
        } else if (player.getCash() < this.getPrice()) {
            System.out.println("Brak wystarczających środków na koncie.");
        } else {
            player.setCash(player.getCash() - this.price);
            player.setFarm(this);
        }
    }


}


