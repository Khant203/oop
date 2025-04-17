package LibraryManagementSystem; // Make sure this matches your other classes

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private List<String> borrowedItems;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void borrowItem(String itemId) {
        borrowedItems.add(itemId);
    }

    public void returnItem(String itemId) {
        borrowedItems.remove(itemId);
    }

    public List<String> getBorrowedItems() {
        return borrowedItems;
    }
}