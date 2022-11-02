// coded by: Chun-Hao Hsu
// partner: Jin-Ching Jeng

package Rooms;

import Game.Adventure;
import Items.Item;

public class Office extends Room{

    private boolean locked_ = false;

    private boolean hasAnswer_ = false;

    private int fiveLitersGlass_ = 0;
    private int threeLiterGlass_ = 0;

    private Item key;

    private boolean hasGlass3L = false;
    private boolean hasGlass5L = false;


    public Office() {
        super("office", "A stuffy office with a big tank full of water.");
//        Item fiveLiterGlass = new Item("5L glass", "A 5 liters glass without graduation");
//        Item threeLiterGlass = new Item("3L glass", "A 3 liters glass without graduation");
        Item scales = new Item("Scales", "The scales is going to run out of battery");
        Item paper = new Item("Paper", "It says : Put a glass with 4 liters water on the scales. Use commands fill/pour 3L/5L glass, and pour water from 5L/3L glass to 3L/5L glass.");
        Item drawer = new Item("Drawer", "A locked drawer");
        Item flashlight = new Item("Flashlight", "A light resource in places during power outages");
        key = new Item("Key", "A silver key");
//        items_.add(fiveLiterGlass);
//        items_.add(threeLiterGlass);
        items_.add(scales);
        items_.add(paper);
        items_.add(drawer);
        items_.add(flashlight);
    }

    @Override
    public Room goThroughDoor(int doorNum) {

        if( locked_ ) {
            System.out.println( "The door is locked!" );
            return null;
        }
        else {
            return super.goThroughDoor( doorNum );
        }
    }

    @Override
    public boolean handleCommand( String[] subcommands ) {


        if( subcommands.length <= 1 ) {
            return false;
        }
        String cmd  = subcommands[0];
        String attr = subcommands[1];


        for(Item item : Adventure.inventory){
            if (item.getName().equals("3L glass")){
                hasGlass3L = true;
            }
            if (item.getName().equals("5L glass")){
                hasGlass5L = true;
            }
        }

        // fill the glass
//        if(hasThreeLGlass_ && hasFiveLGlass_)
        if (hasGlass5L && hasGlass3L) {
            if (cmd.equals("fill") && attr.equals("3L glass")) {
                System.out.println("3L glass is filled");
                threeLiterGlass_ = 3;
                System.out.println("Your have 1 glass with " + fiveLitersGlass_ + " L" + " and 1 glass with " + threeLiterGlass_ + " L");
                return true;
            } else if (cmd.equals("fill") && attr.equals("5L glass")) {
                System.out.println("5L glass is filled");
                fiveLitersGlass_ = 5;
                System.out.println("Your have 1 glass with " + fiveLitersGlass_ + " L" + " and 1 glass with " + threeLiterGlass_ + " L");
                return true;
            } else if (cmd.equals("pour") && attr.equals("3L glass")) {
                System.out.println("3L glass is empty");
                threeLiterGlass_ = 0;
                System.out.println("Your have 1 glass with " + fiveLitersGlass_ + " L" + " and 1 glass with " + threeLiterGlass_ + " L");
                return true;
            } else if (cmd.equals("pour") && attr.equals("5L glass")) {
                System.out.println("5L glass is empty");
                fiveLitersGlass_ = 0;
                System.out.println("Your have 1 glass with " + fiveLitersGlass_ + " L" + " and 1 glass with " + threeLiterGlass_ + " L");
                return true;
            } else if (cmd.equals("pour") && attr.equals("water from 5L glass to 3L glass")) {
                if (threeLiterGlass_ == 0) {
                    if (fiveLitersGlass_ <= 3) {
                        threeLiterGlass_ += fiveLitersGlass_;
                        fiveLitersGlass_ = 0;
                    } else if (fiveLitersGlass_ <= 5) {
                        threeLiterGlass_ = 3;
                        fiveLitersGlass_ -= 3;
                    }
                } else if (threeLiterGlass_ == 1) {
                    if (fiveLitersGlass_ <= 2) {
                        threeLiterGlass_ += fiveLitersGlass_;
                        fiveLitersGlass_ = 0;
                    } else if (fiveLitersGlass_ <= 5) {
                        threeLiterGlass_ = 3;
                        fiveLitersGlass_ -= 2;
                    }
                } else if (threeLiterGlass_ == 2) {
                    if (fiveLitersGlass_ <= 1) {
                        threeLiterGlass_ += fiveLitersGlass_;
                        fiveLitersGlass_ = 0;
                    } else if (fiveLitersGlass_ <= 5) {
                        threeLiterGlass_ = 3;
                        fiveLitersGlass_ -= 1;
                    }
                } else {
                    System.out.println("3L glass is full already, can't be filled");
                }
                System.out.println("Your have 1 glass with " + fiveLitersGlass_ + " L" + " and 1 glass with " + threeLiterGlass_ + " L");

                if (fiveLitersGlass_ != 4) {
                    return true;
                }
            } else if (cmd.equals("pour") && attr.equals("water from 3L glass to 5L glass")) {
                if (fiveLitersGlass_ <= 2) {
                    System.out.println("You add " + threeLiterGlass_ + "L to the 5L glass");
                    fiveLitersGlass_ += threeLiterGlass_;
                    threeLiterGlass_ = 0;
                } else if (fiveLitersGlass_ == 3) {
                    if (threeLiterGlass_ <= 2) {
                        System.out.println("You add " + threeLiterGlass_ + "L to the 5L glass");
                        fiveLitersGlass_ += threeLiterGlass_;
                        threeLiterGlass_ = 0;
                    } else {
                        System.out.println("You add 2L to the 5L glass");
                        fiveLitersGlass_ = 5;
                        threeLiterGlass_ -= 2;
                    }
                } else if (fiveLitersGlass_ == 4) {
                    if (threeLiterGlass_ <= 1) {
                        System.out.println("You add " + threeLiterGlass_ + "L to the 5L glass");
                        fiveLitersGlass_ += threeLiterGlass_;
                        threeLiterGlass_ = 0;
                    } else {
                        System.out.println("You add 1L to the 5L glass");
                        fiveLitersGlass_ = 5;
                        threeLiterGlass_ -= 1;
                    }
                } else {
                    System.out.println("5L glass is full already, can't be filled");
                }
                System.out.println("Your have 1 glass with " + fiveLitersGlass_ + " L" + " and 1 glass with " + threeLiterGlass_ + " L");
                if (fiveLitersGlass_ != 4) {
                    return true;
                }
            }
        }
        else {
            System.out.println("You don't have enough glass");
            return true;
        }

        if(fiveLitersGlass_ == 4){
            hasAnswer_ = true;
            locked_ = false;
            System.out.println( "You unlock the drawer.");
            fiveLitersGlass_ = 0 ;
            return true;
        }


        if( cmd.equals( "open" ) && attr.equals( "drawer") ) {
            if( !locked_ ) {
                System.out.println( "There is a key in the drawer");
                items_.add(key);
                locked_ = false;
            }
            else {
                System.out.println( "Drawer is locked" );
            }
            return true;
        }



        return false;
    }
}







