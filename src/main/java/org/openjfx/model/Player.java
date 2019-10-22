package org.openjfx.model;

//  This is the Player class, with variables related to the player . Obs: Should also inherit Interfaces in the future
public class Player extends Combatant {
    private final int baseAtk = 2;
    private final int baseHp = 10;
    private int exp = 0;
    private Item[] inventory = new Item[4];
    private int selectedItem = 0;
    private double prevXCoord;
    private double prevYCoord;

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
        this.hp = baseHp;
        this.atk = baseAtk;
        itemBonus(inventory[selectedItem -1]);
    }

    public Player(String ID, double XCOORD, double YCOORD, int HP, int ATK, float ATKRANGE) {
        super(ID, XCOORD, YCOORD, HP, ATK, ATKRANGE);
        this.moveSpeed = 0.2;
    }

    public String getId() {
        return id;
    }


    public int getHp() {
        return hp;
    }

    public int getAtk(){
        return atk;
    }

    public double getAtkRange() {
        return atkRange;
    }

    public void decHp(int decAmount) {

        hp = hp - decAmount;

    }

    public void incHp(int incAmount){

        hp = hp + incAmount;

    }

    public int getExp() {
        return exp;
    }

    public void incExp(int incAmount){
        exp = exp + incAmount;
    }

    public void decExp(int decAmount){
        exp = exp - decAmount;
    }

    public Item[] getInventory() {
        Item [] inventoryCopy = new Item[4];
        for (int i = 0; i<inventory.length; i++){
            inventoryCopy[i] = inventory[i];
        }
        return inventoryCopy;
    }

    public void setItem(Item item, int index) {

        this.inventory[index] = item;
    }

    public void itemBonus(Item item) {
        switch (item.getId()) {
            case "Sword":
                this.atk += 2;
                System.out.println(this.atk);
                break;
            case "Axe":
                this.atk += 4;
                System.out.println(this.atk);
                break;
            case "Armor":
                this.hp += 20;
                System.out.println(this.hp);
                break;
        }
    }

    public boolean canAttack(){
        if (attackCooldownTicker > 0){
            return true;
        }
        attackCooldownTicker++;
        return false;
    }

    private void setPrevCoords(double x, double y) {
        this.prevXCoord = x;
        this.prevYCoord = y;
    }

    @Override
    public void move(Direction direction) {
        setPrevCoords(this.getXcoord(), this.getYcoord());
        super.move(direction);
    }

    public double getPrevXCoord() {
        return this.prevXCoord;
    }

    public double getPrevYCoord() {
        return this.prevYCoord;
    }
}


