package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<LibraryItem> items;
    private List<Member> members;

    public LibraryManager() {
        items = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add new items
    public void addStoryBook(StoryBook book) {
        items.add(book);
    }

    public void addSchoolBook(SchoolBook book) {
        items.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        for (LibraryItem item : items) {
            System.out.println(item.getDetails() + (item.isAvailable() ? " [Available]" : " [Borrowed]"));
        }
    }

    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        for (Member member : members) {
            System.out.println("Member ID: " + member.getMemberId() + ", Name: " + member.getName());
        }
    }

    public void borrowItem(String itemId, String memberId) {
        LibraryItem item = findItemById(itemId);
        Member member = findMemberById(memberId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (!item.isAvailable()) {
            System.out.println("Item is already borrowed.");
            return;
        }

        item.borrow();
        member.borrowItem(itemId);
        System.out.println("Item borrowed successfully.");
    }

    public void returnItem(String itemId, String memberId) {
        LibraryItem item = findItemById(itemId);
        Member member = findMemberById(memberId);

        if (item == null || member == null) {
            System.out.println("Invalid item or member ID.");
            return;
        }

        if (!member.getBorrowedItems().contains(itemId)) {
            System.out.println("This item was not borrowed by this member.");
            return;
        }

        item.returnItem();
        member.returnItem(itemId);
        System.out.println("Item returned successfully.");
    }

    // Helper methods
    private LibraryItem findItemById(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    private Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(id)) {
                return member;
            }
        }
        return null;
    }

    public void loadData() {
        items = FileHandler.loadItemsFromFile();
        members = FileHandler.loadMembersFromFile();
    }

    public void saveData() {
        FileHandler.saveItemsToFile(items);
        FileHandler.saveMembersToFile(members);
    }
}
