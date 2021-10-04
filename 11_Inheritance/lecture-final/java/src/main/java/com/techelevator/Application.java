package com.techelevator;


import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        Bid newBid = new Bid("Josh", 1); // a named object
        generalAuction.placeBid(newBid);

        //  create an anonymous Bid object to pass to the placeBid method
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        System.out.println("Current high bid for " + generalAuction.getItemForSale());
        Bid highBid = generalAuction.getHighBid();
        System.out.println("Bidder: " + highBid.getBidder());
        System.out.println("Amount: " + highBid.getBidAmount());

        generalAuction.placeBid(new Bid("Margaret", 45));
        System.out.println("Current high bid for " + generalAuction.getItemForSale());
        highBid = generalAuction.getHighBid();
        System.out.println("Bidder: " + highBid.getBidder());
        System.out.println("Amount: " + highBid.getBidAmount());

        System.out.println("List of all bids so far:");
        List<Bid> allBids = generalAuction.getAllBids();
        for (Bid bid : allBids){
            System.out.println("Bidder: " + bid.getBidder());
            System.out.println("\tAmount: " + bid.getBidAmount());
        }

        BuyoutAuction buyoutAuction =
                new BuyoutAuction("Green tea mug", 120);

        System.out.println("Created a buyout Auction object");
        boolean winningBid = buyoutAuction.placeBid(new Bid ("Leila", 120));
        System.out.println(buyoutAuction.getHighBid().getBidder() + " Amount: " +
                buyoutAuction.getHighBid().getBidAmount());
        System.out.println("Did Leila win my tea mug? " + winningBid);


        System.out.println("Created a reserve Auction object");
        ReserveAuction reserveAuction = new
                ReserveAuction("Deck of Cards", 10);

        reserveAuction.placeBid(new Bid("Katy", 2));
        System.out.println("Is Katy's bid high enough? ");
        System.out.println("Name: " + reserveAuction.getHighBid().getBidder());
        System.out.println("Amount: " + reserveAuction.getHighBid().getBidAmount());

        reserveAuction.placeBid(new Bid("Bob", 10));
        System.out.println("Is Bob's bid high enough?");
        System.out.println("Name: " + reserveAuction.getHighBid().getBidder());
        System.out.println("Amount: " + reserveAuction.getHighBid().getBidAmount());


        System.out.println(reserveAuction);
    }
}
