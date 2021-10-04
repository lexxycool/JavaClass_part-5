package com.techelevator;

/*
   BuyoutAuction is a child of Auction class
   means that an object of type BuyoutAuction
   will have all the properties of Auction class
   as well as any properties declared in this class

   BuyoutAuction class you can set a BuyoutPrice
   and if someone bids that amount, auction immediately
   ends
 */
public class BuyoutAuction extends Auction{

    //declare property for this class
    private int buyoutPrice;

    // constructor
    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);  // pass to the parent constructor FIRST!
        this.buyoutPrice = buyoutPrice;
    }

    @Override  // annotation
    // tells any dev that this methods in the child
    // class is providing a new version for this class
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= buyoutPrice){
            // if bid is higher than the buyoutPrice
            // pass this on to the parent version and
            // this person then wins the item!
            isCurrentWinningBid = super.placeBid(offeredBid);
        } else {
            // otherwise it's just a normal bid
            super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

    public int getBuyoutPrice(){
        return buyoutPrice;
    }
}
