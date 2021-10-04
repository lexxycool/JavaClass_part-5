package com.techelevator;

public class ReserveAuction extends Auction{
    // attribute - instance variable
    private int reservePrice;

    // constructor will pull in itemForSale
    // as well as reservePrice
    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    /*
    ReserveAuction to override -- provide a different version
    of the placeBid method from the parent
     */
    @Override
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        // you either bid the reserve price
        // or your bid is not accepted!
        if (offeredBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

    //  Added a toString method!
    @Override
    public String toString(){
        String output = "";
        output += "*************** RESERVE AUCTION **************";
        output += "\nAll bids so far: ";
        for (Bid bid: super.getAllBids()){
            output += "\nBidder: " + bid.getBidder();
            output +=  "\nAmount: " + bid.getBidAmount();
        }
        return output;
    }

}
