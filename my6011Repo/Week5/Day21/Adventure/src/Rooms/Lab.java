// coded by: Jin-Ching Jeng
// partner: Chun-Hao Hsu

package Rooms;

import Game.Adventure;
import Items.Item;

public class Lab extends Room {
    // At this power outage Science Lab, user needs to have a flashlight, wear a mask,
    // go to the cabinet, and get 2 glasses in the cabinet which the other room needed.
    private boolean hasFlashlight_ = false;
    private boolean hasMask_ = false;
    private boolean atCabinet_ = false;
    public Lab() {
        super( "Science Lab", "A power outage laboratory full of poisonous gas, you need <go cabinet> to get experiment equipments." );
        Item mask = new Item( "Mask", "A mask preventing poisonous gas");
        items_.add( mask );
    }

    @Override
    public void playerEntered() {
        System.out.println( "There's a weird chemical smell..." );
    }

    @Override
    public boolean handleCommand( String[] subcommands ) {

        if( subcommands.length <= 1 ) {
            return false;
        }
        String cmd  = subcommands[0];
        String attr = subcommands[1];

        // command: <go cabinet> ( hasFlashlight_ and hasMask_ should be true to go cabinet)
        if( cmd.equals( "go" ) && attr.equals( "cabinet" ) ){

            for( Item item : Adventure.inventory ){
                if( item.getName().equals( "Mask") ){
                    hasMask_ = true;
                    break;
                }
            }
            for( Item item : Adventure.inventory ){
                if( item.getName().equals( "Flashlight") ){
                    hasFlashlight_ = true;
                    break;
                }
            }
            if( hasFlashlight_ && hasMask_){
                System.out.println( "You're in front of the cabinet. There are <3L glass> and <5L glass> inside.");
                atCabinet_ = true;
                // add two glasses to item when the user is next to the cabinet
                Item glass3L = new Item( "3L glass", "A 3L non-graduated glass");
                Item glass5L = new Item( "5L glass", "A 5L non-graduated glass");
                items_.add( glass3L );
                items_.add( glass5L );
            }else if( !hasFlashlight_ ){
                System.out.println( "You can't see anything without a flashlight." );
            }else{
                System.out.println( "You can't pass through the lab without wearing a mask." );
            }
            return true;
        }
        return false;
    }
}
