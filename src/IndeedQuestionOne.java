/*
You're creating a game with some amusing mini-games, and you've decided to make a simple variant of the game Mahjong.

In this variant, players have a number of tiles, each marked 0-9. The tiles can be grouped into pairs or triples of the same tile. For example, if a player has "33344466", the player's hand has a triple of 3s, a triple of 4s, and a pair of 6s. Similarly, "55555777" has a triple of 5s, a pair of 5s, and a triple of 7s.

A "complete hand" is defined as a collection of tiles where all the tiles can be grouped into any number of triples (zero or more) and exactly one pair, and each tile is used in exactly one triple or pair.

Write a function that takes a string representation of a collection of tiles in no particular order, and returns true or false depending on whether or not the collection represents a complete hand.

tiles1 = "11133555"           # True.  111 33 555
tiles2 = "111333555"          # False. There are three triples, 111 333 555 but no pair.
tiles3 = "00000111"           # True.  000 00 111. Your pair and a triplet can be of the same value
                              #        There is also no limit to how many of each tile there is.
tiles4 = "13233121"           # True.  Tiles are not guaranteed to be in order
tiles5 = "11223344555"        # False. There cannot be more than one pair
tiles6 = "99999999"           # True.  You can have many of one tile
tiles7 = "999999999"          # False.
tiles8 = "9"                  # False.
tiles9 = "99"                 # True.  One pair.
tiles10 = "000022"            # False.
tiles11 = "888889"            # False. There cannot be any tiles left over.
tiles12 = "889"               # False. There cannot be any tiles left over.
tiles13 = "88888844"          # True.  Two triples and one pair
tiles14 = "77777777777777"    # True.  Four triples and one pair
tiles15 = "1111111"       	  # False.
tiles16 = "1111122222"        # False.

complete(tiles1)  => True
complete(tiles2)  => False
complete(tiles3)  => True
complete(tiles4)  => True
complete(tiles5)  => False
complete(tiles6)  => True
complete(tiles7)  => False
complete(tiles8)  => False
complete(tiles9)  => True
complete(tiles10) => False
complete(tiles11) => False
complete(tiles12) => False
complete(tiles13) => True
complete(tiles14) => True
complete(tiles15) => False
complete(tiles16) => False

Complexity Variable
N - Number of tiles in the input string

Time Complexity: O(N)
Space: O(N)
*/

import java.util.HashMap;

public class IndeedQuestionOne {
    public static boolean completeHand(String hand){
        HashMap<Integer,Integer> tileMap = new HashMap<>();
        boolean singleDouble = false;
        // 1) populate map with tile and their counts
        for(int i =0;i<hand.length();i++){
            int tile = Integer.parseInt(hand.substring(i,i+1));
            if(!tileMap.containsKey(tile)){
                tileMap.put(tile,1);
            } else {
                tileMap.put(tile, tileMap.get(tile)+1);
            }
        }
        //System.out.println("tileMap check: "+ Arrays.asList(tileMap));
        for(Integer key: tileMap.keySet()){

            int value = tileMap.get(key);
            while(value>0){
                if(value==1 || value <0){
                    return false;
                }
                else if(value == 2){
                    if(!singleDouble){
                        singleDouble = true;
                        value = value-2;
                    }
                    else {
                        return false;
                    }
                }
                else{
                    value = value -3;
                }
            }
        }

        if(!singleDouble){
            return false;
        }

        return true;
    }
}
